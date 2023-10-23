package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiAsyncInstitutionRestClient;
import com.bybit.api.client.BybitApiCallback;
import com.bybit.api.client.BybitApiService;
import com.bybit.api.client.domain.institution.InstitutionDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncInstitutionRestClientImpl implements BybitApiAsyncInstitutionRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncInstitutionRestClientImpl() {
        bybitApiService = createService(BybitApiService.class);
    }

    @Override
    public void getInsProductInfo(InstitutionDataRequest institutionDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getInsProductInfo(institutionDataRequest.getProductId()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsMarginCoinInfo(InstitutionDataRequest institutionDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getInsMarginCoinInfo(institutionDataRequest.getProductId()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsLoanOrders(InstitutionDataRequest institutionLoanOrdersRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getInsLoanOrders(institutionLoanOrdersRequest.getOrderId(),
                institutionLoanOrdersRequest.getStartTime(),
                institutionLoanOrdersRequest.getEndTime(),
                institutionLoanOrdersRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsRepayOrders(InstitutionDataRequest institutionRepayOrdersRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getInsRepayOrders(institutionRepayOrdersRequest.getStartTime(),
                institutionRepayOrdersRequest.getEndTime(),
                institutionRepayOrdersRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsLoanToValue(BybitApiCallback<Object> callback) {
        bybitApiService.getInsLoanToValue().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getBrokerEarningData(InstitutionDataRequest brokerEarningRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getBrokerEarningData(
                brokerEarningRequest.getBizType() == null ? null : brokerEarningRequest.getBizType().getType(),
                brokerEarningRequest.getStartTime(),
                brokerEarningRequest.getEndTime(),
                brokerEarningRequest.getLimit(),
                brokerEarningRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
