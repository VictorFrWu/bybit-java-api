package com.bybit.api.examples;

import com.bybit.api.client.impl.BybitApiClientFactory;
import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.MarketKlineResult;
import com.bybit.api.client.domain.market.MarketKlineInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.impl.BybitApiRestClient;

/**
 * Examples on how to get market data information such as the latest price of a symbol, etc.
 */
public class MarketDataEndpointsExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        BybitApiRestClient client = factory.newRestClient();

        // Weekly candlestick bars for a symbol
        var marketKlineResult = client.getMarketLinesData(ProductType.SPOT,"BTCUSDT", MarketKlineInterval.WEEKLY);
        System.out.println(marketKlineResult);
    }
}
