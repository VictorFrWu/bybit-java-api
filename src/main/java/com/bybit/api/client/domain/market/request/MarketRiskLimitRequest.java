/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. linear,inverse
 * symbol	false	string	Symbol name
 * Response Parameters
 * Parameter	Type	Comments
 * category	string	Product type
 * list	array	Object
 * > id	integer	Risk ID
 * > symbol	string	Symbol name
 * > riskLimitValue	string	Position limit
 * > maintenanceMargin	number	Maintain margin rate
 * > initialMargin	number	Initial margin rate
 * > isLowestRisk	integer	1: true, 0: false
 * > maxLeverage	string	Allowed max leverage
 */
package com.bybit.api.client.domain.market.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class MarketRiskLimitRequest {
    private final ProductType category;
    private final String symbol;
}
