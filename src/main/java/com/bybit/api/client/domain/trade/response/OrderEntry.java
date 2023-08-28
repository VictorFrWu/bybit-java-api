package com.bybit.api.client.domain.trade.response;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.trade.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderLinkId() {
        return orderLinkId;
    }

    public void setOrderLinkId(String orderLinkId) {
        this.orderLinkId = orderLinkId;
    }

    public String getBlockTradeId() {
        return blockTradeId;
    }

    public void setBlockTradeId(String blockTradeId) {
        this.blockTradeId = blockTradeId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getIsLeverage() {
        return isLeverage;
    }

    public void setIsLeverage(String isLeverage) {
        this.isLeverage = isLeverage;
    }

    public PositionIdx getPositionIdx() {
        return positionIdx;
    }

    public void setPositionIdx(PositionIdx positionIdx) {
        this.positionIdx = positionIdx;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public CancelType getCancelType() {
        return cancelType;
    }

    public void setCancelType(CancelType cancelType) {
        this.cancelType = cancelType;
    }

    public RejectReason getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(RejectReason rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getLeavesQty() {
        return leavesQty;
    }

    public void setLeavesQty(String leavesQty) {
        this.leavesQty = leavesQty;
    }

    public String getLeavesValue() {
        return leavesValue;
    }

    public void setLeavesValue(String leavesValue) {
        this.leavesValue = leavesValue;
    }

    public String getCumExecQty() {
        return cumExecQty;
    }

    public void setCumExecQty(String cumExecQty) {
        this.cumExecQty = cumExecQty;
    }

    public String getCumExecValue() {
        return cumExecValue;
    }

    public void setCumExecValue(String cumExecValue) {
        this.cumExecValue = cumExecValue;
    }

    public String getCumExecFee() {
        return cumExecFee;
    }

    public void setCumExecFee(String cumExecFee) {
        this.cumExecFee = cumExecFee;
    }

    public TimeInForce getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(TimeInForce timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public StopOrderType getStopOrderType() {
        return stopOrderType;
    }

    public void setStopOrderType(StopOrderType stopOrderType) {
        this.stopOrderType = stopOrderType;
    }

    public String getOrderIv() {
        return orderIv;
    }

    public void setOrderIv(String orderIv) {
        this.orderIv = orderIv;
    }

    public String getTriggerPrice() {
        return triggerPrice;
    }

    public void setTriggerPrice(String triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

    public String getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(String takeProfit) {
        this.takeProfit = takeProfit;
    }

    public String getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(String stopLoss) {
        this.stopLoss = stopLoss;
    }

    public String getTpslMode() {
        return tpslMode;
    }

    public void setTpslMode(String tpslMode) {
        this.tpslMode = tpslMode;
    }

    public String getTpLimitPrice() {
        return tpLimitPrice;
    }

    public void setTpLimitPrice(String tpLimitPrice) {
        this.tpLimitPrice = tpLimitPrice;
    }

    public String getSlLimitPrice() {
        return slLimitPrice;
    }

    public void setSlLimitPrice(String slLimitPrice) {
        this.slLimitPrice = slLimitPrice;
    }

    public TriggerBy getTpTriggerBy() {
        return tpTriggerBy;
    }

    public void setTpTriggerBy(TriggerBy tpTriggerBy) {
        this.tpTriggerBy = tpTriggerBy;
    }

    public TriggerBy getSlTriggerBy() {
        return slTriggerBy;
    }

    public void setSlTriggerBy(TriggerBy slTriggerBy) {
        this.slTriggerBy = slTriggerBy;
    }

    public Integer getTriggerDirection() {
        return triggerDirection;
    }

    public void setTriggerDirection(Integer triggerDirection) {
        this.triggerDirection = triggerDirection;
    }

    public TriggerBy getTriggerBy() {
        return triggerBy;
    }

    public void setTriggerBy(TriggerBy triggerBy) {
        this.triggerBy = triggerBy;
    }

    public String getLastPriceOnCreated() {
        return lastPriceOnCreated;
    }

    public void setLastPriceOnCreated(String lastPriceOnCreated) {
        this.lastPriceOnCreated = lastPriceOnCreated;
    }

    public Boolean getReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(Boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public Boolean getCloseOnTrigger() {
        return closeOnTrigger;
    }

    public void setCloseOnTrigger(Boolean closeOnTrigger) {
        this.closeOnTrigger = closeOnTrigger;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public SmpType getSmpType() {
        return smpType;
    }

    public void setSmpType(SmpType smpType) {
        this.smpType = smpType;
    }

    public Integer getSmpGroup() {
        return smpGroup;
    }

    public void setSmpGroup(Integer smpGroup) {
        this.smpGroup = smpGroup;
    }

    public String getSmpOrderId() {
        return smpOrderId;
    }

    public void setSmpOrderId(String smpOrderId) {
        this.smpOrderId = smpOrderId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

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
