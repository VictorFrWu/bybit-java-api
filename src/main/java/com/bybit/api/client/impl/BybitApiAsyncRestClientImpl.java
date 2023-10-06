package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiAsyncRestClient;
import com.bybit.api.client.BybitApiCallback;
import com.bybit.api.client.domain.account.AccountDataRequest;
import com.bybit.api.client.domain.asset.AssetDataRequest;
import com.bybit.api.client.domain.asset.request.AssetCancelWithdrawRequest;
import com.bybit.api.client.domain.asset.request.SetAssetDepositAccountRequest;
import com.bybit.api.client.domain.market.MarketDataRequest;
import com.bybit.api.client.BybitApiService;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.service.JsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

/**
 * Implementation of Bybit's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BybitApiAsyncRestClientImpl implements BybitApiAsyncRestClient {

    private final BybitApiService bybitApiService;
    private final JsonConverter converter = new JsonConverter();

    public BybitApiAsyncRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }

    // Market Data endpoints

    @Override
    public void getServerTime(BybitApiCallback<Object> callback) {
        bybitApiService.getServerTime().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketPriceLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getIndexPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getIndexPriceLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPremiumIndexPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPremiumIndexPriceLinesData(
                marketKlineRequest.getCategory().getProductTypeId(),
                marketKlineRequest.getSymbol(),
                marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                marketKlineRequest.getStart(),
                marketKlineRequest.getEnd(),
                marketKlineRequest.getLimit()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInstrumentsInfo(MarketDataRequest instrumentInfoRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getInstrumentsInfo(
                instrumentInfoRequest.getCategory().getProductTypeId(),
                instrumentInfoRequest.getSymbol(),
                instrumentInfoRequest.getInstrumentStatus() == null ? null : instrumentInfoRequest.getInstrumentStatus().getStatus(),
                instrumentInfoRequest.getBaseCoin(),
                instrumentInfoRequest.getLimit(),
                instrumentInfoRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketOrderbook(MarketDataRequest marketOrderBookRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketOrderbook(
                marketOrderBookRequest.getCategory().getProductTypeId(),
                marketOrderBookRequest.getSymbol(),
                marketOrderBookRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketTickers(MarketDataRequest marketDataTickerRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketTickers(
                marketDataTickerRequest.getCategory().getProductTypeId(),
                marketDataTickerRequest.getSymbol(),
                marketDataTickerRequest.getBaseCoin(),
                marketDataTickerRequest.getExpDate()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getFundingHistory(MarketDataRequest fundingHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getFundingHistory(
                fundingHistoryRequest.getCategory().getProductTypeId(),
                fundingHistoryRequest.getSymbol(),
                fundingHistoryRequest.getStartTime(),
                fundingHistoryRequest.getEndTime(),
                fundingHistoryRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getRecentTradeData(MarketDataRequest recentTradeRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getRecentTradeData(
                recentTradeRequest.getCategory().getProductTypeId(),
                recentTradeRequest.getBaseCoin(),
                recentTradeRequest.getOptionType() == null ? null : recentTradeRequest.getOptionType().getOpType(),
                recentTradeRequest.getSymbol(),
                recentTradeRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOpenInterest(MarketDataRequest openInterestRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getOpenInterest(
                openInterestRequest.getCategory().getProductTypeId(),
                openInterestRequest.getSymbol(),
                openInterestRequest.getMarketInterval() == null ? null : openInterestRequest.getMarketInterval().getIntervalId(),
                openInterestRequest.getStartTime(),
                openInterestRequest.getEndTime(),
                openInterestRequest.getLimit(),
                openInterestRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getHistoricalVolatility(MarketDataRequest historicalVolatilityRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getHistoricalVolatility(
                historicalVolatilityRequest.getCategory().getProductTypeId(),
                historicalVolatilityRequest.getBaseCoin(),
                historicalVolatilityRequest.getOptionPeriod(),
                historicalVolatilityRequest.getStartTime(),
                historicalVolatilityRequest.getEndTime()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsurance(String coin, BybitApiCallback<Object> callback) {
        bybitApiService.getInsurance(coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsurance(BybitApiCallback<Object> callback) {
        bybitApiService.getInsurance().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getRiskLimit(MarketDataRequest marketRiskLimitRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getRiskLimit(
                        marketRiskLimitRequest.getCategory().getProductTypeId(),
                        marketRiskLimitRequest.getSymbol()
                ).
                enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getDeliveryPrice(MarketDataRequest deliveryPriceRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getDeliveryPrice(deliveryPriceRequest.getCategory().getProductTypeId(),
                deliveryPriceRequest.getSymbol(),
                deliveryPriceRequest.getBaseCoin(),
                deliveryPriceRequest.getLimit(),
                deliveryPriceRequest.getCursor()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketAccountRatio(MarketDataRequest marketAccountRatioRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketAccountRatio(marketAccountRatioRequest.getCategory().getProductTypeId(),
                marketAccountRatioRequest.getSymbol(),
                marketAccountRatioRequest.getDataRecordingPeriod() == null ? null : marketAccountRatioRequest.getDataRecordingPeriod().getPeriod(),
                marketAccountRatioRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }


    // Position Data
    @Override
    public void getPositionInfo(PositionDataRequest positionListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPositionInfo(
                positionListRequest.getCategory().getProductTypeId(),
                positionListRequest.getSymbol(),
                positionListRequest.getBaseCoin(),
                positionListRequest.getSettleCoin(),
                positionListRequest.getLimit(),
                positionListRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setPositionLeverage(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setLeverageRequest = converter.mapToSetLeverageRequest(positionDataRequest);
        bybitApiService.setPositionLeverage(setLeverageRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void swithMarginRequest(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var switchMarginRequest = converter.mapToSwitchMarginRequest(positionDataRequest);
        bybitApiService.swithMarginRequest(switchMarginRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void switchPositionMode(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var switchPositionModeRequest = converter.mapToSwitchPositionModeRequest(positionDataRequest);
        bybitApiService.switchPositionMode(switchPositionModeRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setTpslMode(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setTpSlModeRequest = converter.mapToSetTpSlModeRequest(positionDataRequest);
        bybitApiService.setTpslMode(setTpSlModeRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setRiskLimit(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setRiskLimitRequest = converter.mapToSetRiskLimitRequest(positionDataRequest);
        bybitApiService.setRiskLimit(setRiskLimitRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setTradingStop(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var tradingStopRequest = converter.mapToTradingStopRequest(positionDataRequest);
        bybitApiService.setTradingStop(tradingStopRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setAutoAddMargin(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setAutoAddMarginRequest = converter.mapToSetAutoAddMarginRequest(positionDataRequest);
        bybitApiService.setAutoAddMargin(setAutoAddMarginRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void modifyPositionMargin(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var modifyMarginRequest = converter.mapToModifyMarginRequest(positionDataRequest);
        bybitApiService.modifyPositionMargin(modifyMarginRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getExecutionList(PositionDataRequest executionHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getExecutionList(
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
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getClosePnlList(PositionDataRequest closePnlHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getClosePnlList(
                closePnlHistoryRequest.getCategory().getProductTypeId(),
                closePnlHistoryRequest.getSymbol(),
                closePnlHistoryRequest.getStartTime(),
                closePnlHistoryRequest.getEndTime(),
                closePnlHistoryRequest.getLimit(),
                closePnlHistoryRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    // pre upgrade endpoints
    @Override
    public void getPreUpgradeOrderHistory(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeOrderHistory(
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
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeTradeHistory(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeTradeHistory(
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
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeClosePnl(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeClosePnl(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeTransaction(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeTransaction(
                request.getCategory().getProductTypeId(),
                request.getBaseCoin(),
                request.getTransactionType() == null ? null : request.getTransactionType().getTransactionTypeId(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeOptionDelivery(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeOptionDelivery(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getExpDate(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeUsdcSettlement(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeUsdcSettlement(
                request.getCategory().getProductTypeId(),
                request.getSymbol(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    // Account Endpoints
    @Override
    public void getWalletBalance(AccountDataRequest walletBalanceRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getWalletBalance(
                walletBalanceRequest.getAccountType().getAccountTypeValue(),
                walletBalanceRequest.getCoins()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void upgradeAccountToUTA(BybitApiCallback<Object> callback) {
        bybitApiService.upgradeAccountToUTA().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountBorrowHistory(AccountDataRequest borrowHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountBorrowHistory(
                borrowHistoryRequest.getCurrency(),
                borrowHistoryRequest.getStartTime(),
                borrowHistoryRequest.getEndTime(),
                borrowHistoryRequest.getLimit(),
                borrowHistoryRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setAccountCollateralCoin(AccountDataRequest setCollateralCoinRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToSetCollateralCoinRequest(setCollateralCoinRequest);
        bybitApiService.setAccountCollateralCoin(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountCollateralInfo(AccountDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountCollateralInfo(
                request.getCurrency()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountCoinGeeks(AccountDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountCoinGeeks(request.getBaseCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountFreeRate(AccountDataRequest getFeeRateRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountFreeRate(
                getFeeRateRequest.getCategory().getProductTypeId(),
                getFeeRateRequest.getSymbol(),
                getFeeRateRequest.getBaseCoin()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountInfo(BybitApiCallback<Object> callback) {
        bybitApiService.getAccountInfo().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTransactionLog(AccountDataRequest getTransactionLogRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getTransactionLog(
                getTransactionLogRequest.getAccountType() == null ? null : getTransactionLogRequest.getAccountType().getAccountTypeValue(),
                getTransactionLogRequest.getCategory() == null ? null : getTransactionLogRequest.getCategory().getProductTypeId(),
                getTransactionLogRequest.getCurrency(),
                getTransactionLogRequest.getBaseCoin(),
                getTransactionLogRequest.getTransactionType() == null ? null : getTransactionLogRequest.getTransactionType().getTransactionTypeId(),
                getTransactionLogRequest.getStartTime(),
                getTransactionLogRequest.getEndTime(),
                getTransactionLogRequest.getLimit(),
                getTransactionLogRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setAccountMarginMode(AccountDataRequest request, BybitApiCallback<Object> callback) {
        var setMarginMode = converter.mapToSetMarginModeRequest(request);
        bybitApiService.setAccountMarginMode(setMarginMode).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void modifyAccountMMP(AccountDataRequest setMMPRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToSetMMPRequest(setMMPRequest);
        bybitApiService.modifyAccountMMP(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void resetAccountMMP(AccountDataRequest request, BybitApiCallback<Object> callback) {
        var resetMMPRequest = converter.mapToResetMarginModeRequest(request);
        bybitApiService.resetAccountMMP(resetMMPRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountMMPState(AccountDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountMMPState(request.getBaseCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    // Asset endpoints
    @Override
    public void getAssetCoinExchangeRecords(AssetDataRequest coinExchangeRecordsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetCoinExchangeRecords(
                coinExchangeRecordsRequest.getFromCoin(),
                coinExchangeRecordsRequest.getToCoin(),
                coinExchangeRecordsRequest.getLimit(),
                coinExchangeRecordsRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetDeliveryRecords(AssetDataRequest deliveryRecordsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetDeliveryRecords(
                deliveryRecordsRequest.getCategory() == null ? null : deliveryRecordsRequest.getCategory().getProductTypeId(),
                deliveryRecordsRequest.getSymbol(),
                deliveryRecordsRequest.getExpDate(),
                deliveryRecordsRequest.getLimit(),
                deliveryRecordsRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetUSDCSettlementRecords(AssetDataRequest usdcSettlementRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetUSDCSettlementRecords(
                usdcSettlementRequest.getCategory() == null ? null : usdcSettlementRequest.getCategory().getProductTypeId(),
                usdcSettlementRequest.getSymbol(),
                usdcSettlementRequest.getLimit(),
                usdcSettlementRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetInfo(AssetDataRequest assetInfoRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetInfo(
                assetInfoRequest.getAccountType() == null ? null : assetInfoRequest.getAccountType().getAccountTypeValue(),
                assetInfoRequest.getCoin()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetAllCoinsBalance(AssetDataRequest allCoinsBalanceRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetAllCoinsBalance(
                allCoinsBalanceRequest.getAccountType() == null ? null : allCoinsBalanceRequest.getAccountType().getAccountTypeValue(),
                allCoinsBalanceRequest.getMemberId(),
                allCoinsBalanceRequest.getCoin(),
                allCoinsBalanceRequest.getWithBonus() == null ? null : String.valueOf(allCoinsBalanceRequest.getWithBonus().getValue())
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetTransferableCoins(AssetDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetTransferableCoins(
                request.getFromAccountType() == null ? null : request.getFromAccountType().getAccountTypeValue(),
                request.getToAccountType() == null ? null : request.getToAccountType().getAccountTypeValue()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetSingleCoinBalance(AssetDataRequest singleCoinBalanceRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetSingleCoinBalance(
                singleCoinBalanceRequest.getAccountType() == null ? null : singleCoinBalanceRequest.getAccountType().getAccountTypeValue(),
                singleCoinBalanceRequest.getToAccountType() == null ? null : singleCoinBalanceRequest.getToAccountType().getAccountTypeValue(),
                singleCoinBalanceRequest.getMemberId(),
                singleCoinBalanceRequest.getToMemberId() == null ? null : singleCoinBalanceRequest.getToMemberId().toString(),
                singleCoinBalanceRequest.getCoin(),
                singleCoinBalanceRequest.getWithBonus() == null ? null : singleCoinBalanceRequest.getWithBonus().getValue(),
                singleCoinBalanceRequest.getWithTransferSafeAmount() == null ? null : singleCoinBalanceRequest.getWithTransferSafeAmount().getValue(),
                singleCoinBalanceRequest.getWithLtvTransferSafeAmount() == null ? null : singleCoinBalanceRequest.getWithLtvTransferSafeAmount().getValue()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createAssetInternalTransfer(AssetDataRequest assetInternalTransferRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToAssetInternalTransferRequest(assetInternalTransferRequest);
        bybitApiService.createAssetInternalTransfer(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetTransferSubUidList(BybitApiCallback<Object> callback) {
        bybitApiService.getAssetTransferSubUidList().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createAssetUniversalTransfer(AssetDataRequest assetUniversalTransferRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToAssetUniversalTransferRequest(assetUniversalTransferRequest);
        bybitApiService.createAssetUniversalTransfer(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetInternalTransferRecords(AssetDataRequest internalTransferRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetInternalTransferRecords(
                internalTransferRequest.getTransferId(),
                internalTransferRequest.getCoin(),
                internalTransferRequest.getTransferStatus() == null ? null : internalTransferRequest.getTransferStatus().getStatus(),
                internalTransferRequest.getStartTime(),
                internalTransferRequest.getEndTime(),
                internalTransferRequest.getLimit(),
                internalTransferRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetUniversalTransferRecords(AssetDataRequest universalTransferRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetUniversalTransferRecords(
                universalTransferRequest.getTransferId(),
                universalTransferRequest.getCoin(),
                universalTransferRequest.getTransferStatus() == null ? null : universalTransferRequest.getTransferStatus().getStatus(),
                universalTransferRequest.getStartTime(),
                universalTransferRequest.getEndTime(),
                universalTransferRequest.getLimit(),
                universalTransferRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetAllowedDepositCoinInfo(AssetDataRequest allowedDepositCoinRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetAllowedDepositCoinInfo(
                allowedDepositCoinRequest.getCoin(),
                allowedDepositCoinRequest.getChain(),
                allowedDepositCoinRequest.getLimit(),
                allowedDepositCoinRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setAssetDepositAccount(AssetDataRequest request, BybitApiCallback<Object> callback) {
        SetAssetDepositAccountRequest setAssetDepositAccountRequest = converter.mapToSetDepositAccountRequest(request);
        bybitApiService.setAssetDepositAccount(setAssetDepositAccountRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetDepositRecords(AssetDataRequest assetDepositRecordsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetDepositRecords(
                assetDepositRecordsRequest.getCoin(),
                assetDepositRecordsRequest.getStartTime(),
                assetDepositRecordsRequest.getEndTime(),
                assetDepositRecordsRequest.getLimit(),
                assetDepositRecordsRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetSubMembersDepositRecords(AssetDataRequest assetDepositRecordsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetSubMembersDepositRecords(
                assetDepositRecordsRequest.getSubMemberId(),
                assetDepositRecordsRequest.getCoin(),
                assetDepositRecordsRequest.getStartTime(),
                assetDepositRecordsRequest.getEndTime(),
                assetDepositRecordsRequest.getLimit(),
                assetDepositRecordsRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetInternalDepositRecords(AssetDataRequest assetDepositRecordsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetInternalDepositRecords(
                assetDepositRecordsRequest.getCoin(),
                assetDepositRecordsRequest.getStartTime(),
                assetDepositRecordsRequest.getEndTime(),
                assetDepositRecordsRequest.getLimit(),
                assetDepositRecordsRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetMasterDepositAddress(AssetDataRequest masterDepositRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetMasterDepositAddress(
                masterDepositRequest.getCoin(),
                masterDepositRequest.getChainType()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetSubMemberDepositAddress(AssetDataRequest subDepositRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetSubMemberDepositAddress(
                subDepositRequest.getCoin(),
                subDepositRequest.getChainType(),
                subDepositRequest.getSubMemberId()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetCoinInfo(AssetDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetCoinInfo(request.getCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetWithdrawalAmount(AssetDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetWithdrawalAmount(request.getCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetWithdrawalRecords(AssetDataRequest assetWithdrawRecordsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetWithdrawalRecords(
                assetWithdrawRecordsRequest.getWithdrawID(),
                assetWithdrawRecordsRequest.getCoin(),
                assetWithdrawRecordsRequest.getWithdrawType() == null ? null : assetWithdrawRecordsRequest.getWithdrawType().getValue(),
                assetWithdrawRecordsRequest.getStartTime(),
                assetWithdrawRecordsRequest.getEndTime(),
                assetWithdrawRecordsRequest.getLimit(),
                assetWithdrawRecordsRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelAssetWithdraw(AssetDataRequest request, BybitApiCallback<Object> callback) {
        AssetCancelWithdrawRequest assetCancelWithdrawRequest = converter.mapToAssetCancelWithdrawRequest(request);
        bybitApiService.cancelAssetWithdraw(assetCancelWithdrawRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createAssetWithdraw(AssetDataRequest assetWithdrawRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToAssetWithdrawRequest(assetWithdrawRequest);
        bybitApiService.createAssetWithdraw(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
