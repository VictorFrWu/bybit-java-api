package com.bybit.api.client.websocket;

import com.bybit.api.client.logging.LoggingInterceptor;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocketListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public final class WebSocketHttpClientSingleton {
    private final Logger LOGGER = LoggerFactory.getLogger(WebSocketHttpClientSingleton.class);
    private boolean debugMode;
    private final OkHttpClient OK_HTTP_CLIENT = createOkHttpClient(debugMode);

    private WebSocketHttpClientSingleton(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public static WebSocketHttpClientSingleton createInstance(boolean debugMode) {
        return new WebSocketHttpClientSingleton(debugMode);
    }

    public OkHttpClient createOkHttpClient(boolean debugMode) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (debugMode) {
            builder.addInterceptor(new LoggingInterceptor(LOGGER));
        }
        return builder.build();
    }

    public void createWebSocket(String url, WebSocketListener listener) {
        Request request = new Request.Builder().url(url).build();
        OK_HTTP_CLIENT.newWebSocket(request, listener);
    }
}
