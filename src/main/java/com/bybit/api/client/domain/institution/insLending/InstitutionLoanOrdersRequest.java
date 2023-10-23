package com.bybit.api.client.domain.institution.insLending;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class InstitutionLoanOrdersRequest {
    private String orderId;
    private Long startTime;
    private Long endTime;
    private Integer limit;
}

