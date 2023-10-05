/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: linear, inverse
 * Normal account: linear, inverse
 * symbol	true	string	Symbol name
 * margin	true	string	Add or reduce. To add, then 10; To reduce, then -10. Support up to 4 decimal
 * positionIdx	false	integer	Used to identify positions in different position modes. For hedge mode position, this param is required
 * 0: one-way mode
 * 1: hedge-mode Buy side
 * 2: hedge-mode Sell side
 */
package com.bybit.api.client.domain.position.request;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.trade.PositionIdx;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ModifyMarginRequest {
    private String category;
    private String symbol;
    private String margin;
    private Integer positionIdx;
}

