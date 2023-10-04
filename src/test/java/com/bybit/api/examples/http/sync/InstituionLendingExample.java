package com.bybit.api.examples.http.sync;

import com.bybit.api.client.BybitApiInsLendingRestClient;
import com.bybit.api.client.domain.institution.InstitutionLoanOrdersRequest;
import com.bybit.api.client.domain.institution.InstitutionRepayOrdersRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class InstituionLendingExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiInsLendingRestClient client = factory.newInsLendingRestClient();

        // Get Product info
        var insProductInfo = client.getInsProductInfo();
        System.out.println(insProductInfo);

        // Get Margin Coin info
        var insMarginCoinInfo = client.getInsMarginCoinInfo();
        System.out.println(insMarginCoinInfo);

        // Get Loan Orders
        var insLoanOrderRequest = InstitutionLoanOrdersRequest.builder().build();
        var insLoanOrders = client.getInsLoanOrders(insLoanOrderRequest);
        System.out.println(insLoanOrders);

        // Get Repay Orders
        var insRepayOrderRequest = InstitutionRepayOrdersRequest.builder().build();
        var insRepayOrders = client.getInsRepayOrders(insRepayOrderRequest);
        System.out.println(insRepayOrders);

        // Get Loan to Value
        var insLTVData = client.getInsLoanToValue();
        System.out.println(insLTVData);
    }
}
