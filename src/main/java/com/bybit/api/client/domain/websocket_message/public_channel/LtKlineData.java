package com.bybit.api.client.domain.websocket_message.public_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LtKlineData {
    private Long start;
    private Long end;
    private String interval;
    private String open;
    private String close;
    private String high;
    private String low;
    private Boolean confirm;
    private Long timestamp;
}
