package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.broker.BusinessType;
import com.bybit.api.client.domain.broker.request.BrokerEarningRequest;
import com.bybit.api.client.impl.BybitApiClientFactory;
import com.bybit.api.client.BybitApiRestClient;

public class BrokerExample {
    public static void main(String[] args) {
        // Borker API key
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("VUEODVICUIVUXIJJKO", "TWZAESUUJGROUJTAMRKLDDMHLPOXUHUEDBFZ");
        BybitApiRestClient client = factory.newRestClient();

        // Get Broker Earning
        var brokerEarningRequest = new BrokerEarningRequest.Builder().bizType(BusinessType.SPOT).build();
        var brokerEarningData = client.getBrokerEarningData(brokerEarningRequest);
        System.out.println(brokerEarningData);
    }
}
