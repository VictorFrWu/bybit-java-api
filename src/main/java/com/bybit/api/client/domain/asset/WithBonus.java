package com.bybit.api.client.domain.asset;

import lombok.Getter;

@Getter
public enum WithBonus {
    NOT_QUERY(0),
    QUERY(1);

    private final int value;

    WithBonus(int value) {
        this.value = value;
    }
}
