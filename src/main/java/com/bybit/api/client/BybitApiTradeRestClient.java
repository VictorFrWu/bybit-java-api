package com.bybit.api.client;

import com.bybit.api.client.domain.trade.BatchOrderRequest;
import com.bybit.api.client.domain.trade.TradeOrderRequest;

import java.io.IOException;
import java.util.Map;

public interface BybitApiTradeRestClient {

    // Trade
    Object getHistoryOrderResult(TradeOrderRequest orderHistoryRequest);

    Object setDisconnectCancelAllTime(Integer timeWindow);

    Object getBorrowQuota(TradeOrderRequest borrowQuotaRequest);

    Object getOpenOrders(TradeOrderRequest order);

    Object createOrder(TradeOrderRequest order);
    Object createBatchOrder(BatchOrderRequest batchOrderRequest);
    Object createBathOrder(Map<String, Object> payload);
    Object createBathOrder(String json) throws IOException;
    Object amendBatchOrder(BatchOrderRequest batchOrderRequest);
    Object amendBatchOrder(Map<String, Object> payload);
    Object amendBatchOrder(String json) throws IOException;
    Object cancelBatchOrder(BatchOrderRequest batchOrderRequest);
    Object cancelBatchOrder(Map<String, Object> payload);
    Object cancelBatchOrder(String json) throws IOException;
    Object cancelOrder(TradeOrderRequest order);

    Object cancelAllOrder(TradeOrderRequest order);

    Object amendOrder(TradeOrderRequest order);


}
