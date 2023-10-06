package com.bybit.api.client.domain.user;

import lombok.Getter;

@Getter
public enum FrozenStatus {
    UNFREEZE(0),
    FREEZE(1);

    private final int value;

    FrozenStatus(int value) {
        this.value = value;
    }
}
