package com.bybit.api.examples.http.async;

import com.bybit.api.client.BybitApiRestClient;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class PreUpgradeAsyncExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        var client = factory.newAsyncRestClient();

        // Get preupgrade order history
        var preupgradeOrderHistoryRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        client.getPreUpgradeOrderHistory(preupgradeOrderHistoryRequest, System.out::println);

        // Get preupgrade trade history
        var preUpgradeTradeHistoryRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        client.getPreUpgradeTradeHistory(preUpgradeTradeHistoryRequest, System.out::println);

        // Get preupgrade close pnl history
        var preupgradeClosePnlRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").build();
        client.getPreUpgradeClosePnl(preupgradeClosePnlRequest, System.out::println);

        // Get preupgrade Transaction log
        var preUpgradeTransactionRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        client.getPreUpgradeTransaction(preUpgradeTransactionRequest, System.out::println);


        // Get preupgrade option delivery
        var preUpgradeOptionDeliveryRequest = PreUpgradeDataRequest.builder().category(ProductType.OPTION).build();
        client.getPreUpgradeOptionDelivery(preUpgradeOptionDeliveryRequest, System.out::println);

        // Get preupgrade usdc session settlement
        var preUpgradeUsdcSettlementRequest = PreUpgradeDataRequest.builder().category(ProductType.LINEAR).build();
        client.getPreUpgradeUsdcSettlement(preUpgradeUsdcSettlementRequest, System.out::println);
    }
}
