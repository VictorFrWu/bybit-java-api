package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class PreUpgradeExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        var client = factory.newUserRestClient();

        // Get pre-upgrade order history
        var preupgradeOrderHistoryRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        var preupgradeOrderHistoryData = client.getPreUpgradeOrderHistory(preupgradeOrderHistoryRequest);
        System.out.println(preupgradeOrderHistoryData);

        // Get pre-upgrade trade history
        var preUpgradeTradeHistoryRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        var preUpgradeTradeHistoryData = client.getPreUpgradeTradeHistory(preUpgradeTradeHistoryRequest);
        System.out.println(preUpgradeTradeHistoryData);

        // Get preupgrade close pnl history
        var preupgradeClosePnlRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").build();
        var preUpgradeClosePnl = client.getPreUpgradeClosePnl(preupgradeClosePnlRequest);
        System.out.println(preUpgradeClosePnl);

        // Get pre-upgrade Transaction log
        var preUpgradeTransactionRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        var preUpgradeTransaction = client.getPreUpgradeTransaction(preUpgradeTransactionRequest);
        System.out.println(preUpgradeTransaction);

        // Get pre-upgrade option delivery
        var preUpgradeOptionDeliveryRequest = PreUpgradeDataRequest.builder().category(ProductType.OPTION).build();
        var preUpgradeOptionDeliveryData = client.getPreUpgradeOptionDelivery(preUpgradeOptionDeliveryRequest);
        System.out.println(preUpgradeOptionDeliveryData);

        // Get pre-upgrade usdc session settlement
        var preUpgradeUsdcSettlementRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        var preUpgradeUsdcSettlementData = client.getPreUpgradeUsdcSettlement(preUpgradeUsdcSettlementRequest);
        System.out.println(preUpgradeUsdcSettlementData);
    }
}
