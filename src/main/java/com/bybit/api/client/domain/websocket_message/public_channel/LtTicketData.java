package com.bybit.api.client.domain.websocket_message.public_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LtTicketData {
    private String symbol;
    private String price24hPcnt;
    private String lastPrice;
    private String prevPrice24h;
    private String highPrice24h;
    private String lowPrice24h;
}
