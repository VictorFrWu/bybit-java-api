package com.bybit.api.client.domain.position;

import lombok.Getter;

@Getter
public enum TpslMode {
    FULL("Full"),
    PARTIAL("Partial");

    private final String description;

    TpslMode(String description) {
        this.description = description;
    }
}
