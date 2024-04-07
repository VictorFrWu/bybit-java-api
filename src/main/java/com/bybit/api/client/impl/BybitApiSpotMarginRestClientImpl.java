package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiSpotMarginRestClient;
import com.bybit.api.client.domain.spot.SpotMarginDataRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.service.BybitJsonConverter;
import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

/**
 * Implementation of Bybit's REST API using Retrofit with synchronous/blocking
 * method calls.
 */
public class BybitApiSpotMarginRestClientImpl implements BybitApiSpotMarginRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiSpotMarginRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    // Spots
    // Spot Leverage endpoints
    @Override
    public Object getSpotLeverageTokenInfo(SpotMarginDataRequest spotMarginDataRequest) {
        return executeSync(bybitApiService.getSpotLeverageTokenInfo(spotMarginDataRequest.getLtCoin()));
    }

    @Override
    public Object getSpotLeverageTokenMarket(SpotMarginDataRequest spotMarginDataRequest) {
        return executeSync(bybitApiService.getSpotLeverageTokenMarket(spotMarginDataRequest.getLtCoin()));
    }

    @Override
    public Object purchaseSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest) {
        var spotLeverageTokenRequest = converter.mapToSpotLeverageTokenRequest(spotMarginDataRequest);
        return executeSync(bybitApiService.purchaseSpotLeverageToken(spotLeverageTokenRequest));
    }

    @Override
    public Object redeemSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest) {
        var spotLeverageTokenRequest = converter.mapToSpotLeverageTokenRequest(spotMarginDataRequest);
        return executeSync(bybitApiService.redeemSpotLeverageToken(spotLeverageTokenRequest));
    }

    @Override
    public Object getSpotLeverageRecords(SpotMarginDataRequest spotLeverageOrdersRecordRequest) {
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
    public Object getUtaVipSpotMarginTradeData(SpotMarginDataRequest utaMarginDataRequest) {
        return executeSync(bybitApiService.getUtaVipSpotMarginTradeData(
                utaMarginDataRequest.getVipLevel() == null ? null : utaMarginDataRequest.getVipLevel().getLevel(),
                utaMarginDataRequest.getCurrency())
        );
    }

    @Override
    public Object setUTASpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest) {
        String mode = spotMarginDataRequest.getSpotMarginMode() == null ? null : spotMarginDataRequest.getSpotMarginMode().getValue();
        return executeSync(bybitApiService.setUTASpotMarginTrade(mode));
    }

    @Override
    public Object setUTASpotMarginTradeLeverage(SpotMarginDataRequest spotMarginDataRequest) {
        String leverage = spotMarginDataRequest.getLeverage();
        return executeSync(bybitApiService.setUTASpotMarginTradeLeverage(leverage));
    }

    @Override
    public Object getUTASpotMarginTradeLeverageState() {
        return executeSync(bybitApiService.getUTASpotMarginTradeLeverageState());
    }

    // Spot Margin Normal
    @Deprecated
    @Override
    public Object getNormalVipSpotMarginTradeData(SpotMarginDataRequest normalMarginDataRequest) {
        return executeSync(bybitApiService.getNormalVipSpotMarginTradeData(
                normalMarginDataRequest.getVipLevel() == null ? null : normalMarginDataRequest.getVipLevel().getLevel(),
                normalMarginDataRequest.getCurrency())
        );
    }

    @Deprecated
    @Override
    public Object getNormalSpotMarginTradeCoinInfo(SpotMarginDataRequest normalMarginDataRequest) {
        return executeSync(bybitApiService.getNormalSpotMarginTradeCoinInfo(normalMarginDataRequest.getCoin()));
    }

    @Deprecated
    @Override
    public Object getNormalSpotMarginTradeBorrowCoinInfo(SpotMarginDataRequest normalMarginDataRequest) {
        return executeSync(bybitApiService.getNormalSpotMarginTradeBorrowCoinInfo(normalMarginDataRequest.getCoin()));
    }

    @Deprecated
    @Override
    public Object getNormalSpotMarginTradeInterestQuota(SpotMarginDataRequest spotMarginDataRequest) {
        return executeSync(bybitApiService.getNormalSpotMarginTradeInterestQuota(spotMarginDataRequest.getCoin()));
    }

    @Deprecated
    @Override
    public Object getNormalSpotMarginTradeAccountInfo() {
        return executeSync(bybitApiService.getNormalSpotMarginTradeAccountInfo());
    }

    @Deprecated
    @Override
    public Object setNormalSpotToggleMarginTrade(SpotMarginDataRequest spotMarginDataRequest) {
        int switchStatus = spotMarginDataRequest.getSwitchStatus() == null ? 0 : spotMarginDataRequest.getSwitchStatus().getValue();
        return executeSync(bybitApiService.setNormalSpotToggleMarginTrade(switchStatus));
    }

    @Deprecated
    @Override
    public Object loanNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest) {
        var spotMarginTradeBorrowRequest = converter.mapToSpotMarginBorrowRequest(spotMarginDataRequest);
        return executeSync(bybitApiService.loanNormalSpotMarginTrade(spotMarginTradeBorrowRequest));
    }

    @Deprecated
    @Override
    public Object repayNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest) {
        var spotMarginTradeRePayRequest = converter.mapToSpotMarginRepayRequest(spotMarginDataRequest);
        return executeSync(bybitApiService.repayNormalSpotMarginTrade(spotMarginTradeRePayRequest));
    }

    @Deprecated
    @Override
    public Object getNormalSpotMarginTradeBorrowOrders(SpotMarginDataRequest spotMarginTradeBorrowOrdersRequest) {
        return executeSync(bybitApiService.getNormalMarginTradeBorrowOrders(
                spotMarginTradeBorrowOrdersRequest.getStartTime(),
                spotMarginTradeBorrowOrdersRequest.getEndTime(),
                spotMarginTradeBorrowOrdersRequest.getCoin(),
                spotMarginTradeBorrowOrdersRequest.getBorrowStatus() == null ? 0 : spotMarginTradeBorrowOrdersRequest.getBorrowStatus().getValue(),
                spotMarginTradeBorrowOrdersRequest.getLimit()
        ));
    }

    @Deprecated
    @Override
    public Object getNormalSpotMarginTradeRepayOrders(SpotMarginDataRequest spotMarginTradeRepayOrdersRequest) {
        return executeSync(bybitApiService.getNormalMarginTradeRepayOrders(
                spotMarginTradeRepayOrdersRequest.getStartTime(),
                spotMarginTradeRepayOrdersRequest.getEndTime(),
                spotMarginTradeRepayOrdersRequest.getCoin(),
                spotMarginTradeRepayOrdersRequest.getLimit()
        ));
    }
}
