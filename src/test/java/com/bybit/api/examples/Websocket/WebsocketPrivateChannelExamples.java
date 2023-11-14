package com.bybit.api.examples.Websocket;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiClientFactory;

import java.util.List;

public class WebsocketPrivateChannelExamples {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.STREAM_TESTNET_DOMAIN).newWebsocketClient((message) -> System.out.println("Handle message :" + message));
        // Position
        // client.getOrderBookStream(List.of("position.linear"), BybitApiConfig.V5_PRIVATE);

        // Order
        client.getPrivateChannelStream(List.of("order"), BybitApiConfig.V5_PRIVATE);
    }
}
