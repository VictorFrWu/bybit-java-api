/**
 * category	true	string	Product type. linear,inverse
 * symbol	true	string	Symbol name
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 200]. Default: 200
 */
package com.bybit.api.client.domain.market.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FundingHistoryRequest {
    private final ProductType category;
    private final String symbol;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;

    private FundingHistoryRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.limit = builder.limit;
    }

    public static class Builder {
        private final ProductType category;
        private final String symbol;
        private Long startTime;
        private Long endTime;
        private Integer limit = 200;  // Defaulting to 200

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

        public FundingHistoryRequest build() {
            return new FundingHistoryRequest(this);
        }
    }

}

