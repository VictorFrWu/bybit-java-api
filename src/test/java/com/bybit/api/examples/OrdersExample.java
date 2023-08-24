package com.bybit.api.examples;

import com.bybit.api.client.domain.*;
import com.bybit.api.client.domain.market.MarketKlineInterval;
import com.bybit.api.client.domain.market.MarketKlineResult;
import com.bybit.api.client.domain.trade.OrderHistoryRequest;
import com.bybit.api.client.domain.trade.OrderResult;
import com.bybit.api.client.extension.BybitApiRestClient;
import com.bybit.api.client.impl.BybitApiClientFactory;
import retrofit2.Call;

import java.util.List;

import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;


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
