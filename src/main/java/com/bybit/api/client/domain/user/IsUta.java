package com.bybit.api.client.domain.user;

import lombok.Getter;

@Getter
public enum IsUta {
    UTA_ACCOUNT(true),
    CLASSIC_ACCOUNT(false);

    private final boolean value;

    IsUta(boolean value) {
        this.value = value;
    }
}
