package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageOrdersRecordRequest;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageTokenRequest;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.BybitApiRestClient;

public class SpotLeverageExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        BybitApiRestClient client = factory.newRestClient();

        // Get Leverage Token info
        var spotLeverageTokenInfo = client.getSpotLeverageTokenInfo();
        System.out.println(spotLeverageTokenInfo);

        // Get Leverage Token market
        var spotLeverageTokenReference = client.getSpotLeverageTokenMarket("BTC3L");
        System.out.println(spotLeverageTokenReference);

        var spotLeverageRequest = new SpotLeverageTokenRequest.Builder("BTC3L", "10").build();
        // Purchase Leverage token
        var purchaseSpotLeverageResult = client.purchaseSpotLeverageToken(spotLeverageRequest);
        System.out.println(purchaseSpotLeverageResult);

        // Redeem Leverage token
        var redeemSpotLeverageResult = client.redeemSpotLeverageToken(spotLeverageRequest);
        System.out.println(redeemSpotLeverageResult);

        var spotLeverageRecordsRequest = new SpotLeverageOrdersRecordRequest.Builder().build();
        var spotLeverageRecords = client.getSpotLeverageRecords(spotLeverageRecordsRequest);
        System.out.println(spotLeverageRecords);
    }
}
