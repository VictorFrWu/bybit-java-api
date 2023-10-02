package com.bybit.api.client.domain.trade;

import lombok.Getter;

/**
 * Status of a submitted order.
 */
@Getter
public enum OrderStatus {
    CREATED("Created"),
    NEW("New"),
    REJECTED("Rejected"),
    PARTIALLY_FILLED("PartiallyFilled"),
    PARTIALLY_FILLED_CANCELED("PartiallyFilledCanceled"),
    FILLED("Filled"),
    CANCELLED("Cancelled"),
    UNTRIGGERED("Untriggered"),
    TRIGGERED("Triggered"),
    DEACTIVATED("Deactivated"),
    ACTIVE("Active");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }
}