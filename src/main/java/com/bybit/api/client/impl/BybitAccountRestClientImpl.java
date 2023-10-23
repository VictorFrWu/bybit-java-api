package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiAccountRestClient;
import com.bybit.api.client.BybitApiPositionRestClient;
import com.bybit.api.client.BybitApiService;
import com.bybit.api.client.domain.account.AccountDataRequest;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitAccountRestClientImpl implements BybitApiAccountRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitAccountRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }
    // Account endpoints
    @Override
    public Object getWalletBalance(AccountDataRequest walletBalanceRequest) {
        return executeSync(bybitApiService.getWalletBalance(
                walletBalanceRequest.getAccountType().getAccountTypeValue(),
                walletBalanceRequest.getCoins()
        ));
    }

    @Override
    public Object upgradeAccountToUTA() {
        return executeSync(bybitApiService.upgradeAccountToUTA());
    }

    @Override
    public Object getAccountBorrowHistory(AccountDataRequest borrowHistoryRequest) {
        return executeSync(bybitApiService.getAccountBorrowHistory(
                borrowHistoryRequest.getCurrency(),
                borrowHistoryRequest.getStartTime(),
                borrowHistoryRequest.getEndTime(),
                borrowHistoryRequest.getLimit(),
                borrowHistoryRequest.getCursor()
        ));
    }

    @Override
    public Object setAccountCollateralCoin(AccountDataRequest setCollateralCoinRequest) {
        var request = converter.mapToSetCollateralCoinRequest(setCollateralCoinRequest);
        return executeSync(bybitApiService.setAccountCollateralCoin(request));
    }

    @Override
    public Object getAccountCollateralInfo(AccountDataRequest request) {
        return executeSync((bybitApiService.getAccountCollateralInfo(
                request.getCurrency()
        )));
    }

    @Override
    public Object getAccountCoinGeeks(AccountDataRequest request) {
        return executeSync((bybitApiService.getAccountCoinGeeks(request.getBaseCoin())));
    }

    @Override
    public Object getAccountFreeRate(AccountDataRequest getFeeRateRequest) {
        return executeSync(bybitApiService.getAccountFreeRate(
                getFeeRateRequest.getCategory().getProductTypeId(),
                getFeeRateRequest.getSymbol(),
                getFeeRateRequest.getBaseCoin()
        ));
    }


    @Override
    public Object getAccountInfo() {
        return executeSync(bybitApiService.getAccountInfo());
    }

    @Override
    public Object getTransactionLog(AccountDataRequest getTransactionLogRequest) {
        return executeSync(bybitApiService.getTransactionLog(
                getTransactionLogRequest.getAccountType() == null ? null : getTransactionLogRequest.getAccountType().getAccountTypeValue(),
                getTransactionLogRequest.getCategory() == null ? null : getTransactionLogRequest.getCategory().getProductTypeId(),
                getTransactionLogRequest.getCurrency(),
                getTransactionLogRequest.getBaseCoin(),
                getTransactionLogRequest.getTransactionType() == null ? null : getTransactionLogRequest.getTransactionType().getTransactionTypeId(),
                getTransactionLogRequest.getStartTime(),
                getTransactionLogRequest.getEndTime(),
                getTransactionLogRequest.getLimit(),
                getTransactionLogRequest.getCursor()
        ));
    }


    @Override
    public Object setAccountMarginMode(AccountDataRequest setMarginMode) {
        var request = converter.mapToSetMarginModeRequest(setMarginMode);
        return executeSync(bybitApiService.setAccountMarginMode(request));
    }

    @Override
    public Object modifyAccountMMP(AccountDataRequest setMMPRequest) {
        var request = converter.mapToSetMMPRequest(setMMPRequest);
        return executeSync(bybitApiService.modifyAccountMMP(request));
    }

    @Override
    public Object resetAccountMMP(AccountDataRequest request) {
        var resetMMPRequest = converter.mapToResetMarginModeRequest(request);
        return executeSync(bybitApiService.resetAccountMMP(resetMMPRequest));
    }

    @Override
    public Object getAccountMMPState(AccountDataRequest request) {
        return executeSync(bybitApiService.getAccountMMPState(request.getBaseCoin()));
    }
}
