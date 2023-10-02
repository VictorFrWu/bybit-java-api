package com.bybit.api.client.domain.market;

import lombok.Getter;

@Getter
public enum MarketStatus {
    PRE_LAUNCH("PreLaunch"),
    TRADING("Trading"),
    SETTLING("Settling"),
    DELIVERING("Delivering"),
    CLOSED("Closed");

    private final String status;

    MarketStatus(String status) {
        this.status = status;
    }
}


