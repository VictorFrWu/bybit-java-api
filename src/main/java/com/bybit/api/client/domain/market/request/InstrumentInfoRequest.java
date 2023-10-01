/**
 * category	true	string	Product type. spot,linear,inverse,option
 * symbol	false	string	Symbol name
 * status	false	string	Symbol status filter
 * spot/linear/inverse has Trading only
 * baseCoin	false	string	Base coin. linear,inverse,option only
 * For option, it returns BTC by default
 * limit	false	integer	Limit for data size per page. [1, 1000]. Default: 500
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
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
public class InstrumentInfoRequest {
    private final ProductType category;  // Required
    private final String symbol;
    private final String status;
    private final String baseCoin;
    private final Integer limit;
    private final String cursor;
}
