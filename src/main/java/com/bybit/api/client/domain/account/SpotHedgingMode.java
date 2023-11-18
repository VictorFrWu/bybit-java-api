package com.bybit.api.client.domain.account;

import lombok.Getter;

@Getter
public enum SpotHedgingMode {
    ON("ON"),
    OFF("OFF");

    private final String spotHedgingMode;

    SpotHedgingMode(String spotHedgingMode) {
        this.spotHedgingMode = spotHedgingMode;
    }
}
