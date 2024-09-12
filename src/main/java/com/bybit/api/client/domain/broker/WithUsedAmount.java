package com.bybit.api.client.domain.broker;

import lombok.Getter;

@Getter
public enum WithUsedAmount {
    NOT_QUERY(false),
    QUERY(true);

    private final Boolean value;

    WithUsedAmount(Boolean value) {
        this.value = value;
    }
}
