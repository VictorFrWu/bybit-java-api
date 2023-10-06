package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiRestClient;
import com.bybit.api.client.domain.account.AccountDataRequest;
import com.bybit.api.client.domain.asset.AssetDataRequest;
import com.bybit.api.client.domain.asset.request.*;
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
import com.bybit.api.client.BybitApiService;
import com.bybit.api.client.domain.user.request.UserSubMemberRequest;
import com.bybit.api.client.service.JsonConverter;

import static com.bybit.api.client.constant.Util.listToString;
import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

/**
 * Implementation of Bybit's REST API using Retrofit with synchronous/blocking
 * method calls.
 */
public class BybitApiRestClientImpl implements BybitApiRestClient {
    private final BybitApiService bybitApiService;
    private final JsonConverter converter = new JsonConverter();

    public BybitApiRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }

    // Market Data endpoints
    @Override
    public Object getServerTime() {
        return executeSync(
                bybitApiService.getServerTime());
    }

    @Override
    public Object getMarketLinesData(MarketDataRequest marketKlineRequest) {
        return executeSync(
                bybitApiService.getMarketLinesData(
                        marketKlineRequest.getCategory().getProductTypeId(),
                        marketKlineRequest.getSymbol(),
                        marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                        marketKlineRequest.getStart(),
                        marketKlineRequest.getEnd(),
                        marketKlineRequest.getLimit()
                )
        );
    }

    @Override
    public Object getMarketPriceLinesData(MarketDataRequest marketKlineRequest) {
        return executeSync(
                bybitApiService.getMarketPriceLinesData(
                        marketKlineRequest.getCategory().getProductTypeId(),
                        marketKlineRequest.getSymbol(),
                        marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                        marketKlineRequest.getStart(),
                        marketKlineRequest.getEnd(),
                        marketKlineRequest.getLimit()
                )
        );
    }

    @Override
    public Object getIndexPriceLinesData(MarketDataRequest marketKlineRequest) {
        return executeSync(
                bybitApiService.getIndexPriceLinesData(
                        marketKlineRequest.getCategory().getProductTypeId(),
                        marketKlineRequest.getSymbol(),
                        marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                        marketKlineRequest.getStart(),
                        marketKlineRequest.getEnd(),
                        marketKlineRequest.getLimit()
                )
        );
    }

    @Override
    public Object getPremiumIndexPriceLinesData(MarketDataRequest marketKlineRequest) {
        return executeSync(
                bybitApiService.getPremiumIndexPriceLinesData(
                        marketKlineRequest.getCategory().getProductTypeId(),
                        marketKlineRequest.getSymbol(),
                        marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                        marketKlineRequest.getStart(),
                        marketKlineRequest.getEnd(),
                        marketKlineRequest.getLimit()
                )
        );
    }

    @Override
    public Object getInstrumentsInfo(MarketDataRequest instrumentInfoRequest) {
        return executeSync(bybitApiService.getInstrumentsInfo(
                instrumentInfoRequest.getCategory().getProductTypeId(),
                instrumentInfoRequest.getSymbol(),
                instrumentInfoRequest.getInstrumentStatus() == null ? null : instrumentInfoRequest.getInstrumentStatus().getStatus(),
                instrumentInfoRequest.getBaseCoin(),
                instrumentInfoRequest.getLimit(),
                instrumentInfoRequest.getCursor()
        ));
    }

    @Override
    public Object getMarketOrderbook(MarketDataRequest marketOrderBookRequest) {
        return executeSync(bybitApiService.getMarketOrderbook(
                marketOrderBookRequest.getCategory().getProductTypeId(),
                marketOrderBookRequest.getSymbol(),
                marketOrderBookRequest.getLimit()
        ));
    }

    @Override
    public Object getMarketTickers(MarketDataRequest marketDataTickerRequest) {
        return executeSync(bybitApiService.getMarketTickers(
                marketDataTickerRequest.getCategory().getProductTypeId(),
                marketDataTickerRequest.getSymbol(),
                marketDataTickerRequest.getBaseCoin(),
                marketDataTickerRequest.getExpDate()
        ));
    }

    @Override
    public Object getFundingHistory(MarketDataRequest fundingHistoryRequest) {
        return executeSync(bybitApiService.getFundingHistory(
                fundingHistoryRequest.getCategory().getProductTypeId(),
                fundingHistoryRequest.getSymbol(),
                fundingHistoryRequest.getStartTime(),
                fundingHistoryRequest.getEndTime(),
                fundingHistoryRequest.getLimit()
        ));
    }

    @Override
    public Object getRecentTradeData(MarketDataRequest recentTradeRequest) {
        return executeSync(bybitApiService.getRecentTradeData(
                recentTradeRequest.getCategory().getProductTypeId(),
                recentTradeRequest.getBaseCoin(),
                recentTradeRequest.getOptionType() == null ? null : recentTradeRequest.getOptionType().getOpType(),
                recentTradeRequest.getSymbol(),
                recentTradeRequest.getLimit()
        ));
    }

    @Override
    public Object getOpenInterest(MarketDataRequest openInterestRequest) {
        return executeSync(bybitApiService.getOpenInterest(
                openInterestRequest.getCategory().getProductTypeId(),
                openInterestRequest.getSymbol(),
                openInterestRequest.getMarketIntervalTime() == null ? null : openInterestRequest.getMarketIntervalTime().getInterval(),
                openInterestRequest.getStartTime(),
                openInterestRequest.getEndTime(),
                openInterestRequest.getLimit(),
                openInterestRequest.getCursor()
        ));
    }

    @Override
    public Object getHistoricalVolatility(MarketDataRequest historicalVolatilityRequest) {
        return executeSync(bybitApiService.getHistoricalVolatility(
                historicalVolatilityRequest.getCategory().getProductTypeId(),
                historicalVolatilityRequest.getBaseCoin(),
                historicalVolatilityRequest.getOptionPeriod(),
                historicalVolatilityRequest.getStartTime(),
                historicalVolatilityRequest.getEndTime())
        );
    }

    @Override
    public Object getRiskLimit(MarketDataRequest marketRiskLimitRequest) {
        return executeSync(bybitApiService.getRiskLimit(
                marketRiskLimitRequest.getCategory().getProductTypeId(),
                marketRiskLimitRequest.getSymbol()));
    }

    @Override
    public Object getInsurance(String coin) {
        return executeSync(bybitApiService.getInsurance(coin));
    }

    @Override
    public Object getInsurance() {
        return executeSync(bybitApiService.getInsurance());
    }

    @Override
    public Object getDeliveryPrice(MarketDataRequest deliveryPriceRequest) {
        return executeSync(bybitApiService.getDeliveryPrice(deliveryPriceRequest.getCategory().getProductTypeId(),
                deliveryPriceRequest.getSymbol(),
                deliveryPriceRequest.getBaseCoin(),
                deliveryPriceRequest.getLimit(),
                deliveryPriceRequest.getCursor()
        ));
    }

    @Override
    public Object getMarketAccountRatio(MarketDataRequest marketAccountRatioRequest) {
        return executeSync(bybitApiService.getMarketAccountRatio(marketAccountRatioRequest.getCategory().getProductTypeId(),
                marketAccountRatioRequest.getSymbol(),
                marketAccountRatioRequest.getDataRecordingPeriod() == null ? null : marketAccountRatioRequest.getDataRecordingPeriod().getPeriod(),
                marketAccountRatioRequest.getLimit()
        ));
    }

    // User endpoints
    @Override
    public Object getCurrentAPIKeyInfo() {
        return executeSync(bybitApiService.getCurrentAPIKeyInfo());
    }

    @Override
    public Object getSubUIDList() {
        return executeSync(bybitApiService.getSubUIDList());
    }

    @Override
    public Object createSubMember(UserDataRequest request) {
        UserSubMemberRequest subUserRequest = converter.mapToCreateSubMemberRequest(request);
        return executeSync(bybitApiService.createSubMember(subUserRequest));
    }

    @Override
    public Object createSubAPI(UserDataRequest request) {
        var createApiKeyRequest = converter.mapToCreateSubApiRequest(request);
        return executeSync(bybitApiService.createSubAPI(createApiKeyRequest));
    }

    @Override
    public Object freezeSubMember(UserDataRequest request) {
        var freezeSubUIDRquest = converter.mapToFreezeSubApiRequest(request);
        return executeSync(bybitApiService.freezeSubMember(freezeSubUIDRquest));
    }

    @Override
    public Object getUIDWalletType(UserDataRequest request) {
        return executeSync(bybitApiService.getUIDWalletType(request.getMemberIds() == null ? null : listToString(request.getMemberIds())));
    }

    @Override
    public Object modifyMasterApiKey(UserDataRequest userDataRequest) {
        var modifyMasterApiKeyRequest = converter.mapToModifyApiKeyRequest(userDataRequest);
        return executeSync(bybitApiService.modifyMasterApiKey(modifyMasterApiKeyRequest));
    }

    @Override
    public Object modifySubApiKey(UserDataRequest userDataRequest) {
        var modifySubApiKeyRequest = converter.mapToModifyApiKeyRequest(userDataRequest);
        return executeSync(bybitApiService.modifySubApiKey(modifySubApiKeyRequest));
    }

    @Override
    public Object deleteMasterApiKey() {
        return executeSync(bybitApiService.deleteMasterApiKey());
    }

    @Override
    public Object deleteSubApiKey(UserDataRequest userDataRequest) {
        var deleteSubApiKeyRequest = converter.mapToDeleteSubApiKeyRequest(userDataRequest);
        return executeSync(bybitApiService.deleteSubApiKey(deleteSubApiKeyRequest));
    }

    @Override
    public Object getAffiliateUserInfo(UserDataRequest request) {
        return executeSync(bybitApiService.getAffiliateUserInfo(request.getUid()));
    }


    // Position endpoints

    @Override
    public Object getPositionInfo(PositionDataRequest positionListRequest) {
        return executeSync(bybitApiService.getPositionInfo(
                positionListRequest.getCategory().getProductTypeId(),
                positionListRequest.getSymbol(),
                positionListRequest.getBaseCoin(),
                positionListRequest.getSettleCoin(),
                positionListRequest.getLimit(),
                positionListRequest.getCursor()
        ));
    }

    @Override
    public Object setPositionLeverage(PositionDataRequest positionDataRequest) {
        var setLeverageRequest = converter.mapToSetLeverageRequest(positionDataRequest);
        return executeSync(bybitApiService.setPositionLeverage(setLeverageRequest));
    }

    @Override
    public Object swithMarginRequest(PositionDataRequest positionDataRequest) {
        var switchMarginRequest = converter.mapToSwitchMarginRequest(positionDataRequest);
        return executeSync(bybitApiService.swithMarginRequest(switchMarginRequest));
    }

    @Override
    public Object switchPositionMode(PositionDataRequest positionDataRequest) {
        var switchPositionModeRequest = converter.mapToSwitchPositionModeRequest(positionDataRequest);
        return executeSync(bybitApiService.switchPositionMode(switchPositionModeRequest));
    }

    @Override
    public Object setTpslMode(PositionDataRequest positionDataRequest) {
        var setTpSlModeRequest = converter.mapToSetTpSlModeRequest(positionDataRequest);
        return executeSync(bybitApiService.setTpslMode(setTpSlModeRequest));
    }

    @Override
    public Object setRiskLimit(PositionDataRequest positionDataRequest) {
        var setRiskLimitRequest = converter.mapToSetRiskLimitRequest(positionDataRequest);
        return executeSync(bybitApiService.setRiskLimit(setRiskLimitRequest));
    }

    @Override
    public Object setTradingStop(PositionDataRequest positionDataRequest) {
        var tradingStopRequest = converter.mapToTradingStopRequest(positionDataRequest);
        return executeSync(bybitApiService.setTradingStop(tradingStopRequest));
    }

    @Override
    public Object setAutoAddMargin(PositionDataRequest positionDataRequest) {
        var setAutoAddMarginRequest = converter.mapToSetAutoAddMarginRequest(positionDataRequest);
        return executeSync(bybitApiService.setAutoAddMargin(setAutoAddMarginRequest));
    }

    @Override
    public Object modifyPositionMargin(PositionDataRequest positionDataRequest) {
        var modifyMarginRequest = converter.mapToModifyMarginRequest(positionDataRequest);
        return executeSync(bybitApiService.modifyPositionMargin(modifyMarginRequest));
    }

    @Override
    public Object getExecutionList(PositionDataRequest executionHistoryRequest) {
        return executeSync(bybitApiService.getExecutionList(
                executionHistoryRequest.getCategory().getProductTypeId(),
                executionHistoryRequest.getSymbol(),
                executionHistoryRequest.getOrderId(),
                executionHistoryRequest.getOrderLinkId(),
                executionHistoryRequest.getBaseCoin(),
                executionHistoryRequest.getStartTime(),
                executionHistoryRequest.getEndTime(),
                executionHistoryRequest.getExecType() == null ? null : executionHistoryRequest.getExecType().getExecTypeId(),
                executionHistoryRequest.getLimit(),
                executionHistoryRequest.getCursor()
        ));
    }

    @Override
    public Object getClosePnlList(PositionDataRequest closePnlHistoryRequest) {
        return executeSync(bybitApiService.getClosePnlList(
                closePnlHistoryRequest.getCategory().getProductTypeId(),
                closePnlHistoryRequest.getSymbol(),
                closePnlHistoryRequest.getStartTime(),
                closePnlHistoryRequest.getEndTime(),
                closePnlHistoryRequest.getLimit(),
                closePnlHistoryRequest.getCursor()
        ));
    }

    // Pre upgrade endpoints
    @Override
    public Object getPreUpgradeClosePnl(PreUpgradeDataRequest request) {
        return executeSync(bybitApiService.getPreUpgradeClosePnl(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getPreUpgradeOrderHistory(PreUpgradeDataRequest request) {
        return executeSync(bybitApiService.getPreUpgradeOrderHistory(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getBaseCoin(),
                request.getOrderId(),
                request.getOrderLinkId(),
                request.getOrderFilter(),
                request.getOrderStatus() == null ? null : request.getOrderStatus().getDescription(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getPreUpgradeTradeHistory(PreUpgradeDataRequest request) {
        return executeSync(bybitApiService.getPreUpgradeTradeHistory(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getOrderId(),
                request.getOrderLinkId(),
                request.getBaseCoin(),
                request.getStartTime(),
                request.getEndTime(),
                request.getExecType() == null ? null : request.getExecType().getExecTypeId(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getPreUpgradeTransaction(PreUpgradeDataRequest request) {
        return executeSync(bybitApiService.getPreUpgradeTransaction(
                request.getCategory().getProductTypeId(),
                request.getBaseCoin(),
                request.getTransactionType() == null ? null : request.getTransactionType().getTransactionTypeId(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getPreUpgradeOptionDelivery(PreUpgradeDataRequest request) {
        return executeSync(bybitApiService.getPreUpgradeOptionDelivery(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getExpDate(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getPreUpgradeUsdcSettlement(PreUpgradeDataRequest request) {
        return executeSync(bybitApiService.getPreUpgradeUsdcSettlement(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    // Account endpoints
    @Override
    public Object getWalletBalance(AccountDataRequest walletBalanceRequest) {
        return executeSync(bybitApiService.getWalletBalance(
                walletBalanceRequest.getAccountType().getAccountTypeValue(),
                walletBalanceRequest.getCoins()
        ));
    }

    @Override
    public Object upgradeAccountToUTA() {
        return executeSync(bybitApiService.upgradeAccountToUTA());
    }

    @Override
    public Object getAccountBorrowHistory(AccountDataRequest borrowHistoryRequest) {
        return executeSync(bybitApiService.getAccountBorrowHistory(
                borrowHistoryRequest.getCurrency(),
                borrowHistoryRequest.getStartTime(),
                borrowHistoryRequest.getEndTime(),
                borrowHistoryRequest.getLimit(),
                borrowHistoryRequest.getCursor()
        ));
    }

    @Override
    public Object setAccountCollateralCoin(AccountDataRequest setCollateralCoinRequest) {
        var request = converter.mapToSetCollateralCoinRequest(setCollateralCoinRequest);
        return executeSync(bybitApiService.setAccountCollateralCoin(request));
    }

    @Override
    public Object getAccountCollateralInfo(AccountDataRequest request) {
        return executeSync((bybitApiService.getAccountCollateralInfo(
                request.getCurrency()
        )));
    }

    @Override
    public Object getAccountCoinGeeks(AccountDataRequest request) {
        return executeSync((bybitApiService.getAccountCoinGeeks(request.getBaseCoin())));
    }

    @Override
    public Object getAccountFreeRate(AccountDataRequest getFeeRateRequest) {
        return executeSync(bybitApiService.getAccountFreeRate(
                getFeeRateRequest.getCategory().getProductTypeId(),
                getFeeRateRequest.getSymbol(),
                getFeeRateRequest.getBaseCoin()
        ));
    }


    @Override
    public Object getAccountInfo() {
        return executeSync(bybitApiService.getAccountInfo());
    }

    @Override
    public Object getTransactionLog(AccountDataRequest getTransactionLogRequest) {
        return executeSync(bybitApiService.getTransactionLog(
                getTransactionLogRequest.getAccountType() == null ? null : getTransactionLogRequest.getAccountType().getAccountTypeValue(),
                getTransactionLogRequest.getCategory() == null ? null : getTransactionLogRequest.getCategory().getProductTypeId(),
                getTransactionLogRequest.getCurrency(),
                getTransactionLogRequest.getBaseCoin(),
                getTransactionLogRequest.getTransactionType() == null ? null : getTransactionLogRequest.getTransactionType().getTransactionTypeId(),
                getTransactionLogRequest.getStartTime(),
                getTransactionLogRequest.getEndTime(),
                getTransactionLogRequest.getLimit(),
                getTransactionLogRequest.getCursor()
        ));
    }


    @Override
    public Object setAccountMarginMode(AccountDataRequest setMarginMode) {
        var request = converter.mapToSetMarginModeRequest(setMarginMode);
        return executeSync(bybitApiService.setAccountMarginMode(request));
    }

    @Override
    public Object modifyAccountMMP(AccountDataRequest setMMPRequest) {
        var request = converter.mapToSetMMPRequest(setMMPRequest);
        return executeSync(bybitApiService.modifyAccountMMP(request));
    }

    @Override
    public Object resetAccountMMP(AccountDataRequest request) {
        var resetMMPRequest = converter.mapToResetMarginModeRequest(request);
        return executeSync(bybitApiService.resetAccountMMP(resetMMPRequest));
    }

    @Override
    public Object getAccountMMPState(AccountDataRequest request) {
        return executeSync(bybitApiService.getAccountMMPState(request.getBaseCoin()));
    }

    // Spots
    // Spot Leverage endpoints
    @Override
    public Object getSpotLeverageTokenInfo(String ltCoin) {
        return executeSync(bybitApiService.getSpotLeverageTokenInfo(ltCoin));
    }

    @Override
    public Object getSpotLeverageTokenInfo() {
        return executeSync(bybitApiService.getSpotLeverageTokenInfo());
    }

    @Override
    public Object getSpotLeverageTokenMarket(String ltCoin) {
        return executeSync(bybitApiService.getSpotLeverageTokenMarket(ltCoin));
    }

    @Override
    public Object getSpotLeverageTokenMarket() {
        return executeSync(bybitApiService.getSpotLeverageTokenMarket());
    }

    @Override
    public Object purchaseSpotLeverageToken(SpotLeverageTokenRequest spotLeverageTokenRequest) {
        return executeSync(bybitApiService.purchaseSpotLeverageToken(spotLeverageTokenRequest));
    }

    @Override
    public Object redeemSpotLeverageToken(SpotLeverageTokenRequest spotLeverageTokenRequest) {
        return executeSync(bybitApiService.redeemSpotLeverageToken(spotLeverageTokenRequest));
    }

    @Override
    public Object getSpotLeverageRecords(SpotLeverageOrdersRecordRequest spotLeverageOrdersRecordRequest) {
        return executeSync(bybitApiService.getSpotLeverageRecords(
                spotLeverageOrdersRecordRequest.getLtCoin(),
                spotLeverageOrdersRecordRequest.getOrderId(),
                spotLeverageOrdersRecordRequest.getStartTime(),
                spotLeverageOrdersRecordRequest.getEndTime(),
                spotLeverageOrdersRecordRequest.getLimit(),
                spotLeverageOrdersRecordRequest.getLtOrderType(),
                spotLeverageOrdersRecordRequest.getSerialNo()));
    }


    // Spot Margin UTA
    @Override
    public Object getUtaVipSpotMarginTradeData(VIPMarginDataRequest utaMarginDataRequest) {
        return executeSync(bybitApiService.getUtaVipSpotMarginTradeData(
                utaMarginDataRequest.getVipLevel() == null ? null : utaMarginDataRequest.getVipLevel().getLevel(),
                utaMarginDataRequest.getCurrency())
        );
    }

    @Override
    public Object setUTASpotMarginTrade(String spotMarginMode) {
        return executeSync(bybitApiService.setUTASpotMarginTrade(spotMarginMode));
    }

    @Override
    public Object setUTASpotMarginTradeLeverage(String leverage) {
        return executeSync(bybitApiService.setUTASpotMarginTradeLeverage(leverage));
    }

    @Override
    public Object getUTASpotMarginTradeLeverageState() {
        return executeSync(bybitApiService.getUTASpotMarginTradeLeverageState());
    }

    // Spot Margin Normal
    @Override
    public Object getNormalVipSpotMarginTradeData(VIPMarginDataRequest normalMarginDataRequest) {
        return executeSync(bybitApiService.getNormalVipSpotMarginTradeData(
                normalMarginDataRequest.getVipLevel() == null ? null : normalMarginDataRequest.getVipLevel().getLevel(),
                normalMarginDataRequest.getCurrency())
        );
    }

    @Override
    public Object getNormalSpotMarginTradeCoinInfo(String coin) {
        return executeSync(bybitApiService.getNormalSpotMarginTradeCoinInfo(coin));
    }

    @Override
    public Object getNormalSpotMarginTradeCoinInfo() {
        return executeSync(bybitApiService.getNormalSpotMarginTradeCoinInfo());
    }

    @Override
    public Object getNormalSpotMarginTradeBorrowCoinInfo(String coin) {
        return executeSync(bybitApiService.getNormalSpotMarginTradeBorrowCoinInfo(coin));
    }

    @Override
    public Object getNormalSpotMarginTradeBorrowCoinInfo() {
        return executeSync(bybitApiService.getNormalSpotMarginTradeBorrowCoinInfo());
    }

    @Override
    public Object getNormalSpotMarginTradeInterestQuota(String coin) {
        return executeSync(bybitApiService.getNormalSpotMarginTradeInterestQuota(coin));
    }

    @Override
    public Object getNormalSpotMarginTradeAccountInfo() {
        return executeSync(bybitApiService.getNormalSpotMarginTradeAccountInfo());
    }

    @Override
    public Object getNormalSpotToggleMarginTrade(int switchStatus) {
        return executeSync(bybitApiService.getNormalSpotToggleMarginTrade(switchStatus));
    }

    @Override
    public Object loanNormalSpotMarginTrade(SpotMarginTradeBorrowRequest spotMarginTradeBorrowRequest) {
        return executeSync(bybitApiService.loanNormalSpotMarginTrade(spotMarginTradeBorrowRequest));
    }

    @Override
    public Object repayNormalSpotMarginTrade(SpotMarginTradeRePayRequest spotMarginTradeRePayRequest) {
        return executeSync(bybitApiService.repayNormalSpotMarginTrade(spotMarginTradeRePayRequest));
    }

    @Override
    public Object getNormalSpotMarginTradeBorrowOrders(SpotMarginTradeBorrowOrdersRequest spotMarginTradeBorrowOrdersRequest) {
        return executeSync(bybitApiService.getNormalMarginTradeBorrowOrders(
                spotMarginTradeBorrowOrdersRequest.getStartTime(),
                spotMarginTradeBorrowOrdersRequest.getEndTime(),
                spotMarginTradeBorrowOrdersRequest.getCoin(),
                spotMarginTradeBorrowOrdersRequest.getStatus(),
                spotMarginTradeBorrowOrdersRequest.getLimit()
        ));
    }

    @Override
    public Object getNormalSpotMarginTradeRepayOrders(SpotMarginTradeRepayOrdersRequest spotMarginTradeRepayOrdersRequest) {
        return executeSync(bybitApiService.getNormalMarginTradeRepayOrders(
                spotMarginTradeRepayOrdersRequest.getStartTime(),
                spotMarginTradeRepayOrdersRequest.getEndTime(),
                spotMarginTradeRepayOrdersRequest.getCoin(),
                spotMarginTradeRepayOrdersRequest.getLimit()
        ));
    }

    // Broker

    @Override
    public Object getBrokerEarningData(BrokerEarningRequest brokerEarningRequest) {
        return executeSync(bybitApiService.getBrokerEarningData(
                brokerEarningRequest.getBizType() == null ? null : brokerEarningRequest.getBizType().getType(),
                brokerEarningRequest.getStartTime(),
                brokerEarningRequest.getEndTime(),
                brokerEarningRequest.getLimit(),
                brokerEarningRequest.getCursor()
        ));
    }

    // C2C Endpoints
    @Override
    public Object getC2CLendingCoinInfo(String coin) {
        return executeSync(bybitApiService.getC2CLendingCoinInfo(coin));
    }

    @Override
    public Object getC2CLendingCoinInfo() {
        return executeSync(bybitApiService.getC2CLendingCoinInfo());
    }

    @Override
    public Object C2cLendingDepositFunds(ClientLendingFundsRequest depsoitFundRequest) {
        return executeSync(bybitApiService.C2cLendingDepositFunds(depsoitFundRequest));
    }

    @Override
    public Object C2cLendingRedeemFunds(ClientLendingFundsRequest depsoitFundRequest) {
        return executeSync(bybitApiService.C2cLendingRedeemFunds(depsoitFundRequest));
    }

    @Override
    public Object getC2cOrdersRecords(ClientLendingOrderRecordsRequest c2cOrdersRecordsRequest) {
        return executeSync(bybitApiService.getC2cOrdersRecords(
                c2cOrdersRecordsRequest.getCoin(),
                c2cOrdersRecordsRequest.getOrderId(),
                c2cOrdersRecordsRequest.getStartTime(),
                c2cOrdersRecordsRequest.getEndTime(),
                c2cOrdersRecordsRequest.getLimit(),
                c2cOrdersRecordsRequest.getOrderType()));
    }

    @Override
    public Object getC2CLendingAccountInfo(String coin) {
        return executeSync(bybitApiService.getC2CLendingAccountInfo(coin));
    }

    // Asset Endpoints
    @Override
    public Object getAssetCoinExchangeRecords(AssetDataRequest coinExchangeRecordsRequest) {
        return executeSync(bybitApiService.getAssetCoinExchangeRecords(
                coinExchangeRecordsRequest.getFromCoin(),
                coinExchangeRecordsRequest.getToCoin(),
                coinExchangeRecordsRequest.getLimit(),
                coinExchangeRecordsRequest.getCursor()
        ));
    }

    @Override
    public Object getAssetDeliveryRecords(AssetDataRequest deliveryRecordsRequest) {
        return executeSync(bybitApiService.getAssetDeliveryRecords(
                deliveryRecordsRequest.getCategory() == null ? null : deliveryRecordsRequest.getCategory().getProductTypeId(),
                deliveryRecordsRequest.getSymbol(),
                deliveryRecordsRequest.getExpDate(),
                deliveryRecordsRequest.getLimit(),
                deliveryRecordsRequest.getCursor())
        );
    }

    @Override
    public Object getAssetUSDCSettlementRecords(AssetDataRequest usdcSettlementRequest) {
        return executeSync(bybitApiService.getAssetUSDCSettlementRecords(
                usdcSettlementRequest.getCategory() == null ? null : usdcSettlementRequest.getCategory().getProductTypeId(),
                usdcSettlementRequest.getSymbol(),
                usdcSettlementRequest.getLimit(),
                usdcSettlementRequest.getCursor())
        );
    }

    @Override
    public Object getAssetInfo(AssetDataRequest assetInfoRequest) {
        return executeSync(bybitApiService.getAssetInfo(
                assetInfoRequest.getAccountType() == null ? null : assetInfoRequest.getAccountType().getAccountTypeValue(),
                assetInfoRequest.getCoin())
        );
    }

    @Override
    public Object getAssetAllCoinsBalance(AssetDataRequest allCoinsBalanceRequest) {
        return executeSync(bybitApiService.getAssetAllCoinsBalance(
                allCoinsBalanceRequest.getAccountType() == null ? null : allCoinsBalanceRequest.getAccountType().getAccountTypeValue(),
                allCoinsBalanceRequest.getMemberId(),
                allCoinsBalanceRequest.getCoin(),
                allCoinsBalanceRequest.getWithBonus() == null ? null : String.valueOf(allCoinsBalanceRequest.getWithBonus().getValue()))
        );
    }

    @Override
    public Object getAssetTransferableCoins(AssetDataRequest request) {
        return executeSync(bybitApiService.getAssetTransferableCoins(
                request.getFromAccountType() == null ? null : request.getFromAccountType().getAccountTypeValue(),
                request.getToAccountType() == null ? null : request.getToAccountType().getAccountTypeValue()));
    }

    @Override
    public Object getAssetSingleCoinBalance(AssetDataRequest singleCoinBalanceRequest) {
        return executeSync(bybitApiService.getAssetSingleCoinBalance(
                singleCoinBalanceRequest.getAccountType() == null ? null : singleCoinBalanceRequest.getAccountType().getAccountTypeValue(),
                singleCoinBalanceRequest.getToAccountType() == null ? null : singleCoinBalanceRequest.getToAccountType().getAccountTypeValue(),
                singleCoinBalanceRequest.getMemberId(),
                singleCoinBalanceRequest.getToMemberId() == null ? null : singleCoinBalanceRequest.getToMemberId().toString(),
                singleCoinBalanceRequest.getCoin(),
                singleCoinBalanceRequest.getWithBonus() == null ? null : singleCoinBalanceRequest.getWithBonus().getValue(),
                singleCoinBalanceRequest.getWithTransferSafeAmount() == null ? null : singleCoinBalanceRequest.getWithTransferSafeAmount().getValue(),
                singleCoinBalanceRequest.getWithLtvTransferSafeAmount() == null ? null : singleCoinBalanceRequest.getWithLtvTransferSafeAmount().getValue())
        );
    }

    @Override
    public Object createAssetInternalTransfer(AssetDataRequest assetInternalTransferRequest) {
        var request = converter.mapToAssetInternalTransferRequest(assetInternalTransferRequest);
        return executeSync(bybitApiService.createAssetInternalTransfer(request));
    }

    @Override
    public Object getAssetTransferSubUidList() {
        return executeSync(bybitApiService.getAssetTransferSubUidList());
    }

    @Override
    public Object createAssetUniversalTransfer(AssetDataRequest assetUniversalTransferRequest) {
        var request = converter.mapToAssetUniversalTransferRequest(assetUniversalTransferRequest);
        return executeSync(bybitApiService.createAssetUniversalTransfer(request));
    }

    @Override
    public Object getAssetInternalTransferRecords(AssetDataRequest internalTransferRequest) {
        return executeSync(bybitApiService.getAssetInternalTransferRecords(
                internalTransferRequest.getTransferId(),
                internalTransferRequest.getCoin(),
                internalTransferRequest.getTransferStatus() == null ? null : internalTransferRequest.getTransferStatus().getStatus(),
                internalTransferRequest.getStartTime(),
                internalTransferRequest.getEndTime(),
                internalTransferRequest.getLimit(),
                internalTransferRequest.getCursor())
        );
    }

    @Override
    public Object getAssetUniversalTransferRecords(AssetDataRequest universalTransferRequest) {
        return executeSync(bybitApiService.getAssetUniversalTransferRecords(
                universalTransferRequest.getTransferId(),
                universalTransferRequest.getCoin(),
                universalTransferRequest.getTransferStatus() == null ? null : universalTransferRequest.getTransferStatus().getStatus(),
                universalTransferRequest.getStartTime(),
                universalTransferRequest.getEndTime(),
                universalTransferRequest.getLimit(),
                universalTransferRequest.getCursor())
        );
    }

    @Override
    public Object getAssetAllowedDepositCoinInfo(AssetDataRequest allowedDepositCoinRequest) {
        return executeSync(bybitApiService.getAssetAllowedDepositCoinInfo(
                allowedDepositCoinRequest.getCoin(),
                allowedDepositCoinRequest.getChain(),
                allowedDepositCoinRequest.getLimit(),
                allowedDepositCoinRequest.getCursor())
        );
    }

    @Override
    public Object setAssetDepositAccount(AssetDataRequest request) {
        SetAssetDepositAccountRequest setAssetDepositAccountRequest = converter.mapToSetDepositAccountRequest(request);
        return executeSync(bybitApiService.setAssetDepositAccount(setAssetDepositAccountRequest));
    }

    @Override
    public Object getAssetDepositRecords(AssetDataRequest assetDepositRecordsRequest) {
        return executeSync(bybitApiService.getAssetDepositRecords(
                assetDepositRecordsRequest.getCoin(),
                assetDepositRecordsRequest.getStartTime(),
                assetDepositRecordsRequest.getEndTime(),
                assetDepositRecordsRequest.getLimit(),
                assetDepositRecordsRequest.getCursor())
        );
    }

    @Override
    public Object getAssetSubMembersDepositRecords(AssetDataRequest assetDepositRecordsRequest) {
        return executeSync(bybitApiService.getAssetSubMembersDepositRecords(
                assetDepositRecordsRequest.getSubMemberId(),
                assetDepositRecordsRequest.getCoin(),
                assetDepositRecordsRequest.getStartTime(),
                assetDepositRecordsRequest.getEndTime(),
                assetDepositRecordsRequest.getLimit(),
                assetDepositRecordsRequest.getCursor())
        );
    }

    @Override
    public Object getAssetInternalDepositRecords(AssetDataRequest assetDepositRecordsRequest) {
        return executeSync(bybitApiService.getAssetInternalDepositRecords(
                assetDepositRecordsRequest.getCoin(),
                assetDepositRecordsRequest.getStartTime(),
                assetDepositRecordsRequest.getEndTime(),
                assetDepositRecordsRequest.getLimit(),
                assetDepositRecordsRequest.getCursor())
        );
    }

    @Override
    public Object getAssetMasterDepositAddress(AssetDataRequest masterDepositRequest) {
        return executeSync(bybitApiService.getAssetMasterDepositAddress(
                masterDepositRequest.getCoin(),
                masterDepositRequest.getChainType()
        ));
    }

    @Override
    public Object getAssetSubMemberDepositAddress(AssetDataRequest subDepositRequest) {
        return executeSync(bybitApiService.getAssetSubMemberDepositAddress(
                subDepositRequest.getCoin(),
                subDepositRequest.getChainType(),
                subDepositRequest.getSubMemberId()
        ));
    }

    @Override
    public Object getAssetCoinInfo(AssetDataRequest request) {
        return executeSync(bybitApiService.getAssetCoinInfo(request.getCoin()));
    }

    @Override
    public Object getAssetWithdrawalAmount(AssetDataRequest request) {
        return executeSync(bybitApiService.getAssetWithdrawalAmount(request.getCoin()));
    }

    @Override
    public Object getAssetWithdrawalRecords(AssetDataRequest assetWithdrawRecordsRequest) {
        return executeSync(bybitApiService.getAssetWithdrawalRecords(
                assetWithdrawRecordsRequest.getWithdrawID(),
                assetWithdrawRecordsRequest.getCoin(),
                assetWithdrawRecordsRequest.getWithdrawType() == null ? null : assetWithdrawRecordsRequest.getWithdrawType().getValue(),
                assetWithdrawRecordsRequest.getStartTime(),
                assetWithdrawRecordsRequest.getEndTime(),
                assetWithdrawRecordsRequest.getLimit(),
                assetWithdrawRecordsRequest.getCursor()
        ));
    }

    @Override
    public Object cancelAssetWithdraw(AssetDataRequest request) {
        AssetCancelWithdrawRequest assetCancelWithdrawRequest = converter.mapToAssetCancelWithdrawRequest(request);
        return executeSync(bybitApiService.cancelAssetWithdraw(assetCancelWithdrawRequest));
    }

    @Override
    public Object createAssetWithdraw(AssetDataRequest assetWithdrawRequest) {
        var request = converter.mapToAssetWithdrawRequest(assetWithdrawRequest);
        return executeSync(bybitApiService.createAssetWithdraw(request));
    }
}
