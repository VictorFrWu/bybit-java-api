package com.bybit.api.client.domain.market;

import lombok.Getter;

@Getter
public enum InstrumentStatus {
    PRE_LAUNCH("PreLaunch"),
    TRADING("Trading"),
    SETTLING("Settling"),  // Unique status for USDC Perpetual 8-hour settlement
    DELIVERING("Delivering"),
    CLOSED("Closed");

    private final String status;

    InstrumentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
