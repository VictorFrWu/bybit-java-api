package com.bybit.api.client;

import com.bybit.api.client.domain.account.AccountDataRequest;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.account.request.*;
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
