package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.asset.request.AssetDataRequest;

public interface BybitApiAssetRestClient {
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
    // convert coin endpoints
    Object requestQuote(AssetDataRequest assetQuoteRequest);
    Object confirmQuote(String quoteTxId);
    Object confirmQuote(AssetDataRequest assetQuoteRequest);
    Object getConvertCoinList(AssetDataRequest request);
    Object getConvertCoinStatus(AssetDataRequest request);
    Object getConvertCoinHistory(AssetDataRequest request);
}
