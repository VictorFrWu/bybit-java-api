package com.bybit.api.client.domain.spot;

import lombok.Getter;

@Getter
public enum VipLevel {
    NO_VIP("No VIP"),
    VIP_1("VIP-1"),
    VIP_2("VIP-2"),
    VIP_3("VIP-3"),
    VIP_4("VIP-4"),
    VIP_5("VIP-5"),
    VIP_SUPREME("VIP-Supreme"),
    PRO_1("PRO-1"),
    PRO_2("PRO-2"),
    PRO_3("PRO-3"),
    PRO_4("PRO-4"),
    PRO_5("PRO-5");

    private final String level;

    VipLevel(String level) {
        this.level = level;
    }

}
