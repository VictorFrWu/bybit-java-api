package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiAsyncTradeRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.trade.request.BatchOrderRequest;
import com.bybit.api.client.domain.trade.request.TradeOrderRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import java.io.IOException;
import java.util.Map;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiTradeAsyncRestClientImpl implements BybitApiAsyncTradeRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiTradeAsyncRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode);
    }

    @Override
    public void getHistoryOrderResult(TradeOrderRequest orderHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getHistoryOrderResult(
                        orderHistoryRequest.getCategory().getCategoryTypeId(),
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
                        borrowQuotaRequest.getCategory().getCategoryTypeId(),
                        borrowQuotaRequest.getSymbol(),
                        borrowQuotaRequest.getSide() == null ? null : borrowQuotaRequest.getSide().getTransactionSide())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOpenOrders(TradeOrderRequest order, BybitApiCallback<Object> callback) {
        bybitApiService.getOpenOrders(
                        order.getCategory().getCategoryTypeId(),
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
        bybitApiService.createOrder(order).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createOrder(Map<String, Object> order, BybitApiCallback<Object> callback) {
        var singleOrderRequest = converter.convertMapToSingleOrderRequest(order);
        bybitApiService.createOrder(singleOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createOrder(String order, BybitApiCallback<Object> callback) throws IOException {
        var singleOrderRequest = converter.convertJsonToSingleOrderRequest(order);
        bybitApiService.createOrder(singleOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
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
        bybitApiService.cancelOrder(order).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelAllOrder(TradeOrderRequest order, BybitApiCallback<Object> callback) {
        bybitApiService.cancelAllOrder(
                        order.getCategory().getCategoryTypeId(),
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
                        order.getCategory().getCategoryTypeId(),
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
