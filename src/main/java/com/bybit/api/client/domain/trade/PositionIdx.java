package com.bybit.api.client.domain.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Position index. Used to identify positions in different position modes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum PositionIdx {
    ONE_WAY_MODE_POSITION,    // one-way mode position
    BUY_SIDE_HEDGE_MODE_POSITION, // Buy side of hedge-mode position
    SELL_SIDE_HEDGE_MODE_POSITION, // Sell side of hedge-mode position
    UNKNOWN;

    @JsonCreator
    public static PositionIdx fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return UNKNOWN;
        }
        try {
            return PositionIdx.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
