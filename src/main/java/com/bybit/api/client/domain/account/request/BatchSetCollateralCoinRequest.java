package com.bybit.api.client.domain.account.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatchSetCollateralCoinRequest {
    private List<SetCollateralCoinRequest> request;
}
