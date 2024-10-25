package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.loan.request.CryptoLoanAdjustLtvRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanBorrowRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanDataRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanRepayRequest;

public interface BybitApiAsyncLoanRestClient {
    void getCollateralCoins(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getBorrowableCoins(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getAcctMortgageLoanLimit(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void borrow(CryptoLoanBorrowRequest request, BybitApiCallback<Object> callback);
    void repay(CryptoLoanRepayRequest request, BybitApiCallback<Object> callback);
    void adjustCollateralAmount(CryptoLoanAdjustLtvRequest request, BybitApiCallback<Object> callback);
    void getUnpaidOrders(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getCompletedOrders(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getRepayTransactions(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getLtvAdjustmentHistory(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getMaxReduceAmount(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
}
