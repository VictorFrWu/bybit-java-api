package com.bybit.api.functionalTest;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.TradeOrderType;
import com.bybit.api.client.domain.trade.Side;
import com.bybit.api.client.domain.trade.request.TradeOrderRequest;
import com.bybit.api.client.restApi.BybitApiTradeRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;

public class demo_trading_example {
    public static void main(String[] args) {
        BybitApiTradeRestClient client = BybitApiClientFactory.newInstance("4UqdVDGMBrIrHjeaEW", "H8U2zqmF8iwHKZlWQ1pZXk5E3AlQRWAobOer", "https://api-demo.bybit.com").newTradeRestClient();
        var newOrderRequest = TradeOrderRequest.builder().category(CategoryType.LINEAR).symbol("XRPUSDT").side(Side.BUY).orderType(TradeOrderType.MARKET).qty("15").build();
        var newOrder = client.createOrder(newOrderRequest);
        System.out.println(newOrder);
    }
}
