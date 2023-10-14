package com.bybit.api.client.websocket;

import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocketListener;

public final class WebSocketHttpClientSingleton {
    @Getter
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    private WebSocketHttpClientSingleton() {
    }
    public static void createWebSocket(String url, WebSocketListener listener) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newWebSocket(request, listener);
    }
}
