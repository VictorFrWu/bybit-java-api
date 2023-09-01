package com.bybit.api.client.impl;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.MarketKlineResult;
import com.bybit.api.client.domain.market.MarketKlineInterval;
import com.bybit.api.client.domain.ProductType;

/**
 * Bybit API facade, supporting asynchronous/non-blocking access Bybit's REST API.
 */
public interface BybitApiAsyncRestClient {

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @param category product type. spot,linear, inverse (mandatory)
     * @param symbol symbol to aggregate (mandatory)
     * @param interval candlestick interval (mandatory)
     * @param limit Default 500; max 1000 (optional)
     * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
     * @param endTime Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
     * @param callback the callback that handles the response containing a candlestick bar for the given symbol and interval
     */
    void getMarketLinesData(ProductType category, String symbol, MarketKlineInterval interval, Integer limit, Long startTime, Long endTime, BybitApiCallback<Object> callback);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @see #getMarketLinesData(ProductType, String, MarketKlineInterval, BybitApiCallback)
     */
    void getMarketLinesData(ProductType category, String symbol, MarketKlineInterval interval, BybitApiCallback<Object> callback);
}
