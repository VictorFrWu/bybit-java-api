package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiAsyncPositionRestClient;
import com.bybit.api.client.BybitApiCallback;
import com.bybit.api.client.BybitApiService;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

/**
 * Implementation of Bybit's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BybitApiAsyncPositionRestClientImpl implements BybitApiAsyncPositionRestClient {

    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncPositionRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
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
}
