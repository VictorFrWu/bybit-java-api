package com.bybit.api.client.domain.loan.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CryptoLoanBorrowRequest {
    private String loanCurrency; // mandatory
    private String loanAmount;
    private String loanTerm;
    private String collateralCurrency; // mandatory
    private String collateralAmount;
}
