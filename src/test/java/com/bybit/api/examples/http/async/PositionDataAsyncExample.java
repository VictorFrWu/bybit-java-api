package com.bybit.api.examples.http.async;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.TradeOrderType;
import com.bybit.api.client.domain.TriggerBy;
import com.bybit.api.client.domain.position.AutoAddMargin;
import com.bybit.api.client.domain.position.MarginMode;
import com.bybit.api.client.domain.position.TpslMode;
import com.bybit.api.client.domain.position.request.PositionDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class PositionDataAsyncExample {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newAsyncPositionRestClient();

        // Get Position Info
        var positionListRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").build();
        client.getPositionInfo(positionListRequest, System.out::println);

        // Set Leverage
        var setLeverageRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").buyLeverage("5").sellLeverage("5").build();
        client.setPositionLeverage(setLeverageRequest, System.out::println);

        // Get Close PnL History
        var closPnlRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).build();
       client.getClosePnlList(closPnlRequest, System.out::println);

        // Switch Cross/Isolated Margin
        var switchMarginRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTC-31MAR23").tradeMode(MarginMode.CROSS_MARGIN).buyLeverage("5").sellLeverage("5").build();
        client.swithMarginRequest(switchMarginRequest, System.out::println);

        // Set Tp sl
        var setTpSlRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").tpslMode(TpslMode.PARTIAL).build();
        client.swithMarginRequest(setTpSlRequest, System.out::println);

        // Confirm new position risk limit
        var confirmNewRiskRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").build();
        client.confirmPositionRiskLimit(confirmNewRiskRequest, System.out::println);

        // Set Risk Limit
/*        var setRiskLimitRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").riskId(4).build();
        client.setRiskLimit(setRiskLimitRequest, System.out::println);*/

        // Set Trading Stop
        var setTradingStopRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("XRPUSDT").takeProfit("0.6").stopLoss("0.2").tpTriggerBy(TriggerBy.MARK_PRICE).slTriggerBy(TriggerBy.LAST_PRICE)
                .tpslMode(TpslMode.PARTIAL).tpOrderType(TradeOrderType.LIMIT).slOrderType(TradeOrderType.LIMIT).tpSize("50").slSize("50").tpLimitPrice("0.57").slLimitPrice("0.21").build();
        client.setTradingStop(setTradingStopRequest, System.out::println);

        // Set Auto Add Margin
        var setAutoAddMarginRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").autoAddMargin(AutoAddMargin.ON).build();
        client.setAutoAddMargin(setAutoAddMarginRequest, System.out::println);

        // Update Margin
        var updateMarginRequest = PositionDataRequest.builder().category(CategoryType.INVERSE).symbol("ETHUSDT").margin("0.0001").build();
        client.modifyPositionMargin(updateMarginRequest, System.out::println);
    }
}
