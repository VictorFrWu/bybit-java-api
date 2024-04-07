package com.bybit.api.client.websocket.httpclient;

import com.bybit.api.client.websocket.api.WebSocketApiAuth;
import com.bybit.api.client.websocket.api.WebSocketApiTrade;
import com.bybit.api.client.websocket.callback.*;

public interface WebSocketApiClient {
    void connect(WebSocketMessageCallback onMessageCallback);
    void connect(WebSocketOpenCallback onOpenCallback, WebSocketMessageCallback onMessageCallback, WebSocketClosingCallback onClosingCallback, WebSocketClosedCallback onClosedCallback, WebSocketFailureCallback onFailureCallback);
    void close();
    WebSocketApiAuth auth();
    WebSocketApiTrade trade();
}
