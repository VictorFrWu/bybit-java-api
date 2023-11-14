package com.bybit.api.client.websocket;

import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocketListener;

import static com.bybit.api.client.log.Slf4jLoggingInterceptor.HandleLoggingInterceptor;

@Getter
public final class WebSocketHttpClientSingleton {
    private final boolean debugMode;

    private WebSocketHttpClientSingleton(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public static WebSocketHttpClientSingleton createInstance(boolean debugMode) {
        return new WebSocketHttpClientSingleton(debugMode);
    }

    public OkHttpClient createOkHttpClient(boolean debugMode) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        if (debugMode) {
            HandleLoggingInterceptor(clientBuilder);
        }
        return clientBuilder.build();
    }

    public void createWebSocket(String url, WebSocketListener listener) {
        Request request = new Request.Builder().url(url).build();
        OkHttpClient okHttpClient = createOkHttpClient(debugMode);
        okHttpClient.newWebSocket(request, listener);
    }
}
