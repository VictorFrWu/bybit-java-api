/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: linear, inverse
 * Normal account: linear, inverse
 * symbol	true	string	Symbol name
 * margin	true	string	Add or reduce. To add, then 10; To reduce, then -10. Support up to 4 decimal
 * positionIdx	false	integer	Used to identify positions in different position modes. For hedge mode position, this param is required
 * 0: one-way mode
 * 1: hedge-mode Buy side
 * 2: hedge-mode Sell side
 */
package com.bybit.api.client.domain.position.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ModifyMarginRequest {
    private final String category;
    private final String symbol;
    private final String margin;
    private final int positionIdx;

    private ModifyMarginRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.margin = builder.margin;
        this.positionIdx = builder.positionIdx;
    }

    public static class Builder {
        private final String category;
        private final String symbol;
        private final String margin;
        private int positionIdx;

        public Builder(String category, String symbol, String margin) {
            this.category = category;
            this.symbol = symbol;
            this.margin = margin;
        }

        public Builder positionIdx(int positionIdx) {
            this.positionIdx = positionIdx;
            return this;
        }

        public ModifyMarginRequest build() {
            return new ModifyMarginRequest(this);
        }
    }
}

