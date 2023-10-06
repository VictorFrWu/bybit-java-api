package com.bybit.api.client.domain.user;

import lombok.Getter;

@Getter
public enum ReadOnlyStatus {
    READ_AND_WRITE(0),
    READ_ONLY(1);

    private final int value;

    ReadOnlyStatus(int value) {
        this.value = value;
    }
}
