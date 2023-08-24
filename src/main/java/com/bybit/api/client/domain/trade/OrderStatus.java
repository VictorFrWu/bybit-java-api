package com.bybit.api.client.domain.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Status of a submitted order.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OrderStatus {
    Created, // order has been accepted by the system but not yet put through the matching engine
    New, // order has been placed successfully
    Rejected,
    PartiallyFilled,
    PartiallyFilledCanceled, // Only spot has this order status
    Filled,
    Cancelled, // In derivatives, orders with this status may have an executed qty
    Untriggered,
    Triggered,
    Deactivated,
    Active, // order has been triggered and the new active order has been successfully placed. is the final state of a successful conditional order
    UNKNOWN;

    @JsonCreator
    public static OrderStatus fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return UNKNOWN;
        }
        try {
            return OrderStatus.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
