package com.bybit.api.client.domain.asset.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AssetCancelWithdrawRequest {
    private String withdrawId;
}
