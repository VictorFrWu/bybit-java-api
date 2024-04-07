package com.bybit.api.examples.http.async;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.TradeOrderType;
import com.bybit.api.client.domain.trade.PositionIdx;
import com.bybit.api.client.domain.trade.Side;
import com.bybit.api.client.domain.trade.TimeInForce;
import com.bybit.api.client.domain.trade.request.TradeOrderRequest;
import com.bybit.api.client.service.BybitApiClientFactory;
import java.util.Map;

public class TradeAsyncExample {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj", BybitApiConfig.TESTNET_DOMAIN, true).newAsyncTradeRestClient();

        // Place an order
        var newOrderRequest = TradeOrderRequest.builder().category(CategoryType.LINEAR).symbol("XRPUSDT")
                .side(Side.BUY).orderType(TradeOrderType.LIMIT).qty("10").price("0.6").timeInForce(TimeInForce.GOOD_TILL_CANCEL)
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
                "orderLinkId", "victor-test-create-trade-01",
                "price", "5"
        );
        client.createOrder(order, System.out::println);

        // Cancel All order
        var cancelAllOrdersRequest = TradeOrderRequest.builder().category(CategoryType.LINEAR).settleCoin("USDT").build();
        client.cancelAllOrder(cancelAllOrdersRequest, System.out::println);

        // Get Trade History
        var executionRequest = TradeOrderRequest.builder().category(CategoryType.SPOT).build();
        client.getTradeHistory(executionRequest, System.out::println);
    }
}
