package com.bybit.api.client.domain.market.response.fundingRate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *  historical funding rates. Each symbol has a different funding interval.
 */
@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class FundingRateResult {
    @JsonProperty("category")
    private String category;

    @JsonProperty("list")
    private List<FundingRateEntry> fundingRateEntries;
}

