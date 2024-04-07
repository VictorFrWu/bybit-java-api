package com.bybit.api.examples.Websocket.api;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.security.HmacSHA256Signer;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.websocket.httpclient.WebSocketApiClient;
import com.bybit.api.client.websocket.impl.WebSocketApiClientImpl;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import static com.bybit.api.client.config.BybitApiConfig.STREAM_TESTNET_DOMAIN;
import static com.bybit.api.client.config.BybitApiConfig.V5_TRADE;

public class WsStreamAPITrade {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.STREAM_TESTNET_DOMAIN, true).newWebsocketClient(20);
        client.getTradeChannelStream(Map.of("category", "spot","symbol", "XRPUSDT",
                "side", "Buy", "orderType", "Market", "qty", "10"), V5_TRADE);
    }
}
