package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiAsyncRestClient;
import com.bybit.api.client.BybitApiCallback;
import com.bybit.api.client.domain.market.MarketDataRequest;
import com.bybit.api.client.domain.market.request.*;
import com.bybit.api.client.BybitApiService;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.service.JsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

/**
 * Implementation of Bybit's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BybitApiAsyncRestClientImpl implements BybitApiAsyncRestClient {

    private final BybitApiService bybitApiService;
    private final JsonConverter converter = new JsonConverter();

    public BybitApiAsyncRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }

    // Market Data endpoints

    @Override
    public void getServerTime(BybitApiCallback<Object> callback) {
        bybitApiService.getServerTime().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketPriceLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getIndexPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getIndexPriceLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPremiumIndexPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPremiumIndexPriceLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInstrumentsInfo(MarketDataRequest instrumentInfoRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getInstrumentsInfo(
                instrumentInfoRequest.getCategory().getProductTypeId(),
                instrumentInfoRequest.getSymbol(),
                instrumentInfoRequest.getInstrumentStatus() == null ? null : instrumentInfoRequest.getInstrumentStatus().getStatus(),
                instrumentInfoRequest.getBaseCoin(),
                instrumentInfoRequest.getLimit(),
                instrumentInfoRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketOrderbook(MarketDataRequest marketOrderBookRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketOrderbook(
                marketOrderBookRequest.getCategory().getProductTypeId(),
                marketOrderBookRequest.getSymbol(),
                marketOrderBookRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketTickers(MarketDataRequest marketDataTickerRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketTickers(
                marketDataTickerRequest.getCategory().getProductTypeId(),
                marketDataTickerRequest.getSymbol(),
                marketDataTickerRequest.getBaseCoin(),
                marketDataTickerRequest.getExpDate()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getFundingHistory(MarketDataRequest fundingHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getFundingHistory(
                fundingHistoryRequest.getCategory().getProductTypeId(),
                fundingHistoryRequest.getSymbol(),
                fundingHistoryRequest.getStartTime(),
                fundingHistoryRequest.getEndTime(),
                fundingHistoryRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getRecentTradeData(MarketDataRequest recentTradeRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getRecentTradeData(
                recentTradeRequest.getCategory().getProductTypeId(),
                recentTradeRequest.getBaseCoin(),
                recentTradeRequest.getOptionType() == null ? null : recentTradeRequest.getOptionType().getOpType(),
                recentTradeRequest.getSymbol(),
                recentTradeRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOpenInterest(MarketDataRequest openInterestRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getOpenInterest(
                openInterestRequest.getCategory().getProductTypeId(),
                openInterestRequest.getSymbol(),
                openInterestRequest.getMarketInterval() == null ? null : openInterestRequest.getMarketInterval().getIntervalId(),
                openInterestRequest.getStartTime(),
                openInterestRequest.getEndTime(),
                openInterestRequest.getLimit(),
                openInterestRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getHistoricalVolatility(MarketDataRequest historicalVolatilityRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getHistoricalVolatility(
                historicalVolatilityRequest.getCategory().getProductTypeId(),
                historicalVolatilityRequest.getBaseCoin(),
                historicalVolatilityRequest.getOptionPeriod(),
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
    public void getRiskLimit(MarketDataRequest marketRiskLimitRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getRiskLimit(
                        marketRiskLimitRequest.getCategory().getProductTypeId(),
                        marketRiskLimitRequest.getSymbol()
                ).
                enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getDeliveryPrice(MarketDataRequest deliveryPriceRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getDeliveryPrice(deliveryPriceRequest.getCategory().getProductTypeId(),
                deliveryPriceRequest.getSymbol(),
                deliveryPriceRequest.getBaseCoin(),
                deliveryPriceRequest.getLimit(),
                deliveryPriceRequest.getCursor()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketAccountRatio(MarketDataRequest marketAccountRatioRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketAccountRatio(marketAccountRatioRequest.getCategory().getProductTypeId(),
                marketAccountRatioRequest.getSymbol(),
                marketAccountRatioRequest.getDataRecordingPeriod() == null ? null : marketAccountRatioRequest.getDataRecordingPeriod().getPeriod(),
                marketAccountRatioRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }


    // Position Data
    @Override
    public void getPositionInfo(PositionDataRequest positionListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPositionInfo(
                positionListRequest.getCategory().getProductTypeId(),
                positionListRequest.getSymbol(),
                positionListRequest.getBaseCoin(),
                positionListRequest.getSettleCoin(),
                positionListRequest.getLimit(),
                positionListRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setPositionLeverage(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setLeverageRequest = converter.mapToSetLeverageRequest(positionDataRequest);
        bybitApiService.setPositionLeverage(setLeverageRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void swithMarginRequest(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var switchMarginRequest = converter.mapToSwitchMarginRequest(positionDataRequest);
        bybitApiService.swithMarginRequest(switchMarginRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void switchPositionMode(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var switchPositionModeRequest = converter.mapToSwitchPositionModeRequest(positionDataRequest);
        bybitApiService.switchPositionMode(switchPositionModeRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setTpslMode(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setTpSlModeRequest = converter.mapToSetTpSlModeRequest(positionDataRequest);
        bybitApiService.setTpslMode(setTpSlModeRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setRiskLimit(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setRiskLimitRequest = converter.mapToSetRiskLimitRequest(positionDataRequest);
        bybitApiService.setRiskLimit(setRiskLimitRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setTradingStop(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var tradingStopRequest = converter.mapToTradingStopRequest(positionDataRequest);
        bybitApiService.setTradingStop(tradingStopRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setAutoAddMargin(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setAutoAddMarginRequest = converter.mapToSetAutoAddMarginRequest(positionDataRequest);
        bybitApiService.setAutoAddMargin(setAutoAddMarginRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void modifyPositionMargin(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var modifyMarginRequest = converter.mapToModifyMarginRequest(positionDataRequest);
        bybitApiService.modifyPositionMargin(modifyMarginRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getExecutionList(PositionDataRequest executionHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getExecutionList(
                executionHistoryRequest.getCategory().getProductTypeId(),
                executionHistoryRequest.getSymbol(),
                executionHistoryRequest.getOrderId(),
                executionHistoryRequest.getOrderLinkId(),
                executionHistoryRequest.getBaseCoin(),
                executionHistoryRequest.getStartTime(),
                executionHistoryRequest.getEndTime(),
                executionHistoryRequest.getExecType() == null ? null : executionHistoryRequest.getExecType().getExecTypeId(),
                executionHistoryRequest.getLimit(),
                executionHistoryRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getClosePnlList(PositionDataRequest closePnlHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getClosePnlList(
                closePnlHistoryRequest.getCategory().getProductTypeId(),
                closePnlHistoryRequest.getSymbol(),
                closePnlHistoryRequest.getStartTime(),
                closePnlHistoryRequest.getEndTime(),
                closePnlHistoryRequest.getLimit(),
                closePnlHistoryRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    // pre upgrade endpoints
    @Override
    public void getPreUpgradeOrderHistory(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeOrderHistory(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getBaseCoin(),
                request.getOrderId(),
                request.getOrderLinkId(),
                request.getOrderFilter(),
                request.getOrderStatus() == null ? null : request.getOrderStatus().getDescription(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeTradeHistory(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeTradeHistory(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getOrderId(),
                request.getOrderLinkId(),
                request.getBaseCoin(),
                request.getStartTime(),
                request.getEndTime(),
                request.getExecType() == null ? null : request.getExecType().getExecTypeId(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeClosePnl(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeClosePnl(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeTransaction(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeTransaction(
                request.getCategory().getProductTypeId(),
                request.getBaseCoin(),
                request.getTransactionType() == null ? null : request.getTransactionType().getTransactionTypeId(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeOptionDelivery(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeOptionDelivery(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getExpDate(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeUsdcSettlement(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeUsdcSettlement(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
