package com.bybit.api.examples.httpSync;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.impl.BybitApiClientFactory;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.BybitApiAsyncRestClient;

public class MarketDataEndpointsExampleAsync {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        BybitApiAsyncRestClient client = factory.newAsyncRestClient();

        // Weekly candlestick bars for a symbol
        client.getMarketLinesData(ProductType.SPOT,"BTCUSDT", MarketInterval.WEEKLY,
                System.out::println);
    }
}
