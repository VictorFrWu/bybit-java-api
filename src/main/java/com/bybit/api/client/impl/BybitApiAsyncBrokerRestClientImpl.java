package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiAsyncBrokerRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.broker.BrokerDataRequest;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncBrokerRestClientImpl implements BybitApiAsyncBrokerRestClient {
    private final BybitApiService bybitApiService;
    public BybitApiAsyncBrokerRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
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

    @Override
    public void getBrokerAccountInfo(BybitApiCallback<Object> callback) {
        bybitApiService.getBrokerAccountInfo().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSubAccountsDeposits(BrokerDataRequest brokerDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getBrokerSubDeposits(
                brokerDataRequest.getSubMemberId(),
                brokerDataRequest.getCoin(),
                brokerDataRequest.getStartTime(),
                brokerDataRequest.getEndTime(),
                brokerDataRequest.getLimit(),
                brokerDataRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
