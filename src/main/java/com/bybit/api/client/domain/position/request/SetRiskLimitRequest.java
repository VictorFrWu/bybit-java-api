/**
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: linear, inverse
 * Normal account: linear, inverse. Please note that category is not involved with business logic
 * symbol	true	string	Symbol name
 * riskId	true	integer	Risk limit ID
 * positionIdx	false	integer	Used to identify positions in different position modes. For hedge mode, it is required
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
public class SetRiskLimitRequest {
    private final String category;
    private final String symbol;
    private final int riskId;
    private final Integer positionIdx;

    private SetRiskLimitRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.riskId = builder.riskId;
        this.positionIdx = builder.positionIdx;
    }

    public static class Builder {
        private final String category;
        private final String symbol;
        private final int riskId;
        private Integer positionIdx;

        public Builder(String category, String symbol, int riskId) {
            this.category = category;
            this.symbol = symbol;
            this.riskId = riskId;
        }

        public Builder positionIdx(Integer positionIdx) {
            this.positionIdx = positionIdx;
            return this;
        }

        public SetRiskLimitRequest build() {
            return new SetRiskLimitRequest(this);
        }
    }
}
