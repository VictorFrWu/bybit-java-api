package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiAsyncSpotMarginRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.spot.SpotMarginDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

/**
 * Implementation of Bybit's REST API using Retrofit with synchronous/blocking
 * method calls.
 */
public class BybitApiAsyncSpotMarginRestClientImpl implements BybitApiAsyncSpotMarginRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncSpotMarginRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    // Spots
    // Spot Leverage endpoints
    @Override
    public void getSpotLeverageTokenInfo(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getSpotLeverageTokenInfo(spotMarginDataRequest.getLtCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpotLeverageTokenMarket(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getSpotLeverageTokenMarket(spotMarginDataRequest.getLtCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void purchaseSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        var spotLeverageTokenRequest = converter.mapToSpotLeverageTokenRequest(spotMarginDataRequest);
        bybitApiService.purchaseSpotLeverageToken(spotLeverageTokenRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void redeemSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        var spotLeverageTokenRequest = converter.mapToSpotLeverageTokenRequest(spotMarginDataRequest);
        bybitApiService.redeemSpotLeverageToken(spotLeverageTokenRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpotLeverageRecords(SpotMarginDataRequest spotLeverageOrdersRecordRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getSpotLeverageRecords(
                spotLeverageOrdersRecordRequest.getLtCoin(),
                spotLeverageOrdersRecordRequest.getOrderId(),
                spotLeverageOrdersRecordRequest.getStartTime(),
                spotLeverageOrdersRecordRequest.getEndTime(),
                spotLeverageOrdersRecordRequest.getLimit(),
                spotLeverageOrdersRecordRequest.getLtOrderType(),
                spotLeverageOrdersRecordRequest.getSerialNo())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    // Spot Margin UTA
    @Override
    public void getUtaVipSpotMarginTradeData(SpotMarginDataRequest utaMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getUtaVipSpotMarginTradeData(
                utaMarginDataRequest.getVipLevel() == null ? null : utaMarginDataRequest.getVipLevel().getLevel(),
                utaMarginDataRequest.getCurrency())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setUTASpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        String mode = spotMarginDataRequest.getSpotMarginMode() == null ? null : spotMarginDataRequest.getSpotMarginMode().getValue();
        bybitApiService.setUTASpotMarginTrade(mode).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setUTASpotMarginTradeLeverage(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        String leverage = spotMarginDataRequest.getLeverage();
        bybitApiService.setUTASpotMarginTradeLeverage(leverage).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getUTASpotMarginTradeLeverageState(BybitApiCallback<Object> callback) {
        bybitApiService.getUTASpotMarginTradeLeverageState().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    // Spot Margin Normal
    @Override
    @Deprecated
    public void getNormalVipSpotMarginTradeData(SpotMarginDataRequest normalMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalVipSpotMarginTradeData(
                normalMarginDataRequest.getVipLevel() == null ? null : normalMarginDataRequest.getVipLevel().getLevel(),
                normalMarginDataRequest.getCurrency())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Deprecated
    @Override
    public void getNormalSpotMarginTradeCoinInfo(SpotMarginDataRequest normalMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalSpotMarginTradeCoinInfo(normalMarginDataRequest.getCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void getNormalSpotMarginTradeBorrowCoinInfo(SpotMarginDataRequest normalMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalSpotMarginTradeBorrowCoinInfo(normalMarginDataRequest.getCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void getNormalSpotMarginTradeInterestQuota(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalSpotMarginTradeInterestQuota(spotMarginDataRequest.getCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void getNormalSpotMarginTradeAccountInfo(BybitApiCallback<Object> callback) {
        bybitApiService.getNormalSpotMarginTradeAccountInfo().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void setNormalSpotToggleMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        int switchStatus = spotMarginDataRequest.getSwitchStatus() == null ? 0 : spotMarginDataRequest.getSwitchStatus().getValue();
        bybitApiService.setNormalSpotToggleMarginTrade(switchStatus).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void loanNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        var spotMarginTradeBorrowRequest = converter.mapToSpotMarginBorrowRequest(spotMarginDataRequest);
        bybitApiService.loanNormalSpotMarginTrade(spotMarginTradeBorrowRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void repayNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        var spotMarginTradeRePayRequest = converter.mapToSpotMarginRepayRequest(spotMarginDataRequest);
        bybitApiService.repayNormalSpotMarginTrade(spotMarginTradeRePayRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void getNormalSpotMarginTradeBorrowOrders(SpotMarginDataRequest spotMarginTradeBorrowOrdersRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalMarginTradeBorrowOrders(
                spotMarginTradeBorrowOrdersRequest.getStartTime(),
                spotMarginTradeBorrowOrdersRequest.getEndTime(),
                spotMarginTradeBorrowOrdersRequest.getCoin(),
                spotMarginTradeBorrowOrdersRequest.getBorrowStatus() == null ? 0 : spotMarginTradeBorrowOrdersRequest.getBorrowStatus().getValue(),
                spotMarginTradeBorrowOrdersRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void getNormalSpotMarginTradeRepayOrders(SpotMarginDataRequest spotMarginTradeRepayOrdersRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalMarginTradeRepayOrders(
                spotMarginTradeRepayOrdersRequest.getStartTime(),
                spotMarginTradeRepayOrdersRequest.getEndTime(),
                spotMarginTradeRepayOrdersRequest.getCoin(),
                spotMarginTradeRepayOrdersRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
