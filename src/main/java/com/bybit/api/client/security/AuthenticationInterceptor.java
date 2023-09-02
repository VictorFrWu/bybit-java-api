package com.bybit.api.client.security;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.constant.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import static com.bybit.api.client.security.HmacSHA256Signer.sign;

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {

    private final String apiKey;

    private final String secret;

    public AuthenticationInterceptor(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        boolean isApiKeyRequired = original.header(BybitApiConstants.API_KEY_HEADER) != null;
        boolean isSignatureRequired = original.header(BybitApiConstants.SIGN_HEADER) != null;
        newRequestBuilder.removeHeader(BybitApiConstants.API_KEY_HEADER)
                .removeHeader(BybitApiConstants.SIGN_HEADER);

        // Endpoint requires signing the payload
        String payload = "";
        if ("GET".equals(original.method())) {
            payload = original.url().query(); // extract query params
            newRequestBuilder.get();
        }else if ("POST".equals(original.method()) && original.body() != null) {
            Buffer buffer = new Buffer();
            original.body().writeTo(buffer);
            payload = buffer.readUtf8();
            if(StringUtils.isEmpty(payload))
            {
                // Extract JSON payload from POST request
                payload = original.url().query();

                // Convert query parameters into a JSON payload
                Map<String, Object> paramsMap = Util.convertQueryToMap(payload);
                ObjectMapper objectMapper = new ObjectMapper();
                payload = objectMapper.writeValueAsString(paramsMap);
            }
            // Remove query parameters from URL
            HttpUrl newUrl = original.url().newBuilder()
                    .query(null)
                    .build();
            newRequestBuilder.url(newUrl);

            MediaType mediaType = MediaType.parse("application/json");
            newRequestBuilder.post(RequestBody.create(mediaType, payload)); // set new POST body
        }

        if (isApiKeyRequired || isSignatureRequired) {
            long timestamp = Util.generateTimestamp();
            String signature = sign(apiKey, secret, StringUtils.isEmpty(payload) ? ""  : payload, timestamp, BybitApiConstants.DEFAULT_RECEIVING_WINDOW);
            newRequestBuilder.addHeader(BybitApiConstants.API_KEY_HEADER, apiKey);
            newRequestBuilder.addHeader(BybitApiConstants.SIGN_HEADER, signature);
            newRequestBuilder.addHeader(BybitApiConstants.SIGN_TYPE_HEADER, BybitApiConstants.DEFAULT_SIGNATURE_TYPE);
            newRequestBuilder.addHeader(BybitApiConstants.TIMESTAMP_HEADER, String.valueOf(timestamp));
            newRequestBuilder.addHeader(BybitApiConstants.RECV_WINDOW_HEADER, String.valueOf(BybitApiConstants.DEFAULT_RECEIVING_WINDOW));
            newRequestBuilder.addHeader(BybitApiConstants.API_CONTENT_TYPE, BybitApiConstants.DEFAULT_CONTENT_TYPE);
        }
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AuthenticationInterceptor that = (AuthenticationInterceptor) o;
        return Objects.equals(apiKey, that.apiKey) &&
                Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, secret);
    }
}