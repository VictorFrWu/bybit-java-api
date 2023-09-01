package com.bybit.api.examples;

import com.bybit.api.client.domain.*;
import com.bybit.api.client.domain.trade.requests.NewOrderRequest;
import com.bybit.api.client.domain.trade.requests.OpenOrderRequest;
import com.bybit.api.client.domain.trade.requests.OrderHistoryRequest;
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

        // Get all real time orders
        OpenOrderRequest openOrderRequest = new OpenOrderRequest.Builder(ProductType.SPOT).build();
        var allOpenOrders = client.getOpenOrders(openOrderRequest);
        System.out.println(allOpenOrders);


    }
}
