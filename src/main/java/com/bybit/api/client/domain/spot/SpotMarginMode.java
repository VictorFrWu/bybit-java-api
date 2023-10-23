package com.bybit.api.client.domain.spot;

import lombok.Getter;

@Getter
public enum SpotMarginMode {
    ON("1"),
    OFF("0");

    private final String value;

    SpotMarginMode(String value) {
        this.value = value;
    }
}
