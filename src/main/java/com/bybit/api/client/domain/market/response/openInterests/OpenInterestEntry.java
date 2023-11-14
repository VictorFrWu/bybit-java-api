package com.bybit.api.client.domain.market.response.openInterests;

import lombok.Data;

@Data
public class OpenInterestEntry {
    private String openInterest;
    private String timestamp;
}
