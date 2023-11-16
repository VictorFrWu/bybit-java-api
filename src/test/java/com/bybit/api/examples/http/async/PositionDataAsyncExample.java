package com.bybit.api.examples.http.async;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.position.MarginMode;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class PositionDataAsyncExample {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newAsyncPositionRestClient();

        // Get Position Info
        var positionListRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").build();
        client.getPositionInfo(positionListRequest, System.out::println);

        // Set Leverage
        var setLeverageRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").buyLeverage("5").sellLeverage("5").build();
        client.setPositionLeverage(setLeverageRequest, System.out::println);

        // Get Execution History
        var executionRequest = PositionDataRequest.builder().category(CategoryType.SPOT).build();
        client.getExecutionList(executionRequest, System.out::println);

        // Get Close PnL History
        var closPnlRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).build();
       client.getClosePnlList(closPnlRequest, System.out::println);

        // Switch Cross/Isolated Margin
        var switchMarginRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTC-31MAR23").tradeMode(MarginMode.CROSS_MARGIN).buyLeverage("5").sellLeverage("5").build();
        client.swithMarginRequest(switchMarginRequest, System.out::println);

        // Confirm new position risk limit
        var confirmNewRiskRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").build();
        client.confirmPositionRiskLimit(confirmNewRiskRequest, System.out::println);

    }
}
