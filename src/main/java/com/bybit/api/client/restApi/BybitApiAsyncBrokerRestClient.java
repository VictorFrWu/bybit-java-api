package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.broker.BrokerDataRequest;

public interface BybitApiAsyncBrokerRestClient {
    // Broker endpoints
    void getBrokerEarningData(BrokerDataRequest brokerDataRequest, BybitApiCallback<Object> callback);
    void getBrokerAccountInfo(BybitApiCallback<Object> callback);
    void getSubAccountsDeposits(BrokerDataRequest brokerDataRequest, BybitApiCallback<Object> callback);
}
