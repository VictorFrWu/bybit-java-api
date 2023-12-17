package com.bybit.api.client.domain.institution;

import com.bybit.api.client.domain.broker.BusinessType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class LendingDataRequest {
    private final String productId;
    private final String orderId;
    private final BusinessType bizType;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;
    private final String coin;
    private final LendingOrderType lendingOrderType;
    private final String quantity;
    private final String serialNo;
    private final String uid;
    private final OperateType operate;
}

