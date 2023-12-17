package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.broker.BrokerDataRequest;

public interface BybitApiBrokerRestClient {
    // Broker endpoints
    Object getBrokerEarningData(BrokerDataRequest brokerDataRequest);
    Object getBrokerAccountInfo();
}
