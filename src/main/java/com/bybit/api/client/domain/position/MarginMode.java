package com.bybit.api.client.domain.position;

import lombok.Getter;

@Getter
public enum MarginMode {
    CROSS_MARGIN(0, "Cross Margin"),
    ISOLATED_MARGIN(1, "Isolated Margin");

    private final int value;
    private final String description;

    MarginMode(int value, String description) {
        this.value = value;
        this.description = description;
    }
}
