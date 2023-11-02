package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiPositionRestClient;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiPositionRestClientImpl implements BybitApiPositionRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiPositionRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }

    // Position endpoints

    @Override
    public Object getPositionInfo(PositionDataRequest positionListRequest) {
        return executeSync(bybitApiService.getPositionInfo(
                positionListRequest.getCategory().getProductTypeId(),
                positionListRequest.getSymbol(),
                positionListRequest.getBaseCoin(),
                positionListRequest.getSettleCoin(),
                positionListRequest.getLimit(),
                positionListRequest.getCursor()
        ));
    }

    @Override
    public Object setPositionLeverage(PositionDataRequest positionDataRequest) {
        var setLeverageRequest = converter.mapToSetLeverageRequest(positionDataRequest);
        return executeSync(bybitApiService.setPositionLeverage(setLeverageRequest));
    }

    @Override
    public Object swithMarginRequest(PositionDataRequest positionDataRequest) {
        var switchMarginRequest = converter.mapToSwitchMarginRequest(positionDataRequest);
        return executeSync(bybitApiService.swithMarginRequest(switchMarginRequest));
    }

    @Override
    public Object switchPositionMode(PositionDataRequest positionDataRequest) {
        var switchPositionModeRequest = converter.mapToSwitchPositionModeRequest(positionDataRequest);
        return executeSync(bybitApiService.switchPositionMode(switchPositionModeRequest));
    }

    @Override
    public Object setTpslMode(PositionDataRequest positionDataRequest) {
        var setTpSlModeRequest = converter.mapToSetTpSlModeRequest(positionDataRequest);
        return executeSync(bybitApiService.setTpslMode(setTpSlModeRequest));
    }

    @Override
    public Object setRiskLimit(PositionDataRequest positionDataRequest) {
        var setRiskLimitRequest = converter.mapToSetRiskLimitRequest(positionDataRequest);
        return executeSync(bybitApiService.setRiskLimit(setRiskLimitRequest));
    }

    @Override
    public Object setTradingStop(PositionDataRequest positionDataRequest) {
        var tradingStopRequest = converter.mapToTradingStopRequest(positionDataRequest);
        return executeSync(bybitApiService.setTradingStop(tradingStopRequest));
    }

    @Override
    public Object setAutoAddMargin(PositionDataRequest positionDataRequest) {
        var setAutoAddMarginRequest = converter.mapToSetAutoAddMarginRequest(positionDataRequest);
        return executeSync(bybitApiService.setAutoAddMargin(setAutoAddMarginRequest));
    }

    @Override
    public Object modifyPositionMargin(PositionDataRequest positionDataRequest) {
        var modifyMarginRequest = converter.mapToModifyMarginRequest(positionDataRequest);
        return executeSync(bybitApiService.modifyPositionMargin(modifyMarginRequest));
    }

    @Override
    public Object getExecutionList(PositionDataRequest executionHistoryRequest) {
        return executeSync(bybitApiService.getExecutionList(
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
        ));
    }

    @Override
    public Object getClosePnlList(PositionDataRequest closePnlHistoryRequest) {
        return executeSync(bybitApiService.getClosePnlList(
                closePnlHistoryRequest.getCategory().getProductTypeId(),
                closePnlHistoryRequest.getSymbol(),
                closePnlHistoryRequest.getStartTime(),
                closePnlHistoryRequest.getEndTime(),
                closePnlHistoryRequest.getLimit(),
                closePnlHistoryRequest.getCursor()
        ));
    }

    @Override
    public Object confirmPositionRiskLimit(PositionDataRequest positionDataRequest) {
        var confirmNewRiskLimitRequest = converter.mapToConfirmNewRiskLimitRequest(positionDataRequest);
        return executeSync(bybitApiService.confirmPositionRiskLimit(confirmNewRiskLimitRequest));
    }
}
