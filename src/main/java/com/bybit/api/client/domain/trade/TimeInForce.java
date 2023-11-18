package com.bybit.api.client.domain.trade;

import lombok.Getter;

@Getter
public enum TimeInForce {
    GOOD_TILL_CANCEL("GTC"),
    IMMEDIATE_OR_CANCEL("IOC"),
    FILL_OR_KILL("FOK"),
    POST_ONLY("PostOnly"),
    GTC("GTC"),
    IOC("IOC"),
    FOK("FOK");

    private final String description;

    TimeInForce(String description) {
        this.description = description;
    }
}