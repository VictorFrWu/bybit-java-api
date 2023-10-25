package com.bybit.api.examples.http.sync;

import com.bybit.api.client.BybitApiTradeRestClient;
import com.bybit.api.client.domain.*;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.service.BybitApiClientFactory;


/**
 * Examples on how to place orders, cancel them, amend them and query them
 */
public class TradeExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiTradeRestClient client = factory.newTradeRestClient();

        // Getting a list of history order between 2 years
        var orderHistory = TradeOrderRequest.builder().category(ProductType.LINEAR).limit(10).build();
        var allOrders = client.getHistoryOrderResult(orderHistory);
        System.out.println(allOrders);

        // Get all real time orders
        var openOrderRequest = TradeOrderRequest.builder().category(ProductType.SPOT).build();
        var allOpenOrders = client.getOpenOrders(openOrderRequest);
        System.out.println(allOpenOrders);

        // Create a new order
        var newOrderRequest = TradeOrderRequest.builder().category(ProductType.LINEAR).symbol("XRPUSDT").side(Side.BUY).orderType(TradeOrderType.MARKET).qty("10").build();
        var newOrder = client.createOrder(newOrderRequest);
        System.out.println(newOrder);

        // Create an AmendOrderRequest
        var amendOrderRequest = TradeOrderRequest.builder().orderId("1523347543495541248").category(ProductType.LINEAR).symbol("XRPUSDT")
                .price("0.5")  // setting a new price, for example
                .qty("15")  // and a new quantity
                .build();
        var amendedOrder = client.amendOrder(amendOrderRequest);
        System.out.println(amendedOrder);

        // Create a CancelOrderRequest
        var cancelOrderRequest = TradeOrderRequest.builder().category(ProductType.SPOT).symbol("XRPUSDT").orderId("1523347543495541248").build();
        var canceledOrder = client.cancelOrder(cancelOrderRequest);
        System.out.println(canceledOrder);
    }
}
