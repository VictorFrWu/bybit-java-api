package com.bybit.api.client.domain.account;

import lombok.Getter;

@Getter
public enum AccountType {
    CONTRACT("CONTRACT"),
    SPOT("SPOT"),
    INVESTMENT("INVESTMENT"),
    OPTION("OPTION"),
    UNIFIED("UNIFIED"),
    FUND("FUND"),

    // Convert
    CONVERT_UTA("eb_convert_uta"),
    CONVERT_SPOT("eb_convert_spot"),
    CONVERT_contract("eb_convert_contract"),
    CONVERT_FUNDING("eb_convert_funding");

    private final String accountTypeValue;

    AccountType(String accountTypeValue) {
        this.accountTypeValue = accountTypeValue;
    }
}
