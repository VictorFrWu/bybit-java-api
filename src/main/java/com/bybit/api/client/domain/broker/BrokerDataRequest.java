package com.bybit.api.client.domain.broker;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class BrokerDataRequest {
    private final BusinessType bizType;
    private final String subMemberId;
    private final String coin;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;
    private final String id; // mandatory; voucher ID in query voucher spec
    private final String accountId; // mandatory;
    private final String awardId; // mandatory; voucher ID in issue voucher and query issued voucher
    private final String specCode; // mandatory;
    private final String amount; // mandatory;
    private final String brokerId; // mandatory;
    private final WithUsedAmount withUsedAmount;
}
