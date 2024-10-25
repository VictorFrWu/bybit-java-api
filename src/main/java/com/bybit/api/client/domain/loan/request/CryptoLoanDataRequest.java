package com.bybit.api.client.domain.loan.request;

import com.bybit.api.client.domain.loan.Direction;
import com.bybit.api.client.domain.loan.LoanTerm;
import com.bybit.api.client.domain.loan.LoanTermType;
import com.bybit.api.client.domain.loan.VipLevel;
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
public class CryptoLoanDataRequest {
    private String currency;
    private VipLevel vipLevel;
    private String loanCurrency;
    private String collateralCurrency;
    private String loanAmount;
    private String collateralAmount;
    private LoanTerm loanTerm;
    private String orderId;
    private String amount; // repay amount or adjust ltv amount
    private LoanTermType loanTermType;
    private String repayId;
    private String adjustId;
    private Direction direction;
    private String cursor;
    private String limit;
}
