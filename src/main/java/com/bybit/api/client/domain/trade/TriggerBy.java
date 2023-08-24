package com.bybit.api.client.domain.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TriggerBy {
    LastPrice,
    IndexPrice,
    MarkPrice,
    Null,     // not a conditional order
    UNKNOWN;

    @JsonCreator
    public static TriggerBy fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return Null;
        }
        try {
            return TriggerBy.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
