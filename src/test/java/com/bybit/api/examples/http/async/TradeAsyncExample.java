package com.bybit.api.examples.http.async;

import com.bybit.api.client.BybitApiAsyncTradeRestClient;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.TradeOrderType;
import com.bybit.api.client.domain.trade.PositionIdx;
import com.bybit.api.client.domain.trade.Side;
import com.bybit.api.client.domain.trade.TimeInForce;
import com.bybit.api.client.domain.trade.TradeOrderRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

import java.util.HashMap;
import java.util.Map;

public class TradeAsyncExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        BybitApiAsyncTradeRestClient client = factory.newAsyncTradeRestClient();

        // Place an order
        var newOrderRequest = TradeOrderRequest.builder().category(ProductType.LINEAR).symbol("XRPUSDT")
                .side(Side.BUY).orderType(TradeOrderType.MARKET).qty("10").timeInForce(TimeInForce.IMMEDIATE_OR_CANCEL)
                .positionIdx(PositionIdx.ONE_WAY_MODE).build();
        client.createOrder(newOrderRequest, System.out::println);

        // Place an order by map
        Map<String, Object> order =Map.of(
                "category", "option",
                "symbol", "BTC-29DEC23-10000-P",
                "side", "Buy",
                "orderType", "Limit",
                "orderIv", "0.1",
                "qty", "0.1",
                "price", "5",
                "orderLinkId", "test_orderLinkId_1"
        );
        client.createOrder(order, System.out::println);
    }
}
