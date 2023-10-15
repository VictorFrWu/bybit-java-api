package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.domain.preupgrade.request.*;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.BybitApiRestClient;

public class PreUpgradeExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        BybitApiRestClient client = factory.newRestClient();

        // Get preupgrade order history
        var preupgradeOrderHistoryRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        var preupgradeOrderHistoryData = client.getPreUpgradeOrderHistory(preupgradeOrderHistoryRequest);
        System.out.println(preupgradeOrderHistoryData);

        // Get preupgrade trade history
        var preUpgradeTradeHistoryRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        var preUpgradeTradeHistoryData = client.getPreUpgradeTradeHistory(preUpgradeTradeHistoryRequest);
        System.out.println(preUpgradeTradeHistoryData);

        // Get preupgrade close pnl history
        var preupgradeClosePnlRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").build();
        var preUpgradeClosePnl = client.getPreUpgradeClosePnl(preupgradeClosePnlRequest);
        System.out.println(preUpgradeClosePnl);

        // Get preupgrade Transaction log
        var preUpgradeTransactionRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        var preUpgradeTransaction = client.getPreUpgradeTransaction(preUpgradeTransactionRequest);
        System.out.println(preUpgradeTransaction);

        // Get preupgrade option delivery
        var preUpgradeOptionDeliveryRequest = PreUpgradeDataRequest.builder().category(ProductType.OPTION).build();
        var preUpgradeOptionDeliveryData = client.getPreUpgradeOptionDelivery(preUpgradeOptionDeliveryRequest);
        System.out.println(preUpgradeOptionDeliveryData);

        // Get preupgrade usdc session settlement
        var preUpgradeUsdcSettlementRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        var preUpgradeUsdcSettlementData = client.getPreUpgradeUsdcSettlement(preUpgradeUsdcSettlementRequest);
        System.out.println(preUpgradeUsdcSettlementData);
    }
}
