package com.bybit.api.client;

import com.bybit.api.client.domain.trade.BatchOrderRequest;
import com.bybit.api.client.domain.trade.TradeOrderRequest;

import java.io.IOException;
import java.util.Map;

public interface BybitApAsynciTradeRestClient {

    // Trade
    void getHistoryOrderResult(TradeOrderRequest orderHistoryRequest, BybitApiCallback<Object> callback);

    void setDisconnectCancelAllTime(Integer timeWindow, BybitApiCallback<Object> callback);

    void getBorrowQuota(TradeOrderRequest borrowQuotaRequest, BybitApiCallback<Object> callback);

    void getOpenOrders(TradeOrderRequest order, BybitApiCallback<Object> callback);

    void createOrder(TradeOrderRequest order, BybitApiCallback<Object> callback);
    void createBatchOrder(BatchOrderRequest batchOrderRequest, BybitApiCallback<Object> callback);
    void createBathOrder(Map<String, Object> payload, BybitApiCallback<Object> callback);
    void createBathOrder(String json, BybitApiCallback<Object> callback) throws IOException;
    void amendBatchOrder(BatchOrderRequest batchOrderRequest, BybitApiCallback<Object> callback);
    void amendBatchOrder(Map<String, Object> payload, BybitApiCallback<Object> callback);
    void amendBatchOrder(String json, BybitApiCallback<Object> callback) throws IOException;
    void cancelBatchOrder(BatchOrderRequest batchOrderRequest, BybitApiCallback<Object> callback);
    void cancelBatchOrder(Map<String, Object> payload, BybitApiCallback<Object> callback);
    void cancelBatchOrder(String json, BybitApiCallback<Object> callback) throws IOException;
    void cancelOrder(TradeOrderRequest order, BybitApiCallback<Object> callback);

    void cancelAllOrder(TradeOrderRequest order, BybitApiCallback<Object> callback);

    void amendOrder(TradeOrderRequest order, BybitApiCallback<Object> callback);
}
