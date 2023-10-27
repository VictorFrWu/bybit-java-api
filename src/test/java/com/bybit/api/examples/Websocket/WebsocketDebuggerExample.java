package com.bybit.api.examples.Websocket;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiClientFactory;

import java.util.List;

public class WebsocketDebuggerExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        var client = factory.newWebsocketClient(true);

        // Orderbook
        client.getPublicChannelStream(List.of("orderbook.50.MATICUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
    }
}
