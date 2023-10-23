package com.bybit.api.client;

import com.bybit.api.client.domain.account.AccountDataRequest;
import com.bybit.api.client.domain.asset.AssetDataRequest;
import com.bybit.api.client.domain.broker.request.BrokerEarningRequest;
import com.bybit.api.client.domain.c2c.ClientLendingFundsRequest;
import com.bybit.api.client.domain.c2c.ClientLendingOrderRecordsRequest;
import com.bybit.api.client.domain.market.MarketDataRequest;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageOrdersRecordRequest;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageTokenRequest;
import com.bybit.api.client.domain.spot.marginTrade.*;
import com.bybit.api.client.domain.user.UserDataRequest;

public interface BybitApiRestClient {
    // User Data
    Object createSubMember(UserDataRequest subUserRequest);
    Object createSubAPI(UserDataRequest createApiKeyRequest);
    Object getSubUIDList();
    Object freezeSubMember(UserDataRequest freezeSubUIDRequest);
    Object getCurrentAPIKeyInfo();
    Object getUIDWalletType(UserDataRequest userDataRequest);
    Object modifyMasterApiKey(UserDataRequest userDataRequest);
    Object modifySubApiKey(UserDataRequest userDataRequest);
    Object deleteMasterApiKey();
    Object deleteSubApiKey(UserDataRequest userDataRequest);
    Object getAffiliateUserInfo(UserDataRequest userDataRequest);

    // Pre Upgrade
    Object getPreUpgradeOrderHistory(PreUpgradeDataRequest preupgradeOderHistoryRequest);
    Object getPreUpgradeTradeHistory(PreUpgradeDataRequest preUpgradeTradeHistoryRequest);
    Object getPreUpgradeClosePnl(PreUpgradeDataRequest preUpgradeClosePnlRequest);
    Object getPreUpgradeTransaction(PreUpgradeDataRequest preUpgradeTransactionRequest);
    Object getPreUpgradeOptionDelivery(PreUpgradeDataRequest preUpgradeOptionDeliveryRequest);
    Object getPreUpgradeUsdcSettlement(PreUpgradeDataRequest preUpgradeUsdcSettlementRequest);

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

    // Broker endpoints
    Object getBrokerEarningData(BrokerEarningRequest brokerEarningRequest);

    // C2C Endpoints
    Object getC2CLendingCoinInfo(String coin);
    Object getC2CLendingCoinInfo();
    Object C2cLendingDepositFunds(ClientLendingFundsRequest despoitFundRequest);
    Object C2cLendingRedeemFunds(ClientLendingFundsRequest despoitFundRequest);
    Object getC2cOrdersRecords(ClientLendingOrderRecordsRequest c2cOrdersRecordsRequest);
    Object getC2CLendingAccountInfo(String coin);
}
