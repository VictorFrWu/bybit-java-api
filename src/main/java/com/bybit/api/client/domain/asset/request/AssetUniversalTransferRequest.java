package com.bybit.api.client.domain.asset.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AssetUniversalTransferRequest {
    private final String transferId;
    private final String coin;
    private final String amount;
    private final Integer fromMemberId;
    private final Integer toMemberId;
    private final String fromAccountType;
    private final String toAccountType;
}

