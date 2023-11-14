package com.bybit.api.client.domain.market.response.historicalVolatility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HistoricalVolatilityEntry {
    private Integer period;
    @JsonProperty("value")
    private String Volatility;
    private String time;
}
