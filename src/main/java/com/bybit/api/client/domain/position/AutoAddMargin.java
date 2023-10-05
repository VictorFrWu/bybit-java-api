package com.bybit.api.client.domain.position;

import lombok.Getter;

@Getter
public enum AutoAddMargin {
    OFF(0),
    ON(1);

    private final int value;
    AutoAddMargin(int value) {
        this.value = value;
    }
}