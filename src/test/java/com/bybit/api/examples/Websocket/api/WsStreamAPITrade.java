package com.bybit.api.examples.Websocket.api;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiClientFactory;
import java.util.Map;

import static com.bybit.api.client.config.BybitApiConfig.V5_TRADE;

public class WsStreamAPITrade {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.STREAM_TESTNET_DOMAIN, true).newWebsocketClient(20);
        client.getTradeChannelStream(Map.of("X-BAPI-RECV-WINDOW", "5000", "Referer", "bot-001", "category", "spot", "symbol", "XRPUSDT",
                "side", "Buy", "orderType", "Market", "qty", "10"), V5_TRADE);
    }
}
