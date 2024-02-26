package com.bybit.api.client.domain.websocket_message.public_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebsocketOrderbookMessage {
    private String topic;
    private String type;
    private Long ts;
    private PublicOrderBookData data;
}
