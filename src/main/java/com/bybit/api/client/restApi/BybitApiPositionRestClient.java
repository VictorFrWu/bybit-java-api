package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.domain.trade.BatchOrderRequest;
import com.bybit.api.client.domain.trade.TradeOrderRequest;

import java.io.IOException;
import java.util.Map;

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
}
