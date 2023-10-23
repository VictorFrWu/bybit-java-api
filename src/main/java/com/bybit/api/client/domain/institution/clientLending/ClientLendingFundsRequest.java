package com.bybit.api.client.domain.institution.clientLending;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ClientLendingFundsRequest {
    private final String coin;
    private final String quantity;
    private final String serialNo;
    private final String orderId;
}