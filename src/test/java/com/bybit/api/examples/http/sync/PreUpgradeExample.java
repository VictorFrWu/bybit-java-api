package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.preupgrade.request.*;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.BybitApiRestClient;

public class PreUpgradeExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiRestClient client = factory.newRestClient();

        // Get preupgrade order history
        var preupgradeOrderHistoryRequest = new PreUpgradeOrderHistoryRequest.Builder(ProductType.LINEAR).build();
        var preupgradeOrderHistoryData = client.getPreUpgradeOrderHistory(preupgradeOrderHistoryRequest);
        System.out.println(preupgradeOrderHistoryData);

        // Get preupgrade trade history
        var preUpgradeTradeHistoryRequest = new PreUpgradeTradeHistoryRequest.Builder(ProductType.LINEAR).build();
        var preUpgradeTradeHistoryData = client.getPreUpgradeTradeHistory(preUpgradeTradeHistoryRequest);
        System.out.println(preUpgradeTradeHistoryData);

        // Get preupgrade close pnl history
        var preupgradeClosePnlRequest = new PreUpgradeClosePnlRequest.Builder(ProductType.LINEAR, "BTCUSDT").build();
        var preUpgradeClosePnl = client.getPreUpgradeClosePnl(preupgradeClosePnlRequest);
        System.out.println(preUpgradeClosePnl);

        // Get preupgrade Transaction log
        var preUpgradeTransactionRequest = new PreUpgradeTransactionRequest.Builder(ProductType.LINEAR).build();
        var preUpgradeTransaction = client.getPreUpgradeTransaction(preUpgradeTransactionRequest);
        System.out.println(preUpgradeTransaction);

        // Get preupgrade option delivery
        var preUpgradeOptionDeliveryRequest = new PreUpgradeOptionDeliveryRequest.Builder(ProductType.OPTION).build();
        var preUpgradeOptionDeliveryData = client.getPreUpgradeOptionDelivery(preUpgradeOptionDeliveryRequest);
        System.out.println(preUpgradeOptionDeliveryData);

        // Get preupgrade usdc session settlement
        var preUpgradeUsdcSettlementRequest = new PreUpgradeUsdcSettlementRequest.Builder(ProductType.LINEAR).build();
        var preUpgradeUsdcSettlementData = client.getPreUpgradeUsdcSettlement(preUpgradeUsdcSettlementRequest);
        System.out.println(preUpgradeUsdcSettlementData);
    }
}
