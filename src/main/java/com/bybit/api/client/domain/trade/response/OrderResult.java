package com.bybit.api.client.domain.trade.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Trade order information.
 */
@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderResult {
    @JsonProperty("nextPageCursor")
    private String nextPageCursor;
    @JsonProperty("category")
    private String category;
    @JsonProperty("list")
    private List<OrderEntry> orderEntries;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OrderResult[nextPageCursor=").append(nextPageCursor)
                .append(", category=").append(category)
                .append(",orderEntries=[\n");

        for (OrderEntry entry : orderEntries) {
            builder.append("\t").append(entry.toString()).append(",\n");
        }

        builder.append("]]");

        return builder.toString();
    }
}
