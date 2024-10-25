package com.bybit.api.client.domain.loan.request;

import com.bybit.api.client.domain.loan.Direction;
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
public class CryptoLoanAdjustLtvRequest {
    private String orderId; // mandatory
    private String amount; // mandatory
    private String direction; // mandatory; ADD: "0", REDUCE: "1"
}
