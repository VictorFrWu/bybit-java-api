package com.bybit.api.websocket.stream;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.websocket_message.public_channel.WebSocketTickerMessage;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class TickerChannelMessageHandler {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance(BybitApiConfig.STREAM_MAINNET_DOMAIN, true).newWebsocketClient();

        client.setMessageHandler(message -> {
            var tickerData = (new ObjectMapper()).readValue(message, WebSocketTickerMessage.class);
            // Process message data here
            System.out.println("Websocket Message Data: " + tickerData.getData().toString());
        });

        // Ticker
        client.getPublicChannelStream(List.of("tickers.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
    }
}
