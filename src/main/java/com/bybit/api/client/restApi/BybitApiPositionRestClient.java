package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.position.PositionDataRequest;

public interface BybitApiPositionRestClient {
    // Position Data
    Object getPositionInfo(PositionDataRequest positionListRequest);
    Object setPositionLeverage(PositionDataRequest setLeverageRequest);
    Object swithMarginRequest(PositionDataRequest switchMarginRequest);
    Object switchPositionMode(PositionDataRequest switchPositionModeRequest);
    Object setTpslMode(PositionDataRequest setTpSlModeRequest);
    Object setRiskLimit(PositionDataRequest setRiskLimitRequest);
    Object setTradingStop(PositionDataRequest tradingStopRequest);
    Object setAutoAddMargin(PositionDataRequest setAutoAddMarginRequest);
    Object modifyPositionMargin(PositionDataRequest modifyMarginRequest);
    Object getExecutionList(PositionDataRequest executionHistoryRequest);
    Object getClosePnlList(PositionDataRequest closePnlHistoryRequest);
    Object confirmPositionRiskLimit(PositionDataRequest confirmNewRiskLimitRequest);
}
