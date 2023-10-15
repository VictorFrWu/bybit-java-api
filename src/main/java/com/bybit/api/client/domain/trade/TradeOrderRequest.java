package com.bybit.api.client.domain.trade;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.TradeOrderType;
import com.bybit.api.client.domain.TriggerBy;
import com.bybit.api.client.service.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class TradeOrderRequest {
    @JsonSerialize(using = ProductTypeSerializer.class)
    private ProductType category;  // always Required

    private String symbol;

    @JsonSerialize(using = SideSerializer.class)
    private Side side;

    @JsonSerialize(using = TradeOrderTypeSerializer.class)
    private TradeOrderType orderType;

    private String qty;
    private Integer isLeverage;
    private String price;
    private Integer triggerDirection;
    private String orderFilter;
    private String triggerPrice;
    private TriggerBy triggerBy;
    private String orderIv;

    @JsonSerialize(using = TimeInForceSerializer.class)
    private TimeInForce timeInForce;

    @JsonSerialize(using = PositionIdxSerializer.class)
    private PositionIdx positionIdx;
    private String orderId;
    private String orderLinkId;
    private String takeProfit;
    private String stopLoss;

    @JsonSerialize(using = TriggerBySerializer.class)
    private TriggerBy tpTriggerBy;

    @JsonSerialize(using = TriggerBySerializer.class)
    private TriggerBy slTriggerBy;
    private Boolean reduceOnly;
    private Boolean closeOnTrigger;

    @JsonSerialize(using = SmpTypeSerializer.class)
    private SmpType smpType;
    private Boolean mmp;
    private String tpslMode;
    private String tpLimitPrice;
    private String slLimitPrice;
    private String tpOrderType;
    private String slOrderType;
    private String baseCoin;
    private String settleCoin;
    private Integer openOnly;
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;

    @JsonSerialize(using = StopOrderTypeSerializer.class)
    private StopOrderType stopOrderType;
    private OrderStatus orderStatus;
    private Integer timeWindow; // only to Disconnect Cancel All options
}
