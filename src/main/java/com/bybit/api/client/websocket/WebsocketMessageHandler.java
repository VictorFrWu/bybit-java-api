package com.bybit.api.client.websocket;

@FunctionalInterface
public interface WebsocketMessageHandler {
    void handleMessage(String message);
}
