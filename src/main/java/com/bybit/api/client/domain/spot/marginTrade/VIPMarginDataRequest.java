package com.bybit.api.client.domain.spot.marginTrade;

import com.bybit.api.client.domain.spot.VipLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class VIPMarginDataRequest {
    private final VipLevel vipLevel;
    private final String currency;
}


