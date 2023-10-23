package com.bybit.api.client.impl;

import com.bybit.api.client.BybitApiService;
import com.bybit.api.client.BybitApiUserRestClient;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.domain.user.UserDataRequest;
import com.bybit.api.client.domain.user.request.UserSubMemberRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.constant.Util.listToString;
import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

/**
 * Implementation of Bybit's REST API using Retrofit with synchronous/blocking
 * method calls.
 */
public class BybitApiUserRestClientImpl implements BybitApiUserRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiUserRestClientImpl(String apiKey, String secret) {
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
}
