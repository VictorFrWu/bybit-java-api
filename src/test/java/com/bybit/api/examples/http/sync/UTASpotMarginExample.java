package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.spot.marginTrade.VIPMarginDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.BybitApiRestClient;

public class UTASpotMarginExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        BybitApiRestClient client = factory.newRestClient();

        // Get VIP Margin Data
        var utaMarginDataRequest = new VIPMarginDataRequest.Builder().build();
        var utaMarginData = client.getUtaVipSpotMarginTradeData(utaMarginDataRequest);
        System.out.println(utaMarginData);

        // Toggle Margin Trade
        var utaToggleMarginTradeResult = client.setUTASpotMarginTrade("1");
        System.out.println(utaToggleMarginTradeResult);

        // Set Leverage
        var utaLeverageResult = client.setUTASpotMarginTradeLeverage("2");
        System.out.println(utaLeverageResult);

        // Get Status And Leverage
        var utaSpotLeverageState = client.getUTASpotMarginTradeLeverageState();
        System.out.println(utaSpotLeverageState);
    }
}
