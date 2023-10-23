package com.bybit.api.client.domain.institution;

import lombok.Getter;

@Getter
public enum LendingOrderType {
    DEPOSIT("1"),
    REDEMPTION("2"),
    PAYMENT_PROCEED("3");

    private final String type;

    LendingOrderType(String type) {
        this.type = type;
    }
}
