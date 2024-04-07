package com.bybit.api.client.util;

import okhttp3.MediaType;
import okhttp3.Request;

public final class RequestBuilder {
    private static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");
    private static final String USER_AGENT = "binance-connector-java/3.2.0";
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    private RequestBuilder() {
    }
    public static Request buildWebSocketRequest(String fullUrl) {
        return new Request.Builder().url(fullUrl).build();
    }
}
