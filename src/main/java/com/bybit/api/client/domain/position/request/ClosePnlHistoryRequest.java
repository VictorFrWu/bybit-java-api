/**
 Request Parameters
 Parameter	Required	Type	Comments
 category	true	string	Product type
 Unified account: linear, inverse
 Normal account: linear, inverse. Please note that category is not involved with business logic
 symbol	false	string	Symbol name
 startTime	false	integer	The start timestamp (ms)
 endTime	false	integer	The end timestamp (ms)
 limit	false	integer	Limit for data size per page. [1, 100]. Default: 50
 cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 */
package com.bybit.api.client.domain.position.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClosePnlHistoryRequest {
    private final ProductType category;
    private final String symbol;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;

    private ClosePnlHistoryRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private final ProductType category;
        private String symbol;
        private Long startTime;
        private Long endTime;
        private Integer limit;
        private String cursor;

        public Builder(ProductType category) {
            this.category = category;
        }

        public Builder symbol(String symbol) {
            this.symbol = symbol;
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

        public ClosePnlHistoryRequest build() {
            return new ClosePnlHistoryRequest(this);
        }
    }
    
}
