package com.bybit.api.client.domain.position.request;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.TradeOrderType;
import com.bybit.api.client.domain.TriggerBy;
import com.bybit.api.client.domain.position.*;
import com.bybit.api.client.domain.trade.PositionIdx;
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
public class PositionDataRequest {
    private CategoryType category;
    private String symbol;
    private String baseCoin;
    private String settleCoin;
    private String buyLeverage;
    private String sellLeverage;
    private Integer riskId;
    private PositionIdx positionIdx;
    private String takeProfit;
    private String stopLoss;
    private String trailingStop;
    private TriggerBy tpTriggerBy;
    private TriggerBy slTriggerBy;
    private String activePrice;
    private String tpSize;
    private String slSize;
    private String tpLimitPrice;
    private String slLimitPrice;
    private TradeOrderType tpOrderType;
    private TradeOrderType slOrderType;
    private AutoAddMargin autoAddMargin;
    private String margin;
    private String orderId;
    private String orderLinkId;
    private Long startTime;
    private Long endTime;
    private ExecType execType;
    private TpslMode tpslMode;
    private MarginMode tradeMode; // 0: cross margin. 1: isolated margin
    private PositionMode positionMode; // Position mode. 0: Merged Single. 3: Both Sides
    private Integer limit;
    private String cursor;
    private String blockTradeId;
    private MovePositionStatus status;
    private String coin;
}
