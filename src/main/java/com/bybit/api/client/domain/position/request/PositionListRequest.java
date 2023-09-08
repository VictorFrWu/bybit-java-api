/**
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: linear, inverse, option
 * Normal account: linear, inverse. Please note that category is not involved with business logic
 * symbol	false	string	Symbol name
 * If symbol passed, it returns data regardless of having position or not.
 * If symbol=null and settleCoin specified, it returns position size greater than zero.
 * baseCoin	false	string	Base coin. option only. Return all option positions if not passed
 * settleCoin	false	string	Settle coin. For linear & inverse, either symbol or settleCoin is required. symbol has a higher priority
 * limit	false	integer	Limit for data size per page. [1, 200]. Default: 20
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 */
package com.bybit.api.client.domain.position.request;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
public class PositionListRequest {
    private final String category;
    private final String symbol;
    private final String baseCoin;
    private final String settleCoin;
    private final Integer limit;
    private final String cursor;

    private PositionListRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.baseCoin = builder.baseCoin;
        this.settleCoin = builder.settleCoin;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private final String category;
        private String symbol;
        private String baseCoin;
        private String settleCoin;
        private Integer limit = 20;  // Defaulting to 20
        private String cursor;

        public Builder(String category) {
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

        public Builder settleCoin(String settleCoin) {
            this.settleCoin = settleCoin;
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

        public PositionListRequest build() {
            return new PositionListRequest(this);
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("category", category)
                .append("symbol", symbol)
                .append("baseCoin", baseCoin)
                .append("settleCoin", settleCoin)
                .append("limit", limit)
                .append("cursor", cursor)
                .toString();
    }
}
