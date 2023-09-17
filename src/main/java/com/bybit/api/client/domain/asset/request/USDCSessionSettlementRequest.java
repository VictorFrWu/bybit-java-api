/**
 * HTTP Request
 * GET /v5/asset/settlement-record
 *
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. linear
 * symbol	false	string	Symbol name
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 * Response Parameters
 * Parameter	Type	Comments
 * category	string	Product type
 * list	array	Object
 * > symbol	string	Symbol name
 * > side	string	Buy,Sell
 * > size	string	Position size
 * > sessionAvgPrice	string	Settlement price
 * > markPrice	string	Mark price
 * > realisedPnl	string	Realised PnL
 * > createdTime	string	Created time (ms)
 * nextPageCursor	string	Refer to the cursor request parameter
 */
package com.bybit.api.client.domain.asset.request;

import com.bybit.api.client.domain.ProductType;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class USDCSessionSettlementRequest {
    private final ProductType category;
    private final String symbol;
    private final Integer limit;
    private final String cursor;
}

