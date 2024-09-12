package com.bybit.api.client.domain.broker.request;

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
public class BrokerGetIssuedVoucherRequest {
    private String accountId;
    private String awardId;
    private String specCode;
    private Boolean withUsedAmount;
}
