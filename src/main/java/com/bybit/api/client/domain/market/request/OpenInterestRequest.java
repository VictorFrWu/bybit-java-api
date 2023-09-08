/**
 * category	true	string	Product type. linear,inverse
 * symbol	true	string	Symbol name
 * intervalTime	true	string	Interval. 5min,15min,30min,1h,4h,1d
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 200]. Default: 50
 * cursor	false	string	Cursor. Used to paginate
 */
package com.bybit.api.client.domain.market.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OpenInterestRequest {
    private final ProductType category;
    private final String symbol;
    private final String intervalTime;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;

    private OpenInterestRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.intervalTime = builder.intervalTime;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private final ProductType category;
        private final String symbol;
        private final String intervalTime;
        private Long startTime;
        private Long endTime;
        private Integer limit = 50;  // Defaulting to 50
        private String cursor;

        public Builder(ProductType category, String symbol, String intervalTime) {
            this.category = category;
            this.symbol = symbol;
            this.intervalTime = intervalTime;
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

        public OpenInterestRequest build() {
            return new OpenInterestRequest(this);
        }
    }
}
