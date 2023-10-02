package com.bybit.api.client.domain.trade;

import lombok.Getter;

@Getter
public enum StopOrderType {
    TAKE_PROFIT("TakeProfit"),
    STOP_LOSS("StopLoss"),
    TRAILING_STOP("TrailingStop"),
    STOP("Stop"),
    PARTIAL_TAKE_PROFIT("PartialTakeProfit"),
    PARTIAL_STOP_LOSS("PartialStopLoss"),
    TPSL_ORDER("tpslOrder"),
    MM_RATE_CLOSE("MmRateClose");

    private final String description;

    StopOrderType(String description) {
        this.description = description;
    }
}
