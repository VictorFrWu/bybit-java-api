package com.bybit.api.examples.Websocket.stream;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiClientFactory;
import okhttp3.WebSocket;

import java.util.List;

public class WebsockeCloseStreamlExamples {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance(BybitApiConfig.STREAM_MAINNET_DOMAIN, true).newWebsocketClient(5, System.out::println);

        // Ticker
        WebSocket webSocket = client.getPublicChannelStream(List.of("tickers.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // close ws st
        client.onClose(webSocket, 1000, "close normal");

/*        client.setMessageHandler(message -> {
            // Process message data here
            System.out.println("Websocket Message Data: " + message);
        });*/

        // Subscribe Orderbook more than one args
        //client.getPublicChannelStream(List.of("orderbook.25.BTC-23FEB24-51000-P"), BybitApiConfig.V5_PUBLIC_OPTION);
        // Orderbook
        // client.getPublicChannelStream(List.of("orderbook.50.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // Trade
        // client.getPublicChannelStream(List.of("publicTrade.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);


        // Kline
        // client.getPublicChannelStream(List.of("kline.D.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // Liquidation
        // client.getPublicChannelStream(List.of("liquidation.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // LT Kline
        // client.getPublicChannelStream(List.of("kline_lt.1.EOS3LUSDT"), BybitApiConfig.V5_PUBLIC_SPOT);

        // LT Ticker
        // client.getPublicChannelStream(List.of("tickers_lt.1.EOS3LUSDT"), BybitApiConfig.V5_PUBLIC_SPOT);

        // LT Nav
        // client.getPublicChannelStream(List.of("lt.EOS3LUSDT"), BybitApiConfig.V5_PUBLIC_SPOT);
    }
}
