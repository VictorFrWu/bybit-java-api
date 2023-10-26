package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiAsyncAccountRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.account.AccountDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncAccountRestClientImpl implements BybitApiAsyncAccountRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();
    public BybitApiAsyncAccountRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }

    // Account Endpoints
    @Override
    public void getWalletBalance(AccountDataRequest walletBalanceRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getWalletBalance(
                walletBalanceRequest.getAccountType().getAccountTypeValue(),
                walletBalanceRequest.getCoins()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void upgradeAccountToUTA(BybitApiCallback<Object> callback) {
        bybitApiService.upgradeAccountToUTA().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountBorrowHistory(AccountDataRequest borrowHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountBorrowHistory(
                borrowHistoryRequest.getCurrency(),
                borrowHistoryRequest.getStartTime(),
                borrowHistoryRequest.getEndTime(),
                borrowHistoryRequest.getLimit(),
                borrowHistoryRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setAccountCollateralCoin(AccountDataRequest setCollateralCoinRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToSetCollateralCoinRequest(setCollateralCoinRequest);
        bybitApiService.setAccountCollateralCoin(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountCollateralInfo(AccountDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountCollateralInfo(
                request.getCurrency()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountCoinGeeks(AccountDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountCoinGeeks(request.getBaseCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountFreeRate(AccountDataRequest getFeeRateRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountFreeRate(
                getFeeRateRequest.getCategory().getProductTypeId(),
                getFeeRateRequest.getSymbol(),
                getFeeRateRequest.getBaseCoin()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountInfo(BybitApiCallback<Object> callback) {
        bybitApiService.getAccountInfo().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTransactionLog(AccountDataRequest getTransactionLogRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getTransactionLog(
                getTransactionLogRequest.getAccountType() == null ? null : getTransactionLogRequest.getAccountType().getAccountTypeValue(),
                getTransactionLogRequest.getCategory() == null ? null : getTransactionLogRequest.getCategory().getProductTypeId(),
                getTransactionLogRequest.getCurrency(),
                getTransactionLogRequest.getBaseCoin(),
                getTransactionLogRequest.getTransactionType() == null ? null : getTransactionLogRequest.getTransactionType().getTransactionTypeId(),
                getTransactionLogRequest.getStartTime(),
                getTransactionLogRequest.getEndTime(),
                getTransactionLogRequest.getLimit(),
                getTransactionLogRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setAccountMarginMode(AccountDataRequest request, BybitApiCallback<Object> callback) {
        var setMarginMode = converter.mapToSetMarginModeRequest(request);
        bybitApiService.setAccountMarginMode(setMarginMode).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void modifyAccountMMP(AccountDataRequest setMMPRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToSetMMPRequest(setMMPRequest);
        bybitApiService.modifyAccountMMP(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void resetAccountMMP(AccountDataRequest request, BybitApiCallback<Object> callback) {
        var resetMMPRequest = converter.mapToResetMarginModeRequest(request);
        bybitApiService.resetAccountMMP(resetMMPRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountMMPState(AccountDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountMMPState(request.getBaseCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
