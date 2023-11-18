package com.bybit.api.client.domain.trade.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelAllOrdersRequest {
    private String symbol;
    private String category;
    private String baseCoin;
    private String settleCoin;
    private String orderFilter;
    private String stopOrderType;
}
