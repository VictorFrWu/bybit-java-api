package com.bybit.api.client.domain.websocket_message.private_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderData {
    private String category;
    private String orderId;
    private String orderLinkId;
    private String isLeverage;
    private String blockTradeId;
    private String symbol;
    private String price;
    private String qty;
    private String side;
    private Integer positionIdx;
    private String orderStatus;
    private String createType;
    private String cancelType;
    private String rejectReason;
    private String avgPrice;
    private String leavesQty;
    private String leavesValue;
    private String cumExecQty;
    private String cumExecValue;
    private String cumExecFee;
    private String feeCurrency;
    private String timeInForce;
    private String orderType;
    private String stopOrderType;
    private String ocoTriggerType;
    private String orderIv;
    private String marketUnit;
    private String triggerPrice;
    private String takeProfit;
    private String stopLoss;
    private String tpslMode;
    private String tpLimitPrice;
    private String slLimitPrice;
    private String tpTriggerBy;
    private String slTriggerBy;
    private Integer triggerDirection;
    private String triggerBy;
    private String lastPriceOnCreated;
    private Boolean reduceOnly;
    private Boolean closeOnTrigger;
    private String placeType;
    private String smpType;
    private Integer smpGroup;
    private String smpOrderId;
    private String createdTime;
    private String updatedTime;
}
