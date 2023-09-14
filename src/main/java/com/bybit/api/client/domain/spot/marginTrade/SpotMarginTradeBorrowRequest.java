/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * coin	true	string	Coin name
 * qty	true	string	Amount to borrow
 * Response Parameters
 * Parameter	Type	Comments
 * transactId	string	Borrow transaction ID
 */
package com.bybit.api.client.domain.spot.marginTrade;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpotMarginTradeBorrowRequest {
    private final String coin;
    private final String qty;

    private SpotMarginTradeBorrowRequest(Builder builder) {
        this.coin = builder.coin;
        this.qty = builder.qty;
    }

    public static class Builder {
        private final String coin;
        private final String qty;

        public Builder(String coin, String qty) {
            this.coin = coin;
            this.qty = qty;
        }

        public SpotMarginTradeBorrowRequest build() {
            return new SpotMarginTradeBorrowRequest(this);
        }
    }
}

