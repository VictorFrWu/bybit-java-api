package com.bybit.api.client.domain.trade.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceOrderRequest {
    private String category;
    private String symbol;
    private Integer isLeverage;
    private String side;
    private String orderType;
    private String qty;
    private String price;
    private Integer triggerDirection;
    private String orderFilter;
    private String triggerPrice;
    private String triggerBy;
    private String orderIv;
    private String timeInForce;
    private Integer positionIdx;
    private String orderLinkId;
    private String takeProfit;
    private String stopLoss;
    private String tpTriggerBy;
    private String slTriggerBy;
    private Boolean reduceOnly;
    private Boolean closeOnTrigger;
    private String smpType;
    private Boolean mmp;
    private String tpslMode;
    private String tpLimitPrice;
    private String slLimitPrice;
    private String tpOrderType;
    private String slOrderType;
    private String marketUnit;
}

