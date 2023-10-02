package com.bybit.api.client.domain.trade;

import lombok.Getter;

/**
 * Position index. Used to identify positions in different position modes
 */
@Getter
public enum PositionIdx {
    ONE_WAY_MODE(0, "one-way mode position"),
    HEDGE_MODE_BUY(1, "Buy side of hedge-mode position"),
    HEDGE_MODE_SELL(2, "Sell side of hedge-mode position");

    private final int index;
    private final String description;

    PositionIdx(int index, String description) {
        this.index = index;
        this.description = description;
    }
}
