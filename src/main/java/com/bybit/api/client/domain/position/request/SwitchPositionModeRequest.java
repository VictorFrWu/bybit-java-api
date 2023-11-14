/**
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: linear, USDT Perp; inverse, Inverse Futures
 * Normal account: linear, USDT Perp; inverse, Inverse Futures. Please note that category is not involved with business logic
 * symbol	false	string	Symbol name. Either symbol or coin is required. symbol has a higher priority
 * coin	false	string	Coin
 * mode	true	integer	Position mode. 0: Merged Single. 3: Both Sides
 */
package com.bybit.api.client.domain.position.request;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.position.PositionMode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SwitchPositionModeRequest {
    private String category;
    private String symbol;
    private String coin;
    private Integer positionMode;
}
