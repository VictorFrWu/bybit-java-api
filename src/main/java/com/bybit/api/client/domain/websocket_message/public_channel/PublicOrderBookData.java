package com.bybit.api.client.domain.websocket_message.public_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicOrderBookData {
    private String s; // Symbol name
    private List<List<String>> b; // Bids
    private List<List<String>> a; // Asks
    private Long u; // Update ID
    private Long seq; // Sequence
    private Long cts; // Timestamp from the match engine
}
