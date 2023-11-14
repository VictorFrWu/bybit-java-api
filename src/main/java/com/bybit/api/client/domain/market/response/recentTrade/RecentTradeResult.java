package com.bybit.api.client.domain.market.response.recentTrade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder
public class RecentTradeResult {
    @JsonProperty("category")
    private String category;
    @JsonProperty("list")
    private List<RecentTradeEntry> recentTradeEntries;
}
