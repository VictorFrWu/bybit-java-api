package com.bybit.api.client.domain.websocket_message.public_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NavData {
    private Long time;
    private String symbol;
    private String nav;
    private String basketPosition;
    private String leverage;
    private String basketLoan;
    private String circulation;
    private String basket;
}
