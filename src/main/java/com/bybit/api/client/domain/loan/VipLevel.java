package com.bybit.api.client.domain.loan;

import lombok.Getter;

@Getter
public enum VipLevel {
    VIP_0("VIP0"),
    VIP_1("VIP1"),
    VIP_2("VIP2"),
    VIP_3("VIP3"),
    VIP_4("VIP4"),
    VIP_5("VIP5"),
    VIP_SUPREME("VIP99"),
    PRO_1("PRO1"),
    PRO_2("PRO2"),
    PRO_3("PRO3"),
    PRO_4("PRO4"),
    PRO_5("PRO5"),
    PRO_6("PRO6");

    private final String level;

    VipLevel(String level) {
        this.level = level;
    }
}
