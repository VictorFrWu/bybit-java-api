package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.institution.LendingDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class InstituionExample {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET").newLendingRestClient();

        // Get Product info
        var insProductInfoRequest = LendingDataRequest.builder().build();
        var insProductInfo = client.getInsProductInfo(insProductInfoRequest);
        System.out.println(insProductInfo);

        // Get Margin Coin info
        var insMarginCoinRequest = LendingDataRequest.builder().build();
        var insMarginCoinInfo = client.getInsMarginCoinInfo(insMarginCoinRequest);
        System.out.println(insMarginCoinInfo);

        // Get Loan Orders
        var insLoanOrderRequest = LendingDataRequest.builder().build();
        var insLoanOrders = client.getInsLoanOrders(insLoanOrderRequest);
        System.out.println(insLoanOrders);

        // Get Repay Orders
        var insRepayOrderRequest = LendingDataRequest.builder().build();
        var insRepayOrders = client.getInsRepayOrders(insRepayOrderRequest);
        System.out.println(insRepayOrders);

        // Get Loan to Value
        var insLTVData = client.getInsLoanToValue();
        System.out.println(insLTVData);
    }
}
