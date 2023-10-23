package com.bybit.api.client;

import com.bybit.api.client.domain.institution.InstitutionDataRequest;

public interface BybitApiInstitutionRestClient {
    // Institution Endpoints
    Object getInsProductInfo(InstitutionDataRequest institutionDataRequest);
    Object getInsMarginCoinInfo(InstitutionDataRequest institutionDataRequest);
    Object getInsLoanOrders(InstitutionDataRequest institutionLoanOrdersRequest);
    Object getInsRepayOrders(InstitutionDataRequest institutionRepayOrdersRequest);
    Object getInsLoanToValue();
    // Broker endpoints
    Object getBrokerEarningData(InstitutionDataRequest brokerEarningRequest);
}
