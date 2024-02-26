package com.bybit.api.examples.Websocket;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiClientFactory;

import java.util.List;

public class WebsocketPrivateChannelExamples {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj", BybitApiConfig.STREAM_TESTNET_DOMAIN, true).newWebsocketClient(5, "60s", (message) -> System.out.println("Handle message :" + message));
        // Position
        // client.getOrderBookStream(List.of("position.linear"), BybitApiConfig.V5_PRIVATE);

        // Order
        client.getPrivateChannelStream(List.of("execution"), BybitApiConfig.V5_PRIVATE);
    }
}
