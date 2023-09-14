package com.bybit.api.client.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

/**
 * Kline/Candlestick intervals.
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketInterval {
    ONE_MINUTE("1"),
    THREE_MINUTES("3"),
    FIVE_MINUTES("5"),
    FIFTEEN_MINUTES("15"),
    HALF_HOURLY("30"),
    HOURLY("60"),
    TWO_HOURLY("120"),
    FOUR_HOURLY("240"),
    SIX_HOURLY("360"),
    TWELVE_HOURLY("720"),
    DAILY("D"),
    WEEKLY("W"),
    MONTHLY("M");

    private final String intervalId;

    MarketInterval(String intervalId) {
        this.intervalId = intervalId;
    }

}
