package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.asset.request.AssetDataRequest;

public interface BybitApiAsyncAssetRestClient {
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
    // convert coin endpoints
    void requestQuote(AssetDataRequest assetQuoteRequest,BybitApiCallback<Object> callback);
    void confirmQuote(String quoteTxId, BybitApiCallback<Object> callback);

    void confirmQuote(AssetDataRequest assetQuoteRequest, BybitApiCallback<Object> callback);

    void getConvertCoinList(AssetDataRequest request, BybitApiCallback<Object> callback);
    void getConvertCoinStatus(AssetDataRequest request, BybitApiCallback<Object> callback);
    void getConvertCoinHistory(AssetDataRequest request, BybitApiCallback<Object> callback);
}
