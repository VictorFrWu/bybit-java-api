package com.bybit.api.client.domain.trade.response;

import com.bybit.api.client.constant.BybitApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponse {
    private String orderId;
    private String orderLinkId;

    public OrderResponse(String orderId, String orderLinkId) {
        this.orderId = orderId;
        this.orderLinkId = orderLinkId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderLinkId() {
        return orderLinkId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderLinkId(String orderLinkId) {
        this.orderLinkId = orderLinkId;
    }

    @Override
    public String toString() {
        return  new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("orderId", orderId)
                .append("orderLinkId", orderLinkId)
                .toString();
    }
}
