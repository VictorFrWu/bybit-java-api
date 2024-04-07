package com.bybit.api.client.websocket.callback;

import com.fasterxml.jackson.core.JsonProcessingException;

@FunctionalInterface
public interface WebSocketMessageCallback {
    void onMessage(String message) throws JsonProcessingException;
}
