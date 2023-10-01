package com.bybit.api.client;

import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.request.*;

/**
 * Bybit API facade, supporting asynchronous/non-blocking access Bybit's REST API.
 */
public interface BybitApiAsyncRestClient {
    // Market Data
    void getServerTime(BybitApiCallback<Object> callback);

    void getMarketLinesData(MarketKlineRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getMarketPriceLinesData(MarketKlineRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getIndexPriceLinesData(MarketKlineRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getPremiumIndexPriceLinesData(MarketKlineRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getInstrumentsInfo(InstrumentInfoRequest instrumentInfoRequest, BybitApiCallback<Object> callback);

    void getMarketOrderbook(MarketOrderBookRequest marketOrderBookRequest, BybitApiCallback<Object> callback);

    void getMarketTickers(MarketDataTickerRequest marketDataTickerRequest, BybitApiCallback<Object> callback);

    void getFundingHistory(FundingHistoryRequest fundingHistoryRequest, BybitApiCallback<Object> callback);

    void getRecentTradeData(RecentTradeDataRequest recentTradeRequest, BybitApiCallback<Object> callback);

    void getOpenInterest(OpenInterestRequest openInterestRequest, BybitApiCallback<Object> callback);

    void getHistoricalVolatility(HistoricalVolatilityRequest historicalVolatilityRequest, BybitApiCallback<Object> callback);

    void getInsurance(String coin, BybitApiCallback<Object> callback);

    void getInsurance(BybitApiCallback<Object> callback);

    void getRiskLimit(MarketRiskLimitRequest marketRiskLimitRequest, BybitApiCallback<Object> callback);

    void getDeliveryPrice(DeliveryPriceRequest deliveryPriceRequest, BybitApiCallback<Object> callback);

    void getMarketAccountRatio(MarketAccountRatioRequest marketAccountRatioRequest, BybitApiCallback<Object> callback);
}
