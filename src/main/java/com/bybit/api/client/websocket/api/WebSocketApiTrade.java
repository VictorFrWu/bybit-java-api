package com.bybit.api.client.websocket.api;

import com.bybit.api.client.util.ParameterChecker;
import com.bybit.api.client.util.JSONParser;
import org.json.JSONObject;
import com.bybit.api.client.websocket.api.WebSocketApiModule;
import com.bybit.api.client.websocket.callback.WebSocketApiRequestHandler;

/**
 * <h2>Trading Requests</h2>
 * All requests under the
 * <a href="https://binance-docs.github.io/apidocs/websocket_api/en/#trading-requests">Trading requests</a>
 * section of the WebSocket API documentation will be implemented in this class.
 * <br>
 * Response will be returned as callback.
 */
public class WebSocketApiTrade implements WebSocketApiModule {
    private final WebSocketApiRequestHandler handler;

    public WebSocketApiTrade(WebSocketApiRequestHandler handler) {
        this.handler = handler;
    }

    public void newOrder(String category, String symbol, String side, String type, String qty, JSONObject parameters) {

        ParameterChecker.checkParameterType(category, String.class, "category");
        ParameterChecker.checkParameterType(symbol, String.class, "symbol");
        ParameterChecker.checkParameterType(side, String.class, "side");
        ParameterChecker.checkParameterType(type, String.class, "type");
        ParameterChecker.checkParameterType(qty, String.class, "qty");

        parameters = JSONParser.addKeyValue(parameters, "category", category);
        parameters = JSONParser.addKeyValue(parameters, "symbol", symbol);
        parameters = JSONParser.addKeyValue(parameters, "side", side);
        parameters = JSONParser.addKeyValue(parameters, "type", type);
        parameters = JSONParser.addKeyValue(parameters, "qty", qty);

        this.handler.signedRequest("order.create", parameters);
    }
}
