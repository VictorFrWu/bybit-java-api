package com.bybit.api.client.domain.market;

import lombok.Getter;

@Getter
public enum OptionType {
    CALL("Call"),
    PUT("Put");

    private final String opType;

    OptionType(String opType) {
        this.opType = opType;
    }
}
