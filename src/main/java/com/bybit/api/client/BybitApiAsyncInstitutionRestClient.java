package com.bybit.api.client;

import com.bybit.api.client.domain.institution.InstitutionDataRequest;

public interface BybitApiAsyncInstitutionRestClient {
    // Institution Endpoints
    void getInsProductInfo(InstitutionDataRequest institutionDataRequest, BybitApiCallback<Object> callback);
    void getInsMarginCoinInfo(InstitutionDataRequest institutionDataRequest, BybitApiCallback<Object> callback);
    void getInsLoanOrders(InstitutionDataRequest institutionLoanOrdersRequest, BybitApiCallback<Object> callback);
    void getInsRepayOrders(InstitutionDataRequest institutionRepayOrdersRequest, BybitApiCallback<Object> callback);
    void getInsLoanToValue(BybitApiCallback<Object> callback);
    // Broker endpoints
    void getBrokerEarningData(InstitutionDataRequest brokerEarningRequest, BybitApiCallback<Object> callback);
}
