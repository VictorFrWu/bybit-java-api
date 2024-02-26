package com.bybit.api.client.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;

@FunctionalInterface
public interface WebsocketMessageHandler {
    void handleMessage(String message) throws JsonProcessingException;
}
