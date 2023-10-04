package com.bybit.api.examples.Websocket;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.BybitApiWebSocketClient;

/**
 * Order book data stream endpoints examples.
 *
 * It illustrates how to create a stream to obtain updates on Order book.
 */
public class OrderbookDataStream {
    public static void main(String[] args) {
        BybitApiWebSocketClient client = BybitApiClientFactory.newInstance().newWebSocketClient(true, BybitApiConfig.V5_PUBLIC_LINEAR);

        // Listen for order book event
        client.onOrderBookDataUpdateEvent("1","BTCUSDT", response -> System.out.println(response));
    }
}
