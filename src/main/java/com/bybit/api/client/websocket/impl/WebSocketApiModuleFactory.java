package com.bybit.api.client.websocket.impl;

import com.bybit.api.client.domain.trade.CancelType;
import com.bybit.api.client.exception.BybitApiException;
import com.bybit.api.client.websocket.api.WebSocketApiAuth;
import com.bybit.api.client.websocket.api.WebSocketApiModule;
import com.bybit.api.client.websocket.api.WebSocketApiTrade;
import com.bybit.api.client.websocket.callback.WebSocketApiRequestHandler;
import com.bybit.api.client.websocket.enums.Category;

public final class WebSocketApiModuleFactory {

    private static WebSocketApiAuth wsApiAuth;
    private static WebSocketApiTrade wsApiTrade;

    private WebSocketApiModuleFactory() {
        // Private constructor to prevent instantiation
    }

    private interface ModuleCreator {
        WebSocketApiModule create();
    }

    private static WebSocketApiModule obtainModule(WebSocketApiModule module, ModuleCreator creator) {
        if (module == null) {
            module = creator.create();
        }
        return module;
    }

    /**
     * Build WebSocketApiModule for the given WebSocket API category if it does not exist yet.
     * Otherwise, return the existing one.
     *
     * @param category WebSocket API Category
     * @param requestHandler WebSocketApiRequestHandler
     * @return WebSocketApiModule
     */
    public static WebSocketApiModule build(Category category, WebSocketApiRequestHandler requestHandler) {
        switch (category) {
            case AUTH:
                return obtainModule(wsApiAuth, () -> new WebSocketApiAuth(requestHandler));
            case TRADE:
                return obtainModule(wsApiTrade, () -> new WebSocketApiTrade(requestHandler));
            default:
                throw new BybitApiException("Unknown WebSocket API Category: " + category);
        }
    }

}