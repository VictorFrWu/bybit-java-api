package com.bybit.api.client.domain.market.response.orderbook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.util.List;

/**
 * orderbook depth data
 */
@JsonPropertyOrder
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class OrderbookResult {
    @JsonProperty("s")
    private String symbol;
    @JsonProperty("b")
    private List<OrderbookBidEntry> orderbookBidEntries;
    @JsonProperty("a")
    private List<OrderBookAskEntry> orderBookAskEntries;
    @JsonProperty("ts")
    private long timestamp;
    @JsonProperty("u")
    private long updateId;
}
