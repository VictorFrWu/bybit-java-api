package com.bybit.api.client.log;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiServiceGenerator;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Logging Interceptor
 */
public class Slf4jLoggingInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(BybitApiServiceGenerator.class);

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        // Log request headers using SLF4J
        logHeaders(request.headers(), "--- request header ---");

        Response response = chain.proceed(request);

        // Log response headers using SLF4J
        logHeaders(response.headers(), "--- response header ---");

        return response;
    }

    private void logHeaders(Headers headers, String headerTitle) {
        LOGGER.info(headerTitle);
        for (String name : headers.names()) {
            LOGGER.info("{}: {}", name, headers.get(name));
        }
        LOGGER.info("-----------------------");
    }


    public static void HandleLoggingInterceptor(OkHttpClient.Builder clientBuilder) {
        LOGGER.info("Debug Mode Activated, Trace Request in body level");
        if(BybitApiConfig.useSlf4j)
            clientBuilder.addInterceptor(new Slf4jLoggingInterceptor());
        else{
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(LOGGER::info);
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(loggingInterceptor);
        }
    }
}
