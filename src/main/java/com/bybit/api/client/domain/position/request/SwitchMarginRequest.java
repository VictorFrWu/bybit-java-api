/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: inverse
 * Normal account: linear, inverse. Please note that category is not involved with business logic
 * symbol	true	string	Symbol name
 * tradeMode	true	integer	0: cross margin. 1: isolated margin
 * buyLeverage	true	string	The value must be equal to sellLeverage value
 * sellLeverage	true	string	The value must be equal to buyLeverage value
 */
package com.bybit.api.client.domain.position.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SwitchMarginRequest {
    private final String category;
    private final String symbol;
    private final int tradeMode;
    private final String buyLeverage;
    private final String sellLeverage;

    private SwitchMarginRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.tradeMode = builder.tradeMode;
        this.buyLeverage = builder.buyLeverage;
        this.sellLeverage = builder.sellLeverage;
    }

    public static class Builder {
        private final String category;
        private final String symbol;
        private final int tradeMode;
        private final String buyLeverage;
        private final String sellLeverage;

        public Builder(String category, String symbol, int tradeMode, String buyLeverage, String sellLeverage) {
            this.category = category;
            this.symbol = symbol;
            this.tradeMode = tradeMode;
            this.buyLeverage = buyLeverage;
            this.sellLeverage = sellLeverage;
        }

        public SwitchMarginRequest build() {
            return new SwitchMarginRequest(this);
        }
    }
}
