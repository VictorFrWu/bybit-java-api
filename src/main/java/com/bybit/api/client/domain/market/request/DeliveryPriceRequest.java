package com.bybit.api.client.domain.market.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeliveryPriceRequest {
    private final ProductType category;
    private final String symbol;
    private final String baseCoin;
    private final Integer limit;
    private final String cursor;

    private DeliveryPriceRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.baseCoin = builder.baseCoin;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private final ProductType category;
        private String symbol;
        private String baseCoin;  // Defaulting to BTC
        private Integer limit;  // Defaulting to 50
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

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public DeliveryPriceRequest build() {
            return new DeliveryPriceRequest(this);
        }
    }
}
