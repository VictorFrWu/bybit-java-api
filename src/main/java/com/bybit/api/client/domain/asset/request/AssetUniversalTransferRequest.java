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
    private String transferId;
    private String coin;
    private String amount;
    private Integer fromMemberId;
    private Integer toMemberId;
    private String fromAccountType;
    private String toAccountType;
}

