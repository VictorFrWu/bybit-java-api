package com.bybit.api.client.websocket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebsocketMessage {
    private Object websocketMessage;
}
