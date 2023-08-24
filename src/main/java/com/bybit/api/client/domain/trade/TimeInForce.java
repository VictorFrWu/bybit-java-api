package com.bybit.api.client.domain.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TimeInForce {
    GTC,
    IOC,
    FOK,
    PostOnly,
    Null,     // not a conditional order
    UNKNOWN;

    @JsonCreator
    public static TimeInForce fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return Null;
        }
        try {
            return TimeInForce.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
