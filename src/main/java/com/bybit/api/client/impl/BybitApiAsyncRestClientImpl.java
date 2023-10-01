package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiAsyncRestClient;
import com.bybit.api.client.BybitApiCallback;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.request.*;
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
    public void getServerTime(BybitApiCallback<Object> callback) {
        bybitApiService.getServerTime().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketLinesData(MarketKlineRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketPriceLinesData(MarketKlineRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketPriceLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getIndexPriceLinesData(MarketKlineRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getIndexPriceLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPremiumIndexPriceLinesData(MarketKlineRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPremiumIndexPriceLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInstrumentsInfo(InstrumentInfoRequest instrumentInfoRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getInstrumentsInfo(
                instrumentInfoRequest.getCategory().getProductTypeId(),
                instrumentInfoRequest.getSymbol(),
                instrumentInfoRequest.getStatus(),
                instrumentInfoRequest.getBaseCoin(),
                instrumentInfoRequest.getLimit(),
                instrumentInfoRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketOrderbook(MarketOrderBookRequest marketOrderBookRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketOrderbook(
                marketOrderBookRequest.getCategory().getProductTypeId(),
                marketOrderBookRequest.getSymbol(),
                marketOrderBookRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketTickers(MarketDataTickerRequest marketDataTickerRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketTickers(
                marketDataTickerRequest.getCategory().getProductTypeId(),
                marketDataTickerRequest.getSymbol(),
                marketDataTickerRequest.getBaseCoin(),
                marketDataTickerRequest.getExpDate()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getFundingHistory(FundingHistoryRequest fundingHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getFundingHistory(
                fundingHistoryRequest.getCategory().getProductTypeId(),
                fundingHistoryRequest.getSymbol(),
                fundingHistoryRequest.getStartTime(),
                fundingHistoryRequest.getEndTime(),
                fundingHistoryRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getRecentTradeData(RecentTradeDataRequest recentTradeRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getRecentTradeData(
                recentTradeRequest.getCategory().getProductTypeId(),
                recentTradeRequest.getBaseCoin(),
                recentTradeRequest.getOptionType(),
                recentTradeRequest.getSymbol(),
                recentTradeRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOpenInterest(OpenInterestRequest openInterestRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getOpenInterest(
                openInterestRequest.getCategory().getProductTypeId(),
                openInterestRequest.getSymbol(),
                openInterestRequest.getIntervalTime(),
                openInterestRequest.getStartTime(),
                openInterestRequest.getEndTime(),
                openInterestRequest.getLimit(),
                openInterestRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getHistoricalVolatility(HistoricalVolatilityRequest historicalVolatilityRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getHistoricalVolatility(
                historicalVolatilityRequest.getCategory().getProductTypeId(),
                historicalVolatilityRequest.getBaseCoin(),
                historicalVolatilityRequest.getPeriod(),
                historicalVolatilityRequest.getStartTime(),
                historicalVolatilityRequest.getEndTime()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsurance(String coin, BybitApiCallback<Object> callback) {
        bybitApiService.getInsurance(coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsurance(BybitApiCallback<Object> callback) {
        bybitApiService.getInsurance().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getRiskLimit(MarketRiskLimitRequest marketRiskLimitRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getRiskLimit(
                        marketRiskLimitRequest.getCategory().getProductTypeId(),
                        marketRiskLimitRequest.getSymbol()
                ).
                enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getDeliveryPrice(DeliveryPriceRequest deliveryPriceRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getDeliveryPrice(deliveryPriceRequest.getCategory().getProductTypeId(),
                deliveryPriceRequest.getSymbol(),
                deliveryPriceRequest.getBaseCoin(),
                deliveryPriceRequest.getLimit(),
                deliveryPriceRequest.getCursor()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketAccountRatio(MarketAccountRatioRequest marketAccountRatioRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketAccountRatio(marketAccountRatioRequest.getCategory().getProductTypeId(),
                marketAccountRatioRequest.getSymbol(),
                marketAccountRatioRequest.getPeriod(),
                marketAccountRatioRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

}
