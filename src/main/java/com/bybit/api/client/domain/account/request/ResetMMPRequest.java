package com.bybit.api.client.domain.account.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ResetMMPRequest {
    private String baseCoin;
}
