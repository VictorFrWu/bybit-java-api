package com.bybit.api.client.domain.account.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SetSpotHedgingRequest {
    private String setHedgingMode;
}
