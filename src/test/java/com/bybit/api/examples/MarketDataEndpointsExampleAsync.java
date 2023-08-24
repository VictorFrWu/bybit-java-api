package com.bybit.api.examples;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.impl.BybitApiClientFactory;
import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.MarketKlineInterval;
import com.bybit.api.client.domain.market.MarketKlineResult;
import com.bybit.api.client.extension.BybitApiAsyncRestClient;

public class MarketDataEndpointsExampleAsync {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        BybitApiAsyncRestClient client = factory.newAsyncRestClient();

        // Weekly candlestick bars for a symbol
        client.getMarketLinesData(ProductType.SPOT,"BTCUSDT", MarketKlineInterval.WEEKLY,
                (GenericResponse<MarketKlineResult> response) -> System.out.println(response.getResult()));
    }
}
