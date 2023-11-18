package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.position.request.PositionDataRequest;

public interface BybitApiAsyncPositionRestClient {
    // Position endpoints
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
    void confirmPositionRiskLimit(PositionDataRequest confirmNewRiskLimitRequest, BybitApiCallback<Object> callback);
}
