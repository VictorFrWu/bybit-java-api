package com.bybit.api.client.websocket;

import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocketListener;

import static com.bybit.api.client.log.Slf4jLoggingInterceptor.HandleLoggingInterceptor;

@Getter
public final class WebSocketHttpClientSingleton {
    private final boolean debugMode;
    private final String logOption;

    private WebSocketHttpClientSingleton(boolean debugMode, String logOption) {
        this.debugMode = debugMode;
        this.logOption = logOption;
    }

    public static WebSocketHttpClientSingleton createInstance(boolean debugMode, String logOption) {
        return new WebSocketHttpClientSingleton(debugMode, logOption);
    }

    public OkHttpClient createOkHttpClient(boolean debugMode, String logOption) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        if (debugMode) {
            HandleLoggingInterceptor(clientBuilder, logOption);
        }
        return clientBuilder.build();
    }

    public void createWebSocket(String url, WebSocketListener listener) {
        Request request = new Request.Builder().url(url).build();
        OkHttpClient okHttpClient = createOkHttpClient(debugMode, logOption);
        okHttpClient.newWebSocket(request, listener);
    }
}
