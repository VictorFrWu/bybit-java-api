package com.bybit.api.client;

import com.bybit.api.client.domain.market.MarketDataRequest;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.request.*;

/**
 * Bybit API facade, supporting asynchronous/non-blocking access Bybit's REST API.
 */
public interface BybitApiAsyncRestClient {
    // Market Data
    void getServerTime(BybitApiCallback<Object> callback);

    void getMarketLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getMarketPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getIndexPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getPremiumIndexPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getInstrumentsInfo(MarketDataRequest instrumentInfoRequest, BybitApiCallback<Object> callback);

    void getMarketOrderbook(MarketDataRequest marketOrderBookRequest, BybitApiCallback<Object> callback);

    void getMarketTickers(MarketDataRequest marketDataTickerRequest, BybitApiCallback<Object> callback);

    void getFundingHistory(MarketDataRequest fundingHistoryRequest, BybitApiCallback<Object> callback);

    void getRecentTradeData(MarketDataRequest recentTradeRequest, BybitApiCallback<Object> callback);

    void getOpenInterest(MarketDataRequest openInterestRequest, BybitApiCallback<Object> callback);

    void getHistoricalVolatility(MarketDataRequest historicalVolatilityRequest, BybitApiCallback<Object> callback);

    void getInsurance(String coin, BybitApiCallback<Object> callback);

    void getInsurance(BybitApiCallback<Object> callback);

    void getRiskLimit(MarketDataRequest marketRiskLimitRequest, BybitApiCallback<Object> callback);

    void getDeliveryPrice(MarketDataRequest deliveryPriceRequest, BybitApiCallback<Object> callback);

    void getMarketAccountRatio(MarketDataRequest marketAccountRatioRequest, BybitApiCallback<Object> callback);
}
