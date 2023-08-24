package com.bybit.api.client.impl;


import com.bybit.api.client.extension.BybitApiAsyncRestClient;
import com.bybit.api.client.extension.BybitApiRestClient;
import com.bybit.api.client.config.BybitApiConfig;

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
        BybitApiConfig.useTestnetStreaming = false;
    }

    /**
     * Instantiates a new Bybit api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @param useTestnet true if endpoint is spot test network URL; false if endpoint is production spot API URL.
     * @param useTestnetStreaming true for spot test network websocket streaming; false for no streaming.
     */
    private BybitApiClientFactory(String apiKey, String secret, boolean useTestnet, boolean useTestnetStreaming) {
        this(apiKey, secret);
        if (useTestnet) {
            BybitApiConfig.useTestnet = true;
            BybitApiConfig.useTestnetStreaming = useTestnetStreaming; }
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
     * @param useTestnet true if endpoint is spot test network URL; false if endpoint is production spot API URL.
     * @param useTestnetStreaming true for spot test network websocket streaming; false for no streaming.
     *
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, boolean useTestnet, boolean useTestnetStreaming) {
        return new BybitApiClientFactory(apiKey, secret, useTestnet, useTestnetStreaming);
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
     * @param useTestnet true if endpoint is spot test network URL; false if endpoint is production spot API URL.
     * @param useTestnetStreaming true for spot test network websocket streaming; false for no streaming.
     *
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(boolean useTestnet, boolean useTestnetStreaming) {
        return new BybitApiClientFactory(null, null, useTestnet, useTestnetStreaming);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BybitApiRestClient newRestClient() {
        return new BybitApiRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public BybitApiAsyncRestClient newAsyncRestClient() {
        return new BybitApiAsyncRestClientImpl(apiKey, secret);
    }
}
