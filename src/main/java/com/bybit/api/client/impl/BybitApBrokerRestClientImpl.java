package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiBrokerRestClient;
import com.bybit.api.client.BybitApiService;
import com.bybit.api.client.domain.broker.BrokerDataRequest;
import com.bybit.api.client.domain.institution.LendingDataRequest;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApBrokerRestClientImpl implements BybitApiBrokerRestClient {
    private final BybitApiService bybitApiService;

    public BybitApBrokerRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }
    // Broker
    @Override
    public Object getBrokerEarningData(BrokerDataRequest brokerEarningRequest) {
        return executeSync(bybitApiService.getBrokerEarningData(
                brokerEarningRequest.getBizType() == null ? null : brokerEarningRequest.getBizType().getType(),
                brokerEarningRequest.getStartTime(),
                brokerEarningRequest.getEndTime(),
                brokerEarningRequest.getLimit(),
                brokerEarningRequest.getCursor()
        ));
    }
}
