package com.bybit.api.client.impl;

import com.bybit.api.client.exception.BybitApiException;
import com.bybit.api.client.BybitApiCallback;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Bybit API WebSocket listener.
 */
public class BybitApiWebSocketListener<T> extends WebSocketListener {

    private final BybitApiCallback<T> callback;

    private static final ObjectMapper mapper = new ObjectMapper();

    private final ObjectReader objectReader;

    private boolean closing = false;
    private final Logger logger = LoggerFactory.getLogger(BybitApiWebSocketListener.class);

    public BybitApiWebSocketListener(BybitApiCallback<T> callback, Class<T> eventClass) {
        this.callback = callback;
        this.objectReader = mapper.readerFor(eventClass);
    }

    public BybitApiWebSocketListener(BybitApiCallback<T> callback, TypeReference<T> eventTypeReference) {
        this.callback = callback;
        this.objectReader = mapper.readerFor(eventTypeReference);
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        Map<String, Object> subscribeRequest = new HashMap<>();
        subscribeRequest.put("op", "subscribe");
        subscribeRequest.put("args", new String[]{}); // You'll need to pass the topic while constructing the listener

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String subscribeMessage = objectMapper.writeValueAsString(subscribeRequest);
            webSocket.send(subscribeMessage);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        try {
            T event = objectReader.readValue(text);
            callback.onResponse(event);
        } catch (IOException e) {
            throw new BybitApiException(e);
        }
    }

    @Override
    public void onClosing(final WebSocket webSocket, final int code, final String reason) {
        closing = true;
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        if (!closing) {
            callback.onFailure(t);
        }
    }

}