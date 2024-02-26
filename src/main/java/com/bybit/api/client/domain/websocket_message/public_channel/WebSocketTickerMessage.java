package com.bybit.api.client.domain.websocket_message.public_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebSocketTickerMessage {
    private String topic;
    private Long ts;
    private String type;
    private Long cs;
    private PublicTickerData data;
}
