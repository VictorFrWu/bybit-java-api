package com.bybit.api.examples.httpSync;

import com.bybit.api.client.domain.account.institution.InstitutionLoanOrdersRequest;
import com.bybit.api.client.domain.account.institution.InstitutionRepayOrdersRequest;
import com.bybit.api.client.impl.BybitApiClientFactory;
import com.bybit.api.client.BybitApiRestClient;

public class InstituionLendingExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiRestClient client = factory.newRestClient();

        // Get Product info
        var insProductInfo = client.getInsProductInfo();
        System.out.println(insProductInfo);

        // Get Margin Coin info
        var insMarginCoinInfo = client.getInsMarginCoinInfo();
        System.out.println(insMarginCoinInfo);

        // Get Loan Orders
        var insLoanOrderRequest = new InstitutionLoanOrdersRequest.Builder().build();
        var insLoanOrders = client.getInsLoanOrders(insLoanOrderRequest);
        System.out.println(insLoanOrders);

        // Get Repay Orders
        var insRepayOrderRequest = new InstitutionRepayOrdersRequest.Builder().build();
        var insRepayOrders = client.getInsRepayOrders(insRepayOrderRequest);
        System.out.println(insRepayOrders);

        // Get Loan to Value
        var insLTVData = client.getInsLoanToValue();
        System.out.println(insLTVData);
    }
}
