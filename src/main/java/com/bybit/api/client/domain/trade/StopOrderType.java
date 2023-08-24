package com.bybit.api.client.domain.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StopOrderType {
    TakeProfit,
    StopLoss,
    TrailingStop,
    Stop,
    PartialTakeProfit,
    PartialStopLoss,
    tpslOrder, // spot TP/SL order
    NULL, //not a condition order
    UNKNOWN;

    @JsonCreator
    public static StopOrderType fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return NULL;
        }
        try {
            return StopOrderType.valueOf(value);
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
