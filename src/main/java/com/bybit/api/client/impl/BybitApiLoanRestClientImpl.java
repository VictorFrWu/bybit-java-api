package com.bybit.api.client.impl;

import com.bybit.api.client.domain.loan.request.CryptoLoanAdjustLtvRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanBorrowRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanDataRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanRepayRequest;
import com.bybit.api.client.restApi.BybitApiLoanRestClient;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.service.BybitJsonConverter;
import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiLoanRestClientImpl implements BybitApiLoanRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiLoanRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    @Override
    public Object getCollateralCoins(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getCollateralCoins(
                request.getVipLevel() == null ? null : request.getVipLevel().getLevel(),
                request.getCurrency()
        ));
    }

    @Override
    public Object getBorrowableCoins(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getBorrowableCoins(
                request.getVipLevel() == null ? null : request.getVipLevel().getLevel(),
                request.getCurrency()
        ));
    }

    @Override
    public Object getAcctMortgageLoanLimit(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getAcctMortgageLoanLimit(
                request.getLoanCurrency(),
                request.getCollateralCurrency()
        ));
    }

    @Override
    public Object borrow(CryptoLoanBorrowRequest borrowRequest) {
        var request = converter.mapToCryptoLoanBorrowRequest(borrowRequest);
        return executeSync(bybitApiService.borrow(request));
    }

    @Override
    public Object repay(CryptoLoanRepayRequest repayRequest) {
        var request = converter.mapToCryptoLoanRepayRequest(repayRequest);
        return executeSync(bybitApiService.repay(request));
    }

    @Override
    public Object adjustCollateralAmount(CryptoLoanAdjustLtvRequest adjustLtvRequest) {
        var request = converter.mapToCryptoLoanAdjustLtvRequest(adjustLtvRequest);
        return executeSync(bybitApiService.adjustCollateralAmount(request));
    }

    @Override
    public Object getUnpaidOrders(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getUnpaidOrders(
                request.getOrderId(),
                request.getLoanCurrency(),
                request.getCollateralCurrency(),
                request.getLoanTermType() == null ? null : request.getLoanTermType().getTermType(),
                request.getLoanTerm() == null ? null : request.getLoanTerm().getTerm(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getCompletedOrders(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getCompletedOrders(
                request.getOrderId(),
                request.getCollateralCurrency(),
                request.getLoanCurrency(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getRepayTransactions(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getRepayTransactions(
                request.getOrderId(),
                request.getRepayId(),
                request.getLoanCurrency(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getLtvAdjustmentHistory(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getLtvAdjustmentHistory(
                request.getOrderId(),
                request.getAdjustId(),
                request.getCollateralCurrency(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getMaxReduceAmount(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getMaxReduceAmount(
                request.getOrderId()
        ));
    }
}
