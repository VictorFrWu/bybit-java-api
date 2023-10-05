package com.bybit.api.client.domain.position;

import lombok.Getter;

@Getter
public enum PositionMode {
    MERGED_SINGLE(0, "Merged Single"),
    BOTH_SIDES(3, "Both Sides");

    private final int value;
    private final String description;

    PositionMode(int value, String description) {
        this.value = value;
        this.description = description;
    }
}
