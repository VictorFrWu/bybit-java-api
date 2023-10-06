package com.bybit.api.client;

import com.bybit.api.client.domain.market.MarketDataRequest;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.request.*;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;

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

    // Position Data
    void getPositionInfo(PositionDataRequest positionListRequest, BybitApiCallback<Object> callback);

    void setPositionLeverage(PositionDataRequest setLeverageRequest, BybitApiCallback<Object> callback);

    void swithMarginRequest(PositionDataRequest switchMarginRequest, BybitApiCallback<Object> callback);

    void switchPositionMode(PositionDataRequest switchPositionModeRequest, BybitApiCallback<Object> callback);

    void setTpslMode(PositionDataRequest setTpSlModeRequest, BybitApiCallback<Object> callback);

    void setRiskLimit(PositionDataRequest setRiskLimitRequest, BybitApiCallback<Object> callback);

    void setTradingStop(PositionDataRequest tradingStopRequest, BybitApiCallback<Object> callback);

    void setAutoAddMargin(PositionDataRequest setAutoAddMarginRequest, BybitApiCallback<Object> callback);

    void modifyPositionMargin(PositionDataRequest modifyMarginRequest, BybitApiCallback<Object> callback);

    void getExecutionList(PositionDataRequest executionHistoryRequest, BybitApiCallback<Object> callback);

    void getClosePnlList(PositionDataRequest closePnlHistoryRequest, BybitApiCallback<Object> callback);

    // Pre upgrade request
    // Pre Upgrade
    void getPreUpgradeOrderHistory(PreUpgradeDataRequest preupgradeOderHistoryRequest, BybitApiCallback<Object> callback);

    void getPreUpgradeTradeHistory(PreUpgradeDataRequest preUpgradeTradeHistoryRequest, BybitApiCallback<Object> callback);

    void getPreUpgradeClosePnl(PreUpgradeDataRequest preUpgradeClosePnlRequest, BybitApiCallback<Object> callback);

    void getPreUpgradeTransaction(PreUpgradeDataRequest preUpgradeTransactionRequest, BybitApiCallback<Object> callback);

    void getPreUpgradeOptionDelivery(PreUpgradeDataRequest preUpgradeOptionDeliveryRequest, BybitApiCallback<Object> callback);

    void getPreUpgradeUsdcSettlement(PreUpgradeDataRequest preUpgradeUsdcSettlementRequest, BybitApiCallback<Object> callback);
}
