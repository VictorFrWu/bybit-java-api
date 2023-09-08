/**
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: linear, USDT Perp; inverse, Inverse Futures
 * Normal account: linear, USDT Perp; inverse, Inverse Futures. Please note that category is not involved with business logic
 * symbol	false	string	Symbol name. Either symbol or coin is required. symbol has a higher priority
 * coin	false	string	Coin
 * mode	true	integer	Position mode. 0: Merged Single. 3: Both Sides
 */
package com.bybit.api.client.domain.position.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SwitchPositionModeRequest {
    private final String category;
    private final String symbol;
    private final String coin;
    private final int mode;

    private SwitchPositionModeRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.coin = builder.coin;
        this.mode = builder.mode;
    }

    public static class Builder {
        private final String category;
        private String symbol;
        private String coin;
        private final int mode;

        public Builder(String category, int mode) {
            this.category = category;
            this.mode = mode;
        }

        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder coin(String coin) {
            this.coin = coin;
            return this;
        }

        public SwitchPositionModeRequest build() {
            return new SwitchPositionModeRequest(this);
        }
    }
}
