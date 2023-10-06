/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * coin	true	string	Coin name
 * You can get collateral coin from here
 * USDT, USDC cannot be switched off
 * collateralSwitch	true	string	ON: switch on collateral, OFF: switch off collateral
 */
package com.bybit.api.client.domain.account.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SetCollateralCoinRequest {
    private String coin;
    private String collateralSwitch;
}

