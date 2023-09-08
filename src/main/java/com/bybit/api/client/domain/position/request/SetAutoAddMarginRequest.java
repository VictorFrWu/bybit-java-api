/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: linear, inverse
 * Normal account: linear, inverse
 * symbol	true	string	Symbol name
 * autoAddMargin	true	integer	Turn on/off. 0: off. 1: on
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
public class SetAutoAddMarginRequest {
    private final String category;
    private final String symbol;
    private final int autoAddMargin;
    private final int positionIdx;

    private SetAutoAddMarginRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.autoAddMargin = builder.autoAddMargin;
        this.positionIdx = builder.positionIdx;
    }

    public static class Builder {
        private final String category;
        private final String symbol;
        private final int autoAddMargin;
        private int positionIdx;

        public Builder(String category, String symbol, int autoAddMargin) {
            this.category = category;
            this.symbol = symbol;
            this.autoAddMargin = autoAddMargin;
        }

        public Builder positionIdx(int positionIdx) {
            this.positionIdx = positionIdx;
            return this;
        }

        public SetAutoAddMarginRequest build() {
            return new SetAutoAddMarginRequest(this);
        }
    }
}
