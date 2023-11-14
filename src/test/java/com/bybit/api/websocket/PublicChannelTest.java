package com.bybit.api.websocket;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

import java.util.List;

public class PublicChannelTest {
    @Test
    public void Test_GetOrderBookStream1()
    {
        // create websocket with message handler and in debug mode
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        var client = factory.newWebsocketClient((message) -> System.out.println("Handle message :" + message));
        client.getPublicChannelStream(List.of("orderbook.50.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
    }

    @Test
    public void Test_GetOrderBookStream2()
    {
        // create websocket with message handler and  not in debug mode
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        var client = factory.newWebsocketClient((message) -> System.out.println("Handle message :" + message));
        client.getPublicChannelStream(List.of("orderbook.50.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
    }

    @Test
    public void Test_GetOrderBookStream3()
    {
        // create websocket without message handler and in debug mode
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        var client = factory.newWebsocketClient();
        client.getPublicChannelStream(List.of("orderbook.50.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
    }

    @Test
    public void Test_GetOrderBookStream4()
    {
        // create websocket without message handler and  not in debug mode
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        var client = factory.newWebsocketClient();
        client.getPublicChannelStream(List.of("orderbook.50.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
    }

    @Test
    public void Test_GetOrderBookStream5()
    {
        // Subscribe more than one args
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance(false);
        var client = factory.newWebsocketClient();
        client.getPublicChannelStream(List.of("orderbook.50.BTCUSDT","orderbook.1.ETHUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
    }
}
