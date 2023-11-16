package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.spot.SpotMarginDataRequest;
import com.bybit.api.client.domain.spot.SwitchStatus;
import com.bybit.api.client.domain.spot.marginTrade.VIPMarginDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class UTASpotMarginExample {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET").newSpotMarginRestClient();

        // Get VIP Margin Data
        var utaMarginDataRequest = SpotMarginDataRequest.builder().build();
        var utaMarginData = client.getUtaVipSpotMarginTradeData(utaMarginDataRequest);
        System.out.println(utaMarginData);

        // Toggle Margin Trade
        var toggleMarginTradeRequest = SpotMarginDataRequest.builder().switchStatus(SwitchStatus.ON).build();
        var utaToggleMarginTradeResult = client.setUTASpotMarginTrade(toggleMarginTradeRequest);
        System.out.println(utaToggleMarginTradeResult);

        // Set Leverage
        var spotLeverageSetRequest = SpotMarginDataRequest.builder().leverage("2").build();
        var utaLeverageResult = client.setUTASpotMarginTradeLeverage(spotLeverageSetRequest);
        System.out.println(utaLeverageResult);

        // Get Status And Leverage
        var utaSpotLeverageState = client.getUTASpotMarginTradeLeverageState();
        System.out.println(utaSpotLeverageState);
    }
}
