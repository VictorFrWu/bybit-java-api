package com.bybit.api.websocket.stream;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.websocket_message.private_channel.WebSocketOrderMessage;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class OrderChannelMessageHandler {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.STREAM_TESTNET_DOMAIN, true)
                .newWebsocketClient(5, "60s", (message) -> {
                    var orderMessage = (new ObjectMapper()).readValue(message, WebSocketOrderMessage.class);
                    // Process message data here
                    System.out.println("Websocket Message Data: " + orderMessage.getData().toString());
                });

        // Order
        client.getPrivateChannelStream(List.of("order"), BybitApiConfig.V5_PRIVATE);
    }
}
