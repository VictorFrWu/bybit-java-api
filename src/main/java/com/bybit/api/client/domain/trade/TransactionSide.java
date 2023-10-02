package com.bybit.api.client.domain.trade;

import lombok.Getter;

@Getter
public enum TransactionSide {
    BUY("Buy"),
    SELL("Sell");

    private final String description;

    TransactionSide(String description) {
        this.description = description;
    }

}

