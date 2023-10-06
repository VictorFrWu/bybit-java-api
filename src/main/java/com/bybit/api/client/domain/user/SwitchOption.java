package com.bybit.api.client.domain.user;

import lombok.Getter;

@Getter
public enum SwitchOption {
    TURN_OFF(0),
    TURN_ON(1);

    private final int value;

    SwitchOption(int value) {
        this.value = value;
    }
}
