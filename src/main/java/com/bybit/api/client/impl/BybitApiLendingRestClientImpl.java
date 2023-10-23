package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiLendingRestClient;
import com.bybit.api.client.domain.institution.LendingDataRequest;
import com.bybit.api.client.BybitApiService;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiLendingRestClientImpl implements BybitApiLendingRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiLendingRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }
    // Institution endpoints
    @Override
    public Object getInsProductInfo(LendingDataRequest lendingDataRequest) {
        return executeSync(bybitApiService.getInsProductInfo(lendingDataRequest.getProductId()));
    }

    @Override
    public Object getInsMarginCoinInfo(LendingDataRequest lendingDataRequest) {
        return executeSync(bybitApiService.getInsMarginCoinInfo(lendingDataRequest.getProductId()));
    }

    @Override
    public Object getInsLoanOrders(LendingDataRequest institutionLoanOrdersRequest) {
        return executeSync(bybitApiService.getInsLoanOrders(institutionLoanOrdersRequest.getOrderId(),
                institutionLoanOrdersRequest.getStartTime(),
                institutionLoanOrdersRequest.getEndTime(),
                institutionLoanOrdersRequest.getLimit()));
    }

    @Override
    public Object getInsRepayOrders(LendingDataRequest institutionRepayOrdersRequest) {
        return executeSync(bybitApiService.getInsRepayOrders(institutionRepayOrdersRequest.getStartTime(),
                institutionRepayOrdersRequest.getEndTime(),
                institutionRepayOrdersRequest.getLimit()));
    }

    @Override
    public Object getInsLoanToValue() {
        return executeSync(bybitApiService.getInsLoanToValue());
    }

    // C2C Endpoints
    @Override
    public Object getC2CLendingCoinInfo(LendingDataRequest lendingDataRequest) {
        return executeSync(bybitApiService.getC2CLendingCoinInfo(lendingDataRequest.getCoin()));
    }

    @Override
    public Object C2cLendingDepositFunds(LendingDataRequest lendingDataRequest) {
        var depsoitFundRequest = converter.mapToC2CLendingFundRequest(lendingDataRequest);
        return executeSync(bybitApiService.C2cLendingDepositFunds(depsoitFundRequest));
    }

    @Override
    public Object C2cLendingRedeemFunds(LendingDataRequest lendingDataRequest) {
        var redeemFundRequest = converter.mapToC2CLendingFundRequest(lendingDataRequest);
        return executeSync(bybitApiService.C2cLendingRedeemFunds(redeemFundRequest));
    }

    @Override
    public Object C2cLendingRedeemCancel(LendingDataRequest lendingDataRequest) {
        var redeemFundCancelRequest = converter.mapToC2CLendingFundRequest(lendingDataRequest);
        return executeSync(bybitApiService.C2cLendingRedeemFunds(redeemFundCancelRequest));
    }

    @Override
    public Object getC2cOrdersRecords(LendingDataRequest c2cOrdersRecordsRequest) {
        return executeSync(bybitApiService.getC2cOrdersRecords(
                c2cOrdersRecordsRequest.getCoin(),
                c2cOrdersRecordsRequest.getOrderId(),
                c2cOrdersRecordsRequest.getStartTime(),
                c2cOrdersRecordsRequest.getEndTime(),
                c2cOrdersRecordsRequest.getLimit(),
                c2cOrdersRecordsRequest.getLendingOrderType() == null ? null : c2cOrdersRecordsRequest.getLendingOrderType().getType()
        ));
    }

    @Override
    public Object getC2CLendingAccountInfo(LendingDataRequest lendingDataRequest) {
        String coin = lendingDataRequest.getCoin();
        return executeSync(bybitApiService.getC2CLendingAccountInfo(coin));
    }
}
