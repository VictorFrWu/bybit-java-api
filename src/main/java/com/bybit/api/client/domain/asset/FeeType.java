package com.bybit.api.client.domain.asset;

import lombok.Getter;

@Getter
public enum FeeType {
    MANUAL_CALCULATION(0),
    AUTO_DEDUCT(1);

    private final int value;
    FeeType(int value) {
        this.value = value;
    }
}

