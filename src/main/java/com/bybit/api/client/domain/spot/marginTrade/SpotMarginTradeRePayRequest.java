/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * coin	true	string	Coin name
 * qty	false	string	Amount to repay
 * qty is required when completeRepayment=0
 * qty is invalid when completeRepayment=1
 * completeRepayment	false	integer	Whether to pay off all debts. 0(default): false, 1: true
 * Response Parameters
 * Parameter	Type	Comments
 * repayId	string	Repayment transaction ID
 */
package com.bybit.api.client.domain.spot.marginTrade;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpotMarginTradeRePayRequest {
    private final String coin;
    private final String qty;
    private final Integer completeRepayment;

    private SpotMarginTradeRePayRequest(Builder builder) {
        this.coin = builder.coin;
        this.qty = builder.qty;
        this.completeRepayment = builder.completeRepayment;
    }

    public static class Builder {
        private final String coin;
        private String qty;
        private Integer completeRepayment;

        public Builder(String coin) {
            this.coin = coin;
        }

        public Builder qty(String qty) {
            this.qty = qty;
            return this;
        }

        public Builder completeRepayment(Integer completeRepayment) {
            this.completeRepayment = completeRepayment;
            return this;
        }

        public SpotMarginTradeRePayRequest build() {
            return new SpotMarginTradeRePayRequest(this);
        }
    }
}

