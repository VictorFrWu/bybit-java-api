package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiService;
import com.bybit.api.client.BybitApiTradeRestClient;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.service.JsonConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitTradeRestClientImpl implements BybitApiTradeRestClient {
    private final BybitApiService bybitApiService;
    private final JsonConverter converter = new JsonConverter();

    public BybitTradeRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }

    // Trade Data endpoints
    @Override
    public Object setDisconnectCancelAllTime(Integer timeWindow) {
        return executeSync(bybitApiService.setDisconnectCancelAllTime(timeWindow));
    }

    @Override
    public Object getBorrowQuota(TradeOrderRequest borrowQuotaRequest) {
        return executeSync(bybitApiService.getBorrowQuota(
                borrowQuotaRequest.getCategory().getProductTypeId(),
                borrowQuotaRequest.getSymbol(),
                borrowQuotaRequest.getSide() == null ? null : borrowQuotaRequest.getSide().getTransactionSide()
        ));
    }

    @Override
    public Object getHistoryOrderResult(TradeOrderRequest orderHistoryRequest) {
        return executeSync(bybitApiService.getHistoryOrderResult(
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
                orderHistoryRequest.getCursor()));
    }

    public Object createOrder(TradeOrderRequest order) {
        return executeSync(bybitApiService.createOrder(order));
    }

    @Override
    public Object createOrder(Map<String, Object> payload) {
        var singleOrderRequest = converter.convertMapToSingleOrderRequest(payload);
        return executeSync(bybitApiService.createOrder(singleOrderRequest));
    }

    @Override
    public Object createOrder(String json) throws IOException {
        var singleOrderRequest = converter.convertJsonToSingleOrderRequest(json);
        return executeSync(bybitApiService.createOrder(singleOrderRequest));
    }

    @Override
    public Object createBatchOrder(BatchOrderRequest batchOrderRequest) {
        return executeSync(bybitApiService.createBatchOrder(batchOrderRequest));
    }

    @Override
    public Object createBathOrder(Map<String, Object> payload) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        return executeSync(bybitApiService.createBatchOrder(batchOrderRequest));
    }

    @Override
    public Object createBathOrder(String jsonRequest) throws IOException {
        BatchOrderRequest batchOrderRequest = converter.jsonToBatchOrderRequest(jsonRequest);
        return executeSync(bybitApiService.createBatchOrder(batchOrderRequest));
    }

    @Override
    public Object amendBatchOrder(BatchOrderRequest batchOrderRequest) {
        return executeSync(bybitApiService.amendBatchOrder(batchOrderRequest));
    }

    @Override
    public Object amendBatchOrder(Map<String, Object> payload) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        return executeSync(bybitApiService.amendBatchOrder(batchOrderRequest));
    }

    @Override
    public Object amendBatchOrder(String jsonRequest) throws IOException {
        BatchOrderRequest batchOrderRequest = converter.jsonToBatchOrderRequest(jsonRequest);
        return executeSync(bybitApiService.amendBatchOrder(batchOrderRequest));
    }

    @Override
    public Object amendOrder(TradeOrderRequest order) {
        return executeSync(bybitApiService.amendOrder(
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
                order.getSlLimitPrice()
        ));
    }

    @Override
    public Object cancelOrder(TradeOrderRequest order) {
        return executeSync(bybitApiService.cancelOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOrderFilter()
        ));
    }

    @Override
    public Object cancelBatchOrder(BatchOrderRequest batchOrderRequest) {
        return executeSync(bybitApiService.cancelBatchOrder(batchOrderRequest));
    }

    @Override
    public Object cancelBatchOrder(Map<String, Object> payload) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        return executeSync(bybitApiService.cancelBatchOrder(batchOrderRequest));
    }

    @Override
    public Object cancelBatchOrder(String json) throws IOException {
        BatchOrderRequest batchOrderRequest = converter.jsonToBatchOrderRequest(json);
        return executeSync(bybitApiService.cancelBatchOrder(batchOrderRequest));
    }


    @Override
    public Object cancelAllOrder(TradeOrderRequest order) {
        return executeSync(bybitApiService.cancelAllOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getBaseCoin(),
                order.getSettleCoin(),
                order.getOrderFilter(),
                order.getStopOrderType() == null ? null : order.getStopOrderType().getDescription()
        ));
    }

    @Override
    public Object getOpenOrders(TradeOrderRequest order) {
        return executeSync(bybitApiService.getOpenOrders(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getBaseCoin(),
                order.getSettleCoin(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOpenOnly(),
                order.getOrderFilter(),
                order.getLimit(),
                order.getCursor()
        ));
    }
}
