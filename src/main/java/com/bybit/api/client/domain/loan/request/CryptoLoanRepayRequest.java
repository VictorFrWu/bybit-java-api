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
public class CryptoLoanRepayRequest {
    private String orderId; // mandatory
    private String amount;// mandatory
}
