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
public class AssetQuoteRequest {
    private String fromCoin;
    private String toCoin;
    private String fromCoinType;
    private String toCoinType;
    private String requestCoin;
    private String requestAmount;
    private String accountType;
    private String requestId;
}
