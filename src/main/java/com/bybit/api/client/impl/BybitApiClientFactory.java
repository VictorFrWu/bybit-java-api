package com.bybit.api.client.impl;


import com.bybit.api.client.BybitAnnouncementRestClient;
import com.bybit.api.client.BybitApiAsyncRestClient;
import com.bybit.api.client.BybitApiRestClient;
import com.bybit.api.client.BybitApiWebSocketClient;
import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiServiceGenerator;

/**
 * A factory for creating BybitApi client objects.
 */
public class BybitApiClientFactory {

    /**
     * API Key
     */
    private final String apiKey;

    /**
     * Secret.
     */
    private final String secret;

    /**
     * Instantiates a new Bybit api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private BybitApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
        BybitApiConfig.useTestnet = true;
    }

    /**
     * Instantiates a new Bybit api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @param useTestnet true if endpoint is test network URL; false if endpoint is production API URL.
     */
    private BybitApiClientFactory(String apiKey, String secret, boolean useTestnet) {
        this(apiKey, secret);
        if (useTestnet)
            BybitApiConfig.useTestnet = true;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     *
     * @return the Bybit api client factory
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret) {
        return new BybitApiClientFactory(apiKey, secret);
    }

    /**
     * New instance with optional Spot Test Network endpoint.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @param useTestnet true if endpoint is test network URL; false if endpoint is production spot API URL.
     *
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, boolean useTestnet) {
        return new BybitApiClientFactory(apiKey, secret, useTestnet);
    }

    /**
     * New instance without authentication.
     *
     * @return the Bybit api client factory
     */
    public static BybitApiClientFactory newInstance() {
        return new BybitApiClientFactory(null, null);
    }

    /**
     * New instance without authentication and with optional Spot Test Network endpoint.
     *
     * @param useTestnet true if endpoint is test network URL; false if endpoint is production API URL.
     *
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(boolean useTestnet) {
        return new BybitApiClientFactory(null, null, useTestnet);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BybitApiRestClient newRestClient() {
        return new BybitApiRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BybitAnnouncementRestClient newAnnouncementRestClient() {
        return new BybitAnnouncementRestClientImpl();
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public BybitApiAsyncRestClient newAsyncRestClient() {
        return new BybitApiAsyncRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */
    public BybitApiWebSocketClient newWebSocketClient(boolean useTestnetStreaming, String websocketChannel) {
        return new BybitApiWebSocketClientImpl(BybitApiServiceGenerator.getSharedClient(), useTestnetStreaming, websocketChannel);
    }
}
