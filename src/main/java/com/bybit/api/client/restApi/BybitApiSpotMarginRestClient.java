package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.spot.SpotMarginDataRequest;

public interface BybitApiSpotMarginRestClient {
    // Spot Endpoints
    // Spot Leverage Token
    Object getSpotLeverageTokenInfo(SpotMarginDataRequest spotMarginDataRequest);
    Object getSpotLeverageTokenMarket(SpotMarginDataRequest spotMarginDataRequest);
    Object purchaseSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest);
    Object redeemSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest);
    Object getSpotLeverageRecords(SpotMarginDataRequest spotMarginDataRequest);

    // Spot Margin UTA
    Object getUtaVipSpotMarginTradeData(SpotMarginDataRequest spotMarginDataRequest);
    Object setUTASpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest);
    Object setUTASpotMarginTradeLeverage(SpotMarginDataRequest spotMarginDataRequest);
    Object getUTASpotMarginTradeLeverageState();

    // Spot Margin Normal
    Object getNormalVipSpotMarginTradeData(SpotMarginDataRequest spotMarginDataRequest);
    Object getNormalSpotMarginTradeCoinInfo(SpotMarginDataRequest spotMarginDataRequest);
    Object getNormalSpotMarginTradeBorrowCoinInfo(SpotMarginDataRequest spotMarginDataRequest);
    Object getNormalSpotMarginTradeInterestQuota(SpotMarginDataRequest spotMarginDataRequest);
    Object getNormalSpotMarginTradeAccountInfo();
    Object setNormalSpotToggleMarginTrade(SpotMarginDataRequest spotMarginDataRequest);
    Object loanNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest);
    Object repayNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest);
    Object getNormalSpotMarginTradeBorrowOrders(SpotMarginDataRequest spotMarginDataRequest);
    Object getNormalSpotMarginTradeRepayOrders(SpotMarginDataRequest spotMarginDataRequest);
}
