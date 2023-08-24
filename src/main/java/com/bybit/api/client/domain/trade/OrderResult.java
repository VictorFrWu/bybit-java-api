package com.bybit.api.client.domain.trade;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.market.MarketKlineEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Trade order information.
 */
@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResult {
    @JsonProperty("nextPageCursor")
    private String nextPageCursor;
    @JsonProperty("category")
    private String category;
    @JsonProperty("list")
    private List<OrderEntry> orderEntries;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<OrderEntry> getOrderEntries() {
        return orderEntries;
    }

    public void setOrderEntries(List<OrderEntry> orderEntries) {
        this.orderEntries = orderEntries;
    }

    public String getNextPageCursor() {
        return nextPageCursor;
    }

    public void setNextPageCursor(String nextPageCursor) {
        this.nextPageCursor = nextPageCursor;
    }

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
