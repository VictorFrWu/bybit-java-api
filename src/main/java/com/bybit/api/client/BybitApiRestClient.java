package com.bybit.api.client;

import com.bybit.api.client.domain.c2c.ClientLendingFundsRequest;
import com.bybit.api.client.domain.c2c.ClientLendingOrderRecordsRequest;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageOrdersRecordRequest;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageTokenRequest;
import com.bybit.api.client.domain.spot.marginTrade.*;

public interface BybitApiRestClient {
    // Spot Endpoints
    // Spot Leverage Token
    Object getSpotLeverageTokenInfo(String ltCoin);
    Object getSpotLeverageTokenInfo();
    Object getSpotLeverageTokenMarket(String ltCoin);
    Object getSpotLeverageTokenMarket();
    Object purchaseSpotLeverageToken(SpotLeverageTokenRequest spotLeverageTokenRequest);
    Object redeemSpotLeverageToken(SpotLeverageTokenRequest spotLeverageTokenRequest);
    Object getSpotLeverageRecords(SpotLeverageOrdersRecordRequest spotLeverageOrdersRecordRequest);

    // Spot Margin UTA
    Object getUtaVipSpotMarginTradeData(VIPMarginDataRequest utaMarginDataRequest);
    Object setUTASpotMarginTrade(String spotMarginMode);
    Object setUTASpotMarginTradeLeverage(String leverage);
    Object getUTASpotMarginTradeLeverageState();

    // Spot Margin Normal
    Object getNormalVipSpotMarginTradeData(VIPMarginDataRequest normalMarginDataRequest);
    Object getNormalSpotMarginTradeCoinInfo(String coin);
    Object getNormalSpotMarginTradeCoinInfo();
    Object getNormalSpotMarginTradeBorrowCoinInfo(String coin);
    Object getNormalSpotMarginTradeBorrowCoinInfo();
    Object getNormalSpotMarginTradeInterestQuota(String coin);
    Object getNormalSpotMarginTradeAccountInfo();
    Object getNormalSpotToggleMarginTrade(int switchStatus);
    Object loanNormalSpotMarginTrade(SpotMarginTradeBorrowRequest spotMarginTradeBorrowRequest);
    Object repayNormalSpotMarginTrade(SpotMarginTradeRePayRequest spotMarginTradeRePayRequest);
    Object getNormalSpotMarginTradeBorrowOrders(SpotMarginTradeBorrowOrdersRequest spotMarginTradeBorrowOrdersRequest);
    Object getNormalSpotMarginTradeRepayOrders(SpotMarginTradeRepayOrdersRequest spotMarginTradeRepayOrdersRequest);

    // C2C Endpoints
    Object getC2CLendingCoinInfo(String coin);
    Object getC2CLendingCoinInfo();
    Object C2cLendingDepositFunds(ClientLendingFundsRequest despoitFundRequest);
    Object C2cLendingRedeemFunds(ClientLendingFundsRequest despoitFundRequest);
    Object getC2cOrdersRecords(ClientLendingOrderRecordsRequest c2cOrdersRecordsRequest);
    Object getC2CLendingAccountInfo(String coin);
}
