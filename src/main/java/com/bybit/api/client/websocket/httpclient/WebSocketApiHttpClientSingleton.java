package com.bybit.api.client.websocket.httpclient;

import lombok.Getter;
import okhttp3.OkHttpClient;

public final class WebSocketApiHttpClientSingleton {
    @Getter
    private static final OkHttpClient httpClient = new OkHttpClient();

    private WebSocketApiHttpClientSingleton() {
    }

}
