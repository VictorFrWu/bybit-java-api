package com.bybit.api.client.domain.asset;

import lombok.Getter;

@Getter
public enum WithdrawType {
    ON_CHAIN(0),
    OFF_CHAIN(1),
    ALL(2);

    private final int value;

    WithdrawType(int value) {
        this.value = value;
    }
}




