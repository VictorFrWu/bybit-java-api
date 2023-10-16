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
    // Market Data
    Object getServerTime();
    Object getMarketLinesData(MarketDataRequest marketKlineRequest);
    Object getMarketPriceLinesData(MarketDataRequest marketKlineRequest);
    Object getIndexPriceLinesData(MarketDataRequest marketKlineRequest);
    Object getPremiumIndexPriceLinesData(MarketDataRequest marketKlineRequest);
    Object getInstrumentsInfo(MarketDataRequest instrumentInfoRequest);
    Object getMarketOrderBook(MarketDataRequest marketOrderBookRequest);
    Object getMarketTickers(MarketDataRequest marketDataTickerRequest);
    Object getFundingHistory(MarketDataRequest fundingHistoryRequest);
    Object getRecentTradeData(MarketDataRequest recentTradeRequest);
    Object getOpenInterest(MarketDataRequest openInterestRequest);
    Object getHistoricalVolatility(MarketDataRequest HistoricalVolatilityRequest);
    Object getInsurance(String coin);
    Object getInsurance();
    Object getRiskLimit(MarketDataRequest marketRiskLimitRequest);
    Object getDeliveryPrice(MarketDataRequest deliveryPriceRequest);
    Object getMarketAccountRatio(MarketDataRequest marketAccountRatioRequest);

    // Position Data
    Object getPositionInfo(PositionDataRequest positionListRequest);
    Object setPositionLeverage(PositionDataRequest setLeverageRequest);
    Object swithMarginRequest(PositionDataRequest switchMarginRequest);
    Object switchPositionMode(PositionDataRequest switchPositionModeRequest);
    Object setTpslMode(PositionDataRequest setTpSlModeRequest);
    Object setRiskLimit(PositionDataRequest setRiskLimitRequest);
    Object setTradingStop(PositionDataRequest tradingStopRequest);
    Object setAutoAddMargin(PositionDataRequest setAutoAddMarginRequest);
    Object modifyPositionMargin(PositionDataRequest modifyMarginRequest);
    Object getExecutionList(PositionDataRequest executionHistoryRequest);
    Object getClosePnlList(PositionDataRequest closePnlHistoryRequest);

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

    // Account endpoints
    Object getWalletBalance(AccountDataRequest walletBalanceRequest);
    Object upgradeAccountToUTA();
    Object getAccountBorrowHistory(AccountDataRequest borrowHistoryRequest);
    Object setAccountCollateralCoin(AccountDataRequest setCollateralCoinRequest);
    Object getAccountCollateralInfo(AccountDataRequest request);
    Object getAccountCoinGeeks(AccountDataRequest request);
    Object getAccountFreeRate(AccountDataRequest getFeeRateRequest);
    Object getAccountInfo();
    Object getTransactionLog(AccountDataRequest getTransactionLogRequest);
    Object setAccountMarginMode(AccountDataRequest request);
    Object modifyAccountMMP(AccountDataRequest setMMPRequest);
    Object resetAccountMMP(AccountDataRequest request);
    Object getAccountMMPState(AccountDataRequest request);

    // Asset Endpoints
    Object getAssetCoinExchangeRecords(AssetDataRequest coinExchangeRecordsRequest);
    Object getAssetDeliveryRecords(AssetDataRequest deliveryRecordsRequest);
    Object getAssetUSDCSettlementRecords(AssetDataRequest usdcSettlementRequest);
    Object getAssetInfo(AssetDataRequest assetInfoRequest);
    Object getAssetAllCoinsBalance(AssetDataRequest allCoinsBalanceRequest);
    Object getAssetTransferableCoins(AssetDataRequest request);
    Object getAssetSingleCoinBalance(AssetDataRequest singleCoinBalanceRequest);
    Object createAssetInternalTransfer(AssetDataRequest assetInternalTransferRequest);
    Object getAssetTransferSubUidList();
    Object createAssetUniversalTransfer(AssetDataRequest assetUniversalTransferRequest);
    Object getAssetInternalTransferRecords(AssetDataRequest internalTransferRequest);
    Object getAssetUniversalTransferRecords(AssetDataRequest universalTransferRequest);
    Object getAssetAllowedDepositCoinInfo(AssetDataRequest allowedDepositCoinRequest);
    Object setAssetDepositAccount(AssetDataRequest request);
    Object getAssetDepositRecords(AssetDataRequest assetDepositRecordsRequest);
    Object getAssetSubMembersDepositRecords(AssetDataRequest assetDepositRecordsRequest);
    Object getAssetInternalDepositRecords(AssetDataRequest assetDepositRecordsRequest);
    Object getAssetMasterDepositAddress(AssetDataRequest masterDepositRequest);
    Object getAssetSubMemberDepositAddress(AssetDataRequest subDepositRequest);
    Object getAssetCoinInfo(AssetDataRequest request);
    Object getAssetWithdrawalAmount(AssetDataRequest request);
    Object getAssetWithdrawalRecords(AssetDataRequest assetWithdrawRecordsRequest);
    Object cancelAssetWithdraw(AssetDataRequest request);
    Object createAssetWithdraw(AssetDataRequest assetWithdrawRequest);

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
