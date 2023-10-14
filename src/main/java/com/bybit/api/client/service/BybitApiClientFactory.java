package com.bybit.api.client.service;


import com.bybit.api.client.*;
import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.impl.*;
import com.bybit.api.client.websocket.WebsocketClient;
import com.bybit.api.client.websocket.WebsocketClientImpl;
import com.bybit.api.client.websocket.WebsocketMessageHandler;

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
     * Creates a new synchronous/blocking REST client to Announcement Endpoints
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
     * Creates a new synchronous/blocking REST client to Institution Lending Endpoints
     */
    public BybitApiInsLendingRestClient newInsLendingRestClient() {
        return new BybitInsLendingRestClientImpl();
    }

    /**
     * Creates a new synchronous/blocking REST client to trading
     */
    public BybitApiTradeRestClient newTradeRestClient() {
        return new BybitTradeRestClientImpl(apiKey, secret);
    }
    /**
     * Creates a new asynchronous/non-blocking REST client to trading
     */
    public BybitApAsynciTradeRestClient newAsyncTradeRestClient() {
        return new BybitTradeAsyncRestClientImpl(apiKey, secret);
    }

    public WebsocketClient newWebsocketClient(WebsocketMessageHandler messageHandler) {
        return new WebsocketClientImpl(apiKey, secret, BybitApiConfig.useTestnet ? BybitApiConfig.STREAM_TESTNET_DOMAIN : BybitApiConfig.STREAM_MAINNET_DOMAIN, messageHandler);
    }
}
