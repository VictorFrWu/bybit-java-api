package com.bybit.api.examples.Websocket.api;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiClientFactory;

import java.util.Map;

import static com.bybit.api.client.config.BybitApiConfig.V5_TRADE;

public class WsStreamAPITrade {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj", BybitApiConfig.STREAM_TESTNET_DOMAIN).newWebsocketClient(20);
        var webSocket = client.getTradeChannelStream(Map.of("reqId", "test-001", "category", "spot", "symbol", "XRPUSDT",
                "side", "Buy", "orderType", "Market", "qty", "10", "orderLinkId", "t0003"), V5_TRADE);

        client.sendSubscribeMessage(webSocket, Map.of("reqId", "test-002", "category", "spot", "symbol", "XRPUSDT",
                "side", "Buy", "orderType", "Market", "qty", "10","orderLinkId", "t0004"));

        // Close websocket
        //client.onClose(webSocket, 1000, "close normal");
    }
}
