/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. linear, inverse, option
 * symbol	false	string	Symbol name
 * baseCoin	false	string	Base coin. Default: BTC. valid for option only
 * limit	false	integer	Limit for data size per page. [1, 200]. Default: 50
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 * Response Parameters
 * Parameter	Type	Comments
 * category	string	Product type
 * list	array	Object
 * > symbol	string	Symbol name
 * > deliveryPrice	string	Delivery price
 * > deliveryTime	string	Delivery timestamp (ms)
 * nextPageCursor	string	Refer to the cursor request parameter
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
public class DeliveryPriceRequest {
    private final ProductType category;
    private final String symbol;
    private final String baseCoin;
    private final Integer limit;
    private final String cursor;
}
