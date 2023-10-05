/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: inverse
 * Normal account: linear, inverse. Please note that category is not involved with business logic
 * symbol	true	string	Symbol name
 * tradeMode	true	integer	0: cross margin. 1: isolated margin
 * buyLeverage	true	string	The value must be equal to sellLeverage value
 * sellLeverage	true	string	The value must be equal to buyLeverage value
 */
package com.bybit.api.client.domain.position.request;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.position.MarginMode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SwitchMarginRequest {
    private String category;
    private String symbol;
    private Integer tradeMode;
    private String buyLeverage;
    private String sellLeverage;
}
