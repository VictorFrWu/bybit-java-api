package com.bybit.api.examples;

import com.bybit.api.client.domain.*;
import com.bybit.api.client.domain.trade.requests.OrderHistoryRequest;
import com.bybit.api.client.domain.trade.response.OrderResult;
import com.bybit.api.client.impl.BybitApiRestClient;
import com.bybit.api.client.impl.BybitApiClientFactory;


/**
 * Examples on how to place orders, cancel them, amend them and query them
 */
public class OrdersExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiRestClient client = factory.newRestClient();

        // Getting a list of history order between 2 years
        GenericResponse<OrderResult> allOrders = client.getHistoryOrderResult(new OrderHistoryRequest(ProductType.LINEAR).limit(10));
        System.out.println(allOrders.getResult());
    }
}
