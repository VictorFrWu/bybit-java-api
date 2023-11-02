package com.bybit.api.client.domain.position;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ConfirmNewRiskLimitRequest {
    private final String category;
    private final String symbol;
}
