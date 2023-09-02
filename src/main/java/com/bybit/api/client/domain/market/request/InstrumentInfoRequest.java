/**
 * category	true	string	Product type. spot,linear,inverse,option
 * symbol	false	string	Symbol name
 * status	false	string	Symbol status filter
 * spot/linear/inverse has Trading only
 * baseCoin	false	string	Base coin. linear,inverse,option only
 * For option, it returns BTC by default
 * limit	false	integer	Limit for data size per page. [1, 1000]. Default: 500
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 */
package com.bybit.api.client.domain.market.request;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.ProductType;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
public class InstrumentInfoRequest {

    private final ProductType category;  // Required
    private final String symbol;
    private final String status;
    private final String baseCoin;
    private final Integer limit;
    private final String cursor;

    private InstrumentInfoRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.status = builder.status;
        this.baseCoin = builder.baseCoin;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private final ProductType category;
        private String symbol;
        private String status;
        private String baseCoin;
        private Integer limit;
        private String cursor;

        public Builder(ProductType category) {
            this.category = category;
        }

        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder baseCoin(String baseCoin) {
            this.baseCoin = baseCoin;
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

        public InstrumentInfoRequest build() {
            return new InstrumentInfoRequest(this);
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("category", category)
                .append("symbol", symbol)
                .append("status", status)
                .append("baseCoin", baseCoin)
                .append("limit", limit)
                .append("cursor", cursor)
                .toString();
    }
}
