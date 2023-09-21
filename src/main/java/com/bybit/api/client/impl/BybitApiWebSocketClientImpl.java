package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiCallback;
import com.bybit.api.client.BybitApiWebSocketClient;
import com.bybit.api.client.config.BybitApiConfig;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.net.URISyntaxException;

/**
 * Bybit API WebSocket client implementation using OkHttp.
 */
@Getter
public class BybitApiWebSocketClientImpl implements BybitApiWebSocketClient, Closeable {
    private final OkHttpClient client;
    private final Boolean useTestnetStreaming;
    private final String websocketChannel;

    public BybitApiWebSocketClientImpl(OkHttpClient client, boolean useTestnetStreaming, String websocketChannel) {
        this.client = client;
        this.useTestnetStreaming = useTestnetStreaming;
        this.websocketChannel = websocketChannel;
    }

    private final Logger logger = LoggerFactory.getLogger(BybitApiWebSocketListener.class);

    // This method can be used as a replacement for your connectWS method.
    public void connectToTopic(String topic) throws URISyntaxException, InterruptedException {
        BybitApiWebSocketListener<Object> listener = new BybitApiWebSocketListener<>(new BybitApiCallback<Object>() {
            @Override
            public void onResponse(Object response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Throwable cause) {
                logger.error(cause.getMessage());
            }
        }, Object.class);
        createNewWebSocket(topic, listener);
    }

    @Override
    public Closeable onOrderBookDataUpdateEvent(String depth, String symbol, BybitApiCallback<Object> callback) {
        String topic = "orderbook." + depth + "." + symbol;
        return createNewWebSocket(topic, new BybitApiWebSocketListener<>(callback, Object.class));
    }

    /**
     * @deprecated This method is no longer functional. Please use the returned {@link Closeable} from any of the other methods to close the web socket.
     */
    @Override
    public void close() {
    }

    private Closeable createNewWebSocket(String topic, BybitApiWebSocketListener<?> listener) {
        String streamingUrl = String.format("%s%s/%s", useTestnetStreaming ? BybitApiConfig.getStreamTestNetBaseUrl() : BybitApiConfig.getStreamMainnetNetBaseUrl(), websocketChannel, topic);
        Request request = new Request.Builder().url(streamingUrl).build();
        final WebSocket webSocket = client.newWebSocket(request, listener);
        return () -> {
            final int code = 1000;
            listener.onClosing(webSocket, code, null);
            webSocket.close(code, null);
            listener.onClosed(webSocket, code, null);
        };
    }

}
