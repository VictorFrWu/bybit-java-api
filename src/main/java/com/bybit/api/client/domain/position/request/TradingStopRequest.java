/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: linear, inverse
 * Normal account: linear, inverse. Please note that category is not involved with business logic
 * symbol	true	string	Symbol name
 * takeProfit	false	string	Cannot be less than 0, 0 means cancel TP
 * stopLoss	false	string	Cannot be less than 0, 0 means cancel SL
 * trailingStop	false	string	Trailing stop by price distance. Cannot be less than 0, 0 means cancel TS
 * tpTriggerBy	false	string	Take profit trigger price type
 * slTriggerBy	false	string	Stop loss trigger price type
 * activePrice	false	string	Trailing stop trigger price. Trailing stop will be triggered when this price is reached only
 * tpslMode	false	string	TP/SL mode. Full: entire position TP/SL, Partial: partial position TP/SL. As each contract has an initial full TP/SL mode, if it has been modified before, it may be partial. Therefore, if not provided, the system will automatically retrieve the current TP/SL mode configuration for the contract.
 * tpSize	false	string	Take profit size. Valid in TP/SL partial mode. Note: the value of tpSize and slSize must equal
 * slSize	false	string	Stop loss size. Valid in TP/SL partial mode. Note: the value of tpSize and slSize must equal
 * tpLimitPrice	false	string	The limit order price when take profit price is triggered. Only works when tpslMode=Partial and tpOrderType=Limit
 * slLimitPrice	false	string	The limit order price when stop loss price is triggered. Only works when tpslMode=Partial and slOrderType=Limit
 * tpOrderType	false	string	The order type when take profit is triggered. Market(default), Limit. For tpslMode=Full, it only supports tpOrderType=Market
 * slOrderType	false	string	The order type when stop loss is triggered. Market(default), Limit. For tpslMode=Full, it only supports slOrderType=Market
 * positionIdx	true	integer	Used to identify positions in different position modes.
 * 0: one-way mode
 * 1: hedge-mode Buy side
 * 2: hedge-mode Sell side
 */

package com.bybit.api.client.domain.position.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TradingStopRequest {
    private final String category;
    private final String symbol;
    private final String takeProfit;
    private final String stopLoss;
    private final String trailingStop;
    private final String tpTriggerBy;
    private final String slTriggerBy;
    private final String activePrice;
    private final String tpslMode;
    private final String tpSize;
    private final String slSize;
    private final String tpLimitPrice;
    private final String slLimitPrice;
    private final String tpOrderType;
    private final String slOrderType;
    private final int positionIdx;

    private TradingStopRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.takeProfit = builder.takeProfit;
        this.stopLoss = builder.stopLoss;
        this.trailingStop = builder.trailingStop;
        this.tpTriggerBy = builder.tpTriggerBy;
        this.slTriggerBy = builder.slTriggerBy;
        this.activePrice = builder.activePrice;
        this.tpslMode = builder.tpslMode;
        this.tpSize = builder.tpSize;
        this.slSize = builder.slSize;
        this.tpLimitPrice = builder.tpLimitPrice;
        this.slLimitPrice = builder.slLimitPrice;
        this.tpOrderType = builder.tpOrderType;
        this.slOrderType = builder.slOrderType;
        this.positionIdx = builder.positionIdx;
    }

    public static class Builder {
        private final String category;
        private String symbol;
        private String takeProfit = "0";
        private String stopLoss = "0";
        private String trailingStop = "0";
        private String tpTriggerBy;
        private String slTriggerBy;
        private String activePrice;
        private String tpslMode;
        private String tpSize;
        private String slSize;
        private String tpLimitPrice;
        private String slLimitPrice;
        private String tpOrderType;
        private String slOrderType;
        private int positionIdx;

        public Builder(String category, String symbol, int positionIdx) {
            this.category = category;
            this.symbol = symbol;
            this.positionIdx = positionIdx;
        }

        public Builder takeProfit(String takeProfit) {
            this.takeProfit = takeProfit;
            return this;
        }

        public Builder stopLoss(String stopLoss) {
            this.stopLoss = stopLoss;
            return this;
        }

        public Builder trailingStop(String trailingStop) {
            this.trailingStop = trailingStop;
            return this;
        }

        public Builder tpTriggerBy(String tpTriggerBy) {
            this.tpTriggerBy = tpTriggerBy;
            return this;
        }

        public Builder slTriggerBy(String slTriggerBy) {
            this.slTriggerBy = slTriggerBy;
            return this;
        }

        public Builder activePrice(String activePrice) {
            this.activePrice = activePrice;
            return this;
        }

        public Builder tpslMode(String tpslMode) {
            this.tpslMode = tpslMode;
            return this;
        }

        public Builder tpSize(String tpSize) {
            this.tpSize = tpSize;
            return this;
        }

        public Builder slSize(String slSize) {
            this.slSize = slSize;
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

        public Builder tpOrderType(String tpOrderType) {
            this.tpOrderType = tpOrderType;
            return this;
        }

        public Builder slOrderType(String slOrderType) {
            this.slOrderType = slOrderType;
            return this;
        }

        public TradingStopRequest build() {
            return new TradingStopRequest(this);
        }
    }
}