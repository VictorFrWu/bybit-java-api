package com.bybit.api.client.domain.market.response.kline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.util.List;

/**
 * Kline/Candlestick bars for a symbol. Klines are uniquely identified by their open time.
 */
@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class MarketKlineResult {
    @JsonProperty("category")
    private String category;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("list")
    private List<MarketKlineEntry> marketKlineEntries;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MarketKlineResult[category=").append(category)
                .append(",symbol=").append(symbol)
                .append(",marketKlineEntries=[\n");

        for (MarketKlineEntry entry : marketKlineEntries) {
            builder.append("\t").append(entry.toString()).append(",\n");
        }

        builder.append("]]");

        return builder.toString();
    }
}

