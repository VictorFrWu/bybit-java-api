package com.bybit.api.client.domain.trade.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelOrderRequest {
    private String category;
    private String symbol;
    private String orderId;
    private String orderLinkId;
    private String orderFilter;
}
