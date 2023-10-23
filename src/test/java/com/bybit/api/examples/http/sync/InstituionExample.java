package com.bybit.api.examples.http.sync;

import com.bybit.api.client.BybitApiInstitutionRestClient;
import com.bybit.api.client.domain.institution.InstitutionDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class InstituionExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        var client = factory.newInstitutionRestClient();

        // Get Product info
        var insProductInfoRequest = InstitutionDataRequest.builder().build();
        var insProductInfo = client.getInsProductInfo(insProductInfoRequest);
        System.out.println(insProductInfo);

        // Get Margin Coin info
        var insMarginCoinRequest = InstitutionDataRequest.builder().build();
        var insMarginCoinInfo = client.getInsMarginCoinInfo(insMarginCoinRequest);
        System.out.println(insMarginCoinInfo);

        // Get Loan Orders
        var insLoanOrderRequest = InstitutionDataRequest.builder().build();
        var insLoanOrders = client.getInsLoanOrders(insLoanOrderRequest);
        System.out.println(insLoanOrders);

        // Get Repay Orders
        var insRepayOrderRequest = InstitutionDataRequest.builder().build();
        var insRepayOrders = client.getInsRepayOrders(insRepayOrderRequest);
        System.out.println(insRepayOrders);

        // Get Loan to Value
        var insLTVData = client.getInsLoanToValue();
        System.out.println(insLTVData);
    }
}
