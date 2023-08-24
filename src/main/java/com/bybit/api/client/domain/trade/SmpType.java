package com.bybit.api.client.domain.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * SMP execution type
 */
public enum SmpType {
    None,
    CancelMaker,
    CancelTaker,
    CancelBoth,
    UNKNOWN;

    @JsonCreator
    public static SmpType fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return UNKNOWN;
        }
        try {
            return SmpType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
