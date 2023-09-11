/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * baseCoin	true	string	Base coin
 * window	true	string	Time window (ms)
 * frozenPeriod	true	string	Frozen period (ms). "0" means the trade will remain frozen until manually reset
 * qtyLimit	true	string	Trade qty limit (positive and up to 2 decimal places)
 * deltaLimit	true	string	Delta limit (positive and up to 2 decimal places)
 */
package com.bybit.api.client.domain.account.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetFeeRateRequest {
    private final ProductType category;
    private final String symbol;
    private final String baseCoin;

    private GetFeeRateRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.baseCoin = builder.baseCoin;
    }

    public static class Builder {
        private ProductType category;
        private String symbol;
        private String baseCoin;

        public Builder category(ProductType category) {
            this.category = category;
            return this;
        }

        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder baseCoin(String baseCoin) {
            this.baseCoin = baseCoin;
            return this;
        }

        public GetFeeRateRequest build() {
            return new GetFeeRateRequest(this);
        }
    }
}


