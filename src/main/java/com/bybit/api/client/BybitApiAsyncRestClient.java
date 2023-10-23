package com.bybit.api.client;

import com.bybit.api.client.domain.account.AccountDataRequest;
import com.bybit.api.client.domain.asset.AssetDataRequest;
import com.bybit.api.client.domain.market.MarketDataRequest;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.request.*;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.domain.user.UserDataRequest;

/**
 * Bybit API facade, supporting asynchronous/non-blocking access Bybit's REST API.
 */
public interface BybitApiAsyncRestClient {


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
}
