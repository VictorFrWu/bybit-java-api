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
public class BrokerIssueVoucherRequest {
    private String accountId;
    private String awardId;
    private String specCode;
    private String amount;
    private String brokerId;
}
