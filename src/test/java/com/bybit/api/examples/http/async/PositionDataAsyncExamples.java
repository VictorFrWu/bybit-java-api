package com.bybit.api.examples.http.async;

import com.bybit.api.client.BybitApiAsyncRestClient;
import com.bybit.api.client.BybitApiRestClient;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.position.MarginMode;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class PositionDataAsyncExamples {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiAsyncRestClient client = factory.newAsyncRestClient();

        // Get Position Info
        var positionListRequest = PositionDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").build();
        client.getPositionInfo(positionListRequest, System.out::println);

        // Set Leverage
        var setLeverageRequest = PositionDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").buyLeverage("5").sellLeverage("5").build();
        client.setPositionLeverage(setLeverageRequest, System.out::println);

        // Get Execution History
        var executionRequest = PositionDataRequest.builder().category(ProductType.SPOT).build();
        client.getExecutionList(executionRequest, System.out::println);

        // Get Close PnL History
        var closPnlRequest = PositionDataRequest.builder().category(ProductType.LINEAR).build();
       client.getClosePnlList(closPnlRequest, System.out::println);

        // Switch Cross/Isolated Margin
        var switchMarginRequest = PositionDataRequest.builder().category(ProductType.LINEAR).symbol("BTC-31MAR23").tradeMode(MarginMode.CROSS_MARGIN).buyLeverage("5").sellLeverage("5").build();
        client.swithMarginRequest(switchMarginRequest, System.out::println);
    }
}
