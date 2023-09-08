package com.bybit.api.client.domain.position.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SetLeverageRequest {
    private final String category;
    private final String symbol;
    private final String buyLeverage;
    private final String sellLeverage;

    private SetLeverageRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.buyLeverage = builder.buyLeverage;
        this.sellLeverage = builder.sellLeverage;
    }

    public static class Builder {
        private final String category;
        private final String symbol;
        private final String buyLeverage;
        private final String sellLeverage;

        public Builder(String category, String symbol, String buyLeverage, String sellLeverage) {
            this.category = category;
            this.symbol = symbol;
            this.buyLeverage = buyLeverage;
            this.sellLeverage = sellLeverage;
        }

        public SetLeverageRequest build() {
            return new SetLeverageRequest(this);
        }
    }
}
