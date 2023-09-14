/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * ltCoin	true	string	Abbreviation of the LT, such as BTC3L
 * ltAmount	true	string	Purchase amount
 * serialNo	false	string	Serial number
 */
package com.bybit.api.client.domain.spot.leverageToken;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpotLeverageTokenRequest {
    private final String ltCoin;
    private final String ltAmount;
    private final String serialNo;

    private SpotLeverageTokenRequest(Builder builder) {
        this.ltCoin = builder.ltCoin;;
        this.ltAmount = builder.ltAmount;;
        this.serialNo = builder.serialNo;
    }

    public static class Builder {
        private final String ltCoin;
        private final String ltAmount;
        private String serialNo;

        public Builder(String ltCoin, String ltAmount) {
            this.ltCoin = ltCoin;
            this.ltAmount = ltAmount;
        }

        public Builder serialNo(String serialNo) {
            this.serialNo = serialNo;
            return this;
        }

        public SpotLeverageTokenRequest build() {
            return new SpotLeverageTokenRequest(this);
        }
    }
}

