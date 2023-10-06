package com.bybit.api.client.domain.position;

import lombok.Getter;

@Getter
public enum MarginMode {
    CROSS_MARGIN(0, "REGULAR_MARGIN"), // Cross margin
    ISOLATED_MARGIN(1, "ISOLATED_MARGIN"),
    PORTFOLIO_MARGIN(2,"PORTFOLIO_MARGIN");

    private final int value;
    private final String description;

    MarginMode(int value, String description) {
        this.value = value;
        this.description = description;
    }
}
