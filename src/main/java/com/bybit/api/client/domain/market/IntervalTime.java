package com.bybit.api.client.domain.market;

import lombok.Getter;

@Getter
public enum IntervalTime {
    FIVE_MINUTES("5min"),
    FIFTEEN_MINUTES("15min"),
    THIRTY_MINUTES("30min"),
    ONE_HOUR("1h"),
    FOUR_HOURS("4h"),
    ONE_DAY("1d");

    private final String interval;

    IntervalTime(String interval) {
        this.interval = interval;
    }

}
