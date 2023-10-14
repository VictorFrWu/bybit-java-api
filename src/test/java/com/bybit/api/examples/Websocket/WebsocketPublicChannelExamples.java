package com.bybit.api.examples.Websocket;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiClientFactory;
public class WebsocketPublicChannelExamples {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        var client = factory.newWebsocketClient((message) -> {
            System.out.println("Handle message :" + message);
        });

        // Orderbook
        // client.orderBookStream(List.of("orderbook.50.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // Trade
        // client.orderBookStream(List.of("publicTrade.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // Ticker
        // client.orderBookStream(List.of("tickers.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // Kline
        // client.orderBookStream(List.of("kline.D.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // Liquidation
        // client.orderBookStream(List.of("liquidation.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // LT Kline
        // client.orderBookStream(List.of("kline_lt.1.EOS3LUSDT"), BybitApiConfig.V5_PUBLIC_SPOT);

        // LT Ticker
        // client.orderBookStream(List.of("tickers_lt.1.EOS3LUSDT"), BybitApiConfig.V5_PUBLIC_SPOT);

        // LT Nav
        client.orderBookStream(List.of("lt.EOS3LUSDT"), BybitApiConfig.V5_PUBLIC_SPOT);
    }
}
