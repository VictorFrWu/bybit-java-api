package com.bybit.api.client.impl;

import com.bybit.api.client.domain.trade.request.BatchOrderRequest;
import com.bybit.api.client.restApi.BybitApiAsyncTradeRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.trade.request.TradeOrderRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import java.io.IOException;
import java.util.Map;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiTradeAsyncRestClientImpl implements BybitApiAsyncTradeRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiTradeAsyncRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
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
                        orderHistoryRequest.getOrderFilter() == null ? null : orderHistoryRequest.getOrderFilter().getOrderFilterType(),
                        orderHistoryRequest.getOrderStatus(),
                        orderHistoryRequest.getStartTime(),
                        orderHistoryRequest.getEndTime(),
                        orderHistoryRequest.getLimit(),
                        orderHistoryRequest.getCursor())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setDisconnectCancelAllTime(TradeOrderRequest orderRequest, BybitApiCallback<Object> callback) {
        var setDcpRequest = converter.convertMapToDcpRequest(orderRequest);
        bybitApiService.setDisconnectCancelAllTime(setDcpRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
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
                        order.getOrderFilter() == null ? null : order.getOrderFilter().getOrderFilterType(),
                        order.getLimit(),
                        order.getCursor())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createOrder(TradeOrderRequest order, BybitApiCallback<Object> callback) {
        var placeOrderRequest = converter.convertTradeToPlaceOrderRequest(order);
        bybitApiService.createOrder(placeOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createOrder(Map<String, Object> order, BybitApiCallback<Object> callback) {
        var singleOrderRequest = converter.convertMapToSingleOrderRequest(order);
        var placeOrderRequest = converter.convertTradeToPlaceOrderRequest(singleOrderRequest);
        bybitApiService.createOrder(placeOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createOrder(String order, BybitApiCallback<Object> callback) throws IOException {
        var singleOrderRequest = converter.convertJsonToSingleOrderRequest(order);
        var placeOrderRequest = converter.convertTradeToPlaceOrderRequest(singleOrderRequest);
        bybitApiService.createOrder(placeOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createBatchOrder(BatchOrderRequest batchOrderRequest, BybitApiCallback<Object> callback) {
        var placeBatchOrderRequest = converter.convertToPlaceBatchOrderRequest(batchOrderRequest);
        bybitApiService.createBatchOrder(placeBatchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createBathOrder(Map<String, Object> payload, BybitApiCallback<Object> callback) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        var placeBatchOrderRequest = converter.convertToPlaceBatchOrderRequest(batchOrderRequest);
        bybitApiService.createBatchOrder(placeBatchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createBathOrder(String json, BybitApiCallback<Object> callback) throws IOException {
        var batchOrderRequest = converter.jsonToBatchOrderRequest(json);
        var placeBatchOrderRequest = converter.convertToPlaceBatchOrderRequest(batchOrderRequest);
        bybitApiService.createBatchOrder(placeBatchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void amendBatchOrder(BatchOrderRequest batchOrderRequest, BybitApiCallback<Object> callback) {
        var amendBatchOrderRequest = converter.convertToAmendBatchOrderRequest(batchOrderRequest);
        bybitApiService.amendBatchOrder(amendBatchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void amendBatchOrder(Map<String, Object> payload, BybitApiCallback<Object> callback) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        var amendBatchOrderRequest = converter.convertToAmendBatchOrderRequest(batchOrderRequest);
        bybitApiService.amendBatchOrder(amendBatchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void amendBatchOrder(String json, BybitApiCallback<Object> callback) throws IOException {
        var batchOrderRequest = converter.jsonToBatchOrderRequest(json);
        var amendBatchOrderRequest = converter.convertToAmendBatchOrderRequest(batchOrderRequest);
        bybitApiService.amendBatchOrder(amendBatchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelBatchOrder(BatchOrderRequest batchOrderRequest, BybitApiCallback<Object> callback) {
        var cancelBatchOrderRequest = converter.convertToCancelBatchOrderRequest(batchOrderRequest);
        bybitApiService.cancelBatchOrder(cancelBatchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelBatchOrder(Map<String, Object> payload, BybitApiCallback<Object> callback) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        var cancelBatchOrderRequest = converter.convertToCancelBatchOrderRequest(batchOrderRequest);
        bybitApiService.cancelBatchOrder(cancelBatchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelBatchOrder(String json, BybitApiCallback<Object> callback) throws IOException {
        var batchOrderRequest = converter.jsonToBatchOrderRequest(json);
        var cancelBatchOrderRequest = converter.convertToCancelBatchOrderRequest(batchOrderRequest);
        bybitApiService.cancelBatchOrder(cancelBatchOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelOrder(TradeOrderRequest order, BybitApiCallback<Object> callback) {
        var cancelOrderRequest = converter.convertTradeToCancelOrderRequest(order);
        bybitApiService.cancelOrder(cancelOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelAllOrder(TradeOrderRequest order, BybitApiCallback<Object> callback) {
        var cancelAllOrderRequest = converter.convertTradeToCancelAllOrdersRequest(order);
        bybitApiService.cancelAllOrder(cancelAllOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void amendOrder(TradeOrderRequest order, BybitApiCallback<Object> callback) {
        var amendOrderRequest = converter.convertTradeToAmendOrderRequest(order);
        bybitApiService.amendOrder(amendOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
