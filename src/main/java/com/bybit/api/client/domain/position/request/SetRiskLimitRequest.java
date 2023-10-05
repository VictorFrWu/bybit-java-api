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

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Builder
public class SetRiskLimitRequest {
    private String category;
    private String symbol;
    private Integer riskId;
    private Integer positionIdx;
}
