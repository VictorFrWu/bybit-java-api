/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * ltCoin	true	string	Abbreviation of the LT, such as BTC3L
 * ltAmount	true	string	Purchase amount
 * serialNo	false	string	Serial number
 */
package com.bybit.api.client.domain.spot.leverageToken;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SpotLeverageTokenRequest {
    private final String ltCoin;
    private final String ltAmount;
    private final String serialNo;
    private final String quantity;
}

