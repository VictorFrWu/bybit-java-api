package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.broker.request.BrokerDataRequest;

public interface BybitApiBrokerRestClient {
    // Broker endpoints
    Object getBrokerEarningData(BrokerDataRequest brokerDataRequest);
    Object getBrokerAccountInfo();
    Object getSubAccountsDeposits(BrokerDataRequest brokerDataRequest);
    Object getSubAccountsDeposits();
    Object getVoucherSpec(BrokerDataRequest brokerDataRequest);
    Object issueVoucher(BrokerDataRequest brokerDataRequest);
    Object getIssuedVoucher(BrokerDataRequest brokerDataRequest);
}
