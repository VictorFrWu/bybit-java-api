package com.bybit.api.client;

import com.bybit.api.client.domain.account.AccountDataRequest;
import com.bybit.api.client.domain.asset.AssetDataRequest;
import com.bybit.api.client.domain.market.MarketDataRequest;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.request.*;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.domain.user.UserDataRequest;

/**
 * Bybit API facade, supporting asynchronous/non-blocking access Bybit's REST API.
 */
public interface BybitApiAsyncRestClient {
    // Market endpoints
    void getServerTime(BybitApiCallback<Object> callback);

    void getMarketLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getMarketPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getIndexPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getPremiumIndexPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);

    void getInstrumentsInfo(MarketDataRequest instrumentInfoRequest, BybitApiCallback<Object> callback);

    void getMarketOrderbook(MarketDataRequest marketOrderBookRequest, BybitApiCallback<Object> callback);

    void getMarketTickers(MarketDataRequest marketDataTickerRequest, BybitApiCallback<Object> callback);

    void getFundingHistory(MarketDataRequest fundingHistoryRequest, BybitApiCallback<Object> callback);

    void getRecentTradeData(MarketDataRequest recentTradeRequest, BybitApiCallback<Object> callback);

    void getOpenInterest(MarketDataRequest openInterestRequest, BybitApiCallback<Object> callback);

    void getHistoricalVolatility(MarketDataRequest historicalVolatilityRequest, BybitApiCallback<Object> callback);

    void getInsurance(String coin, BybitApiCallback<Object> callback);

    void getInsurance(BybitApiCallback<Object> callback);

    void getRiskLimit(MarketDataRequest marketRiskLimitRequest, BybitApiCallback<Object> callback);

    void getDeliveryPrice(MarketDataRequest deliveryPriceRequest, BybitApiCallback<Object> callback);

    void getMarketAccountRatio(MarketDataRequest marketAccountRatioRequest, BybitApiCallback<Object> callback);

    // Position endpoints
    void getPositionInfo(PositionDataRequest positionListRequest, BybitApiCallback<Object> callback);

    void setPositionLeverage(PositionDataRequest setLeverageRequest, BybitApiCallback<Object> callback);

    void swithMarginRequest(PositionDataRequest switchMarginRequest, BybitApiCallback<Object> callback);

    void switchPositionMode(PositionDataRequest switchPositionModeRequest, BybitApiCallback<Object> callback);

    void setTpslMode(PositionDataRequest setTpSlModeRequest, BybitApiCallback<Object> callback);

    void setRiskLimit(PositionDataRequest setRiskLimitRequest, BybitApiCallback<Object> callback);

    void setTradingStop(PositionDataRequest tradingStopRequest, BybitApiCallback<Object> callback);

    void setAutoAddMargin(PositionDataRequest setAutoAddMarginRequest, BybitApiCallback<Object> callback);

    void modifyPositionMargin(PositionDataRequest modifyMarginRequest, BybitApiCallback<Object> callback);

    void getExecutionList(PositionDataRequest executionHistoryRequest, BybitApiCallback<Object> callback);

    void getClosePnlList(PositionDataRequest closePnlHistoryRequest, BybitApiCallback<Object> callback);

    // Pre upgrade endpoints
    void getPreUpgradeOrderHistory(PreUpgradeDataRequest preupgradeOderHistoryRequest, BybitApiCallback<Object> callback);

    void getPreUpgradeTradeHistory(PreUpgradeDataRequest preUpgradeTradeHistoryRequest, BybitApiCallback<Object> callback);

    void getPreUpgradeClosePnl(PreUpgradeDataRequest preUpgradeClosePnlRequest, BybitApiCallback<Object> callback);

    void getPreUpgradeTransaction(PreUpgradeDataRequest preUpgradeTransactionRequest, BybitApiCallback<Object> callback);

    void getPreUpgradeOptionDelivery(PreUpgradeDataRequest preUpgradeOptionDeliveryRequest, BybitApiCallback<Object> callback);

    void getPreUpgradeUsdcSettlement(PreUpgradeDataRequest preUpgradeUsdcSettlementRequest, BybitApiCallback<Object> callback);

    // Account endpoints
    void getWalletBalance(AccountDataRequest walletBalanceRequest, BybitApiCallback<Object> callback);

    void upgradeAccountToUTA(BybitApiCallback<Object> callback);

    void getAccountBorrowHistory(AccountDataRequest borrowHistoryRequest, BybitApiCallback<Object> callback);

    void setAccountCollateralCoin(AccountDataRequest setCollateralCoinRequest, BybitApiCallback<Object> callback);

    void getAccountCollateralInfo(AccountDataRequest request, BybitApiCallback<Object> callback);

    void getAccountCoinGeeks(AccountDataRequest request, BybitApiCallback<Object> callback);

    void getAccountFreeRate(AccountDataRequest getFeeRateRequest, BybitApiCallback<Object> callback);

    void getAccountInfo(BybitApiCallback<Object> callback);

    void getTransactionLog(AccountDataRequest getTransactionLogRequest, BybitApiCallback<Object> callback);

    void setAccountMarginMode(AccountDataRequest request, BybitApiCallback<Object> callback);

    void modifyAccountMMP(AccountDataRequest setMMPRequest, BybitApiCallback<Object> callback);

    void resetAccountMMP(AccountDataRequest request, BybitApiCallback<Object> callback);

    void getAccountMMPState(AccountDataRequest request, BybitApiCallback<Object> callback);

    // Asset Endpoints
    void getAssetCoinExchangeRecords(AssetDataRequest assetDataRequest, BybitApiCallback<Object> callback);

    void getAssetDeliveryRecords(AssetDataRequest deliveryReco, BybitApiCallback<Object> callbackrdsRequest);

    void getAssetUSDCSettlementRecords(AssetDataRequest usdcSettlementRequest, BybitApiCallback<Object> callback);

    void getAssetInfo(AssetDataRequest assetInfoRequest, BybitApiCallback<Object> callback);

    void getAssetAllCoinsBalance(AssetDataRequest allCoinsBalanceRequest, BybitApiCallback<Object> callback);

    void getAssetTransferableCoins(AssetDataRequest request, BybitApiCallback<Object> callback);

    void getAssetSingleCoinBalance(AssetDataRequest singleCoinBalanceRequest, BybitApiCallback<Object> callback);

    void createAssetInternalTransfer(AssetDataRequest assetInternalTransferRequest, BybitApiCallback<Object> callback);

    void getAssetTransferSubUidList(BybitApiCallback<Object> callback);

    void createAssetUniversalTransfer(AssetDataRequest assetUniversalTransferRequest, BybitApiCallback<Object> callback);

    void getAssetInternalTransferRecords(AssetDataRequest internalTransferRequest, BybitApiCallback<Object> callback);

    void getAssetUniversalTransferRecords(AssetDataRequest universalTransferRequest, BybitApiCallback<Object> callback);

    void getAssetAllowedDepositCoinInfo(AssetDataRequest allowedDepositCoinRequest, BybitApiCallback<Object> callback);

    void setAssetDepositAccount(AssetDataRequest request, BybitApiCallback<Object> callback);

    void getAssetDepositRecords(AssetDataRequest assetDepositRecordsRequest, BybitApiCallback<Object> callback);

    void getAssetSubMembersDepositRecords(AssetDataRequest assetDepositRecordsRequest, BybitApiCallback<Object> callback);

    void getAssetInternalDepositRecords(AssetDataRequest assetDepositRecordsRequest, BybitApiCallback<Object> callback);

    void getAssetMasterDepositAddress(AssetDataRequest masterDepositRequest, BybitApiCallback<Object> callback);

    void getAssetSubMemberDepositAddress(AssetDataRequest subDepositRequest, BybitApiCallback<Object> callback);

    void getAssetCoinInfo(AssetDataRequest request, BybitApiCallback<Object> callback);

    void getAssetWithdrawalAmount(AssetDataRequest request, BybitApiCallback<Object> callback);

    void getAssetWithdrawalRecords(AssetDataRequest assetWithdrawRecordsRequest, BybitApiCallback<Object> callback);

    void cancelAssetWithdraw(AssetDataRequest request, BybitApiCallback<Object> callback);

    void createAssetWithdraw(AssetDataRequest assetWithdrawRequest, BybitApiCallback<Object> callback);
    // User Data
    void createSubMember(UserDataRequest subUserRequest, BybitApiCallback<Object> callback);
    void createSubAPI(UserDataRequest createApiKeyRequest, BybitApiCallback<Object> callback);
    void getSubUIDList(BybitApiCallback<Object> callback);
    void freezeSubMember(UserDataRequest freezeSubUIDRequest, BybitApiCallback<Object> callback);
    void getCurrentAPIKeyInfo(BybitApiCallback<Object> callback);
    void getUIDWalletType(UserDataRequest userDataRequest, BybitApiCallback<Object> callback);
    void modifyMasterApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback);
    void modifySubApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback);
    void deleteMasterApiKey(BybitApiCallback<Object> callback);
    void deleteSubApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback);
    void getAffiliateUserInfo(UserDataRequest userDataRequest, BybitApiCallback<Object> callback);
}
