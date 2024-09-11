package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.domain.user.UserDataRequest;

/**
 * Bybit API facade, supporting asynchronous/non-blocking access Bybit's REST API.
 */
public interface BybitApiAsyncUserRestClient {
    // Pre upgrade endpoints
    void getPreUpgradeOrderHistory(PreUpgradeDataRequest preupgradeOderHistoryRequest, BybitApiCallback<Object> callback);
    void getPreUpgradeTradeHistory(PreUpgradeDataRequest preUpgradeTradeHistoryRequest, BybitApiCallback<Object> callback);
    void getPreUpgradeClosePnl(PreUpgradeDataRequest preUpgradeClosePnlRequest, BybitApiCallback<Object> callback);
    void getPreUpgradeTransaction(PreUpgradeDataRequest preUpgradeTransactionRequest, BybitApiCallback<Object> callback);
    void getPreUpgradeOptionDelivery(PreUpgradeDataRequest preUpgradeOptionDeliveryRequest, BybitApiCallback<Object> callback);
    void getPreUpgradeUsdcSettlement(PreUpgradeDataRequest preUpgradeUsdcSettlementRequest, BybitApiCallback<Object> callback);

    // User Data
    void createSubMember(UserDataRequest subUserRequest, BybitApiCallback<Object> callback);
    void createSubAPI(UserDataRequest createApiKeyRequest, BybitApiCallback<Object> callback);
    void getSubUIDList(BybitApiCallback<Object> callback);
    void freezeSubMember(UserDataRequest freezeSubUIDRequest, BybitApiCallback<Object> callback);
    void getCurrentAPIKeyInfo(BybitApiCallback<Object> callback);
    void getUIDWalletType(UserDataRequest userDataRequest, BybitApiCallback<Object> callback);
    void modifyMasterApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback);
    void modifySubApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback);
    void deleteMasterApiKey(BybitApiCallback<Object> callback);
    void deleteSubApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback);
    void getAffiliateUserInfo(UserDataRequest userDataRequest, BybitApiCallback<Object> callback);

    void getSubUIDListUnlimited(UserDataRequest subUserRequest, BybitApiCallback<Object> callback);
    void getSubUIDListUnlimited(BybitApiCallback<Object> callback);
    void getSubAccAllAPIKeyInfo(UserDataRequest subUserRequest, BybitApiCallback<Object> callback);
}
