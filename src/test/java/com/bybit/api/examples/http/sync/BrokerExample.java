package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.broker.WithUsedAmount;
import com.bybit.api.client.domain.broker.request.BrokerDataRequest;
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

        // Get Broker Account Info
        var brokerAccountInfo = client.getBrokerAccountInfo();
        System.out.println(brokerAccountInfo);

        // Get Broker Sub Deposits
        var brokerDepositsRecords = client.getSubAccountsDeposits();
        System.out.println(brokerDepositsRecords);

        // Query Voucher Spec
        var brokerVoucherRequest = BrokerDataRequest.builder().id("80209").build();
        var voucherSpec = client.getVoucherSpec(brokerVoucherRequest);
        System.out.println(voucherSpec);

        // Issue voucher
        var brokerIssueVoucherRequest = BrokerDataRequest.builder().accountId("2846381").awardId("123456").specCode("award-001").amount("100").brokerId("v-28478").build();
        var issueVoucher = client.issueVoucher(brokerIssueVoucherRequest);
        System.out.println(issueVoucher);

        // Query Issued Voucher
        var brokerQueryVoucherRequest = BrokerDataRequest.builder().accountId("5714139").awardId("189528").specCode("demo000").withUsedAmount(WithUsedAmount.NOT_QUERY).build();
        var queryIssuedVoucher = client.getIssuedVoucher(brokerQueryVoucherRequest);
        System.out.println(queryIssuedVoucher);
    }
}
