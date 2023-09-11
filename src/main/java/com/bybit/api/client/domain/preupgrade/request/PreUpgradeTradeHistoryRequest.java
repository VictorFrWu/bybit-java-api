/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type linear, inverse, option
 * symbol	false	string	Symbol name
 * orderId	false	string	Order ID
 * orderLinkId	false	string	User customised order ID
 * baseCoin	false	string	Base coin. Used for option
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end timestamp (ms)
 * execType	false	string	Execution type
 * limit	false	integer	Limit for data size per page. [1, 100]. Default: 50
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 */
package com.bybit.api.client.domain.preupgrade.request;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.position.ExecType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PreUpgradeTradeHistoryRequest {
    private final ProductType category;
    private final String symbol;
    private final String orderId;
    private final String orderLinkId;
    private final String baseCoin;
    private final Long startTime;
    private final Long endTime;
    private final ExecType execType;
    private final Integer limit;
    private final String cursor;

    private PreUpgradeTradeHistoryRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.orderId = builder.orderId;
        this.orderLinkId = builder.orderLinkId;
        this.baseCoin = builder.baseCoin;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.execType = builder.execType;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private final ProductType category;
        private String symbol;
        private String orderId;
        private String orderLinkId;
        private String baseCoin;
        private Long startTime;
        private Long endTime;
        private ExecType execType;
        private Integer limit; // Default value 50
        private String cursor;

        public Builder(ProductType category) {
            this.category = category;
        }

        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder orderLinkId(String orderLinkId) {
            this.orderLinkId = orderLinkId;
            return this;
        }

        public Builder baseCoin(String baseCoin) {
            this.baseCoin = baseCoin;
            return this;
        }

        public Builder startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder execType(ExecType execType) {
            this.execType = execType;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public PreUpgradeTradeHistoryRequest build() {
            return new PreUpgradeTradeHistoryRequest(this);
        }
    }
}

