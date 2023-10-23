package com.bybit.api.client;

import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.domain.user.UserDataRequest;

public interface BybitApiUserRestClient {
    // User Data
    Object createSubMember(UserDataRequest subUserRequest);
    Object createSubAPI(UserDataRequest createApiKeyRequest);
    Object getSubUIDList();
    Object freezeSubMember(UserDataRequest freezeSubUIDRequest);
    Object getCurrentAPIKeyInfo();
    Object getUIDWalletType(UserDataRequest userDataRequest);
    Object modifyMasterApiKey(UserDataRequest userDataRequest);
    Object modifySubApiKey(UserDataRequest userDataRequest);
    Object deleteMasterApiKey();
    Object deleteSubApiKey(UserDataRequest userDataRequest);
    Object getAffiliateUserInfo(UserDataRequest userDataRequest);

    // Pre Upgrade
    Object getPreUpgradeOrderHistory(PreUpgradeDataRequest preupgradeOderHistoryRequest);
    Object getPreUpgradeTradeHistory(PreUpgradeDataRequest preUpgradeTradeHistoryRequest);
    Object getPreUpgradeClosePnl(PreUpgradeDataRequest preUpgradeClosePnlRequest);
    Object getPreUpgradeTransaction(PreUpgradeDataRequest preUpgradeTransactionRequest);
    Object getPreUpgradeOptionDelivery(PreUpgradeDataRequest preUpgradeOptionDeliveryRequest);
    Object getPreUpgradeUsdcSettlement(PreUpgradeDataRequest preUpgradeUsdcSettlementRequest);
}
