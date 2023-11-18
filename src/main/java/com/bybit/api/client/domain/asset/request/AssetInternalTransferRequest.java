package com.bybit.api.client.domain.asset.request;

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
public class AssetInternalTransferRequest {
    private String transferId;
    private String coin;
    private String amount;
    private String fromAccountType;
    private String toAccountType;
}

