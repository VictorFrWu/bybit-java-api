/**
 * HTTP Request
 * GET /v5/asset/delivery-record
 *
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. option, linear
 * symbol	false	string	Symbol name
 * expDate	false	string	Expiry date. 25MAR22. Default: return all
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 * Response Parameters
 * Parameter	Type	Comments
 * category	string	Product type
 * list	array	Object
 * > deliveryTime	number	Delivery time (ms)
 * > symbol	string	Symbol name
 * > side	string	Buy,Sell
 * > position	string	Executed size
 * > deliveryPrice	string	Delivery price
 * > strike	string	Exercise price
 * > fee	string	Trading fee
 * > deliveryRpl	string	Realized PnL of the delivery
 * nextPageCursor	string	Refer to the cursor request parameter
 */
package com.bybit.api.client.domain.asset.request;

import com.bybit.api.client.domain.ProductType;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class AssetDeliveryRecordsRequest {
    private final ProductType category;
    private final String symbol;
    private final String expDate;
    private final Integer limit;
    private final String cursor;
}
