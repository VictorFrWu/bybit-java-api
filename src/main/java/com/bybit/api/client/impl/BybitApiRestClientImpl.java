package com.bybit.api.client.impl;

import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.account.institution.InstitutionLoanOrdersRequest;
import com.bybit.api.client.domain.account.institution.InstitutionRepayOrdersRequest;
import com.bybit.api.client.domain.account.request.*;
import com.bybit.api.client.domain.asset.request.*;
import com.bybit.api.client.domain.broker.request.BrokerEarningRequest;
import com.bybit.api.client.domain.c2c.ClientLendingFundsRequest;
import com.bybit.api.client.domain.c2c.ClientLendingOrderRecordsRequest;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.request.*;
import com.bybit.api.client.domain.position.request.*;
import com.bybit.api.client.domain.preupgrade.request.*;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageOrdersRecordRequest;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageTokenRequest;
import com.bybit.api.client.domain.spot.marginTrade.*;
import com.bybit.api.client.domain.trade.requests.*;
import com.bybit.api.client.domain.user.request.ApiKeyRequest;
import com.bybit.api.client.domain.user.request.FreezeSubUIDRquest;
import com.bybit.api.client.domain.user.request.SubUserRequest;
import com.bybit.api.client.service.BybitApiService;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

/**
 * Implementation of Bybit's REST API using Retrofit with synchronous/blocking
 * method calls.
 */
public class BybitApiRestClientImpl implements BybitApiRestClient {
    private final BybitApiService bybitApiService;

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
    public Object getMarketLinesData(ProductType category, String symbol, MarketInterval interval, Integer limit, Long startTime, Long endTime) {
        return executeSync(
                bybitApiService.getMarketLinesData(category.getProductTypeId(), symbol, interval.getIntervalId(), limit, startTime, endTime));
    }

    @Override
    public Object getMarketLinesData(ProductType category, String symbol, MarketInterval interval) {
        return getMarketLinesData(category, symbol, interval, null, null, null);
    }

    @Override
    public Object getMarketPriceLinesData(ProductType category, String symbol, MarketInterval interval, Integer limit, Long startTime, Long endTime) {
        return executeSync(
                bybitApiService.getMarketPriceLinesData(category.getProductTypeId(), symbol, interval.getIntervalId(), limit, startTime, endTime));
    }

    @Override
    public Object getMarketPriceLinesData(ProductType category, String symbol, MarketInterval interval) {
        return getMarketPriceLinesData(category, symbol, interval, null, null, null);
    }

    @Override
    public Object getIndexPriceLinesData(ProductType category, String symbol, MarketInterval interval, Integer limit, Long startTime, Long endTime) {
        return executeSync(
                bybitApiService.getIndexPriceLinesData(category.getProductTypeId(), symbol, interval.getIntervalId(), limit, startTime, endTime));
    }

    @Override
    public Object getIndexPriceLinesData(ProductType category, String symbol, MarketInterval interval) {
        return getIndexPriceLinesData(category, symbol, interval, null, null, null);
    }

    @Override
    public Object getPremiumIndexPriceLinesData(ProductType category, String symbol, MarketInterval interval, Integer limit, Long startTime, Long endTime) {
        return executeSync(
                bybitApiService.getPremiumIndexPriceLinesData(category.getProductTypeId(), symbol, interval.getIntervalId(), limit, startTime, endTime));
    }


    @Override
    public Object getPremiumIndexPriceLinesData(ProductType category, String symbol, MarketInterval interval) {
        return getPremiumIndexPriceLinesData(category, symbol, interval, null, null, null);
    }

    @Override
    public Object getInstrumentsInfo(InstrumentInfoRequest instrumentInfoRequest) {
        return executeSync(bybitApiService.getInstrumentsInfo(
                instrumentInfoRequest.getCategory().getProductTypeId(),
                instrumentInfoRequest.getSymbol(),
                instrumentInfoRequest.getStatus(),
                instrumentInfoRequest.getBaseCoin(),
                instrumentInfoRequest.getLimit(),
                instrumentInfoRequest.getCursor()
        ));
    }

    @Override
    public Object getMarketOrderbook(ProductType category, String symbol) {
        return executeSync(bybitApiService.getMarketOrderbook(
                category.getProductTypeId(), symbol
        ));
    }

    @Override
    public Object getMarketOrderbook(ProductType category, String symbol, Integer limit) {
        return executeSync(bybitApiService.getMarketOrderbook(
                category.getProductTypeId(), symbol, limit
        ));
    }

    @Override
    public Object getMarketTickers(ProductType category, String symbol) {
        return executeSync(bybitApiService.getMarketTickers(
                category.getProductTypeId(), symbol
        ));
    }

    @Override
    public Object getMarketTickers(ProductType category, String symbol, String baseCoin, String expDate) {
        return executeSync(bybitApiService.getMarketTickers(
                category.getProductTypeId(), symbol, baseCoin, expDate
        ));
    }

    @Override
    public Object getFundingHistory(FundingHistoryRequest fundingHistoryRequest) {
        return executeSync(bybitApiService.getFundingHistory(
                fundingHistoryRequest.getCategory().getProductTypeId(),
                fundingHistoryRequest.getSymbol(),
                fundingHistoryRequest.getStartTime(),
                fundingHistoryRequest.getEndTime(),
                fundingHistoryRequest.getLimit()
        ));
    }

    @Override
    public Object getRecentTradeData(RecentTradeDataRequest recentTradeRequest) {
        return executeSync(bybitApiService.getRecentTradeData(
                recentTradeRequest.getCategory().getProductTypeId(),
                recentTradeRequest.getBaseCoin(),
                recentTradeRequest.getOptionType(),
                recentTradeRequest.getSymbol(),
                recentTradeRequest.getLimit()
        ));
    }

    @Override
    public Object getOpenInterest(OpenInterestRequest openInterestRequest) {
        return executeSync(bybitApiService.getOpenInterest(
                openInterestRequest.getCategory().getProductTypeId(),
                openInterestRequest.getSymbol(),
                openInterestRequest.getIntervalTime(),
                openInterestRequest.getStartTime(),
                openInterestRequest.getEndTime(),
                openInterestRequest.getLimit(),
                openInterestRequest.getCursor()
        ));
    }

    @Override
    public Object getHistoricalVolatility(HistoricalVolatilityRequest historicalVolatilityRequest) {
        return executeSync(bybitApiService.getHistoricalVolatility(
                historicalVolatilityRequest.getCategory().getProductTypeId(),
                historicalVolatilityRequest.getBaseCoin(),
                historicalVolatilityRequest.getPeriod(),
                historicalVolatilityRequest.getStartTime(),
                historicalVolatilityRequest.getEndTime())
        );
    }

    @Override
    public Object getHistoryOrderResult(OrderHistoryRequest orderHistoryRequest) {
        return executeSync(bybitApiService.getHistoryOrderResult(
                orderHistoryRequest.getCategory().getProductTypeId(),
                orderHistoryRequest.getSymbol(),
                orderHistoryRequest.getBaseCoin(),
                orderHistoryRequest.getSettleCoin(),
                orderHistoryRequest.getOrderId(),
                orderHistoryRequest.getOrderLinkId(),
                orderHistoryRequest.getOrderFilter(),
                orderHistoryRequest.getOrderStatus(),
                orderHistoryRequest.getStartTime(),
                orderHistoryRequest.getEndTime(),
                orderHistoryRequest.getLimit(),
                orderHistoryRequest.getCursor()));
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
    public Object getRiskLimit(ProductType category) {
        return executeSync(bybitApiService.getRiskLimit(category.getProductTypeId()));
    }

    @Override
    public Object getRiskLimit(ProductType category, String symbol) {
        return executeSync(bybitApiService.getRiskLimit(category.getProductTypeId(), symbol));
    }

    @Override
    public Object getDeliveryPrice(DeliveryPriceRequest deliveryPriceRequest) {
        return executeSync(bybitApiService.getDeliveryPrice(deliveryPriceRequest.getCategory().getProductTypeId(),
                deliveryPriceRequest.getSymbol(),
                deliveryPriceRequest.getBaseCoin(),
                deliveryPriceRequest.getLimit(),
                deliveryPriceRequest.getCursor()
        ));
    }

    // Trade Data endpoints
    @Override
    public Object newOrder(NewOrderRequest order) {
        return executeSync(bybitApiService.newOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getIsLeverage(),
                order.getSide(),
                order.getOrderType(),
                order.getQty(),
                order.getPrice(),
                order.getTriggerDirection(),
                order.getOrderFilter(),
                order.getTriggerPrice(),
                order.getTriggerBy(),
                order.getOrderIv(),
                order.getTimeInForce(),
                order.getPositionIdx(),
                order.getOrderLinkId(),
                order.getTakeProfit(),
                order.getStopLoss(),
                order.getTpTriggerBy(),
                order.getSlTriggerBy(),
                order.getReduceOnly(),
                order.getCloseOnTrigger(),
                order.getSmpType(),
                order.getMmp(),
                order.getTpslMode(),
                order.getTpLimitPrice(),
                order.getSlLimitPrice(),
                order.getTpOrderType(),
                order.getSlOrderType()
        ));
    }

    @Override
    public Object amendOrder(AmendOrderRequest order) {
        return executeSync(bybitApiService.amendOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOrderIv(),
                order.getTriggerPrice(),
                order.getQty(),
                order.getPrice(),
                order.getTakeProfit(),
                order.getStopLoss(),
                order.getTpTriggerBy(),
                order.getSlTriggerBy(),
                order.getTriggerBy(),
                order.getTpLimitPrice(),
                order.getSlLimitPrice()
        ));
    }

    @Override
    public Object cancelOrder(CancelOrderRequest order) {
        return executeSync(bybitApiService.cancelOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOrderFilter()
        ));
    }

    @Override
    public Object getOpenOrders(OpenOrderRequest order) {
        return executeSync(bybitApiService.getOpenOrders(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getBaseCoin(),
                order.getSettleCoin(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOpenOnly(),
                order.getOrderFilter(),
                order.getLimit(),
                order.getCursor()
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
    public Object createSubMember(SubUserRequest subUserRequest) {
        return executeSync(bybitApiService.createSubMember(
                subUserRequest.getUsername(),
                subUserRequest.getPassword(),
                subUserRequest.getMemberType(),
                subUserRequest.getSwitchOption(),
                subUserRequest.getIsUta(),
                subUserRequest.getNote()
        ));
    }

    @Override
    public Object createSubAPI(ApiKeyRequest apiKeyRequest) {
        return executeSync(bybitApiService.createSubAPI(apiKeyRequest));
    }

    @Override
    public Object freezeSubMember(FreezeSubUIDRquest freezeSubUIDRquest) {
        return executeSync(bybitApiService.freezeSubMember(freezeSubUIDRquest));
    }

    @Override
    public Object getUIDWalletType(String memberIds) {
        return executeSync(bybitApiService.getUIDWalletType(memberIds));
    }

    @Override
    public Object getUIDWalletType() {
        return executeSync(bybitApiService.getUIDWalletType());
    }

    @Override
    public Object getAffiliateUserInfo(String uid) {
        return executeSync(bybitApiService.getAffiliateUserInfo(uid));
    }


    // Position endpoints

    @Override
    public Object getPositionInfo(PositionListRequest positionListRequest) {
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
    public Object setPositionLeverage(SetLeverageRequest setLeverageRequest) {
        return executeSync(bybitApiService.setPositionLeverage(setLeverageRequest));
    }

    @Override
    public Object swithMarginRequest(SwitchMarginRequest switchMarginRequest) {
        return executeSync(bybitApiService.swithMarginRequest(switchMarginRequest));
    }

    @Override
    public Object switchPositionMode(SwitchPositionModeRequest switchPositionModeRequest) {
        return executeSync(bybitApiService.switchPositionMode(switchPositionModeRequest));
    }

    @Override
    public Object setTpslMode(SetTpSlModeRequest setTpSlModeRequest) {
        return executeSync(bybitApiService.setTpslMode(setTpSlModeRequest));
    }

    @Override
    public Object setRiskLimit(SetRiskLimitRequest setRiskLimitRequest) {
        return executeSync(bybitApiService.setRiskLimit(setRiskLimitRequest));
    }

    @Override
    public Object setTradingStop(TradingStopRequest tradingStopRequest) {
        return executeSync(bybitApiService.setTradingStop(tradingStopRequest));
    }

    @Override
    public Object setAutoAddMargin(SetAutoAddMarginRequest setAutoAddMarginRequest) {
        return executeSync(bybitApiService.setAutoAddMargin(setAutoAddMarginRequest));
    }

    @Override
    public Object modifyPositionMargin(ModifyMarginRequest modifyMarginRequest) {
        return executeSync(bybitApiService.modifyPositionMargin(modifyMarginRequest));
    }

    @Override
    public Object getExecutionList(ExecutionHistoryRequest executionHistoryRequest) {
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
    public Object getClosePnlList(ClosePnlHistoryRequest closePnlHistoryRequest) {
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
    public Object getPreUpgradeClosePnl(PreUpgradeClosePnlRequest request) {
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
    public Object getPreUpgradeOrderHistory(PreUpgradeOrderHistoryRequest request) {
        return executeSync(bybitApiService.getPreUpgradeOrderHistory(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getBaseCoin(),
                request.getOrderId(),
                request.getOrderLinkId(),
                request.getOrderFilter(),
                request.getOrderStatus(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getPreUpgradeTradeHistory(PreUpgradeTradeHistoryRequest request) {
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
    public Object getPreUpgradeTransaction(PreUpgradeTransactionRequest request) {
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
    public Object getPreUpgradeOptionDelivery(PreUpgradeOptionDeliveryRequest request) {
        return executeSync(bybitApiService.getPreUpgradeOptionDelivery(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getExpDate(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getPreUpgradeUsdcSettlement(PreUpgradeUsdcSettlementRequest request) {
        return executeSync(bybitApiService.getPreUpgradeUsdcSettlement(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    // Account endpoints
    @Override
    public Object getWalletBalance(WalletBalanceRequest walletBalanceRequest) {
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
    public Object getAccountBorrowHistory(BorrowHistoryRequest borrowHistoryRequest) {
        return executeSync(bybitApiService.getAccountBorrowHistory(
                borrowHistoryRequest.getCurrency(),
                borrowHistoryRequest.getStartTime(),
                borrowHistoryRequest.getEndTime(),
                borrowHistoryRequest.getLimit(),
                borrowHistoryRequest.getCursor()
        ));
    }

    @Override
    public Object setAccountCollateralCoin(SetCollateralCoinRequest setCollateralCoinRequest) {
        return executeSync(bybitApiService.setAccountCollateralCoin(setCollateralCoinRequest));
    }

    @Override
    public Object getAccountCollateralInfo(String currency) {
        return executeSync((bybitApiService.getAccountCollateralInfo(currency)));
    }

    @Override
    public Object getAccountCollateralInfo() {
        return executeSync((bybitApiService.getAccountCollateralInfo()));
    }

    @Override
    public Object getAccountCoinGeeks(String baseCoin) {
        return executeSync((bybitApiService.getAccountCoinGeeks(baseCoin)));
    }

    @Override
    public Object getAccountCoinGeeks() {
        return executeSync((bybitApiService.getAccountCoinGeeks()));
    }

    @Override
    public Object getAccountFreeRate(GetFeeRateRequest getFeeRateRequest) {
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
    public Object getTransactionLog(GetTransactionLogRequest getTransactionLogRequest) {
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
    public Object setAccountMarginMode(String setMarginMode) {
        return executeSync(bybitApiService.setAccountMarginMode(setMarginMode));
    }

    @Override
    public Object modifyAccountMMP(SetMMPRequest setMMPRequest) {
        return executeSync(bybitApiService.modifyAccountMMP(setMMPRequest));
    }

    @Override
    public Object resetAccountMMP(String baseCoin) {
        return executeSync(bybitApiService.resetAccountMMP(baseCoin));
    }

    @Override
    public Object getAccountMMPState(String baseCoin) {
        return executeSync(bybitApiService.getAccountMMPState(baseCoin));
    }

    // Institution endpoints
    @Override
    public Object getInsProductInfo(String productId) {
        return executeSync(bybitApiService.getInsProductInfo(productId));
    }

    @Override
    public Object getInsProductInfo() {
        return executeSync(bybitApiService.getInsProductInfo());
    }

    @Override
    public Object getInsMarginCoinInfo(String productId) {
        return executeSync(bybitApiService.getInsMarginCoinInfo(productId));
    }

    @Override
    public Object getInsMarginCoinInfo() {
        return executeSync(bybitApiService.getInsMarginCoinInfo());
    }

    @Override
    public Object getInsLoanOrders(InstitutionLoanOrdersRequest institutionLoanOrdersRequest) {
        return executeSync(bybitApiService.getInsLoanOrders(institutionLoanOrdersRequest.getOrderId(),
                institutionLoanOrdersRequest.getStartTime(),
                institutionLoanOrdersRequest.getEndTime(),
                institutionLoanOrdersRequest.getLimit()));
    }

    @Override
    public Object getInsRepayOrders(InstitutionRepayOrdersRequest institutionRepayOrdersRequest) {
        return executeSync(bybitApiService.getInsRepayOrders(institutionRepayOrdersRequest.getStartTime(),
                institutionRepayOrdersRequest.getEndTime(),
                institutionRepayOrdersRequest.getLimit()));
    }

    @Override
    public Object getInsLoanToValue() {
        return executeSync(bybitApiService.getInsLoanToValue());
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
    public Object getAssetCoinExchangeRecords(CoinExchangeRecordsRequest coinExchangeRecordsRequest) {
        return executeSync(bybitApiService.getAssetCoinExchangeRecords(
                coinExchangeRecordsRequest.getFromCoin(),
                coinExchangeRecordsRequest.getToCoin(),
                coinExchangeRecordsRequest.getLimit(),
                coinExchangeRecordsRequest.getCursor()
        ));
    }

    @Override
    public Object getAssetDeliveryRecords(AssetDeliveryRecordsRequest deliveryRecordsRequest) {
        return executeSync(bybitApiService.getAssetDeliveryRecords(
                deliveryRecordsRequest.getCategory() == null ? null : deliveryRecordsRequest.getCategory().getProductTypeId(),
                deliveryRecordsRequest.getSymbol(),
                deliveryRecordsRequest.getExpDate(),
                deliveryRecordsRequest.getLimit(),
                deliveryRecordsRequest.getCursor())
        );
    }

    @Override
    public Object getAssetUSDCSettlementRecords(USDCSessionSettlementRequest usdcSettlementRequest) {
        return executeSync(bybitApiService.getAssetUSDCSettlementRecords(
                usdcSettlementRequest.getCategory() == null ? null : usdcSettlementRequest.getCategory().getProductTypeId(),
                usdcSettlementRequest.getSymbol(),
                usdcSettlementRequest.getLimit(),
                usdcSettlementRequest.getCursor())
        );
    }

    @Override
    public Object getAssetInfo(AssetInfoRequest assetInfoRequest) {
        return executeSync(bybitApiService.getAssetInfo(
                assetInfoRequest.getAccountType() == null ? null : assetInfoRequest.getAccountType().getAccountTypeValue(),
                assetInfoRequest.getCoin())
        );
    }

    @Override
    public Object getAssetAllCoinsBalance(AssetCoinsBalanceRequest allCoinsBalanceRequest) {
        return executeSync(bybitApiService.getAssetAllCoinsBalance(
                allCoinsBalanceRequest.getAccountType() == null ? null : allCoinsBalanceRequest.getAccountType().getAccountTypeValue(),
                allCoinsBalanceRequest.getMemberId(),
                allCoinsBalanceRequest.getCoin(),
                allCoinsBalanceRequest.getWithBonus())
        );
    }

    @Override
    public Object getAssetTransferableCoins(AccountType fromAccountType, AccountType toAccountType) {
        return executeSync(bybitApiService.getAssetTransferableCoins(
                fromAccountType == null ? null : fromAccountType.getAccountTypeValue(),
                toAccountType == null ? null : toAccountType.getAccountTypeValue()));
    }

    @Override
    public Object getAssetSingleCoinBalance(AssetSingleCoinBalanceRequest singleCoinBalanceRequest) {
        return executeSync(bybitApiService.getAssetSingleCoinBalance(
                singleCoinBalanceRequest.getAccountType() == null ? null : singleCoinBalanceRequest.getAccountType().getAccountTypeValue(),
                singleCoinBalanceRequest.getToAccountType() == null ? null : singleCoinBalanceRequest.getToAccountType().getAccountTypeValue(),
                singleCoinBalanceRequest.getMemberId(),
                singleCoinBalanceRequest.getToMemberId(),
                singleCoinBalanceRequest.getCoin(),
                singleCoinBalanceRequest.getWithBonus(),
                singleCoinBalanceRequest.getWithTransferSafeAmount(),
                singleCoinBalanceRequest.getWithLtvTransferSafeAmount())
        );
    }

    @Override
    public Object createAssetInternalTransfer(AssetInternalTransferRequest assetInternalTransferRequest) {
        return executeSync(bybitApiService.createAssetInternalTransfer(assetInternalTransferRequest));
    }

    @Override
    public Object getAssetTransferSubUidList() {
        return executeSync(bybitApiService.getAssetTransferSubUidList());
    }

    @Override
    public Object createAssetUniversalTransfer(AssetUniversalTransferRequest assetUniversalTransferRequest) {
        return executeSync(bybitApiService.createAssetUniversalTransfer(assetUniversalTransferRequest));
    }

    @Override
    public Object getAssetInternalTransferRecords(AssetTransferRecordsRequest internalTransferRequest) {
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
    public Object getAssetUniversalTransferRecords(AssetTransferRecordsRequest universalTransferRequest) {
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
    public Object getAssetAllowedDepositCoinInfo(AssetAllowedDepositCoinRequest allowedDepositCoinRequest) {
        return executeSync(bybitApiService.getAssetAllowedDepositCoinInfo(
                allowedDepositCoinRequest.getCoin(),
                allowedDepositCoinRequest.getChain(),
                allowedDepositCoinRequest.getLimit(),
                allowedDepositCoinRequest.getCursor())
        );
    }

    @Override
    public Object setAssetDepositAccount(AccountType accountType) {
        return executeSync(bybitApiService.setAssetDepositAccount(accountType == null ? null : accountType.getAccountTypeValue()));
    }

    @Override
    public Object getAssetDepositRecords(AssetDepositRecordsRequest assetDepositRecordsRequest) {
        return executeSync(bybitApiService.getAssetDepositRecords(
                assetDepositRecordsRequest.getCoin(),
                assetDepositRecordsRequest.getStartTime(),
                assetDepositRecordsRequest.getEndTime(),
                assetDepositRecordsRequest.getLimit(),
                assetDepositRecordsRequest.getCursor())
        );
    }

    @Override
    public Object getAssetSubMembersDepositRecords(AssetDepositRecordsRequest assetDepositRecordsRequest) {
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
    public Object getAssetInternalDepositRecords(AssetDepositRecordsRequest assetDepositRecordsRequest) {
        return executeSync(bybitApiService.getAssetInternalDepositRecords(
                assetDepositRecordsRequest.getCoin(),
                assetDepositRecordsRequest.getStartTime(),
                assetDepositRecordsRequest.getEndTime(),
                assetDepositRecordsRequest.getLimit(),
                assetDepositRecordsRequest.getCursor())
        );
    }

    @Override
    public Object getAssetMasterDepositAddress(AssetDepositRequest masterDepositRequest) {
        return executeSync(bybitApiService.getAssetMasterDepositAddress(
                masterDepositRequest.getCoin(),
                masterDepositRequest.getChainType()
        ));
    }

    @Override
    public Object getAssetSubMemberDepositAddress(AssetDepositRequest subDepositRequest) {
        return executeSync(bybitApiService.getAssetSubMemberDepositAddress(
                subDepositRequest.getCoin(),
                subDepositRequest.getChainType(),
                subDepositRequest.getSubMemberId()
        ));
    }

    @Override
    public Object getAssetCoinInfo() {
        return executeSync(bybitApiService.getAssetCoinInfo());
    }

    @Override
    public Object getAssetCoinInfo(String coin) {
        return executeSync(bybitApiService.getAssetCoinInfo(coin));
    }

    @Override
    public Object getAssetWithdrawalAmount(String coin) {
        return executeSync(bybitApiService.getAssetWithdrawalAmount(coin));
    }

    @Override
    public Object getAssetWithdrawalRecords(AssetWithdrawRecordsRequest assetWithdrawRecordsRequest) {
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
    public Object cancelAssetWithdraw(String withdrawId) {
        return executeSync(bybitApiService.cancelAssetWithdraw(withdrawId));
    }

    @Override
    public Object createAssetWithdraw(AssetWithdrawRequest assetWithdrawRequest) {
        return executeSync(bybitApiService.createAssetWithdraw(assetWithdrawRequest));
    }


}
