package com.bybit.api.client;

import com.bybit.api.client.domain.institution.LendingDataRequest;
import com.bybit.api.client.domain.institution.clientLending.ClientLendingFundsRequest;
import com.bybit.api.client.domain.institution.clientLending.ClientLendingOrderRecordsRequest;

public interface BybitApiLendingRestClient {
    // Institution Endpoints
    Object getInsProductInfo(LendingDataRequest lendingDataRequest);
    Object getInsMarginCoinInfo(LendingDataRequest lendingDataRequest);
    Object getInsLoanOrders(LendingDataRequest institutionLoanOrdersRequest);
    Object getInsRepayOrders(LendingDataRequest institutionRepayOrdersRequest);
    Object getInsLoanToValue();

    // C2C Endpoints
    Object getC2CLendingCoinInfo(LendingDataRequest lendingDataRequest);
    Object C2cLendingDepositFunds(LendingDataRequest lendingDataRequest);
    Object C2cLendingRedeemFunds(LendingDataRequest lendingDataRequest);
    Object C2cLendingRedeemCancel(LendingDataRequest lendingDataRequest);
    Object getC2cOrdersRecords(LendingDataRequest lendingDataRequest);
    Object getC2CLendingAccountInfo(LendingDataRequest lendingDataRequest);
}
