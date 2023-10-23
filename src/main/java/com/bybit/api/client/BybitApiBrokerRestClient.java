package com.bybit.api.client;

import com.bybit.api.client.domain.broker.BrokerDataRequest;

public interface BybitApiBrokerRestClient {
    // Broker endpoints
    Object getBrokerEarningData(BrokerDataRequest brokerEarningRequest);
}
