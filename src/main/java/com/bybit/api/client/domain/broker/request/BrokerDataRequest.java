package com.bybit.api.client.domain.broker.request;

import com.bybit.api.client.domain.broker.BusinessType;
import com.bybit.api.client.domain.broker.WithUsedAmount;
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
public class BrokerDataRequest {
    private BusinessType bizType;
    private String subMemberId;
    private String coin;
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;
    private String id; // mandatory; voucher ID in query voucher spec
    private String accountId; // mandatory;
    private String awardId; // mandatory; voucher ID in issue voucher and query issued voucher
    private String specCode; // mandatory;
    private String amount; // mandatory;
    private String brokerId; // mandatory;
    private WithUsedAmount withUsedAmount;
}
