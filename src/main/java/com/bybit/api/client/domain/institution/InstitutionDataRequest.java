package com.bybit.api.client.domain.institution;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class InstitutionDataRequest {
    private final String productId;
    private final String orderId;
    private final BusinessType bizType;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;
}

