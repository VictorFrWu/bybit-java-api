package com.bybit.api.client.domain.position;

import lombok.Getter;

@Getter
public enum MovePositionStatus {
    Processing("Processing"),
    Filled("Filled"),
    Rejected("Rejected");

    private final String movePositionStatus;

    MovePositionStatus(String movePositionStatus) {
        this.movePositionStatus = movePositionStatus;
    }
}
