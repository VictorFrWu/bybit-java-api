package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.position.MarginMode;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class PositionDataExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        var client = factory.newPositionRestClient();

        // Get Position Info
        var positionListRequest = PositionDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").build();
        var positionListData = client.getPositionInfo(positionListRequest);
        System.out.println(positionListData);

        // Set Leverage
        var setLeverageRequest = PositionDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").buyLeverage("5").sellLeverage("5").build();
        var setPositionLeverageResult = client.setPositionLeverage(setLeverageRequest);
        System.out.println(setPositionLeverageResult);

        // Get Execution History
        var executionRequest = PositionDataRequest.builder().category(ProductType.SPOT).build();
        var executionData = client.getExecutionList(executionRequest);
        System.out.println(executionData);

        // Get Close PnL History
        var closPnlRequest = PositionDataRequest.builder().category(ProductType.LINEAR).build();
        var closePnLData = client.getClosePnlList(closPnlRequest);
        System.out.println(closePnLData);

        // Switch Cross/Isolated Margin
        var switchMarginRequest = PositionDataRequest.builder().category(ProductType.LINEAR).symbol("BTC-31MAR23").tradeMode(MarginMode.CROSS_MARGIN).buyLeverage("5").sellLeverage("5").build();
        var switchMarginResult = client.swithMarginRequest(switchMarginRequest);
        System.out.println(switchMarginResult);
    }
}
