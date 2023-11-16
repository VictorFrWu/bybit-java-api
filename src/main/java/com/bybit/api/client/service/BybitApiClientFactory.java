package com.bybit.api.client.service;


import com.bybit.api.client.impl.*;
import com.bybit.api.client.log.LogOption;
import com.bybit.api.client.restApi.*;
import com.bybit.api.client.websocket.WebsocketClient;
import com.bybit.api.client.websocket.WebsocketClientImpl;
import com.bybit.api.client.websocket.WebsocketMessageHandler;

import static com.bybit.api.client.config.BybitApiConfig.MAINNET_DOMAIN;
import static com.bybit.api.client.constant.BybitApiConstants.*;

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
    private final Boolean debugMode;

    /**
     * DebugMode log option to print request and response header
     */
    private final String logOption;

    /**
     * recvWindow to print request and response header
     */
    private final Long recvWindow;

    /**
     * Instantiates a new Bybit api client factory.
     *
     * @param apiKey    api key
     * @param secret    api secret
     * @param baseUrl   base url
     * @param debugMode debugMode
     */
    private BybitApiClientFactory(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.baseUrl = baseUrl;
        this.debugMode = debugMode;
        this.recvWindow = recvWindow;
        this.logOption = logOption;
    }

    /**
     * New instance of Api Mainnet Client
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the Bybit api client factory
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret) {
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, false, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType());
    }


    /**
     * New instance of Api Mainnet Client with url
     *
     * @param apiKey  the API key
     * @param secret  the Secret
     * @param baseUrl the baseUrl
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, String baseUrl) {
        return new BybitApiClientFactory(apiKey, secret, baseUrl, false, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType());
    }

    public static BybitApiClientFactory newInstance(String apiKey, String secret, long recvWindow) {
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, false, recvWindow, LogOption.SLF4J.getLogOptionType());
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
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, debugMode, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType());
    }

    public static BybitApiClientFactory newInstance(String apiKey, String secret, boolean debugMode, String logOption) {
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, debugMode, DEFAULT_RECEIVING_WINDOW, logOption);
    }

    public static BybitApiClientFactory newInstance(String apiKey, String secret, boolean debugMode, long recvWindow) {
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, debugMode, recvWindow, LogOption.SLF4J.getLogOptionType());
    }

    public static BybitApiClientFactory newInstance(String apiKey, String secret, boolean debugMode, long recvWindow, String logOption) {
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, debugMode, recvWindow, logOption);
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
        return new BybitApiClientFactory(apiKey, secret, baseUrl, debugMode, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType());
    }

    public static BybitApiClientFactory newInstance(String apiKey, String secret, String baseUrl, long recvWindow) {
        return new BybitApiClientFactory(apiKey, secret, baseUrl, false, recvWindow, LogOption.SLF4J.getLogOptionType());
    }


    /**
     * New instance without authentication.
     *
     * @return the Bybit api client factory
     */
    public static BybitApiClientFactory newInstance() {
        return new BybitApiClientFactory(null, null, MAINNET_DOMAIN, false, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType());
    }

    public static BybitApiClientFactory newInstance(long recvWindow) {
        return new BybitApiClientFactory(null, null, MAINNET_DOMAIN, false, recvWindow, LogOption.SLF4J.getLogOptionType());
    }

    /**
     * New instance without authentication and with optional url
     *
     * @param baseUrl base url
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String baseUrl) {
        return new BybitApiClientFactory(null, null, baseUrl, false, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType());
    }

    /**
     * New instance without authentication and with optional debug mode
     *
     * @param debugMode debug mode
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(boolean debugMode) {
        return new BybitApiClientFactory(null, null, MAINNET_DOMAIN, debugMode, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType());
    }

    public static BybitApiClientFactory newInstance(boolean debugMode, String logOption) {
        return new BybitApiClientFactory(null, null, MAINNET_DOMAIN, debugMode, DEFAULT_RECEIVING_WINDOW, logOption);
    }

    /**
     * New instance without authentication and with optional base url and debug mode
     *
     * @param baseUrl   base url
     * @param debugMode debug mode
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String baseUrl, boolean debugMode, String logOption) {
        return new BybitApiClientFactory(null, null, baseUrl, debugMode, DEFAULT_RECEIVING_WINDOW, logOption);
    }

    public static BybitApiClientFactory newInstance(String baseUrl, boolean debugMode) {
        return new BybitApiClientFactory(null, null, baseUrl, debugMode, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType());
    }

    /**
     * Creates a new synchronous/blocking REST client to spot leverage token and spot margin endpoints.
     */
    public BybitApiSpotMarginRestClient newSpotMarginRestClient() {
        return new BybitApiSpotMarginRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }


    public BybitApiAsyncSpotMarginRestClient newSpotMarginAsyncRestClient() {
        return new BybitApiAsyncSpotMarginRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BybitApiUserRestClient newUserRestClient() {
        return new BybitApiUserRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client to User and upgrade endpoints.
     */
    public BybitApiAsyncUserRestClient newAsyncUserRestClient() {
        return new BybitApiAsyncUserRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to Market Data Endpoints
     */
    public BybitApiMarketRestClient newMarketDataRestClient() {
        return new BybitApiMarketRestClientImpl(baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Market Data Endpoints
     */
    public BybitApiAsyncMarketDataRestClient newAsyncMarketDataRestClient() {
        return new BybitApiMarketAsyncRestClientImpl(baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to Institution and Broker Endpoints
     */
    public BybitApiLendingRestClient newLendingRestClient() {
        return new BybitApiLendingRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client to Institution Lending Endpoints
     */
    public BybitApiAsyncLendingRestClient newAsyncLendingRestClient() {
        return new BybitApiAsyncLendingRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to trading
     */
    public BybitApiTradeRestClient newTradeRestClient() {
        return new BybitApiTradeRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client to trading
     */
    public BybitApiAsyncTradeRestClient newAsyncTradeRestClient() {
        return new BybitApiTradeAsyncRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to position data
     */
    public BybitApiPositionRestClient newPositionRestClient() {
        return new BybitApiPositionRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking client to position data
     */
    public BybitApiAsyncPositionRestClient newAsyncPositionRestClient() {
        return new BybitApiAsyncPositionRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to Account data
     */
    public BybitApiAccountRestClient newAccountRestClient() {
        return new BybitApiAccountRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Account data
     */
    public BybitApiAsyncAccountRestClient newAsyncAccountRestClient() {
        return new BybitApiAsyncAccountRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to Asset data
     */
    public BybitApiAssetRestClient newAssetRestClient() {
        return new BybitApiAssetRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Asset data
     */
    public BybitApiAsyncAssetRestClient newAsyncAssetRestClient() {
        return new BybitApiAsyncAssetRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to Broker earning data
     */
    public BybitApiBrokerRestClient newBrokerRestClient() {
        return new BybitApBrokerRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Broker earning data
     */
    public BybitApiAsyncBrokerRestClient newAsyncBrokerRestClient() {
        return new BybitApiAsyncBrokerRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Access to public websocket
     */
    public WebsocketClient newWebsocketClient() {
        return new WebsocketClientImpl(apiKey, secret, baseUrl, DEFAULT_PING_INTERVAL, DEFAULT_MAX_ALIVE_TIME, debugMode, logOption, null);
    }

    public WebsocketClient newWebsocketClient(int pingInterval) {
        return new WebsocketClientImpl(apiKey, secret, baseUrl, pingInterval, DEFAULT_MAX_ALIVE_TIME, debugMode, logOption, null);
    }

    public WebsocketClient newWebsocketClient(String maxAliveTime) {
        return new WebsocketClientImpl(apiKey, secret, baseUrl, DEFAULT_PING_INTERVAL, maxAliveTime, debugMode, logOption, null);
    }

    public WebsocketClient newWebsocketClient(WebsocketMessageHandler messageHandler) {
        return new WebsocketClientImpl(apiKey, secret, baseUrl, DEFAULT_PING_INTERVAL, DEFAULT_MAX_ALIVE_TIME, debugMode, logOption, messageHandler);
    }

    public WebsocketClient newWebsocketClient(int pingInterval, WebsocketMessageHandler messageHandler) {
        return new WebsocketClientImpl(apiKey, secret, baseUrl, pingInterval, DEFAULT_MAX_ALIVE_TIME, debugMode, logOption, messageHandler);
    }
    public WebsocketClient newWebsocketClient(int pingInterval, String maxAliveTime) {
        return new WebsocketClientImpl(apiKey, secret, baseUrl, pingInterval, maxAliveTime, debugMode, logOption, null);
    }

    public WebsocketClient newWebsocketClient(String maxAliveTime, WebsocketMessageHandler messageHandler) {
        return new WebsocketClientImpl(apiKey, secret, baseUrl, DEFAULT_PING_INTERVAL, maxAliveTime, debugMode, logOption, null);
    }

    public WebsocketClient newWebsocketClient(int pingInterval, String maxAliveTime, WebsocketMessageHandler messageHandler) {
        return new WebsocketClientImpl(apiKey, secret, baseUrl, pingInterval, maxAliveTime, debugMode, logOption, messageHandler);
    }
}
