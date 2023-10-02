package com.bybit.api.client.domain.trade;

import lombok.Getter;

@Getter
public enum TimeInForce {
    GTC("GoodTillCancel"),
    IOC("ImmediateOrCancel"),
    FOK("FillOrKill"),
    POST_ONLY("PostOnly");

    private final String description;

    TimeInForce(String description) {
        this.description = description;
    }
}