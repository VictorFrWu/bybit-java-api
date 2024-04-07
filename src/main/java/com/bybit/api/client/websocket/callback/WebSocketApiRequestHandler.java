package com.bybit.api.client.websocket.callback;

import com.bybit.api.client.exception.BybitApiException;
import com.bybit.api.client.security.SignatureGenerator;
import com.bybit.api.client.util.*;
import com.bybit.api.client.websocket.impl.WebSocketConnection;
import org.json.JSONObject;

public class WebSocketApiRequestHandler {
    private final SignatureGenerator signatureGenerator;
    private final String apiKey;
    private final WebSocketConnection connection;

    public WebSocketApiRequestHandler(WebSocketConnection connection, String apiKey, SignatureGenerator signatureGenerator) {
        if (connection == null) {
            throw new BybitApiException("[WebSocketApiRequestHandler] WebSocketConnection cannot be null");
        }
        this.connection = connection;
        this.apiKey = apiKey;
        this.signatureGenerator = signatureGenerator;
    }

    public void publicRequest(String method) {
        this.request(RequestType.PUBLIC, method, null);
    }

    public void publicRequest(String method, JSONObject parameters) {
        this.request(RequestType.PUBLIC, method, parameters);
    }

    public void signedRequest(String method, JSONObject parameters) {
        RequestType requestType = this.connection.getSessionStatus() ? RequestType.PUBLIC : RequestType.SIGNED;
        this.request(requestType, method, parameters);
    }

    public void request(RequestType requestType, String method, JSONObject parameters) {
        Object requestId = ParameterChecker.processId(JSONParser.pullValue(parameters, "requestId"), "requestId");
        ParameterChecker.checkParameterType(method, String.class, "method");

        switch (requestType) {
            case PUBLIC:
                this.connection.send(JSONParser.buildJSONString(requestId, method, parameters));
                break;
            case SIGNED:
                ParameterChecker.checkParameterType(this.apiKey, String.class, "apiKey");
                parameters = JSONParser.addKeyValue(parameters, "apiKey", this.apiKey);
                if (!parameters.has("timestamp")) {
                    parameters.put("timestamp", UrlBuilder.buildTimestamp());
                }

                // signature
                ParameterChecker.checkParameterType(this.signatureGenerator, SignatureGenerator.class, "signatureGenerator");
                String payload = UrlBuilder.joinQueryParameters(JSONParser.sortJSONObject(parameters));
                String signature = this.signatureGenerator.auth(payload);
                parameters.put("signature", signature);

                this.connection.send(JSONParser.buildJSONString(requestId, method, parameters));
                break;
            default:
                throw new BybitApiException("[WebSocketApiRequestHandler] Invalid request type: " + requestType);
        }
    }
}
