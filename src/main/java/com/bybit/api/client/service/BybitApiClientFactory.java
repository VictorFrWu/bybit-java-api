package com.bybit.api.client.service;


import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.impl.*;
import com.bybit.api.client.restApi.*;
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
        BybitApiConfig.useTestnet = false;
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
     * Creates a new synchronous/blocking REST client to spot leverage token and spot margin endpoints.
     */
    public BybitApiSpotMarginRestClient newSpotMarginRestClient() {
        return new BybitApiSpotMarginRestClientImpl(apiKey, secret);
    }


    public BybitApiAsyncSpotMarginRestClient newSpotMarginAsyncRestClient() {
        return new BybitApiAsyncSpotMarginRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BybitApiUserRestClient newUserRestClient() {
        return new BybitApiUserRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client to User and upgrade endpoints.
     */
    public BybitApiAsyncUserRestClient newAsyncUserRestClient() {
        return new BybitApiAsyncUserRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new synchronous/blocking REST client to Market Data Endpoints
     */
    public BybitApiMarketRestClient newMarketDataRestClient() {
        return new BybitApiMarketRestClientImpl();
    }

    /**
     * Creates a new asynchronous/non-blocking client to Market Data Endpoints
     */
    public BybitApiAsyncMarketDataRestClient newAsyncMarketDataRestClient() {
        return new BybitApiMarketAsyncRestClientImpl();
    }

    /**
     * Creates a new synchronous/blocking REST client to Institution and Broker Endpoints
     */
    public BybitApiLendingRestClient newLendingRestClient() {
        return new BybitApiLendingRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client to Institution Lending Endpoints
     */
    public BybitApiAsyncLendingRestClient newAsyncLendingRestClient() {
        return new BybitApiAsyncLendingRestClientImpl();
    }

    /**
     * Creates a new synchronous/blocking REST client to trading
     */
    public BybitApiTradeRestClient newTradeRestClient() {
        return new BybitApiTradeRestClientImpl(apiKey, secret);
    }
    /**
     * Creates a new asynchronous/non-blocking REST client to trading
     */
    public BybitApiAsyncTradeRestClient newAsyncTradeRestClient() {
        return new BybitApiTradeAsyncRestClientImpl(apiKey, secret);
    }

    /**
     * Access to public and private websocket with message handler and debug mode
     */
    public WebsocketClient newWebsocketClient(WebsocketMessageHandler messageHandler, Boolean debugMode) {
        return new WebsocketClientImpl(apiKey, secret, BybitApiConfig.useTestnet ? BybitApiConfig.STREAM_TESTNET_DOMAIN : BybitApiConfig.STREAM_MAINNET_DOMAIN, messageHandler, debugMode);
    }

    /**
     * Access to public and private websocket with message handler
     */
    public WebsocketClient newWebsocketClient(WebsocketMessageHandler messageHandler) {
        return new WebsocketClientImpl(apiKey, secret, BybitApiConfig.useTestnet ? BybitApiConfig.STREAM_TESTNET_DOMAIN : BybitApiConfig.STREAM_MAINNET_DOMAIN, messageHandler);
    }

    /**
     * Access to public and private websocket in debug mode without message handler
     */
    public WebsocketClient newWebsocketClient(Boolean debugMode) {
        return new WebsocketClientImpl(apiKey, secret, BybitApiConfig.useTestnet ? BybitApiConfig.STREAM_TESTNET_DOMAIN : BybitApiConfig.STREAM_MAINNET_DOMAIN, debugMode);
    }

    /**
     * Access to public and private websocket without message handler and debug mode
     */
    public WebsocketClient newWebsocketClient() {
        return new WebsocketClientImpl(apiKey, secret, BybitApiConfig.useTestnet ? BybitApiConfig.STREAM_TESTNET_DOMAIN : BybitApiConfig.STREAM_MAINNET_DOMAIN);
    }

    /**
     * Creates a new synchronous/blocking REST client to position data
     */
    public BybitApiPositionRestClient newPositionRestClient() {
        return new BybitApiPositionRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new asynchronous/non-blocking client to position data
     */
    public BybitApiAsyncPositionRestClient newAsyncPositionRestClient() {
        return new BybitApiAsyncPositionRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new synchronous/blocking REST client to Account data
     */
    public BybitApiAccountRestClient newAccountRestClient() {
        return new BybitApiAccountRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Account data
     */
    public BybitApiAsyncAccountRestClient newAsyncAccountRestClient() {
        return new BybitApiAsyncAccountRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new synchronous/blocking REST client to Asset data
     */
    public BybitApiAssetRestClient newAssetRestClient() {
        return new BybitApiAssetRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Asset data
     */
    public BybitApiAsyncAssetRestClient newAsyncAssetRestClient() {
        return new BybitApiAsyncAssetRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new synchronous/blocking REST client to Broker earning data
     */
    public BybitApiBrokerRestClient newBrokerRestClient() {
        return new BybitApBrokerRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Broker earning data
     */
    public BybitApiAsyncBrokerRestClient newAsyncBrokerRestClient() {
        return new BybitApiAsyncBrokerRestClientImpl(apiKey, secret);
    }
}
