package com.bybit.api.client.domain.spot;

import lombok.Getter;

@Getter
public enum CompleteRepayment {
    TRUE(1),
    FALSE(0);

    private final int value;

    CompleteRepayment(int value) {
        this.value = value;
    }
}
