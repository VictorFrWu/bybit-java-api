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
        var utaToggleMarginTradeResult = client.setUTASpotMarginTrade("0");
        System.out.println(utaToggleMarginTradeResult);

        // Set Leverage
        var utaLeverageResult = client.setUTASpotMarginTradeLeverage("2");
        System.out.println(utaLeverageResult);

        // Get Status And Leverage
        var utaSpotLeverageState = client.getUTASpotMarginTradeLeverageState();
        System.out.println(utaSpotLeverageState);
    }
}
