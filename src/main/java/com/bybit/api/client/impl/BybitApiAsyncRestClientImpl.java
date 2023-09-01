package com.bybit.api.client.impl;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.MarketKlineResult;
import com.bybit.api.client.domain.market.MarketKlineInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.service.BybitApiService;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

/**
 * Implementation of Bybit's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BybitApiAsyncRestClientImpl implements BybitApiAsyncRestClient {

    private final BybitApiService bybitApiService;

    public BybitApiAsyncRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }

    // Market Data endpoints

    @Override
    public void getMarketLinesData(ProductType category, String symbol, MarketKlineInterval interval, Integer limit, Long startTime, Long endTime, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketLinesData(category.getProductTypeId(), symbol, interval.getIntervalId(), limit, startTime, endTime).enqueue(new BybitApiCallbackAdapter<Object>(callback));
    }

    @Override
    public void getMarketLinesData(ProductType category, String symbol, MarketKlineInterval interval, BybitApiCallback<Object> callback) {
        getMarketLinesData(category, symbol, interval, null, null, null, callback);
    }
}
