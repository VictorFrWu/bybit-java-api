package com.bybit.api.client.domain.loan;

import lombok.Getter;

@Getter
public enum LoanTerm {
    FLEXIBLE(""),
    FIXED_7D("7"),
    FIXED_14D("14"),
    FIXED_30D("30"),
    FIXED_90D("90"),
    FIXED_180D("180");

    private final String term;

    LoanTerm(String term) {
        this.term = term;
    }
}
