package com.bybit.api.client.domain.broker;

import lombok.Getter;

@Getter
public enum BusinessType {
    SPOT("SPOT"),
    DERIVATIVES("DERIVATIVES"),
    OPTIONS("OPTIONS");

    private final String type;

    BusinessType(String type) {
        this.type = type;
    }

}

