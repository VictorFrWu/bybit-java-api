package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiInsLendingRestClient;
import com.bybit.api.client.domain.institution.InstitutionLoanOrdersRequest;
import com.bybit.api.client.domain.institution.InstitutionRepayOrdersRequest;
import com.bybit.api.client.BybitApiService;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitInsLendingRestClientImpl implements BybitApiInsLendingRestClient {
    private final BybitApiService bybitApiService;

    public BybitInsLendingRestClientImpl() {
        bybitApiService = createService(BybitApiService.class);
    }
    // Institution endpoints
    @Override
    public Object getInsProductInfo(String productId) {
        return executeSync(bybitApiService.getInsProductInfo(productId));
    }

    @Override
    public Object getInsProductInfo() {
        return executeSync(bybitApiService.getInsProductInfo());
    }

    @Override
    public Object getInsMarginCoinInfo(String productId) {
        return executeSync(bybitApiService.getInsMarginCoinInfo(productId));
    }

    @Override
    public Object getInsMarginCoinInfo() {
        return executeSync(bybitApiService.getInsMarginCoinInfo());
    }

    @Override
    public Object getInsLoanOrders(InstitutionLoanOrdersRequest institutionLoanOrdersRequest) {
        return executeSync(bybitApiService.getInsLoanOrders(institutionLoanOrdersRequest.getOrderId(),
                institutionLoanOrdersRequest.getStartTime(),
                institutionLoanOrdersRequest.getEndTime(),
                institutionLoanOrdersRequest.getLimit()));
    }

    @Override
    public Object getInsRepayOrders(InstitutionRepayOrdersRequest institutionRepayOrdersRequest) {
        return executeSync(bybitApiService.getInsRepayOrders(institutionRepayOrdersRequest.getStartTime(),
                institutionRepayOrdersRequest.getEndTime(),
                institutionRepayOrdersRequest.getLimit()));
    }

    @Override
    public Object getInsLoanToValue() {
        return executeSync(bybitApiService.getInsLoanToValue());
    }
}
