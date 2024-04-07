package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiBrokerRestClient;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.broker.BrokerDataRequest;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApBrokerRestClientImpl implements BybitApiBrokerRestClient {
    private final BybitApiService bybitApiService;

    public BybitApBrokerRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }
    // Broker
    @Override
    public Object getBrokerEarningData(BrokerDataRequest brokerDataRequest) {
        return executeSync(bybitApiService.getBrokerEarningData(
                brokerDataRequest.getBizType() == null ? null : brokerDataRequest.getBizType().getType(),
                brokerDataRequest.getStartTime(),
                brokerDataRequest.getEndTime(),
                brokerDataRequest.getLimit(),
                brokerDataRequest.getCursor()
        ));
    }

    @Override
    public Object getBrokerAccountInfo() {
        return executeSync(bybitApiService.getBrokerAccountInfo());
    }
}
