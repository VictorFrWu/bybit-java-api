package com.bybit.api.client.domain.websocket_message.private_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebSocketGreekMessage {
    private String id;
    private String topic;
    private Long creationTime;
    private List<GreekData> data; // Assuming 'data' is an array of KlineData objects
}
