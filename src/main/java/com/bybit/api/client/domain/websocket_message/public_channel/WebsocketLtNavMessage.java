package com.bybit.api.client.domain.websocket_message.public_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebsocketLtNavMessage {
    private String topic;
    private String type;
    private Long ts;
    private List<NavData> data;
}
