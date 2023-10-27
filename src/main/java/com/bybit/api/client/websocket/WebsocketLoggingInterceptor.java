package com.bybit.api.client.websocket;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.io.IOException;

public class WebsocketLoggingInterceptor implements Interceptor {
    private final Logger LOGGER;
    public WebsocketLoggingInterceptor(Logger logger) {
        this.LOGGER = logger;
    }

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        // Log request headers
        logHeaders(request.headers(), "--- request header ---");

        Response response = chain.proceed(request);

        // Log response headers
        logHeaders(response.headers(), "--- response header ---");

        return response;
    }

    private void logHeaders(Headers headers, String headerTitle) {
        LOGGER.info(headerTitle);
        for (String name : headers.names()) {
            LOGGER.info(name + ": " + headers.get(name));
        }
        LOGGER.info("-----------------------");
    }
}
