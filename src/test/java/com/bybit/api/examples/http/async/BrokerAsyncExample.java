package com.bybit.api.examples.http.async;

import com.bybit.api.client.domain.institution.BusinessType;
import com.bybit.api.client.domain.institution.InstitutionDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class BrokerAsyncExample {
    public static void main(String[] args) {
        // Borker API key
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        var client = factory.newAsyncInstitutionRestClient();

        // Get Broker Earning
        var brokerEarningRequest = InstitutionDataRequest.builder().bizType(BusinessType.SPOT).build();
        client.getBrokerEarningData(brokerEarningRequest, System.out::println);
    }
}
