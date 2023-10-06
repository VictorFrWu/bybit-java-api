package com.bybit.api.client;

import com.bybit.api.client.domain.account.AccountDataRequest;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.account.request.*;
import com.bybit.api.client.domain.asset.AssetDataRequest;
import com.bybit.api.client.domain.asset.request.*;
import com.bybit.api.client.domain.broker.request.BrokerEarningRequest;
import com.bybit.api.client.domain.c2c.ClientLendingFundsRequest;
import com.bybit.api.client.domain.c2c.ClientLendingOrderRecordsRequest;
import com.bybit.api.client.domain.market.MarketDataRequest;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.domain.position.request.*;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.domain.preupgrade.request.*;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageOrdersRecordRequest;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageTokenRequest;
import com.bybit.api.client.domain.spot.marginTrade.*;
import com.bybit.api.client.domain.user.request.ApiKeyRequest;
import com.bybit.api.client.domain.user.request.FreezeSubUIDRquest;
import com.bybit.api.client.domain.user.request.SubUserRequest;

public interface BybitApiRestClient {
    // Market Data
    Object getServerTime();

    Object getMarketLinesData(MarketDataRequest marketKlineRequest);

    Object getMarketPriceLinesData(MarketDataRequest marketKlineRequest);

    Object getIndexPriceLinesData(MarketDataRequest marketKlineRequest);

    Object getPremiumIndexPriceLinesData(MarketDataRequest marketKlineRequest);

    Object getInstrumentsInfo(MarketDataRequest instrumentInfoRequest);

    Object getMarketOrderbook(MarketDataRequest marketOrderBookRequest);

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

    // User
    Object getCurrentAPIKeyInfo();

    Object getSubUIDList();

    Object createSubMember(SubUserRequest subUserRequest);

    Object createSubAPI(ApiKeyRequest apiKeyRequest);

    Object freezeSubMember(FreezeSubUIDRquest freezeSubUIDRquest);

    Object getUIDWalletType(String memberIds);

    Object getUIDWalletType();

    Object getAffiliateUserInfo(String uid);

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

    /**
     * Get Leverage Token Info
     * Query leverage token information
     *
     * @param ltCoin
     * @return
     */
    Object getSpotLeverageTokenInfo(String ltCoin);

    Object getSpotLeverageTokenInfo();

    /**
     * Get Leveraged Token Market
     * Get leverage token market information
     *
     * @param ltCoin
     * @return
     */
    Object getSpotLeverageTokenMarket(String ltCoin);

    Object getSpotLeverageTokenMarket();

    /**
     * Purchase
     * Purchase levearge token
     *
     * @param spotLeverageTokenRequest
     * @return
     */
    Object purchaseSpotLeverageToken(SpotLeverageTokenRequest spotLeverageTokenRequest);

    /**
     * Redeem
     * Redeem leverage token
     *
     * @param spotLeverageTokenRequest
     * @return
     */
    Object redeemSpotLeverageToken(SpotLeverageTokenRequest spotLeverageTokenRequest);

    /**
     * Get Purchase/Redemption Records
     * Get purchase or redeem history
     *
     * @param spotLeverageOrdersRecordRequest
     * @return
     */
    Object getSpotLeverageRecords(SpotLeverageOrdersRecordRequest spotLeverageOrdersRecordRequest);

    // Spot Margin UTA

    /**
     * Get VIP Margin Data
     * This margin data is for Unified account in particular.
     *
     * @param utaMarginDataRequest
     * @return
     */
    Object getUtaVipSpotMarginTradeData(VIPMarginDataRequest utaMarginDataRequest);

    /**
     * Toggle Margin Trade
     * Turn on / off spot margin trade
     * <p>
     * Covers: Margin trade (Unified Account)
     * <p>
     * CAUTION
     * Your account needs to activate spot margin first; i.e., you must have finished the quiz on web / app.
     * <p>
     * Request Parameters
     * Parameter	Required	Type	Comments
     * spotMarginMode	true	string	1: on, 0: off
     * Response Parameters
     * Parameter	Type	Comments
     * spotMarginMode	string	Spot margin status. 1: on, 0: off
     *
     * @param spotMarginMode
     * @return
     */
    Object setUTASpotMarginTrade(String spotMarginMode);

    /**
     * et Leverage
     * Set the user's maximum leverage in spot cross margin
     * <p>
     * Covers: Margin trade (Unified Account)
     * <p>
     * CAUTION
     * Your account needs to activate spot margin first; i.e., you must have finished the quiz on web / app.
     * <p>
     * Request Parameters
     * Parameter	Required	Type	Comments
     * leverage	true	string	Leverage. [2, 10].
     *
     * @param leverage
     * @return
     */
    Object setUTASpotMarginTradeLeverage(String leverage);

    /**
     * Get Status And Leverage
     * Query the Spot margin status and leverage of Unified account
     * <p>
     * Covers: Margin trade (Unified Account)
     * <p>
     * Response Parameters
     * Parameter	Type	Comments
     * spotLeverage	string	Spot margin leverage. Returns "" if the margin trade is turned off
     * spotMarginMode	string	Spot margin status. 1: on, 0: off
     *
     * @return
     */
    Object getUTASpotMarginTradeLeverageState();

    // Spot Margin Normal

    /**
     * Get VIP Margin Data
     * This margin data is for Classic account in particular.
     * <p>
     * INFO
     * Do not need authentication
     *
     * @param normalMarginDataRequest
     * @return
     */
    Object getNormalVipSpotMarginTradeData(VIPMarginDataRequest normalMarginDataRequest);


    /**
     * Get Margin Coin Info
     * INFO
     * Do not need authentication
     *
     * @param coin
     * @return
     */
    Object getNormalSpotMarginTradeCoinInfo(String coin);

    Object getNormalSpotMarginTradeCoinInfo();

    /**
     * Get Borrowable Coin Info
     * INFO
     * Do not need authentication
     *
     * @param coin
     * @return
     */
    Object getNormalSpotMarginTradeBorrowCoinInfo(String coin);

    Object getNormalSpotMarginTradeBorrowCoinInfo();

    /**
     * Get Interest & Quota
     * Covers: Margin trade (Normal Account)
     *
     * @param coin
     * @return
     */
    Object getNormalSpotMarginTradeInterestQuota(String coin);

    /**
     * Get Loan Account Info
     * Covers: Margin trade (Normal Account)
     *
     * @return
     */
    Object getNormalSpotMarginTradeAccountInfo();

    /**
     * Toggle Margin Trade
     * Turn on / off spot margin trade
     * <p>
     * Covers: Margin trade (Normal Account)
     *
     * @param switchStatus
     * @return
     */
    Object getNormalSpotToggleMarginTrade(int switchStatus);

    /**
     * Borrow
     * Covers: Margin trade (Normal Account)
     *
     * @param spotMarginTradeBorrowRequest
     * @return
     */
    Object loanNormalSpotMarginTrade(SpotMarginTradeBorrowRequest spotMarginTradeBorrowRequest);

    /**
     * Repay
     * Covers: Margin trade (Normal Account)
     *
     * @param spotMarginTradeRePayRequest
     * @return
     */
    Object repayNormalSpotMarginTrade(SpotMarginTradeRePayRequest spotMarginTradeRePayRequest);

    /**
     * Get Borrow Order Detail
     * Covers: Margin trade (Normal Account)
     *
     * @param spotMarginTradeBorrowOrdersRequest
     * @return
     */
    Object getNormalSpotMarginTradeBorrowOrders(SpotMarginTradeBorrowOrdersRequest spotMarginTradeBorrowOrdersRequest);

    /**
     * Get Repayment Order Detail
     * Covers: Margin trade (Normal Account)
     *
     * @param spotMarginTradeRepayOrdersRequest
     * @return
     */
    Object getNormalSpotMarginTradeRepayOrders(SpotMarginTradeRepayOrdersRequest spotMarginTradeRepayOrdersRequest);

    // Broker endpoints

    /**
     * Get Broker Earning
     * INFO
     * Use exchange broker master account to query
     * The data can support up to past 6 months until T-1
     * startTime & endTime are either entered at the same time or not entered
     *
     * @param brokerEarningRequest
     * @return
     */
    Object getBrokerEarningData(BrokerEarningRequest brokerEarningRequest);

    // C2C Endpoints

    /**
     * Get Lending Coin Info
     * Get the basic information of lending coins
     * <p>
     * INFO
     * All v5/lending APIs need SPOT permission.
     *
     * @param coin
     * @return
     */
    Object getC2CLendingCoinInfo(String coin);

    Object getC2CLendingCoinInfo();

    /**
     * Deposit Funds
     * Lending funds to Bybit asset pool
     * <p>
     * INFO
     * normal & UMA account: deduct funds from Spot wallet
     * UTA account: deduct funds from Unified wallet
     *
     * @param despoitFundRequest
     * @return
     */
    Object C2cLendingDepositFunds(ClientLendingFundsRequest despoitFundRequest);

    /**
     * Redeem Funds
     * Withdraw funds from the Bybit asset pool.
     * <p>
     * TIP
     * There will be two redemption records: one for the redeemed quantity, and the other one is for the total interest occurred.
     *
     * @param despoitFundRequest
     * @return
     */
    Object C2cLendingRedeemFunds(ClientLendingFundsRequest despoitFundRequest);

    /**
     * Get Order Records
     * Get lending or redeem history
     *
     * @param c2cOrdersRecordsRequest
     * @return
     */
    Object getC2cOrdersRecords(ClientLendingOrderRecordsRequest c2cOrdersRecordsRequest);

    /**
     * Get Lending Account Info
     * HTTP Request
     * GET /v5/lending/account
     * <p>
     * Request Parameters
     * Parameter	Required	Type	Comments
     * coin	true	string	Coin name
     * Response Parameters
     * Parameter	Type	Comments
     * coin	string	Coin name
     * principalInterest	string	User Redeemable interest
     * principalQty	string	Leftover quantity you can redeem for today (measured from 0 - 24 UTC)
     * principalTotal	string	Total amount redeemable by user
     * quantity	string	Current deposit quantity
     *
     * @param coin
     * @return
     */
    Object getC2CLendingAccountInfo(String coin);
}
