package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.broker.BrokerDataRequest;
import com.bybit.api.client.domain.broker.BusinessType;
import com.bybit.api.client.service.BybitApiClientFactory;

public class BrokerExample {
    public static void main(String[] args) {
        // Borker API key
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET").newBrokerRestClient();

        // Get Broker Earning
        var brokerEarningRequest = BrokerDataRequest.builder().bizType(BusinessType.SPOT).build();
        var brokerEarningData = client.getBrokerEarningData(brokerEarningRequest);
        System.out.println(brokerEarningData);
    }
}
