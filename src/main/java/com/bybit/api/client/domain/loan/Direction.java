package com.bybit.api.client.domain.loan;

import lombok.Getter;

@Getter
public enum Direction {
    ADD("0"),
    REDUCE("1");

    private final String directionValue;

    Direction(String directionValue) {
        this.directionValue = directionValue;
    }
}
