package com.bybit.api.client.domain.trade.requests;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.trade.OrderStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OrderHistoryRequest extends OrderRequest {
    private static final Integer DEFAULT_LIMIT = 20;
    private String symbol;
    private String baseCoin;
    private String settleCoin;
    private String orderId;
    private String orderLinkId;
    private String orderFilter;
    private OrderStatus orderStatus;
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;

    public OrderHistoryRequest(ProductType category) {
        super(category);
        this.limit = DEFAULT_LIMIT;
    }

    public OrderHistoryRequest orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderHistoryRequest limit(Integer limit) {
        this.limit = limit;
        return this;
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

    public String getOrderFilter() {
        return orderFilter;
    }

    public void setOrderFilter(String orderFilter) {
        this.orderFilter = orderFilter;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("baseCoin", baseCoin)
                .append("settleCoin", settleCoin)
                .append("orderId", orderId)
                .append("orderLinkId", orderLinkId)
                .append("orderFilter", orderFilter)
                .append("orderStatus", orderStatus)
                .append("startTime", startTime)
                .append("endTime", endTime)
                .append("limit", limit)
                .append("cursor", cursor)
                .toString();
    }
}
