package com.bybit.api.client.domain.market;

import lombok.Getter;

@Getter
public enum DataRecordingPeriod {
    FIVE_MINUTES("5min"),
    FIFTEEN_MINUTES("15min"),
    THIRTY_MINUTES("30min"),
    ONE_HOUR("1h"),
    FOUR_HOURS("4h"),
    FOUR_DAYS("4d");

    private final String period;

    DataRecordingPeriod(String period) {
        this.period = period;
    }

}