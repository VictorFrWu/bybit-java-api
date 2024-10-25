package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.loan.request.CryptoLoanAdjustLtvRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanBorrowRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanDataRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanRepayRequest;

public interface BybitApiLoanRestClient {
    Object getCollateralCoins(CryptoLoanDataRequest request);
    Object getBorrowableCoins(CryptoLoanDataRequest request);
    Object getAcctMortgageLoanLimit(CryptoLoanDataRequest request);
    Object borrow(CryptoLoanBorrowRequest borrowRequest);
    Object repay(CryptoLoanRepayRequest repayRequest);
    Object adjustCollateralAmount(CryptoLoanAdjustLtvRequest adjustLtvRequest);
    Object getUnpaidOrders(CryptoLoanDataRequest request);
    Object getCompletedOrders(CryptoLoanDataRequest request);
    Object getRepayTransactions(CryptoLoanDataRequest request);
    Object getLtvAdjustmentHistory(CryptoLoanDataRequest request);
    Object getMaxReduceAmount(CryptoLoanDataRequest request);
}
