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
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
public class RecentTradeDataRequest {
    private ProductType category;
    private String symbol;
    private String baseCoin;
    private String optionType;
    private Integer limit;

    private RecentTradeDataRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.baseCoin = builder.baseCoin;
        this.optionType = builder.optionType;
        this.limit = builder.limit;
    }

    public static class Builder {
        private final ProductType category;
        private String symbol;
        private String baseCoin;
        private String optionType;
        private Integer limit;

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

        public Builder optionType(String optionType) {
            this.optionType = optionType;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public RecentTradeDataRequest build() {
            return new RecentTradeDataRequest(this);
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("category", category.getProductTypeId())
                .append("symbol", symbol)
                .append("baseCoin", baseCoin)
                .append("optionType", optionType)
                .append("limit", limit)
                .toString();
    }
}
