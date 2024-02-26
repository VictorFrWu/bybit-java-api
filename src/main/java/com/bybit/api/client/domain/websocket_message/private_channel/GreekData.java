package com.bybit.api.client.domain.websocket_message.private_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GreekData {
    private String baseCoin;
    private String totalDelta;
    private String totalGamma;
    private String totalVega;
    private String totalTheta;
}
