package com.bybit.api.examples.http.async;

import com.bybit.api.client.BybitApAsynciTradeRestClient;
import com.bybit.api.client.BybitApiAsyncRestClient;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.DataRecordingPeriod;
import com.bybit.api.client.domain.market.InstrumentStatus;
import com.bybit.api.client.domain.market.MarketDataRequest;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.service.BybitApiClientFactory;

import java.util.Arrays;

public class BatchOrderAsyncExampleAsync {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApAsynciTradeRestClient client = factory.newAsyncTradeRestClient();

        // Create a batch order
        var orderRequests = Arrays.asList(TradeOrderRequest.builder().category(ProductType.OPTION).symbol("BTC-10FEB23-24000-C").transactionSide(TransactionSide.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
                        .price("5").orderIv("0.1").timeInForce(TimeInForce.GTC).orderLinkId("9b381bb1-401").mmp(false).reduceOnly(false).build(),
                TradeOrderRequest.builder().category(ProductType.OPTION).symbol("BTC-10FEB23-24000-C").transactionSide(TransactionSide.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
                        .price("5").orderIv("0.1").timeInForce(TimeInForce.GTC).orderLinkId("82ee86dd-001").mmp(false).reduceOnly(false).build());
        var createBatchOrders = BatchOrderRequest.builder().category(ProductType.OPTION.getProductTypeId()).request(orderRequests).build();
        client.createBatchOrder(createBatchOrders, System.out::println);
    }
}
