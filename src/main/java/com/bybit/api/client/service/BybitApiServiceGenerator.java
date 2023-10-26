package com.bybit.api.client.service;

import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.exception.BybitApiError;
import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.exception.BybitApiException;
import com.bybit.api.client.security.AuthenticationInterceptor;
import lombok.Getter;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Generates a Bybit API implementation based on @see {@link BybitApiService}.
 */
public class BybitApiServiceGenerator {

    /**
     * -- GETTER --
     *  Returns the shared OkHttpClient instance.
     */
    @Getter
    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();
    }

    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, BybitApiError> errorBodyConverter =
            (Converter<ResponseBody, BybitApiError>) converterFactory.responseBodyConverter(
                    BybitApiError.class, new Annotation[0], null);

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    /**
     * Create a Bybit API service.
     *
     * @param serviceClass the type of service.
     * @param apiKey Bybit API key.
     * @param secret Bybit secret.
     *
     * @return a new implementation of the API endpoints for the Bybit API service.
     */
    public static <S> S createService(Class<S> serviceClass, String apiKey, String secret) {
        String baseUrl;
        if (!BybitApiConfig.useTestnet) {
            baseUrl = BybitApiConfig.MAINNET_DOMAIN;
        } else {
            baseUrl = BybitApiConfig.TESTNET_DOMAIN;
        }

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory);

        if (StringUtils.isEmpty(apiKey) || StringUtils.isEmpty(secret)) {
            retrofitBuilder.client(sharedClient);
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc. with the 'parent' client
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey, secret);
            OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> Object executeSync(Call<T> call) {
        try {
            var response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                BybitApiError apiError = getBybitApiError(response);
                throw new BybitApiException(apiError);
            }
        } catch (IOException e) {
            throw new BybitApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static BybitApiError getBybitApiError(Response<?> response) throws IOException, BybitApiException{
        if (errorBodyConverter != null) {
            return errorBodyConverter.convert(Objects.requireNonNull(response.errorBody()));
        }
            return new BybitApiError();
    }

}
