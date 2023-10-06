/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. linear
 * symbol	false	string	Symbol name
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
 * cursor	false	string	Cursor. Used for pagination
 */
package com.bybit.api.client.domain.preupgrade.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class PreUpgradeUsdcSettlementRequest {
    private String category;
    private String symbol;
    private Integer limit;
    private String cursor;
}

