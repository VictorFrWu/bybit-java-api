package com.bybit.api.examples;

import com.bybit.api.client.domain.*;
import com.bybit.api.client.domain.trade.requests.*;
import com.bybit.api.client.domain.trade.response.OrderResponse;
import com.bybit.api.client.domain.trade.response.OrderResult;
import com.bybit.api.client.impl.BybitApiRestClient;
import com.bybit.api.client.impl.BybitApiClientFactory;

import java.util.Optional;


/**
 * Examples on how to place orders, cancel them, amend them and query them
 */
public class OrdersExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiRestClient client = factory.newRestClient();

        // Getting a list of history order between 2 years
        var allOrders = client.getHistoryOrderResult(new OrderHistoryRequest(ProductType.LINEAR).limit(10));
        System.out.println(allOrders);

        // Create a new order
        NewOrderRequest newOrderRequest = new NewOrderRequest.Builder(ProductType.SPOT, "XRPUSDT", "Buy", "Market", "10").build();
        var newOrder = client.newOrder(newOrderRequest);
        System.out.println(newOrder);

        // Create an AmendOrderRequest
        AmendOrderRequest amendOrderRequest = new AmendOrderRequest.Builder(ProductType.LINEAR, "XRPUSDT")
                .price("0.5")  // setting a new price, for example
                .qty("15")  // and a new quantity
                .build();
        var amendedOrder = client.amendOrder(amendOrderRequest);
        System.out.println(amendedOrder);

        // Create a CancelOrderRequest
        CancelOrderRequest cancelOrderRequest = new CancelOrderRequest.Builder(ProductType.SPOT, "XRPUSDT").build();
        var canceledOrder = client.cancelOrder(cancelOrderRequest);
        System.out.println(canceledOrder);

        // Get all real time orders
        OpenOrderRequest openOrderRequest = new OpenOrderRequest.Builder(ProductType.SPOT).build();
        var allOpenOrders = client.getOpenOrders(openOrderRequest);
        System.out.println(allOpenOrders);


    }
}
