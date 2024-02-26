package com.bybit.api.websocket;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.websocket_message.public_channel.WebSocketKlineMessage;
import com.bybit.api.client.domain.websocket_message.public_channel.WebSocketTradeMessage;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class KlineChannelMessageHandler {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance(BybitApiConfig.STREAM_MAINNET_DOMAIN, true).newWebsocketClient();

        client.setMessageHandler(message -> {
            var klineData = (new ObjectMapper()).readValue(message, WebSocketKlineMessage.class);
            // Process message data here
            System.out.println("Websocket Message Data: " + klineData.getData().toString());
        });

        // Kline
        client.getPublicChannelStream(List.of("kline.D.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
    }
}
