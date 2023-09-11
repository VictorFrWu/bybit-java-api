/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type linear, inverse
 * symbol	true	string	Symbol name
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 100]. Default: 50
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
public class PreUpgradeClosePnlRequest {
    private final ProductType category;
    private final String symbol;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;

    private PreUpgradeClosePnlRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private final ProductType category;
        private final String symbol;
        private Long startTime;
        private Long endTime;
        private Integer limit; // Default value 50
        private String cursor;

        public Builder(ProductType category, String symbol) {
            this.category = category;
            this.symbol = symbol;
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

        public PreUpgradeClosePnlRequest build() {
            return new PreUpgradeClosePnlRequest(this);
        }
    }
}

