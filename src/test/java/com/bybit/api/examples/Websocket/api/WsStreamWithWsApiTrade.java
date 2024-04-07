package com.bybit.api.examples.Websocket.api;

import com.bybit.api.client.security.HmacSHA256Signer;
import com.bybit.api.client.websocket.httpclient.WebSocketApiClient;
import com.bybit.api.client.websocket.impl.WebSocketApiClientImpl;
import org.json.JSONObject;

import static com.bybit.api.client.config.BybitApiConfig.STREAM_TESTNET_DOMAIN;
import static com.bybit.api.client.config.BybitApiConfig.V5_TRADE;

public class WsStreamWithWsApiTrade {
    private static final double quantity = 0.01;
    private static final int waitTime = 5000;

    public static void main(String[] args) throws InterruptedException {

        // ws api call
        HmacSHA256Signer signatureGenerator = new HmacSHA256Signer("YOUR_API_SECRET");
        WebSocketApiClient apiClient = new WebSocketApiClientImpl("YOUR_API_KEY", signatureGenerator, STREAM_TESTNET_DOMAIN+ V5_TRADE);
        apiClient.connect((System.out::println));

        JSONObject params = new JSONObject();
        params.put("quantity", quantity);

        apiClient.trade().newOrder("spot", "BTCUSDT", "BUY", "MARKET", "0.01", params);

        Thread.sleep(waitTime);

        // closing all connections
        apiClient.close();
    }
}
