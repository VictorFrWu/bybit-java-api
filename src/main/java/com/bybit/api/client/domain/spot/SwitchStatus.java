package com.bybit.api.client.domain.spot;

import lombok.Getter;

@Getter
public enum SwitchStatus {
    ON(1),
    OFF(0);

    private final int value;

    SwitchStatus(int value) {
        this.value = value;
    }
}
