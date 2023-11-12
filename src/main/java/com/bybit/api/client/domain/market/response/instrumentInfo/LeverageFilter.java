package com.bybit.api.client.domain.market.response.instrumentInfo;

import lombok.Getter;

@Getter
public class LeverageFilter {
    private String minLeverage;
    private String maxLeverage;
    private String leverageStep;
}
