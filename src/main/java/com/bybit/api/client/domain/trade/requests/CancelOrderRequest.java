package com.bybit.api.client.domain.trade.requests;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.ProductType;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CancelOrderRequest {
    private final ProductType category;
    private final String symbol;
    private String orderId;
    private String orderLinkId;
    private String orderFilter = "Order"; // Defaulting to "Order"

    public ProductType getCategory() {
        return category;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderLinkId() {
        return orderLinkId;
    }

    public void setOrderLinkId(String orderLinkId) {
        this.orderLinkId = orderLinkId;
    }

    public String getOrderFilter() {
        return orderFilter;
    }

    public void setOrderFilter(String orderFilter) {
        this.orderFilter = orderFilter;
    }

    // Private constructor to enforce the use of Builder
    private CancelOrderRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.orderId = builder.orderId;
        this.orderLinkId = builder.orderLinkId;
        this.orderFilter = builder.orderFilter;
    }

    public static class Builder {
        private final ProductType category;
        private final String symbol;
        private String orderId;
        private String orderLinkId;
        private String orderFilter;

        public Builder(ProductType category, String symbol) {
            this.category = category;
            this.symbol = symbol;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder orderLinkId(String orderLinkId) {
            this.orderLinkId = orderLinkId;
            return this;
        }

        public Builder orderFilter(String orderFilter) {
            this.orderFilter = orderFilter;
            return this;
        }

        public CancelOrderRequest build() {
            return new CancelOrderRequest(this);
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("category", category)
                .append("symbol", symbol)
                .append("orderId", orderId)
                .append("orderLinkId", orderLinkId)
                .append("orderFilter", orderFilter)
                .toString();
    }
}
