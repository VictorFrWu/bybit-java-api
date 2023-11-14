package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiBrokerRestClient;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.broker.BrokerDataRequest;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApBrokerRestClientImpl implements BybitApiBrokerRestClient {
    private final BybitApiService bybitApiService;

    public BybitApBrokerRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode);
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
