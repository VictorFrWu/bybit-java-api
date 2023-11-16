package com.bybit.api.examples.http.async;

import com.bybit.api.client.domain.institution.LendingDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class InstituionAsyncExample {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET").newAsyncLendingRestClient();

        // Get Product info
        var insProductInfoRequest = LendingDataRequest.builder().build();
        client.getInsProductInfo(insProductInfoRequest, System.out::println);

        // Get Margin Coin info
        var insMarginCoinRequest = LendingDataRequest.builder().build();
        client.getInsMarginCoinInfo(insMarginCoinRequest, System.out::println);

        // Get Loan Orders
        var insLoanOrderRequest = LendingDataRequest.builder().build();
        client.getInsLoanOrders(insLoanOrderRequest, System.out::println);

        // Get Repay Orders
        var insRepayOrderRequest = LendingDataRequest.builder().build();
        client.getInsRepayOrders(insRepayOrderRequest, System.out::println);

        // Get Loan to Value
        client.getInsLoanToValue(System.out::println);
    }
}
