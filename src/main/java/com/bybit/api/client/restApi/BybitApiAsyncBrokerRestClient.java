package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.broker.BrokerDataRequest;

public interface BybitApiAsyncBrokerRestClient {
    // Broker endpoints
    void getBrokerEarningData(BrokerDataRequest brokerEarningRequest, BybitApiCallback<Object> callback);
}
