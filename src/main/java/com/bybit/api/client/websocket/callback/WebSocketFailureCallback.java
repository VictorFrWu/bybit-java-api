package com.bybit.api.client.websocket.callback;

import okhttp3.Response;

@FunctionalInterface
public interface WebSocketFailureCallback {
    /**
     * onFailure will be called when the websocket has been closed and an error has occurred.
     *
     * @param t The exception thrown by server.
     * @param response The associated response.
     */
    void onFailure(Throwable t, Response response);
}
