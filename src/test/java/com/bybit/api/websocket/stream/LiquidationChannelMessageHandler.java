package com.bybit.api.websocket.stream;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.websocket_message.public_channel.WebSocketLiquidationMessage;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class LiquidationChannelMessageHandler {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance(BybitApiConfig.STREAM_MAINNET_DOMAIN, true).newWebsocketClient();

        client.setMessageHandler(message -> {
            var liquidationData = (new ObjectMapper()).readValue(message, WebSocketLiquidationMessage.class);
            // Process message data here
                System.out.println("Websocket Message Data: " + liquidationData.getData().toString());
        });

        // Liquidation
        client.getPublicChannelStream(List.of("liquidation.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
    }
}
