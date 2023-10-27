package com.bybit.api.client.websocket;

import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocketListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public final class WebSocketHttpClientSingleton {
    private final Logger LOGGER = LoggerFactory.getLogger(WebSocketHttpClientSingleton.class);
    private final boolean debugMode;

    private WebSocketHttpClientSingleton(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public static WebSocketHttpClientSingleton createInstance(boolean debugMode) {
        return new WebSocketHttpClientSingleton(debugMode);
    }

    public OkHttpClient createOkHttpClient(boolean debugMode) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (debugMode) {
            LOGGER.info("Debug Mode Actived, Trace Request Header and Response Header");
            builder.addInterceptor(new WebsocketLoggingInterceptor(LOGGER));
        }
        return builder.build();
    }

    public void createWebSocket(String url, WebSocketListener listener) {
        Request request = new Request.Builder().url(url).build();
        OkHttpClient okHttpClient = createOkHttpClient(debugMode);
        okHttpClient.newWebSocket(request, listener);
    }
}
