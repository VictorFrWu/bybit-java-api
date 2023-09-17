package com.bybit.api.client.domain.asset.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AssetInternalTransferRequest {
    private final String transferId;
    private final String coin;
    private final String amount;
    private final String fromAccountType;
    private final String toAccountType;
}

