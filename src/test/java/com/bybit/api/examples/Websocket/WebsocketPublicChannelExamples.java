package com.bybit.api.examples.Websocket;

import java.util.List;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiClientFactory;
public class WebsocketPublicChannelExamples {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        var client = factory.newWebsocketClient((message) -> System.out.println("Handle message :" + message));

        // Orderbook
        // client.getOrderBookStream(List.of("orderbook.50.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // Trade
        // client.getTradeStream(List.of("publicTrade.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // Ticker
        // client.getTickerStream(List.of("tickers.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // Kline
        // client.getMarketKlineStream(List.of("kline.D.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // Liquidation
        // client.getLiquidationStream(List.of("liquidation.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);

        // LT Kline
        client.getLeverageKlineStream(List.of("kline_lt.1.EOS3LUSDT"), BybitApiConfig.V5_PUBLIC_SPOT);

        // LT Ticker
        // client.getLeverageTickerStream(List.of("tickers_lt.1.EOS3LUSDT"), BybitApiConfig.V5_PUBLIC_SPOT);

        // LT Nav
        // client.getLeverageNavStream(List.of("lt.EOS3LUSDT"), BybitApiConfig.V5_PUBLIC_SPOT);
    }
}
