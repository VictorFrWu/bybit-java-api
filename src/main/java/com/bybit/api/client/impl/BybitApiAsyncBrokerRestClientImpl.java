package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiAsyncBrokerRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.broker.BrokerDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncBrokerRestClientImpl implements BybitApiAsyncBrokerRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncBrokerRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class);
    }

    @Override
    public void getBrokerEarningData(BrokerDataRequest brokerEarningRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getBrokerEarningData(
                brokerEarningRequest.getBizType() == null ? null : brokerEarningRequest.getBizType().getType(),
                brokerEarningRequest.getStartTime(),
                brokerEarningRequest.getEndTime(),
                brokerEarningRequest.getLimit(),
                brokerEarningRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
