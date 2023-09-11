/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * coin	true	string	Coin name
 * You can get collateral coin from here
 * USDT, USDC cannot be switched off
 * collateralSwitch	true	string	ON: switch on collateral, OFF: switch off collateral
 */
package com.bybit.api.client.domain.account.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SetCollateralCoinRequest {
    private final String coin;
    private final String collateralSwitch;

    private SetCollateralCoinRequest(Builder builder) {
        this.coin = builder.coin;
        this.collateralSwitch = builder.collateralSwitch;
    }

    public static class Builder {
        private String coin;
        private String collateralSwitch;

        public Builder() {
        }

        public Builder coin(String coin) {
            this.coin = coin;
            return this;
        }

        public Builder collateralSwitch(String collateralSwitch) {
            this.collateralSwitch = collateralSwitch;
            return this;
        }

        public SetCollateralCoinRequest build() {
            return new SetCollateralCoinRequest(this);
        }
    }
}

