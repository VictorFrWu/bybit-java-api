package com.bybit.api.client.impl;

import com.bybit.api.client.domain.loan.request.CryptoLoanAdjustLtvRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanBorrowRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanDataRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanRepayRequest;
import com.bybit.api.client.restApi.BybitApiAsyncLoanRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiLoanRestClient;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiAsyncLoanRestClientImpl implements BybitApiAsyncLoanRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncLoanRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    @Override
    public void getCollateralCoins(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getCollateralCoins(
                request.getVipLevel() == null ? null : request.getVipLevel().getLevel(),
                request.getCurrency()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getBorrowableCoins(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getBorrowableCoins(
                request.getVipLevel() == null ? null : request.getVipLevel().getLevel(),
                request.getCurrency()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAcctMortgageLoanLimit(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAcctMortgageLoanLimit(
                request.getLoanCurrency(),
                request.getCollateralCurrency()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void borrow(CryptoLoanBorrowRequest borrowRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToCryptoLoanBorrowRequest(borrowRequest);
        bybitApiService.borrow(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void repay(CryptoLoanRepayRequest repayRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToCryptoLoanRepayRequest(repayRequest);
        bybitApiService.repay(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void adjustCollateralAmount(CryptoLoanAdjustLtvRequest adjustLtvRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToCryptoLoanAdjustLtvRequest(adjustLtvRequest);
        bybitApiService.adjustCollateralAmount(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getUnpaidOrders(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getUnpaidOrders(
                request.getOrderId(),
                request.getCollateralCurrency(),
                request.getLoanCurrency(),
                request.getLoanTermType() == null ? null : request.getLoanTermType().getTermType(),
                request.getLoanTerm() == null ? null : request.getLoanTerm().getTerm(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCompletedOrders(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getCompletedOrders(
                request.getOrderId(),
                request.getCollateralCurrency(),
                request.getLoanCurrency(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getRepayTransactions(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getRepayTransactions(
                request.getOrderId(),
                request.getRepayId(),
                request.getLoanCurrency(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLtvAdjustmentHistory(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getLtvAdjustmentHistory(
                request.getOrderId(),
                request.getAdjustId(),
                request.getCollateralCurrency(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMaxReduceAmount(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getMaxReduceAmount(
                request.getOrderId()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
