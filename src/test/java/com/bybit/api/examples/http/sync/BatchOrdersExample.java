package com.bybit.api.examples.http.sync;

import com.bybit.api.client.BybitApiTradeRestClient;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.service.JsonConverter;

import java.io.IOException;
import java.util.*;

import static com.bybit.api.client.constant.Util.convertMapToJson;

public class BatchOrdersExample {
    public static void main(String[] args) throws IOException {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiTradeRestClient client = factory.newTradeRestClient();

        // Create a batch order
        var orderRequests = Arrays.asList(TradeOrderRequest.builder().category(ProductType.OPTION).symbol("BTC-10FEB23-24000-C").transactionSide(TransactionSide.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
                        .price("5").orderIv("0.1").timeInForce(TimeInForce.GTC).orderLinkId("9b381bb1-401").mmp(false).reduceOnly(false).build(),
                TradeOrderRequest.builder().category(ProductType.OPTION).symbol("BTC-10FEB23-24000-C").transactionSide(TransactionSide.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
                        .price("5").orderIv("0.1").timeInForce(TimeInForce.GTC).orderLinkId("82ee86dd-001").mmp(false).reduceOnly(false).build());
        var createBatchOrders = BatchOrderRequest.builder().category(ProductType.OPTION.getProductTypeId()).request(orderRequests).build();
        var createBatchRequestResponse = client.createBatchOrder(createBatchOrders);
        System.out.println(createBatchRequestResponse);

        // Create a batch order by map
        Map<String, Object> payload = new HashMap<>();
        payload.put("category", "option");
        List<Map<String, Object>> orders = new ArrayList<>();
        List<Integer> prices = Arrays.asList(15000, 15500, 16000, 16500, 16600);
        for (Integer price : prices) {
            Map<String, Object> order = new HashMap<>();
            order.put("symbol", "BTC-30JUN23-20000-C");
            order.put("side", "Buy");
            order.put("orderType", "Limit");
            order.put("qty", "0.1");
            order.put("price", price.toString());
            orders.add(order);
        }
        payload.put("request", orders);
        var createBatchResponse = client.createBathOrder(payload);
        System.out.println(createBatchResponse);

        // Create a batch order by json
        String jsonRequest = "{"
                + "\"category\":\"option\","
                + "\"request\": ["
                + "{"
                + "\"category\":\"option\","
                + "\"symbol\":\"BTC-10FEB23-24000-C\","
                + "\"orderType\":\"Limit\","
                + "\"side\":\"Buy\","
                + "\"qty\":\"0.1\","
                + "\"price\":\"5\","
                + "\"orderIv\":\"0.1\","
                + "\"timeInForce\":\"GTC\","
                + "\"orderLinkId\":\"9b381bb1-401\","
                + "\"mmp\":false,"
                + "\"reduceOnly\":false"
                + "},"
                + "{"
                + "\"category\":\"option\","
                + "\"symbol\":\"BTC-10FEB23-24000-C\","
                + "\"orderType\":\"Limit\","
                + "\"side\":\"Buy\","
                + "\"qty\":\"0.1\","
                + "\"price\":\"5\","
                + "\"orderIv\":\"0.1\","
                + "\"timeInForce\":\"GTC\","
                + "\"orderLinkId\":\"82ee86dd-001\","
                + "\"mmp\":false,"
                + "\"reduceOnly\":false"
                + "}"
                + "]"
                + "}";

        var batchOrderRequest = client.createBathOrder(jsonRequest);
        System.out.println(batchOrderRequest);
    }
}
