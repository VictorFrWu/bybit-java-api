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
import com.bybit.api.client.domain.user.UserDataRequest;
import com.bybit.api.client.domain.user.request.UserSubMemberRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.constant.Util.listToString;
import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

/**
 * Implementation of Bybit's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BybitApiAsyncRestClientImpl implements BybitApiAsyncRestClient {

    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
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

    // User endpoints
    @Override
    public void createSubMember(UserDataRequest request, BybitApiCallback<Object> callback) {
        UserSubMemberRequest subUserRequest = converter.mapToCreateSubMemberRequest(request);
        bybitApiService.createSubMember(subUserRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createSubAPI(UserDataRequest request, BybitApiCallback<Object> callback) {
        var createApiKeyRequest = converter.mapToCreateSubApiRequest(request);
        bybitApiService.createSubAPI(createApiKeyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSubUIDList(BybitApiCallback<Object> callback) {
        bybitApiService.getSubUIDList().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void freezeSubMember(UserDataRequest request, BybitApiCallback<Object> callback) {
        var freezeSubUIDRquest = converter.mapToFreezeSubApiRequest(request);
        bybitApiService.freezeSubMember(freezeSubUIDRquest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCurrentAPIKeyInfo(BybitApiCallback<Object> callback) {
        bybitApiService.getCurrentAPIKeyInfo().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getUIDWalletType(UserDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getUIDWalletType(request.getMemberIds() == null ? null : listToString(request.getMemberIds())).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void modifyMasterApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback) {
        var modifyMasterApiKeyRequest = converter.mapToModifyApiKeyRequest(userDataRequest);
        bybitApiService.modifyMasterApiKey(modifyMasterApiKeyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void modifySubApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback) {
        var modifySubApiKeyRequest = converter.mapToModifyApiKeyRequest(userDataRequest);
        bybitApiService.modifySubApiKey(modifySubApiKeyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void deleteMasterApiKey(BybitApiCallback<Object> callback) {
        bybitApiService.deleteMasterApiKey().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void deleteSubApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback) {
        var deleteSubApiKeyRequest = converter.mapToDeleteSubApiKeyRequest(userDataRequest);
        bybitApiService.deleteSubApiKey(deleteSubApiKeyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAffiliateUserInfo(UserDataRequest userDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAffiliateUserInfo(userDataRequest.getUid()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
