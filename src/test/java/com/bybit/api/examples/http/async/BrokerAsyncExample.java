package com.bybit.api.examples.http.async;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.broker.WithUsedAmount;
import com.bybit.api.client.domain.broker.request.BrokerDataRequest;
import com.bybit.api.client.domain.broker.BusinessType;
import com.bybit.api.client.service.BybitApiClientFactory;

public class BrokerAsyncExample {
    public static void main(String[] args) {
        // Borker API key
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET").newAsyncBrokerRestClient();

        // Get Broker Earning
        var brokerEarningRequest = BrokerDataRequest.builder().bizType(BusinessType.SPOT).build();
        client.getBrokerEarningData(brokerEarningRequest, System.out::println);

        // Get Broker Account Info
        client.getBrokerAccountInfo(System.out::println);

        // Get Broker Sub Deposits
        var brokerDepositsRequest = BrokerDataRequest.builder().build();
        client.getSubAccountsDeposits(brokerDepositsRequest, System.out::println);

        // Query Voucher Spec
        var brokerVoucherRequest = BrokerDataRequest.builder().id("80209").build();
        client.getVoucherSpec(brokerVoucherRequest, System.out::println);

        // Issue voucher
        var brokerIssueVoucherRequest = BrokerDataRequest.builder().accountId("2846381").awardId("123456").specCode("award-001").amount("100").brokerId("v-28478").build();
        client.issueVoucher(brokerIssueVoucherRequest, System.out::println);

        // Query Issued Voucher
        var brokerQueryVoucherRequest = BrokerDataRequest.builder().accountId("5714139").awardId("189528").specCode("demo000").withUsedAmount(WithUsedAmount.NOT_QUERY).build();
        client.getIssuedVoucher(brokerQueryVoucherRequest, System.out::println);
    }
}
