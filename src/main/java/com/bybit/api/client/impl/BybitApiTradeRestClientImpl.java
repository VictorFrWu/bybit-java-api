package com.bybit.api.client.impl;

import com.bybit.api.client.domain.trade.request.BatchOrderRequest;
import com.bybit.api.client.domain.trade.request.TradeOrderRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiTradeRestClient;
import com.bybit.api.client.service.BybitJsonConverter;

import java.io.IOException;
import java.util.Map;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiTradeRestClientImpl implements BybitApiTradeRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiTradeRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    // Trade Data endpoints
    @Override
    public Object setDisconnectCancelAllTime(TradeOrderRequest tradeOrderRequest) {
        var setDcpRequest = converter.convertMapToDcpRequest(tradeOrderRequest);
        return executeSync(bybitApiService.setDisconnectCancelAllTime(setDcpRequest));
    }

    @Override
    public Object getBorrowQuota(TradeOrderRequest borrowQuotaRequest) {
        return executeSync(bybitApiService.getBorrowQuota(
                borrowQuotaRequest.getCategory().getCategoryTypeId(),
                borrowQuotaRequest.getSymbol(),
                borrowQuotaRequest.getSide() == null ? null : borrowQuotaRequest.getSide().getTransactionSide()
        ));
    }

    @Override
    public Object getOrderHistory(TradeOrderRequest orderHistoryRequest) {
        return executeSync(bybitApiService.getOrderHistory(
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
                orderHistoryRequest.getCursor()));
    }

    public Object createOrder(TradeOrderRequest tradeOrderRequest) {
        var singleOrderRequest = converter.convertTradeToPlaceOrderRequest(tradeOrderRequest);
        return executeSync(bybitApiService.createOrder(singleOrderRequest));
    }

    @Override
    public Object createOrder(Map<String, Object> payload) {
        var singleOrderRequest = converter.convertMapToSingleOrderRequest(payload);
        var placeOrderRequest = converter.convertTradeToPlaceOrderRequest(singleOrderRequest);
        return executeSync(bybitApiService.createOrder(placeOrderRequest));
    }

    @Override
    public Object createOrder(String json) throws IOException {
        var singleOrderRequest = converter.convertJsonToSingleOrderRequest(json);
        var placeOrderRequest = converter.convertTradeToPlaceOrderRequest(singleOrderRequest);
        return executeSync(bybitApiService.createOrder(placeOrderRequest));
    }

    @Override
    public Object createBatchOrder(BatchOrderRequest batchOrderRequest) {
        var placeBatchOrderRequest = converter.convertToPlaceBatchOrderRequest(batchOrderRequest);
        return executeSync(bybitApiService.createBatchOrder(placeBatchOrderRequest));
    }

    @Override
    public Object createBathOrder(Map<String, Object> payload) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        var placeBatchOrderRequest = converter.convertToPlaceBatchOrderRequest(batchOrderRequest);
        return executeSync(bybitApiService.createBatchOrder(placeBatchOrderRequest));
    }

    @Override
    public Object createBathOrder(String jsonRequest) throws IOException {
        var batchOrderRequest = converter.jsonToBatchOrderRequest(jsonRequest);
        var placeBatchOrderRequest = converter.convertToPlaceBatchOrderRequest(batchOrderRequest);
        return executeSync(bybitApiService.createBatchOrder(placeBatchOrderRequest));
    }

    @Override
    public Object amendBatchOrder(BatchOrderRequest batchOrderRequest) {
        var amendBatchOrderRequest = converter.convertToAmendBatchOrderRequest(batchOrderRequest);
        return executeSync(bybitApiService.amendBatchOrder(amendBatchOrderRequest));
    }

    @Override
    public Object amendBatchOrder(Map<String, Object> payload) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        var amendBatchOrderRequest = converter.convertToAmendBatchOrderRequest(batchOrderRequest);
        return executeSync(bybitApiService.amendBatchOrder(amendBatchOrderRequest));
    }

    @Override
    public Object amendBatchOrder(String jsonRequest) throws IOException {
        var batchOrderRequest = converter.jsonToBatchOrderRequest(jsonRequest);
        var amendBatchOrderRequest = converter.convertToAmendBatchOrderRequest(batchOrderRequest);
        return executeSync(bybitApiService.amendBatchOrder(amendBatchOrderRequest));
    }

    @Override
    public Object amendOrder(TradeOrderRequest order) {
        var amendOrderRequest = converter.convertTradeToAmendOrderRequest(order);
        return executeSync(bybitApiService.amendOrder(amendOrderRequest));
    }

    @Override
    public Object cancelOrder(TradeOrderRequest order) {
        var cancelOrderRequest = converter.convertTradeToCancelOrderRequest(order);
        return executeSync(bybitApiService.cancelOrder(cancelOrderRequest));
    }

    @Override
    public Object cancelBatchOrder(BatchOrderRequest batchOrderRequest) {
        var cancelBatchOrderRequest = converter.convertToCancelBatchOrderRequest(batchOrderRequest);
        return executeSync(bybitApiService.cancelBatchOrder(cancelBatchOrderRequest));
    }

    @Override
    public Object cancelBatchOrder(Map<String, Object> payload) {
        var batchOrderRequest = converter.convertMapToBatchOrderRequest(payload);
        var cancelBatchOrderRequest = converter.convertToCancelBatchOrderRequest(batchOrderRequest);
        return executeSync(bybitApiService.cancelBatchOrder(cancelBatchOrderRequest));
    }

    @Override
    public Object cancelBatchOrder(String json) throws IOException {
        var batchOrderRequest = converter.jsonToBatchOrderRequest(json);
        var cancelBatchOrderRequest = converter.convertToCancelBatchOrderRequest(batchOrderRequest);
        return executeSync(bybitApiService.cancelBatchOrder(cancelBatchOrderRequest));
    }


    @Override
    public Object cancelAllOrder(TradeOrderRequest order) {
        var cancelAllOrderRequest = converter.convertTradeToCancelAllOrdersRequest(order);
        return executeSync(bybitApiService.cancelAllOrder(cancelAllOrderRequest));
    }

    @Override
    public Object getOpenOrders(TradeOrderRequest order) {
        return executeSync(bybitApiService.getOpenOrders(
                order.getCategory().getCategoryTypeId(),
                order.getSymbol(),
                order.getBaseCoin(),
                order.getSettleCoin(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOpenOnly(),
                order.getOrderFilter() == null ? null : order.getOrderFilter().getOrderFilterType(),
                order.getLimit(),
                order.getCursor()
        ));
    }

    @Override
    public Object getTradeHistory(TradeOrderRequest order) {
        return executeSync(bybitApiService.getTradeHistory(
                order.getCategory().getCategoryTypeId(),
                order.getSymbol(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getBaseCoin(),
                order.getStartTime(),
                order.getEndTime(),
                order.getExecType() == null ? null : order.getExecType().getExecTypeId(),
                order.getLimit(),
                order.getCursor()
        ));
    }
}
