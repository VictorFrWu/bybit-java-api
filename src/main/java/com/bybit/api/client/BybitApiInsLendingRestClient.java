package com.bybit.api.client;

import com.bybit.api.client.domain.institution.InstitutionLoanOrdersRequest;
import com.bybit.api.client.domain.institution.InstitutionRepayOrdersRequest;

public interface BybitApiInsLendingRestClient {
    // Institution Endpoints
    Object getInsProductInfo(String productId);

    Object getInsProductInfo();

    Object getInsMarginCoinInfo(String productId);

    Object getInsMarginCoinInfo();

    Object getInsLoanOrders(InstitutionLoanOrdersRequest institutionLoanOrdersRequest);

    Object getInsRepayOrders(InstitutionRepayOrdersRequest institutionRepayOrdersRequest);

    /**
     * Get LTV
     *
     * @return
     */
    Object getInsLoanToValue();
}
