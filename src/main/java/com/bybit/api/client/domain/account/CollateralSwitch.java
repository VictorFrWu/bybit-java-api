package com.bybit.api.client.domain.account;

import lombok.Getter;

@Getter
public enum CollateralSwitch {
    ON("ON"),
    OFF("OFF");

    private final String collateralSwitchMode;

    CollateralSwitch(String collateralSwitchMode) {
        this.collateralSwitchMode = collateralSwitchMode;
    }
}
