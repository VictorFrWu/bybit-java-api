package com.bybit.api.client.extension;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.MarketKlineResult;
import com.bybit.api.client.domain.market.MarketKlineInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.trade.OrderHistoryRequest;
import com.bybit.api.client.domain.trade.OrderResult;

import java.util.List;

public interface BybitApiRestClient {

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @param category product type. spot,linear, inverse (mandatory)
     * @param symbol symbol to aggregate (mandatory)
     * @param interval candlestick interval (mandatory)
     * @param limit Default 500; max 1000 (optional)
     * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
     * @param endTime Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
     * @return a candlestick bar for the given symbol and interval
     */
    GenericResponse<MarketKlineResult> getMarketLinesData(ProductType category, String symbol, MarketKlineInterval interval, Integer limit, Long startTime, Long endTime);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @see #getMarketLinesData(ProductType, String, MarketKlineInterval, Integer, Long, Long)
     */
    GenericResponse<MarketKlineResult> getMarketLinesData(ProductType category, String symbol, MarketKlineInterval interval);

    /**
     * Get all account orders; active, canceled, or filled.
     *
     * @param orderHistoryRequest order request parameters
     * @return a list of all history orders 2 years
     */
    GenericResponse<OrderResult> getHistoryOrderResult(OrderHistoryRequest orderHistoryRequest);
}
