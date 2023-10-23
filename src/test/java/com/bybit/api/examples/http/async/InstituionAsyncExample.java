package com.bybit.api.examples.http.async;

import com.bybit.api.client.BybitApiInstitutionRestClient;
import com.bybit.api.client.domain.institution.InstitutionDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class InstituionAsyncExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        var client = factory.newAsyncInstitutionRestClient();

        // Get Product info
        var insProductInfoRequest = InstitutionDataRequest.builder().build();
        client.getInsProductInfo(insProductInfoRequest, System.out::println);

        // Get Margin Coin info
        var insMarginCoinRequest = InstitutionDataRequest.builder().build();
        client.getInsMarginCoinInfo(insMarginCoinRequest, System.out::println);

        // Get Loan Orders
        var insLoanOrderRequest = InstitutionDataRequest.builder().build();
        client.getInsLoanOrders(insLoanOrderRequest, System.out::println);

        // Get Repay Orders
        var insRepayOrderRequest = InstitutionDataRequest.builder().build();
        client.getInsRepayOrders(insRepayOrderRequest, System.out::println);

        // Get Loan to Value
        client.getInsLoanToValue(System.out::println);
    }
}
