package com.bybit.api.client.domain.websocket_message.public_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeData {
    private Long T; // Timestamp of the order filled
    private String s; // Symbol name
    private String S; // Side of taker (Buy, Sell)
    private String v; // Trade size
    private String p; // Trade price
    private String L; // Direction of price change
    private String i; // Trade ID
    private Boolean BT; // Whether it is a block trade order or not
}
