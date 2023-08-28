package com.bybit.api.client.domain.trade.requests;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.ProductType;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OpenOrderRequest {
    private final ProductType category;
    private String symbol;
    private String baseCoin;
    private String settleCoin;
    private String orderId;
    private String orderLinkId;
    private Integer openOnly;
    private String orderFilter;
    private Integer limit;
    private String cursor;

    public ProductType getCategory() {
        return category;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBaseCoin() {
        return baseCoin;
    }

    public void setBaseCoin(String baseCoin) {
        this.baseCoin = baseCoin;
    }

    public String getSettleCoin() {
        return settleCoin;
    }

    public void setSettleCoin(String settleCoin) {
        this.settleCoin = settleCoin;
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

    public Integer getOpenOnly() {
        return openOnly;
    }

    public void setOpenOnly(Integer openOnly) {
        this.openOnly = openOnly;
    }

    public String getOrderFilter() {
        return orderFilter;
    }

    public void setOrderFilter(String orderFilter) {
        this.orderFilter = orderFilter;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    // Private constructor to enforce the use of Builder
    private OpenOrderRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.baseCoin = builder.baseCoin;
        this.settleCoin = builder.settleCoin;
        this.orderId = builder.orderId;
        this.orderLinkId = builder.orderLinkId;
        this.openOnly = builder.openOnly;
        this.orderFilter = builder.orderFilter;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }
    public static class Builder {
        private final ProductType category;
        private String symbol;
        private String baseCoin;
        private String settleCoin;
        private String orderId;
        private String orderLinkId;
        private Integer openOnly;
        private String orderFilter;
        private Integer limit;
        private String cursor;

        public Builder(ProductType category) {
            this.category = category;
        }

        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder baseCoin(String baseCoin) {
            this.baseCoin = baseCoin;
            return this;
        }

        public Builder settleCoin(String settleCoin) {
            this.settleCoin = settleCoin;
            return this;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder orderLinkId(String orderLinkId) {
            this.orderLinkId = orderLinkId;
            return this;
        }

        public Builder openOnly(Integer openOnly) {
            this.openOnly = openOnly;
            return this;
        }

        public Builder orderFilter(String orderFilter) {
            this.orderFilter = orderFilter;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public OpenOrderRequest build() {
            return new OpenOrderRequest(this);
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("category", category)
                .append("symbol", symbol)
                .append("baseCoin", baseCoin)
                .append("settleCoin", settleCoin)
                .append("orderId", orderId)
                .append("orderLinkId", orderLinkId)
                .append("orderFilter", orderFilter)
                .append("openOnly", openOnly)
                .append("limit", limit)
                .append("cursor", cursor)
                .toString();
    }

}
