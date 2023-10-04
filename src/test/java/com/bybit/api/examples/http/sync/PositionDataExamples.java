package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.position.request.*;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.BybitApiRestClient;

public class PositionDataExamples {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiRestClient client = factory.newRestClient();

        // Get Position Info
        var positionListRequest = new PositionListRequest.Builder(ProductType.LINEAR)
                .symbol("BTCUSDT")
                .build();
        var positionListData = client.getPositionInfo(positionListRequest);
        System.out.println(positionListData);

        // Set Leverage
        var setLeverageRequest = new SetLeverageRequest.Builder("linear", "BTCUSDT", "2", "2").build();
        var setPositionLeverageResult = client.setPositionLeverage(setLeverageRequest);
        System.out.println(setPositionLeverageResult);

        // Get Execution History
        var executionRequest = new ExecutionHistoryRequest.Builder(ProductType.SPOT).build();
        var executionData = client.getExecutionList(executionRequest);
        System.out.println(executionData);

        // Get Close PnL History
        var closPnlRequest = new ClosePnlHistoryRequest.Builder(ProductType.LINEAR).build();
        var closePnLData = client.getClosePnlList(closPnlRequest);
        System.out.println(closePnLData);

        // Switch Cross/Isolated Margin
        var switchMarginRequest = new SwitchMarginRequest.Builder(
                "linear",
                "BTC-31MAR23",
                0,
                "5",
                "5"
        ).build();
        var switchMarginResult = client.swithMarginRequest(switchMarginRequest);
        System.out.println(switchMarginResult);
    }
}
