package com.bybit.api.client.domain.spot;

import lombok.Getter;

@Getter
public enum BorrowStatus {
    ALL_STATUS(0),
    UNCLEARED(1),
    CLEARED(2);
    private final int value;
    BorrowStatus(int value) {
        this.value = value;
    }
}
