package com.bybit.api.client.domain.trade;

import lombok.Getter;

/**
 * Position index. Used to identify positions in different position modes
 */
@Getter
public enum PositionIdx {
    ONE_WAY_MODE(0),
    HEDGE_MODE_BUY(1),
    HEDGE_MODE_SELL(2);

    private final int index;

    PositionIdx(int index) {
        this.index = index;
    }
}
