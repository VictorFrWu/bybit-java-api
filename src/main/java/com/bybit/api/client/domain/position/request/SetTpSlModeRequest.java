/**
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: linear, inverse
 * Normal account: linear, inverse. Please note that category is not involved with business logic
 * symbol	true	string	Symbol name
 * tpSlMode	true	string	TP/SL mode. Full,Partial
 */
package com.bybit.api.client.domain.position.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SetTpSlModeRequest {
    private final String category;
    private final String symbol;
    private final String tpSlMode;

    private SetTpSlModeRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.tpSlMode = builder.tpSlMode;
    }

    public static class Builder {
        private final String category;
        private final String symbol;
        private final String tpSlMode;

        public Builder(String category, String symbol, String tpSlMode) {
            this.category = category;
            this.symbol = symbol;
            this.tpSlMode = tpSlMode;
        }

        public SetTpSlModeRequest build() {
            return new SetTpSlModeRequest(this);
        }
    }

}
