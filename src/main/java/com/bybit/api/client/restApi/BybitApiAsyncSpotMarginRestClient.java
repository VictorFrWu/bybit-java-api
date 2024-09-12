package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.spot.SpotMarginDataRequest;

public interface BybitApiAsyncSpotMarginRestClient {
    // Spot Endpoints
    // Spot Leverage Token
    void getSpotLeverageTokenInfo(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getSpotLeverageTokenMarket(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void purchaseSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void redeemSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getSpotLeverageRecords(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    // Spot Margin UTA
    void getUtaVipSpotMarginTradeData(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void setUTASpotMarginTrade(String mode, BybitApiCallback<Object> callback);

    void setUTASpotMarginTradeLeverage(String leverage, BybitApiCallback<Object> callback);

    void getUTASpotMarginTradeLeverageState(BybitApiCallback<Object> callback);

    // Spot Margin Normal
    void getNormalVipSpotMarginTradeData(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getNormalSpotMarginTradeCoinInfo(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getNormalSpotMarginTradeBorrowCoinInfo(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getNormalSpotMarginTradeInterestQuota(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getNormalSpotMarginTradeAccountInfo(BybitApiCallback<Object> callback);

    void setNormalSpotToggleMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void loanNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void repayNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getNormalSpotMarginTradeBorrowOrders(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getNormalSpotMarginTradeRepayOrders(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);
}
