package com.bybit.api.client.domain.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CancelType {
    CancelByUser,
    CancelByReduceOnly,
    CancelByPrepareLiq,
    CancelAllBeforeLiq, //Cancelled due to liquidation
    CancelByPrepareAdl,
    CancelAllBeforeAdl, //Cancelled due to ADL
    CancelByAdmin,
    CancelByTpSlTsClear,
    CancelByPzSideCh,
    CancelBySmp,
    Null,     // order was executed
    UNKNOWN;

    @JsonCreator
    public static CancelType fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return Null;
        }
        try {
            return CancelType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
