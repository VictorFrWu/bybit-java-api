package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiInstitutionRestClient;
import com.bybit.api.client.domain.institution.InstitutionDataRequest;
import com.bybit.api.client.BybitApiService;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitInstitutionRestClientImpl implements BybitApiInstitutionRestClient {
    private final BybitApiService bybitApiService;

    public BybitInstitutionRestClientImpl() {
        bybitApiService = createService(BybitApiService.class);
    }
    // Institution endpoints
    @Override
    public Object getInsProductInfo(InstitutionDataRequest institutionDataRequest) {
        return executeSync(bybitApiService.getInsProductInfo(institutionDataRequest.getProductId()));
    }

    @Override
    public Object getInsMarginCoinInfo(InstitutionDataRequest institutionDataRequest) {
        return executeSync(bybitApiService.getInsMarginCoinInfo(institutionDataRequest.getProductId()));
    }

    @Override
    public Object getInsLoanOrders(InstitutionDataRequest institutionLoanOrdersRequest) {
        return executeSync(bybitApiService.getInsLoanOrders(institutionLoanOrdersRequest.getOrderId(),
                institutionLoanOrdersRequest.getStartTime(),
                institutionLoanOrdersRequest.getEndTime(),
                institutionLoanOrdersRequest.getLimit()));
    }

    @Override
    public Object getInsRepayOrders(InstitutionDataRequest institutionRepayOrdersRequest) {
        return executeSync(bybitApiService.getInsRepayOrders(institutionRepayOrdersRequest.getStartTime(),
                institutionRepayOrdersRequest.getEndTime(),
                institutionRepayOrdersRequest.getLimit()));
    }

    @Override
    public Object getInsLoanToValue() {
        return executeSync(bybitApiService.getInsLoanToValue());
    }

    // Broker

    @Override
    public Object getBrokerEarningData(InstitutionDataRequest brokerEarningRequest) {
        return executeSync(bybitApiService.getBrokerEarningData(
                brokerEarningRequest.getBizType() == null ? null : brokerEarningRequest.getBizType().getType(),
                brokerEarningRequest.getStartTime(),
                brokerEarningRequest.getEndTime(),
                brokerEarningRequest.getLimit(),
                brokerEarningRequest.getCursor()
        ));
    }
}
