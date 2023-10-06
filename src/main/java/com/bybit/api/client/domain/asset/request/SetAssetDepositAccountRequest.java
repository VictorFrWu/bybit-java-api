package com.bybit.api.client.domain.asset.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class SetAssetDepositAccountRequest {
    private String accountType;
}
