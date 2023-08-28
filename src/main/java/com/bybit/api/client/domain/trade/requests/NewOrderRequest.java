package com.bybit.api.client.domain.trade.requests;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.trade.PositionIdx;
import com.bybit.api.client.domain.trade.SmpType;
import com.bybit.api.client.domain.trade.TimeInForce;
import com.bybit.api.client.domain.trade.TriggerBy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * A trader places an order
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrderRequest {

    private ProductType category;  // Required
    private String symbol;    // Required
    private String side;     // Required
    private String orderType; // Required
    private String qty;       // Required
    private Integer isLeverage;
    private String price;
    private Integer triggerDirection;
    private String orderFilter;
    private String triggerPrice;
    private TriggerBy triggerBy;
    private String orderIv;
    private TimeInForce timeInForce;
    private PositionIdx positionIdx;
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
    public ProductType getCategory() {
        return category;
    }

    public void setCategory(ProductType category) {
        this.category = category;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getIsLeverage() {
        return isLeverage;
    }

    public void setIsLeverage(Integer isLeverage) {
        this.isLeverage = isLeverage;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getTriggerDirection() {
        return triggerDirection;
    }

    public void setTriggerDirection(Integer triggerDirection) {
        this.triggerDirection = triggerDirection;
    }

    public String getOrderFilter() {
        return orderFilter;
    }

    public void setOrderFilter(String orderFilter) {
        this.orderFilter = orderFilter;
    }

    public String getTriggerPrice() {
        return triggerPrice;
    }

    public void setTriggerPrice(String triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

    public TriggerBy getTriggerBy() {
        return triggerBy;
    }

    public void setTriggerBy(TriggerBy triggerBy) {
        this.triggerBy = triggerBy;
    }

    public String getOrderIv() {
        return orderIv;
    }

    public void setOrderIv(String orderIv) {
        this.orderIv = orderIv;
    }

    public TimeInForce getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(TimeInForce timeInForce) {
        this.timeInForce = timeInForce;
    }

    public PositionIdx getPositionIdx() {
        return positionIdx;
    }

    public void setPositionIdx(PositionIdx positionIdx) {
        this.positionIdx = positionIdx;
    }

    public String getOrderLinkId() {
        return orderLinkId;
    }

    public void setOrderLinkId(String orderLinkId) {
        this.orderLinkId = orderLinkId;
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

    public SmpType getSmpType() {
        return smpType;
    }

    public void setSmpType(SmpType smpType) {
        this.smpType = smpType;
    }

    public Boolean getMmp() {
        return mmp;
    }

    public void setMmp(Boolean mmp) {
        this.mmp = mmp;
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

    public String getTpOrderType() {
        return tpOrderType;
    }

    public void setTpOrderType(String tpOrderType) {
        this.tpOrderType = tpOrderType;
    }

    public String getSlOrderType() {
        return slOrderType;
    }

    public void setSlOrderType(String slOrderType) {
        this.slOrderType = slOrderType;
    }

    /**
     * Creates a new order with all required parameters.
     */
    public NewOrderRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.side = builder.side;
        this.orderType = builder.orderType;
        this.qty = builder.qty;
    }

    public static class Builder {
        // Required parameters
        private final ProductType category;
        private final String symbol;
        private final String side;
        private final String orderType;
        private final String qty;

        // Optional parameters - initialized to default values
        private Integer isLeverage;
        private String price;
        private Integer triggerDirection;
        private String orderFilter;
        private String triggerPrice;
        private TriggerBy triggerBy;
        private String orderIv;
        private TimeInForce timeInForce;
        private PositionIdx positionIdx;
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

        public Builder(ProductType category, String symbol, String side, String orderType, String qty) {
            this.category = category;
            this.symbol = symbol;
            this.side = side;
            this.orderType = orderType;
            this.qty = qty;
        }

        public Builder isLeverage(Integer val) {
            isLeverage = val;
            return this;
        }

        public Builder price(String val) {
            price = val;
            return this;
        }

        public Builder triggerDirection(Integer val) {
            triggerDirection = val;
            return this;
        }

        public Builder orderFilter(String val) {
            orderFilter = val;
            return this;
        }

        public Builder triggerPrice(String val) {
            triggerPrice = val;
            return this;
        }

        public Builder triggerBy(TriggerBy val) {
            triggerBy = val;
            return this;
        }

        public Builder orderIv(String val) {
            orderIv = val;
            return this;
        }

        public Builder timeInForce(TimeInForce val) {
            timeInForce = val;
            return this;
        }

        public Builder positionIdx(PositionIdx val) {
            positionIdx = val;
            return this;
        }

        public Builder orderLinkId(String val) {
            orderLinkId = val;
            return this;
        }

        public Builder takeProfit(String val) {
            takeProfit = val;
            return this;
        }

        public Builder stopLoss(String val) {
            stopLoss = val;
            return this;
        }

        public Builder tpTriggerBy(TriggerBy val) {
            tpTriggerBy = val;
            return this;
        }

        public Builder slTriggerBy(TriggerBy val) {
            slTriggerBy = val;
            return this;
        }

        public Builder reduceOnly(Boolean val) {
            reduceOnly = val;
            return this;
        }

        public Builder closeOnTrigger(Boolean val) {
            closeOnTrigger = val;
            return this;
        }

        public Builder smpType(SmpType val) {
            smpType = val;
            return this;
        }

        public Builder mmp(Boolean val) {
            mmp = val;
            return this;
        }

        public Builder tpslMode(String val) {
            tpslMode = val;
            return this;
        }

        public Builder tpLimitPrice(String val) {
            tpLimitPrice = val;
            return this;
        }

        public Builder slLimitPrice(String val) {
            slLimitPrice = val;
            return this;
        }

        public Builder tpOrderType(String val) {
            tpOrderType = val;
            return this;
        }

        public Builder slOrderType(String val) {
            slOrderType = val;
            return this;
        }

        public NewOrderRequest build() {
            return new NewOrderRequest(this);
        }
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("category", category)
                .append("symbol", symbol)
                .append("isLeverage", isLeverage)
                .append("side", side)
                .append("orderType", orderType)
                .append("qty", qty)
                .append("price", price)
                .append("triggerDirection", triggerDirection)
                .append("orderFilter", orderFilter)
                .append("triggerPrice", triggerPrice)
                .append("triggerBy", triggerBy)
                .append("orderIv", orderIv)
                .append("timeInForce", timeInForce)
                .append("positionIdx", positionIdx)
                .append("orderLinkId", orderLinkId)
                .append("takeProfit", takeProfit)
                .append("stopLoss", stopLoss)
                .append("tpTriggerBy", tpTriggerBy)
                .append("slTriggerBy", slTriggerBy)
                .append("reduceOnly", reduceOnly)
                .append("closeOnTrigger", closeOnTrigger)
                .append("smpType", smpType)
                .append("mmp", mmp)
                .append("tpslMode", tpslMode)
                .append("tpLimitPrice", tpLimitPrice)
                .append("slLimitPrice", slLimitPrice)
                .append("tpOrderType", tpOrderType)
                .append("slOrderType", slOrderType)
                .toString();
    }

}
