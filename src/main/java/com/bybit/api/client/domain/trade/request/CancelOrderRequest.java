package com.bybit.api.client.domain.trade.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancelOrderRequest {
    private String category;
    private String symbol;
    private String orderId;
    private String orderLinkId;
    private String orderFilter;
}
