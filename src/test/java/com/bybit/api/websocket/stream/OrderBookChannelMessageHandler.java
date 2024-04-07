package com.bybit.api.websocket.stream;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.websocket_message.public_channel.WebsocketOrderbookMessage;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class OrderBookChannelMessageHandler {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance(BybitApiConfig.STREAM_MAINNET_DOMAIN, true).newWebsocketClient();

        client.setMessageHandler(message -> {
            var orderbookMessage = (new ObjectMapper()).readValue(message, WebsocketOrderbookMessage.class);
            // Process message data here
            System.out.println("Websocket Message Data: " + orderbookMessage.getData().toString());
        });

        // Order book
        client.getPublicChannelStream(List.of("orderbook.50.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
    }
}
