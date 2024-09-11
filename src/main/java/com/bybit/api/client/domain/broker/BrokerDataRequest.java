package com.bybit.api.client.domain.broker;

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
    private final BusinessType bizType;
    private final String subMemberId;
    private final String coin;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;
}
