package com.bybit.api.client.domain.trade.response;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.TriggerBy;
import com.bybit.api.client.domain.trade.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderEntry {
    private String orderId;

    private String orderLinkId;


    private String blockTradeId;


    private String symbol;


    private String price;


    private String qty;

    private String side;

    private String isLeverage;

    private PositionIdx positionIdx;


    private OrderStatus orderStatus;


    private CancelType cancelType;


    private RejectReason rejectReason;


    private String avgPrice;

    private String leavesQty;


    private String leavesValue;


    private String cumExecQty;


    private String cumExecValue;


    private String cumExecFee;


    private TimeInForce timeInForce;


    private String orderType;


    private StopOrderType stopOrderType;


    private String orderIv;


    private String triggerPrice;


    private String takeProfit;


    private String stopLoss;


    private String tpslMode;


    private String tpLimitPrice;


    private String slLimitPrice;


    private TriggerBy tpTriggerBy;


    private TriggerBy slTriggerBy;


    private Integer triggerDirection;


    private TriggerBy triggerBy;

    private String lastPriceOnCreated;


    private Boolean reduceOnly;

    private Boolean closeOnTrigger;


    private String placeType;

    private SmpType smpType;


    private Integer smpGroup;


    private String smpOrderId;


    private String createdTime;

    private String updatedTime;

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("orderType", orderType)
                .append("orderLinkId", orderLinkId)
                .append("slLimitPrice", slLimitPrice)
                .append("orderId", orderId)
                .append("cancelType", cancelType)
                .append("avgPrice", avgPrice)
                .append("stopOrderType", stopOrderType)
                .append("lastPriceOnCreated", lastPriceOnCreated)
                .append("orderStatus", orderStatus)
                .append("takeProfit", takeProfit)
                .append("cumExecValue", cumExecValue)
                .append("tpslMode", tpslMode)
                .append("smpType", smpType)
                .append("triggerDirection", triggerDirection)
                .append("blockTradeId", blockTradeId)
                .append("rejectReason", rejectReason)
                .append("isLeverage", isLeverage)
                .append("price", price)
                .append("orderIv", orderIv)
                .append("createdTime", createdTime)
                .append("tpTriggerBy", tpTriggerBy)
                .append("positionIdx", positionIdx)
                .append("timeInForce", timeInForce)
                .append("leavesValue", leavesValue)
                .append("updatedTime", updatedTime)
                .append("side", side)
                .append("smpGroup", smpGroup)
                .append("triggerPrice", triggerPrice)
                .append("tpLimitPrice", tpLimitPrice)
                .append("cumExecFee", cumExecFee)
                .append("slTriggerBy", slTriggerBy)
                .append("leavesQty", leavesQty)
                .append("closeOnTrigger", closeOnTrigger)
                .append("placeType", placeType)
                .append("cumExecQty", cumExecQty)
                .append("reduceOnly", reduceOnly)
                .append("qty", qty)
                .append("stopLoss", stopLoss)
                .append("smpOrderId", smpOrderId)
                .append("triggerBy", triggerBy)
                .toString();
    }
}
