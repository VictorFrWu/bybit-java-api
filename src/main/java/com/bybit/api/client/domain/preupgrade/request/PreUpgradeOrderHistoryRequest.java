/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. linear, inverse, option
 * symbol	false	string	Symbol name.
 * If not passed, return settleCoin=USDT by default
 * To get USDC perp, please pass symbol
 * baseCoin	false	string	Base coin. Used for option query
 * orderId	false	string	Order ID
 * orderLinkId	false	string	User customised order ID
 * orderFilter	false	string	Order: active order, StopOrder: conditional order
 * orderStatus	false	string	Order status
 * startTime	false	integer	The start timestamp (ms)
 * startTime and endTime must be passed together
 * If not passed, query the past 7 days data by default
 * endTime	false	integer	The end timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 */
package com.bybit.api.client.domain.preupgrade.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PreUpgradeOrderHistoryRequest {
    private final ProductType category;
    private final String symbol;
    private final String baseCoin;
    private final String orderId;
    private final String orderLinkId;
    private final String orderFilter;
    private final String orderStatus;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;

    private PreUpgradeOrderHistoryRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.baseCoin = builder.baseCoin;
        this.orderId = builder.orderId;
        this.orderLinkId = builder.orderLinkId;
        this.orderFilter = builder.orderFilter;
        this.orderStatus = builder.orderStatus;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private final ProductType category;
        private String symbol;// Default value USDT
        private String baseCoin;
        private String orderId;
        private String orderLinkId;
        private String orderFilter;
        private String orderStatus;
        private Long startTime;
        private Long endTime;
        private Integer limit; // Default value 20
        private String cursor;

        public Builder(ProductType category) {
            this.category = category;
        }

        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder baseCoin(String baseCoin) {
            this.baseCoin = baseCoin;
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

        public Builder orderFilter(String orderFilter) {
            this.orderFilter = orderFilter;
            return this;
        }

        public Builder orderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
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

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public PreUpgradeOrderHistoryRequest build() {
            return new PreUpgradeOrderHistoryRequest(this);
        }
    }
}

