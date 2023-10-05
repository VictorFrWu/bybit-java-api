package com.bybit.api.client;

import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.account.request.*;
import com.bybit.api.client.domain.asset.request.*;
import com.bybit.api.client.domain.broker.request.BrokerEarningRequest;
import com.bybit.api.client.domain.c2c.ClientLendingFundsRequest;
import com.bybit.api.client.domain.c2c.ClientLendingOrderRecordsRequest;
import com.bybit.api.client.domain.market.MarketDataRequest;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.domain.position.request.*;
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

    /**
     * Get Pre-upgrade Order History
     * After the account is upgraded to a Unified account, you can get the orders which occurred before the upgrade.
     * <p>
     * INFO
     * can get all status in 7 days
     * can only get filled orders beyond 7 days
     *
     * @param preupgradeOderHistoryRequest
     * @return
     */
    Object getPreUpgradeOrderHistory(PreUpgradeOrderHistoryRequest preupgradeOderHistoryRequest);

    /**
     * Get Pre-upgrade Trade History
     * Get users' execution records which occurred before you upgraded the account to a Unified account, sorted by execTime in descending order
     * <p>
     * For now, it supports to query USDT perpetual, USDC perpetual, Inverse perpetual and futures, Option.
     * <p>
     * TIP
     * You may have multiple executions in a single order.
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId > orderLinkId > symbol > baseCoin.
     *
     * @param preUpgradeTradeHistoryRequest
     * @return
     */
    Object getPreUpgradeTradeHistory(PreUpgradeTradeHistoryRequest preUpgradeTradeHistoryRequest);

    /**
     * Get Pre-upgrade Closed PnL
     * Query user's closed profit and loss records from before you upgraded the account to a Unified account. The results are sorted by createdTime in descending order.
     * <p>
     * For now, it only supports to query USDT perpetual, Inverse perpetual and futures.
     *
     * @param preUpgradeClosePnlRequest
     * @return
     */
    Object getPreUpgradeClosePnl(PreUpgradeClosePnlRequest preUpgradeClosePnlRequest);

    /**
     * Get Pre-upgrade Transaction Log
     * Query transaction logs which occurred in the USDC Derivatives wallet before the account was upgraded to a Unified account.
     * <p>
     * You can get USDC Perpetual, Option records.
     *
     * @param preUpgradeTransactionRequest
     * @return
     */
    Object getPreUpgradeTransaction(PreUpgradeTransactionRequest preUpgradeTransactionRequest);

    /**
     * Get Pre-upgrade Option Delivery Record
     * Query delivery records of Option before you upgraded the account to a Unified account, sorted by deliveryTime in descending order
     *
     * @param preUpgradeOptionDeliveryRequest
     * @return
     */
    Object getPreUpgradeOptionDelivery(PreUpgradeOptionDeliveryRequest preUpgradeOptionDeliveryRequest);

    /**
     * Get Pre-upgrade USDC Session Settlement
     * Query session settlement records of USDC perpetual before you upgrade the account to Unified account.
     *
     * @param preUpgradeUsdcSettlementRequest
     * @return
     */
    Object getPreUpgradeUsdcSettlement(PreUpgradeUsdcSettlementRequest preUpgradeUsdcSettlementRequest);

    // Account endpoints

    /**
     * Get Wallet Balance
     * Obtain wallet balance, query asset information of each currency, and account risk rate information. By default, currency information with assets or liabilities of 0 is not returned.
     * <p>
     * TIP
     * The trading of UTA inverse contracts is conducted through the CONTRACT wallet.
     * To get Funding wallet balance, please go to this endpoint
     *
     * @param walletBalanceRequest
     * @return
     */
    Object getWalletBalance(WalletBalanceRequest walletBalanceRequest);

    /**
     * Upgrade Unified Account
     * <p>
     * UPGRADE GUIDANCE
     * Check your current account status by calling this Get Account Info
     * <p>
     * if unifiedMarginStatus=1, then it is classic account, you can call below upgrade endpoint to UTA Pro. Check Get Account Info after a while and if unifiedMarginStatus=4, then it is successfully upgraded to UTA Pro.
     * <p>
     * if unifiedMarginStatus=2, then it is UMA, you need to call below upgrade endpoint twice. The first call, your account will be upgraded to UTA, please make sure you call this Get Account Info and unifiedMarginStatus=3, then you can start the 2nd call, if you see unifiedMarginStatus=4, then it is UTA Pro.
     * <p>
     * if unifiedMarginStatus=3, then it is UTA, you need to call below upgrade endpoint to UTA Pro. Check Get Account Info after a while and if unifiedMarginStatus=4, then it is successfully upgraded to UTA Pro.
     * <p>
     * IMPORTANT
     * Banned / Express path users cannot upgrade the account to Unified Account for now.
     * <p>
     * INFO
     * You can upgrade the normal acct to unified acct without closing positions now, but please note belows:
     * <p>
     * Please avoid upgrading during these period:
     * every hour	50th minute to 5th minute of next hour
     * Please ensure:
     * No open order and debt in the Spot account
     * No open order and hedge-mode USDT position or isolated margin USDT position in the Derivatives account
     * No open order in the USDC Derivatives account
     * Cannot have TPSL order either
     * When the unifiedUpgradeProcess = PROCESS, it means that the system needs asynchronous verification processing, and the upgrade result cannot be returned in real time. You can check API Get Account Info after 3-5 minutes, check whether the upgrade is successful according to the "unifiedMarginStatus" field in the return.
     * <p>
     * During the account upgrade process, the data of Rest API/Websocket stream may be inaccurate due to the fact that the account-related asset data is in the processing state. It is recommended to query and use it after the upgrade is completed.
     *
     * @return
     */
    Object upgradeAccountToUTA();

    /**
     * Get Borrow History
     * Get interest records, sorted in reverse order of creation time.
     * <p>
     * Unified account
     *
     * @param borrowHistoryRequest
     * @return
     */
    Object getAccountBorrowHistory(BorrowHistoryRequest borrowHistoryRequest);

    /**
     * Set Collateral Coin
     * You can decide whether the assets in the Unified account needs to be collateral coins.
     *
     * @param setCollateralCoinRequest
     * @return
     */
    Object setAccountCollateralCoin(SetCollateralCoinRequest setCollateralCoinRequest);

    /**
     * Get Collateral Info
     * Get the collateral information of the current unified margin account, including loan interest rate, loanable amount, collateral conversion rate, whether it can be mortgaged as margin, etc.
     *
     * @return
     */
    Object getAccountCollateralInfo(String currency);

    Object getAccountCollateralInfo();

    /**
     * Get Coin Greeks
     * Get current account Greeks information
     *
     * @param baseCoin
     * @return
     */
    Object getAccountCoinGeeks(String baseCoin);

    Object getAccountCoinGeeks();

    /**
     * Get Fee Rate
     * Get the trading fee rate.
     * <p>
     * Covers: Spot / USDT perpetual / USDC perpetual / USDC futures / Inverse perpetual / Inverse futures / Options
     * <p>
     * HTTP Request
     *
     * @param getFeeRateRequest
     * @return
     */
    Object getAccountFreeRate(GetFeeRateRequest getFeeRateRequest);

    /**
     * Get Account Info
     * Query the margin mode configuration of the account.
     *
     * @return
     */
    Object getAccountInfo();

    /**
     * Get Transaction Log
     * Query transaction logs in Unified account.
     *
     * @param getTransactionLogRequest
     * @return
     */
    Object getTransactionLog(GetTransactionLogRequest getTransactionLogRequest);

    /**
     * Set Margin Mode
     * Default is regular margin mode
     * <p>
     * INFO
     * UTA account can be switched between these 3 kinds of margin modes, which is across UID level, working for USDT Perp, USDC Perp, USDC Futures and Options (Option does not support ISOLATED_MARGIN)
     * Normal account can be switched between REGULAR_MARGIN and PORTFOLIO_MARGIN, only work for USDC Perp and Options trading.
     *
     * @param setMarginMode
     * @return
     */
    Object setAccountMarginMode(String setMarginMode);

    /**
     * Set MMP
     * INFO
     * What is MMP?
     * Market Maker Protection (MMP) is an automated mechanism designed to protect market makers (MM) against liquidity risks and over-exposure in the market. It prevents simultaneous trade executions on quotes provided by the MM within a short time span. The MM can automatically pull their quotes if the number of contracts traded for an underlying asset exceeds the configured threshold within a certain time frame. Once MMP is triggered, any pre-existing MMP orders will be automatically canceled, and new orders tagged as MMP will be rejected for a specific duration — known as the frozen period — so that MM can reassess the market and modify the quotes.
     * <p>
     * How to enable MMP
     * Send an email to Bybit (financial.inst@bybit.com) or contact your business development (BD) manager to apply for MMP. After processed, the default settings are as below table:
     * <p>
     * Parameter	Type	Comments	Default value
     * baseCoin	string	Base coin	BTC
     * window	string	Time window (millisecond)	5000
     * frozenPeriod	string	Frozen period (millisecond)	100
     * qtyLimit	string	Quantity limit	100
     * deltaLimit	string	Delta limit	100
     * Applicable
     * Effective for options only. When you place an option order, set mmp=true, which means you mark this order as a mmp order.
     *
     * @param setMMPRequest
     * @return
     */
    Object modifyAccountMMP(SetMMPRequest setMMPRequest);

    /**
     * Reset MMP
     * INFO
     * Once the mmp triggered, you can unfreeze the account by this endpoint, then qtyLimit and deltaLimit will be reset to 0.
     * If the account is not frozen, reset action can also remove previous accumulation, i.e., qtyLimit and deltaLimit will be reset to 0.
     *
     * @param baseCoin
     * @return
     */
    Object resetAccountMMP(String baseCoin);

    /**
     * Get MMP State
     *
     * @param baseCoin
     * @return
     */
    Object getAccountMMPState(String baseCoin);

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

    // Asset Endpoints

    /**
     * Get Coin Exchange Records
     * Query the coin exchange records.
     * <p>
     * INFO
     * This endpoint currently is not available to get data after 12 Mar 2023. We will make it fully available later.
     * <p>
     * CAUTION
     * You may have a long delay of this endpoint.
     *
     * @param coinExchangeRecordsRequest
     * @return
     */
    Object getAssetCoinExchangeRecords(CoinExchangeRecordsRequest coinExchangeRecordsRequest);

    /**
     * Get Delivery Record
     * Query delivery records of USDC futures and Options, sorted by deliveryTime in descending order
     * <p>
     * Unified account covers: USDC futures / Option
     *
     * @param deliveryRecordsRequest
     * @return
     */
    Object getAssetDeliveryRecords(AssetDeliveryRecordsRequest deliveryRecordsRequest);

    /**
     * Get USDC Session Settlement
     * Query session settlement records of USDC perpetual and futures
     * <p>
     * Unified account covers: USDC perpetual / USDC futures
     *
     * @param usdcSettlementRequest
     * @return
     */
    Object getAssetUSDCSettlementRecords(USDCSessionSettlementRequest usdcSettlementRequest);

    /**
     * Get Asset Info
     * Query asset information
     * <p>
     * INFO
     * For now, it can query SPOT only.
     *
     * @param assetInfoRequest
     * @return
     */
    Object getAssetInfo(AssetInfoRequest assetInfoRequest);

    /**
     * Get All Coins Balance
     * You could get all coin balance of all account types under the master account, and sub account.
     * <p>
     * IMPORTANT
     * It is not allowed to get master account coin balance via sub account api key.
     *
     * @param allCoinsBalanceRequest
     * @return
     */
    Object getAssetAllCoinsBalance(AssetCoinsBalanceRequest allCoinsBalanceRequest);

    /**
     * Get Transferable Coin
     * Query the transferable coin list between each account type
     *
     * @param fromAccountType
     * @param toAccountType
     * @return
     */
    Object getAssetTransferableCoins(AccountType fromAccountType, AccountType toAccountType);

    /**
     * Get Single Coin Balance
     * Query the balance of a specific coin in a specific account type. Supports querying sub UID's balance. Also, you can check the transferable amount from master to sub account, sub to master account or sub to sub account, especially for user who has INS loan.
     * <p>
     * INFO
     * Sub account cannot query master account balance
     * Sub account can only check its own balance
     * Master account can check its own and its sub uids balance
     *
     * @param singleCoinBalanceRequest
     * @return
     */
    Object getAssetSingleCoinBalance(AssetSingleCoinBalanceRequest singleCoinBalanceRequest);

    /**
     * Create Internal Transfer
     * Create the internal transfer between different account types under the same UID.
     * <p>
     * TIP
     * Each account type has its own acceptable coins, e.g, you cannot transfer USDC from SPOT to CONTRACT. Please refer to transferable coin list API to find out more.
     * <p>
     * HTTP Request
     * POST /v5/asset/transfer/inter-transfer
     *
     * @param assetInternalTransferRequest
     * @return
     */
    Object createAssetInternalTransfer(AssetInternalTransferRequest assetInternalTransferRequest);

    /**
     * Get Sub UID
     * Query the sub UIDs under a main UID
     * <p>
     * CAUTION
     * Can query by the master UID's api key only
     *
     * @return
     */
    Object getAssetTransferSubUidList();

    /**
     * Create Universal Transfer
     * Transfer between sub-sub or main-sub.
     * <p>
     * CAUTION
     * Can use master or sub acct api key to request
     * To use sub acct api key, it must have "SubMemberTransferList" permission
     * When use sub acct api key, it can only transfer to main account
     * If you encounter errorCode: 131228 and msg: your balance is not enough, please go to Get Single Coin Balance to check transfer safe amount.
     * You can not transfer between the same UID
     *
     * @param assetUniversalTransferRequest
     * @return
     */
    Object createAssetUniversalTransfer(AssetUniversalTransferRequest assetUniversalTransferRequest);

    /**
     * Get Internal Transfer Records
     * Query the internal transfer records between different account types under the same UID.
     *
     * @param internalTransferRequest
     * @return
     */
    Object getAssetInternalTransferRecords(AssetTransferRecordsRequest internalTransferRequest);

    /**
     * Get Universal Transfer Records
     * Query universal transfer records
     * <p>
     * TIP
     * Main acct api key or Sub acct api key are both supported
     * Main acct api key needs "SubMemberTransfer" permission
     * Sub acct api key needs "SubMemberTransferList" permission
     *
     * @param universalTransferRequest
     * @return
     */
    Object getAssetUniversalTransferRecords(AssetTransferRecordsRequest universalTransferRequest);

    /**
     * Get Allowed Deposit Coin Info
     * Query allowed deposit coin information. To find out paired chain of coin, please refer coin info api.
     * <p>
     * TIP
     * This is an endpoint that does not need authentication
     *
     * @param allowedDepositCoinRequest
     * @return
     */
    Object getAssetAllowedDepositCoinInfo(AssetAllowedDepositCoinRequest allowedDepositCoinRequest);

    /**
     * HTTP Request
     * POST /v5/asset/deposit/deposit-to-account
     * <p>
     * Request Parameters
     * Parameter	Required	Type	Comments
     * accountType	true	string	Account type
     * UNIFIED
     * SPOT
     * OPTION
     * CONTRACT
     * FUND
     * Response Parameters
     * Parameter	Type	Comments
     * status	integer	Request result:
     * 1: SUCCESS
     * 0: FAIL
     *
     * @param accountType
     * @return
     */
    Object setAssetDepositAccount(AccountType accountType);

    /**
     * Get Deposit Records (on-chain)
     * Query deposit records.
     * <p>
     * TIP
     * endTime - startTime should be less than 30 days. Query last 30 days records by default.
     * Can use main or sub UID api key to query deposit records respectively.
     *
     * @param assetDepositRecordsRequest
     * @return
     */
    Object getAssetDepositRecords(AssetDepositRecordsRequest assetDepositRecordsRequest);

    /**
     * Get Sub Deposit Records (on-chain)
     * Query subaccount's deposit records by main UID's API key.
     * <p>
     * TIP
     * endTime - startTime should be less than 30 days. Queries for the last 30 days worth of records by default.
     *
     * @param assetDepositRecordsRequest
     * @return
     */
    Object getAssetSubMembersDepositRecords(AssetDepositRecordsRequest assetDepositRecordsRequest);

    /**
     * Get Internal Deposit Records (off-chain)
     * Query deposit records within the Bybit platform. These transactions are not on the blockchain.
     * <p>
     * RULES
     * The maximum difference between the start time and the end time is 30 days.
     * Support to get deposit records by Master or Sub Member Api Key
     *
     * @param assetDepositRecordsRequest
     * @return
     */
    Object getAssetInternalDepositRecords(AssetDepositRecordsRequest assetDepositRecordsRequest);

    Object getAssetMasterDepositAddress(AssetDepositRequest masterDepositRequest);

    Object getAssetSubMemberDepositAddress(AssetDepositRequest subDepositRequest);

    Object getAssetCoinInfo();

    Object getAssetCoinInfo(String coin);

    Object getAssetWithdrawalAmount(String coin);

    Object getAssetWithdrawalRecords(AssetWithdrawRecordsRequest assetWithdrawRecordsRequest);

    Object cancelAssetWithdraw(String withdrawId);

    Object createAssetWithdraw(AssetWithdrawRequest assetWithdrawRequest);
}
