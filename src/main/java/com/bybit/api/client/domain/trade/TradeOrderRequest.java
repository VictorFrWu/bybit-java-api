package com.bybit.api.client.domain.trade;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.TradeOrderType;
import com.bybit.api.client.domain.TriggerBy;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class TradeOrderRequest {
    private ProductType category;  // always Required
    private String symbol;
    private TransactionSide transactionSide;
    private TradeOrderType orderType;
    private String qty;
    private Integer isLeverage;
    private String price;
    private Integer triggerDirection;
    private String orderFilter;
    private String triggerPrice;
    private TriggerBy triggerBy;
    private String orderIv;
    private TimeInForce timeInForce;
    private PositionIdx positionIdx;
    private String orderId;
    private String orderLinkId;
    private String takeProfit;
    private String stopLoss;
    private TriggerBy tpTriggerBy;
    private TriggerBy slTriggerBy;
    private Boolean reduceOnly;
    private Boolean closeOnTrigger;
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
    private StopOrderType stopOrderType;
    private OrderStatus orderStatus;
    private Integer timeWindow; // only to Disconnect Cancel All options
}
