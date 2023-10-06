package com.bybit.api.client.domain.user;

import lombok.Getter;

@Getter
public enum MemberType {
    NORMAL_SUB_ACCOUNT(1),
    CUSTODIAL_SUB_ACCOUNT(6);

    private final int value;

    MemberType(int value) {
        this.value = value;
    }
}
