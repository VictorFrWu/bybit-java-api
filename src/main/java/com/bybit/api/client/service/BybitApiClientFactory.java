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
     * BaseUrl
     */
    private final String baseUrl;

    /**
     * DebugMode to print request and response header
     */
    private final boolean debugMode;

    /**
     * Instantiates a new Bybit api client factory.
     *
     * @param apiKey    api key
     * @param secret    api secret
     * @param baseUrl   base url
     * @param debugMode debugMode
     */
    private BybitApiClientFactory(String apiKey, String secret, String baseUrl, boolean debugMode) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.baseUrl = baseUrl;
        this.debugMode = debugMode;
    }

    private BybitApiClientFactory(String apiKey, String secret, boolean debugMode) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.baseUrl = BybitApiConfig.MAINNET_DOMAIN;
        this.debugMode = debugMode;
    }

    private BybitApiClientFactory(String apiKey, String secret, String baseUrl) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.baseUrl = baseUrl;
        this.debugMode = false;
    }

    private BybitApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.baseUrl = BybitApiConfig.MAINNET_DOMAIN;
        this.debugMode = false;
    }

    /**
     * New instance of Api Mainnet Client
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the Bybit api client factory
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret) {
        return new BybitApiClientFactory(apiKey, secret);
    }


    /**
     * New instance of Api Mainnet Client with url
     *
     * @param apiKey    the API key
     * @param secret    the Secret
     * @param baseUrl    the baseUrl
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, String baseUrl) {
        return new BybitApiClientFactory(apiKey, secret, baseUrl);
    }

    /**
     * New instance of Api Mainnet Client with debug mode
     *
     * @param apiKey    the API key
     * @param secret    the Secret
     * @param debugMode to print request and response header
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, boolean debugMode) {
        return new BybitApiClientFactory(apiKey, secret, debugMode);
    }

    /**
     * New instance of Api Client without debug mode and set URL
     *
     * @param apiKey  the API key
     * @param secret  the Secret
     * @param baseUrl base url
     * @return the Bybit api client factory
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, String baseUrl, boolean debugMode) {
        return new BybitApiClientFactory(apiKey, secret, baseUrl, debugMode);
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
     * New instance without authentication and with optional url
     *
     * @param baseUrl base url
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String baseUrl) {
        return new BybitApiClientFactory(null, null, baseUrl);
    }

    /**
     * New instance without authentication and with optional debug mode
     *
     * @param debugMode debug mode
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(boolean debugMode) {
        return new BybitApiClientFactory(null, null, debugMode);
    }

    /**
     * New instance without authentication and with optional base url and debug mode
     *
     * @param baseUrl base url
     * @param debugMode debug mode
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String baseUrl, boolean debugMode) {
        return new BybitApiClientFactory(null, null, baseUrl, debugMode);
    }

    /**
     * Creates a new synchronous/blocking REST client to spot leverage token and spot margin endpoints.
     */
    public BybitApiSpotMarginRestClient newSpotMarginRestClient() {
        return new BybitApiSpotMarginRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }


    public BybitApiAsyncSpotMarginRestClient newSpotMarginAsyncRestClient() {
        return new BybitApiAsyncSpotMarginRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BybitApiUserRestClient newUserRestClient() {
        return new BybitApiUserRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client to User and upgrade endpoints.
     */
    public BybitApiAsyncUserRestClient newAsyncUserRestClient() {
        return new BybitApiAsyncUserRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new synchronous/blocking REST client to Market Data Endpoints
     */
    public BybitApiMarketRestClient newMarketDataRestClient() {
        return new BybitApiMarketRestClientImpl(baseUrl, debugMode);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Market Data Endpoints
     */
    public BybitApiAsyncMarketDataRestClient newAsyncMarketDataRestClient() {
        return new BybitApiMarketAsyncRestClientImpl(baseUrl, debugMode);
    }

    /**
     * Creates a new synchronous/blocking REST client to Institution and Broker Endpoints
     */
    public BybitApiLendingRestClient newLendingRestClient() {
        return new BybitApiLendingRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client to Institution Lending Endpoints
     */
    public BybitApiAsyncLendingRestClient newAsyncLendingRestClient() {
        return new BybitApiAsyncLendingRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new synchronous/blocking REST client to trading
     */
    public BybitApiTradeRestClient newTradeRestClient() {
        return new BybitApiTradeRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client to trading
     */
    public BybitApiAsyncTradeRestClient newAsyncTradeRestClient() {
        return new BybitApiTradeAsyncRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new synchronous/blocking REST client to position data
     */
    public BybitApiPositionRestClient newPositionRestClient() {
        return new BybitApiPositionRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new asynchronous/non-blocking client to position data
     */
    public BybitApiAsyncPositionRestClient newAsyncPositionRestClient() {
        return new BybitApiAsyncPositionRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new synchronous/blocking REST client to Account data
     */
    public BybitApiAccountRestClient newAccountRestClient() {
        return new BybitApiAccountRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Account data
     */
    public BybitApiAsyncAccountRestClient newAsyncAccountRestClient() {
        return new BybitApiAsyncAccountRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new synchronous/blocking REST client to Asset data
     */
    public BybitApiAssetRestClient newAssetRestClient() {
        return new BybitApiAssetRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Asset data
     */
    public BybitApiAsyncAssetRestClient newAsyncAssetRestClient() {
        return new BybitApiAsyncAssetRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new synchronous/blocking REST client to Broker earning data
     */
    public BybitApiBrokerRestClient newBrokerRestClient() {
        return new BybitApBrokerRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Broker earning data
     */
    public BybitApiAsyncBrokerRestClient newAsyncBrokerRestClient() {
        return new BybitApiAsyncBrokerRestClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Access to public and private websocket without message handler
     */
    public WebsocketClient newWebsocketClient() {
        return new WebsocketClientImpl(apiKey, secret, baseUrl, debugMode);
    }

    /**
     * Access to public and private websocket with message handler
     */
    public WebsocketClient newWebsocketClient(WebsocketMessageHandler messageHandler) {
        return new WebsocketClientImpl(apiKey, secret, baseUrl, debugMode, messageHandler);
    }
}
