package com.bybit.api.client.websocket.impl;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.websocket.callback.WebSocketMessageCallback;
import com.bybit.api.client.websocket.httpclient.WebSocketStreamHttpClientSingleton;
import com.bybit.api.client.websocket.httpclient.WebsocketStreamClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.security.HmacSHA256Signer;
import lombok.Getter;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bybit.api.client.constant.Helper.generateTimestamp;
import static com.bybit.api.client.constant.Helper.generateTransferID;

@Getter
public class WebsocketStreamClientImpl implements WebsocketStreamClient {
    private static final String THREAD_PING = "thread-public-ping";
    private static final String THREAD_PRIVATE_AUTH = "thread-private-auth";
    private static final String PING_DATA = "{\"op\":\"ping\"}";
    private static final Logger LOGGER = LoggerFactory.getLogger(WebsocketStreamClientImpl.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private WebSocketMessageCallback webSocketMessageCallback;
    private final WebSocketStreamHttpClientSingleton webSocketHttpClientSingleton;
    private WebSocket webSocket;

    private final String apikey;
    private final String secret;
    private final String baseUrl;
    private final Boolean debugMode;
    private final String logOption;
    private final Integer pingInterval;
    private final String maxAliveTime;
    private List<String> argNames;
    private Map<String,Object> params;
    private String path;

    public WebsocketStreamClientImpl(String apikey, String secret, String baseUrl, Integer pingInterval, String maxAliveTime, Boolean debugMode, String logOption, WebSocketMessageCallback webSocketMessageCallback) {
        this.webSocketMessageCallback = webSocketMessageCallback;
        this.apikey = apikey;
        this.secret = secret;
        this.baseUrl = baseUrl;
        this.pingInterval = pingInterval;
        this.debugMode = debugMode;
        this.logOption = logOption;
        this.maxAliveTime = maxAliveTime;
        webSocketHttpClientSingleton = WebSocketStreamHttpClientSingleton.createInstance(this.debugMode, this.logOption);
    }

    private void setupChannelStream(List<String> argNames, String path) {
        this.argNames = new ArrayList<>(argNames);
        this.path = path;
    }

    private void setupChannelStream(Map<String,Object> params, String path) {
        this.params = new HashMap<>(params);
        this.path = path;
    }

    private void sendJsonMessage(WebSocket ws, Object messageObject, String messageType) {
        try {
            String json = objectMapper.writeValueAsString(messageObject);
            ws.send(json);
            LOGGER.info("Sent {}: {}", messageType, json);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error serializing {} message: ", messageType, e);
        }
    }

    private void sendSubscribeMessage(WebSocket ws, String messageType) {
        Map<String, Object> subscribeMsg = createSubscribeMessage(messageType);
        sendJsonMessage(ws, subscribeMsg, messageType);
    }

    @NotNull
    private Map<String, Object> createSubscribeMessage(String messageType) {
        Map<String, Object> wsPostMsg = new LinkedHashMap<>();
        if (messageType.equals("Trade")) {
            wsPostMsg.put("reqId", params.getOrDefault("reqId", generateTransferID()));
            wsPostMsg.put("headers", constructWsAPIHeaders(params));
            wsPostMsg.put("op", "order.create");
            wsPostMsg.put("args", constructWsAPIArgs()); // Ensure this is structured correctly
        } else {
            wsPostMsg.put("req_id", generateTransferID());
            wsPostMsg.put("op", "subscribe");
            wsPostMsg.put("args", argNames); // Ensure argNames is correctly formatted for subscription messages
        }
        return wsPostMsg;
    }

    private List<Map<String, Object>> constructWsAPIArgs() {
        // Remove specified keys
        params.remove("X-BAPI-TIMESTAMP");
        params.remove("reqId");
        params.remove("X-BAPI-RECV-WINDOW");
        params.remove("Referer");
        return Collections.singletonList(params);
    }

    private Map<String, String> constructWsAPIHeaders(Map<String,Object> params) {
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put(BybitApiConstants.TIMESTAMP_HEADER, String.valueOf(generateTimestamp()));
        headerMap.put(BybitApiConstants.RECV_WINDOW_HEADER, params.getOrDefault(BybitApiConstants.RECV_WINDOW_HEADER, BybitApiConstants.DEFAULT_RECEIVING_WINDOW).toString());
        // Check broker referral code
        if(params.containsKey("Referer"))
            headerMap.put("Referer", params.get("Referer").toString());
        return headerMap;
    }

    private boolean requiresAuthentication(String path) {
        return BybitApiConfig.V5_TRADE.equals(path) ||
                BybitApiConfig.V5_PRIVATE.equals(path) ||
                BybitApiConfig.V3_CONTRACT_PRIVATE.equals(path) ||
                BybitApiConfig.V3_UNIFIED_PRIVATE.equals(path) ||
                BybitApiConfig.V3_SPOT_PRIVATE.equals(path);
    }

    @NotNull
    private Thread createPingThread() {
        return new Thread(() -> {
            try {
                // check if the WebSocket is still valid
                while (this.webSocket != null) {
                        webSocket.send(PING_DATA);
                        LOGGER.info(PING_DATA);
                        TimeUnit.SECONDS.sleep(pingInterval); // waits for 10 seconds before the next iteration
                }
            } catch (InterruptedException e) {
                LOGGER.error("Ping thread was interrupted", e);
                Thread.currentThread().interrupt();
            }
        });
    }

    @NotNull
    private Map<String, Object> createAuthMessage() {
        long expires = Instant.now().toEpochMilli() + 10000;
        String val = "GET/realtime" + expires;
        String signature = HmacSHA256Signer.getSignature(val, secret);

        var args = List.of(apikey, expires, signature);
        return Map.of("req_id", generateTransferID(), "op", "auth", "args", args);
    }

    private void sendAuthMessage(WebSocket ws) {
        var authMessage = createAuthMessage();
        sendJsonMessage(ws, authMessage, "Auth");
    }

    @NotNull
    private Thread createAuthThread(WebSocket ws, Runnable afterAuth) {
        return new Thread(() -> {
            try {
                sendAuthMessage(ws);
                if (afterAuth != null) {
                    afterAuth.run();
                }
            } catch (Exception e) {
                LOGGER.error("Error during authentication: ", e);
            }
        });
    }

    @NotNull
    private String getWssUrl() {
        Pattern pattern = Pattern.compile("(\\d+)([sm])");
        Matcher matcher = pattern.matcher(maxAliveTime);
        String wssUrl;
        if (matcher.matches()) {
            int timeValue = Integer.parseInt(matcher.group(1));
            String timeUnit = matcher.group(2);
            boolean isTimeValid = isTimeValid(timeUnit, timeValue);

            wssUrl = isTimeValid && requiresAuthentication(path) ? baseUrl + path + "?max_alive_time=" + maxAliveTime : baseUrl + path;
        } else {
            wssUrl = baseUrl + path;
        }
        return wssUrl;
    }

    private boolean isTimeValid(String timeUnit, int timeValue) {
        int minValue = "s".equals(timeUnit) ? 30 : 1;
        int maxValue = "s".equals(timeUnit) ? 600 : 10;
        return timeValue >= minValue && timeValue <= maxValue;
    }

    @NotNull
    private WebSocketListener createWebSocketListener() {
        return new WebSocketListener() {
            @Override
            public void onClosed(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
                WebsocketStreamClientImpl.this.onClose(webSocket, code, reason);
            }

            @Override
            public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
                WebsocketStreamClientImpl.this.onError(t);
            }

            @Override
            public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
                try {
                    WebsocketStreamClientImpl.this.onMessage(text);
                } catch (Exception e) {
                    WebsocketStreamClientImpl.this.onError(e);
                }
            }

            @Override
            public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
                WebsocketStreamClientImpl.this.onOpen(webSocket);
            }
        };
    }

    public void setMessageHandler(WebSocketMessageCallback webSocketMessageCallback) {
        this.webSocketMessageCallback = webSocketMessageCallback;
    }

    @Override
    public void onMessage(String msg) throws JsonProcessingException {
        if (webSocketMessageCallback != null) {
            webSocketMessageCallback.onMessage(msg);
        } else {
            LOGGER.info(msg);
        }
    }

    @Override
    public void onError(Throwable t) {
        LOGGER.error(t.getMessage());
    }

    @Override
    public void onClose(WebSocket ws, int code, String reason) {
        LOGGER.info("WebSocket closed. Code: {}, Reason: {}", code, reason);
        ws.close(code, reason);
        this.webSocket = null;
    }

    @Override
    public void onOpen(WebSocket ws) {
        // If it requires authentication, authenticate first, then subscribe.
        if (requiresAuthentication(path)) {
            Thread authThread = createAuthThread(ws, () -> {
                // After auth, trade api
                if(path.equals(BybitApiConfig.V5_TRADE)){
                    sendSubscribeMessage(ws, "Trade");
                }
                // After auth, send a subscribed message
                else{
                    sendSubscribeMessage(ws, "Subscribe");
                }
            });
            authThread.start();
        } else {
            // If no authentication is needed, just send the subscribed message.
            sendSubscribeMessage(ws, "Subscribe");
        }
    }

    @Override
    public WebSocket connect() {
        String wssUrl = getWssUrl();
        LOGGER.info(wssUrl);
        this.webSocket = webSocketHttpClientSingleton.createWebSocket(wssUrl, createWebSocketListener());

        // Start the ping thread immediately.
        Thread pingThread = createPingThread();
        pingThread.setName(THREAD_PING); // Default to public ping name
        pingThread.start();
        return this.webSocket;
    }

    @Override
    public WebSocket getPublicChannelStream(List<String> argNames, String path) {
        setupChannelStream(argNames, path);
        return connect();
    }

    @Override
    public WebSocket getPrivateChannelStream(List<String> argNames, String path) {
        setupChannelStream(argNames, path);
        return connect();
    }

    @Override
    public WebSocket getTradeChannelStream(Map<String,Object> params, String path) {
        setupChannelStream(params, path);
        return connect();
    }
}
