package com.bybit.api.client.domain.asset;

import lombok.Getter;

@Getter
public enum WithTransferSafeAmount {
    FALSE(0),
    TRUE(1);

    private final int value;

    WithTransferSafeAmount(int value) {
        this.value = value;
    }
}
