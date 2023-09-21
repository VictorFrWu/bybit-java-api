package com.bybit.api.examples.httpSync;

import com.bybit.api.client.domain.c2c.ClientLendingFundsRequest;
import com.bybit.api.client.domain.c2c.ClientLendingOrderRecordsRequest;
import com.bybit.api.client.impl.BybitApiClientFactory;
import com.bybit.api.client.BybitApiRestClient;

public class C2CExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("VUEODVICUIVUXIJJKO", "TWZAESUUJGROUJTAMRKLDDMHLPOXUHUEDBFZ");
        BybitApiRestClient client = factory.newRestClient();

        // Get Lending Coin
        var lendingCoinInfo = client.getC2CLendingCoinInfo();
        System.out.println(lendingCoinInfo);

        // Deposit Fund
        var despoitFundRequest = new ClientLendingFundsRequest.Builder("USDT", "100").build();
        var depositFundResult = client.C2cLendingDepositFunds(despoitFundRequest);
        System.out.println(depositFundResult);

        // Redeem Fund
        var redeemFundRequest = new ClientLendingFundsRequest.Builder("USDT", "100").build();
        var redeemFundResult = client.C2cLendingRedeemFunds(redeemFundRequest);
        System.out.println(redeemFundResult);

        // Get Order Records
        var c2cOrdersRecordsRequest = new ClientLendingOrderRecordsRequest.Builder().build();
        var c2cOrdersRecords = client.getC2cOrdersRecords(c2cOrdersRecordsRequest);
        System.out.println(c2cOrdersRecords);

        // Get Lending Account
        var lendingAccount = client.getC2CLendingAccountInfo("USDT");
        System.out.println(lendingAccount);
    }
}
