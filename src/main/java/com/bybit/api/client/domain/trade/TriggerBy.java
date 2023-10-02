package com.bybit.api.client.domain.trade;

import lombok.Getter;

@Getter
public enum TriggerBy {
    LAST_PRICE("LastPrice"),
    INDEX_PRICE("IndexPrice"),
    MARK_PRICE("MarkPrice");

    private final String trigger;

    TriggerBy(String trigger) {
        this.trigger = trigger;
    }

    public String getTrigger() {
        return trigger;
    }

    @Override
    public String toString() {
        return trigger;
    }
}
