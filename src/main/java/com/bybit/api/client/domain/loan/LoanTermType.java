package com.bybit.api.client.domain.loan;

import lombok.Getter;

@Getter
public enum LoanTermType {
    FLEXIBLE("2"),
    FIXED("1");

    private final String termType;

    LoanTermType(String termType) {
        this.termType = termType;
    }
}
