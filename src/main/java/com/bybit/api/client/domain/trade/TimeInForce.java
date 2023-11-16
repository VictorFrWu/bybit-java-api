package com.bybit.api.client.domain.trade;

import lombok.Getter;

@Getter
public enum TimeInForce {
    GOOD_TILL_CANCEL("GoodTillCancel"),
    IMMEDIATE_OR_CANCEL("ImmediateOrCancel"),
    FILL_OR_KILL("FillOrKill"),
    POST_ONLY("PostOnly"),
    GTC("GTC"),
    IOC("IOC"),
    FOK("FOK");

    private final String[] description;

    TimeInForce(String ... description) {
        this.description = description;
    }
}