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
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.constant.Util.listToString;
import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

/**
 * Implementation of Bybit's REST API using Retrofit with synchronous/blocking
 * method calls.
 */
public class BybitApiRestClientImpl implements BybitApiRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
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
}
