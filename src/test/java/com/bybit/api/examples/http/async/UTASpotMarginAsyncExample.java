package com.bybit.api.examples.http.async;

import com.bybit.api.client.domain.spot.SpotMarginDataRequest;
import com.bybit.api.client.domain.spot.SwitchStatus;
import com.bybit.api.client.service.BybitApiClientFactory;

public class UTASpotMarginAsyncExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        var client = factory.newSpotMarginAsyncRestClient();

        // Get VIP Margin Data
        var utaMarginDataRequest = SpotMarginDataRequest.builder().build();
        client.getUtaVipSpotMarginTradeData(utaMarginDataRequest, System.out::println);

        // Toggle Margin Trade
        var toggleMarginTradeRequest = SpotMarginDataRequest.builder().switchStatus(SwitchStatus.ON).build();
        client.setUTASpotMarginTrade(toggleMarginTradeRequest, System.out::println);

        // Set Leverage
        var spotLeverageSetRequest = SpotMarginDataRequest.builder().leverage("2").build();
        client.setUTASpotMarginTradeLeverage(spotLeverageSetRequest, System.out::println);

        // Set Status And Leverage
        client.getUTASpotMarginTradeLeverageState(System.out::println);
    }
}
