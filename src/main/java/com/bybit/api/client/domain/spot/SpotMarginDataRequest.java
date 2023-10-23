package com.bybit.api.client.domain.spot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SpotMarginDataRequest {
    private final String ltCoin;
    private final String ltAmount;
    private final String quantity;
    private final String orderId;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final Integer ltOrderType;
    private final String serialNo;
    private final VipLevel vipLevel;
    private final String currency;
    private final String coin;
    private final String qty;
    private final CompleteRepayment completeRepayment;
    private final String leverage;
    private final SpotMarginMode spotMarginMode;
    private final SwitchStatus switchStatus;
    private final BorrowStatus borrowStatus;
}
