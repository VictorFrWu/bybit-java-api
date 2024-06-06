package com.bybit.api.examples.http.async;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.broker.BrokerDataRequest;
import com.bybit.api.client.domain.broker.BusinessType;
import com.bybit.api.client.service.BybitApiClientFactory;

public class BrokerAsyncExample {
    public static void main(String[] args) {
        // Borker API key
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newAsyncBrokerRestClient();

        // Get Broker Earning
        var brokerEarningRequest = BrokerDataRequest.builder().bizType(BusinessType.SPOT).build();
        client.getBrokerEarningData(brokerEarningRequest, System.out::println);

        // Get Broker Earning
        client.getBrokerAccountInfo(System.out::println);

        // Get Broker Sub Deposits
        var brokerDepositsRequest = BrokerDataRequest.builder().build();
        client.getSubAccountsDeposits(brokerDepositsRequest, System.out::println);
    }
}
