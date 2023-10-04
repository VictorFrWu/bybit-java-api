package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApAsynciTradeRestClient;
import com.bybit.api.client.BybitApiCallback;
import com.bybit.api.client.BybitApiService;
import com.bybit.api.client.BybitApiTradeRestClient;
import com.bybit.api.client.domain.trade.BatchOrderRequest;
import com.bybit.api.client.domain.trade.TradeOrderRequest;
import com.bybit.api.client.service.JsonConverter;

import java.io.IOException;
import java.util.Map;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitTradeAsyncRestClientImpl implements BybitApAsynciTradeRestClient {
    private final BybitApiService bybitApiService;
    private final JsonConverter converter = new JsonConverter();

    public BybitTradeAsyncRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }

    @Override
    public void getHistoryOrderResult(TradeOrderRequest orderHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getHistoryOrderResult(
                orderHistoryRequest.getCategory().getProductTypeId(),
                orderHistoryRequest.getSymbol(),
                orderHistoryRequest.getBaseCoin(),
                orderHistoryRequest.getSettleCoin(),
                orderHistoryRequest.getOrderId(),
                orderHistoryRequest.getOrderLinkId(),
                orderHistoryRequest.getOrderFilter(),
                orderHistoryRequest.getOrderStatus(),
                orderHistoryRequest.getStartTime(),
                orderHistoryRequest.getEndTime(),
                orderHistoryRequest.getLimit(),
                orderHistoryRequest.getCursor())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setDisconnectCancelAllTime(Integer timeWindow, BybitApiCallback<Object> callback) {
        bybitApiService.setDisconnectCancelAllTime(timeWindow).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getBorrowQuota(TradeOrderRequest borrowQuotaRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getBorrowQuota(
                borrowQuotaRequest.getCategory().getProductTypeId(),
                borrowQuotaRequest.getSymbol(),
                borrowQuotaRequest.getTransactionSide() == null ? null : borrowQuotaRequest.getTransactionSide().getSide())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOpenOrders(TradeOrderRequest order, BybitApiCallback<Object> callback) {
        bybitApiService.getOpenOrders(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getBaseCoin(),
                order.getSettleCoin(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOpenOnly(),
                order.getOrderFilter(),
                order.getLimit(),
                order.getCursor())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createOrder(TradeOrderRequest order, BybitApiCallback<Object> callback) {
        bybitApiService.createOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getIsLeverage(),
                order.getTransactionSide() == null ? null : order.getTransactionSide().getSide(),
                order.getOrderType() == null ? null : order.getOrderType().getOType(),
                order.getQty(),
                order.getPrice(),
                order.getTriggerDirection(),
                order.getOrderFilter(),
                order.getTriggerPrice(),
                order.getTriggerBy() == null ? null : order.getTriggerBy().getTrigger(),
                order.getOrderIv(),
                order.getTimeInForce() == null ? null : order.getTimeInForce().getDescription(),
                order.getPositionIdx() == null ? null : order.getPositionIdx().getIndex(),
                order.getOrderLinkId(),
                order.getTakeProfit(),
                order.getStopLoss(),
                order.getTpTriggerBy()== null ? null : order.getTpTriggerBy().getTrigger(),
                order.getSlTriggerBy()== null ? null : order.getSlTriggerBy().getTrigger(),
                order.getReduceOnly(),
                order.getCloseOnTrigger(),
                order.getSmpType() == null ? null : order.getSmpType().getDescription(),
                order.getMmp(),
                order.getTpslMode(),
                order.getTpLimitPrice(),
                order.getSlLimitPrice(),
                order.getTpOrderType(),
                order.getSlOrderType())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createBatchOrder(BatchOrderRequest batchOrderRequest, BybitApiCallback<Object> callback) {
        bybitApiService.createBatchOrder(batchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createBathOrder(Map<String, Object> payload, BybitApiCallback<Object> callback) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        bybitApiService.createBatchOrder(batchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createBathOrder(String json, BybitApiCallback<Object> callback) throws IOException {
        BatchOrderRequest batchOrderRequest = converter.jsonToBatchOrderRequest(json);
        bybitApiService.createBatchOrder(batchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void amendBatchOrder(BatchOrderRequest batchOrderRequest, BybitApiCallback<Object> callback) {
        bybitApiService.amendBatchOrder(batchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void amendBatchOrder(Map<String, Object> payload, BybitApiCallback<Object> callback) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        bybitApiService.amendBatchOrder(batchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void amendBatchOrder(String json, BybitApiCallback<Object> callback) throws IOException {
        BatchOrderRequest batchOrderRequest = converter.jsonToBatchOrderRequest(json);
        bybitApiService.amendBatchOrder(batchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelBatchOrder(BatchOrderRequest batchOrderRequest, BybitApiCallback<Object> callback) {
        bybitApiService.cancelBatchOrder(batchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelBatchOrder(Map<String, Object> payload, BybitApiCallback<Object> callback) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        bybitApiService.cancelBatchOrder(batchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelBatchOrder(String json, BybitApiCallback<Object> callback) throws IOException {
        BatchOrderRequest batchOrderRequest = converter.jsonToBatchOrderRequest(json);
        bybitApiService.cancelBatchOrder(batchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelOrder(TradeOrderRequest order, BybitApiCallback<Object> callback) {
        bybitApiService.cancelOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOrderFilter())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelAllOrder(TradeOrderRequest order, BybitApiCallback<Object> callback) {
        bybitApiService.cancelAllOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getBaseCoin(),
                order.getSettleCoin(),
                order.getOrderFilter(),
                order.getStopOrderType() == null ? null : order.getStopOrderType().getDescription())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void amendOrder(TradeOrderRequest order, BybitApiCallback<Object> callback) {
        bybitApiService.amendOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOrderIv(),
                order.getTriggerPrice(),
                order.getQty(),
                order.getPrice(),
                order.getTakeProfit(),
                order.getStopLoss(),
                order.getTpTriggerBy(),
                order.getSlTriggerBy(),
                order.getTriggerBy(),
                order.getTpLimitPrice(),
                order.getSlLimitPrice())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
