package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.institution.LendingDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class C2CExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        var client = factory.newLendingRestClient();

        // Get Lending Coin
        var lendingCoinRequest = LendingDataRequest.builder().build();
        var lendingCoinInfo = client.getC2CLendingCoinInfo(lendingCoinRequest);
        System.out.println(lendingCoinInfo);

        // Deposit Fund
        var despoitFundRequest = LendingDataRequest.builder().coin("USDT").quantity("100").build();
        var depositFundResult = client.C2cLendingDepositFunds(despoitFundRequest);
        System.out.println(depositFundResult);

        // Redeem Fund
        var redeemFundResult = client.C2cLendingRedeemFunds(despoitFundRequest);
        System.out.println(redeemFundResult);

        // Get Order Records
        var c2cOrdersRecordsRequest = LendingDataRequest.builder().build();
        var c2cOrdersRecords = client.getC2cOrdersRecords(c2cOrdersRecordsRequest);
        System.out.println(c2cOrdersRecords);

        // Get Lending Account
        var lendingAccountRequest = LendingDataRequest.builder().coin("USDT").build();
        var lendingAccount = client.getC2CLendingAccountInfo(lendingAccountRequest);
        System.out.println(lendingAccount);
    }
}
