package com.bybit.api.client.domain.market.response.openInterests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@JsonPropertyOrder
public class OpenInterestResult {
    @JsonProperty("category")
    private String category;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("list")
    private List<OpenInterestEntry> openInterestEntries;
    @JsonProperty("nextPageCursor")
    private String nextPageCursor;
}
