package com.bybit.api.client.domain.trade.requests;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.trade.TriggerBy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A trade amends an order
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmendOrderRequest {

    private ProductType category; // required
    private String symbol; // required
    private String orderId;
    private String orderLinkId;
    private String orderIv;
    private String triggerPrice;
    private String qty;
    private String price;
    private String takeProfit;
    private String stopLoss;
    private TriggerBy tpTriggerBy;
    private TriggerBy slTriggerBy;
    private TriggerBy triggerBy;
    private String tpLimitPrice;
    private String slLimitPrice;

    private AmendOrderRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.orderId = builder.orderId;
        this.orderLinkId = builder.orderLinkId;
        this.orderIv = builder.orderIv;
        this.triggerPrice = builder.triggerPrice;
        this.qty = builder.qty;
        this.price = builder.price;
        this.takeProfit = builder.takeProfit;
        this.stopLoss = builder.stopLoss;
        this.tpTriggerBy = builder.tpTriggerBy;
        this.slTriggerBy = builder.slTriggerBy;
        this.triggerBy = builder.triggerBy;
        this.tpLimitPrice = builder.tpLimitPrice;
        this.slLimitPrice = builder.slLimitPrice;
    }

    public static class Builder {
        private ProductType category;
        private String symbol;
        private String orderId;
        private String orderLinkId;
        private String orderIv;
        private String triggerPrice;
        private String qty;
        private String price;
        private String takeProfit;
        private String stopLoss;
        private TriggerBy tpTriggerBy;
        private TriggerBy slTriggerBy;
        private TriggerBy triggerBy;
        private String tpLimitPrice;
        private String slLimitPrice;

        public Builder(ProductType category, String symbol) {
            this.category = category;
            this.symbol = symbol;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder orderLinkId(String orderLinkId) {
            this.orderLinkId = orderLinkId;
            return this;
        }

        public Builder orderIv(String orderIv) {
            this.orderIv = orderIv;
            return this;
        }

        public Builder triggerPrice(String triggerPrice) {
            this.triggerPrice = triggerPrice;
            return this;
        }

        public Builder qty(String qty) {
            this.qty = qty;
            return this;
        }

        public Builder price(String price) {
            this.price = price;
            return this;
        }

        public Builder takeProfit(String takeProfit) {
            this.takeProfit = takeProfit;
            return this;
        }

        public Builder stopLoss(String stopLoss) {
            this.stopLoss = stopLoss;
            return this;
        }

        public Builder tpTriggerBy(TriggerBy tpTriggerBy) {
            this.tpTriggerBy = tpTriggerBy;
            return this;
        }

        public Builder slTriggerBy(TriggerBy slTriggerBy) {
            this.slTriggerBy = slTriggerBy;
            return this;
        }

        public Builder triggerBy(TriggerBy triggerBy) {
            this.triggerBy = triggerBy;
            return this;
        }

        public Builder tpLimitPrice(String tpLimitPrice) {
            this.tpLimitPrice = tpLimitPrice;
            return this;
        }

        public Builder slLimitPrice(String slLimitPrice) {
            this.slLimitPrice = slLimitPrice;
            return this;
        }

        public AmendOrderRequest build() {
            return new AmendOrderRequest(this);
        }
    }

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

    public TriggerBy getTriggerBy() {
        return triggerBy;
    }

    public void setTriggerBy(TriggerBy triggerBy) {
        this.triggerBy = triggerBy;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("category", category)
                .append("symbol", symbol)
                .append("orderId", orderId)
                .append("orderLinkId", orderLinkId)
                .append("orderIv", orderIv)
                .append("triggerPrice", triggerPrice)
                .append("qty", qty)
                .append("price", price)
                .append("takeProfit", takeProfit)
                .append("stopLoss", stopLoss)
                .append("tpTriggerBy", tpTriggerBy)
                .append("slTriggerBy", slTriggerBy)
                .append("triggerBy", triggerBy)
                .append("tpLimitPrice", tpLimitPrice)
                .append("slLimitPrice", slLimitPrice)
                .toString();
    }
}
