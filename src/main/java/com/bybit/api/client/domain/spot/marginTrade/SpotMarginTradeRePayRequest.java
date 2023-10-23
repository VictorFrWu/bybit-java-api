package com.bybit.api.client.domain.spot.marginTrade;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SpotMarginTradeRePayRequest {
    private final String coin;
    private final String qty;
    private final Integer completeRepayment;
}

