package com.bybit.api.client.domain.account;

public enum AccountType {
    CONTRACT("CONTRACT"),
    SPOT("SPOT"),
    INVESTMENT("INVESTMENT"),
    OPTION("OPTION"),
    UNIFIED("UNIFIED"),
    FUND("FUND");

    private final String accountTypeValue;

    AccountType(String accountTypeValue) {
        this.accountTypeValue = accountTypeValue;
    }

    public String getAccountTypeValue() {
        return accountTypeValue;
    }
}
