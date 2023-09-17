/**
 * HTTP Request
 * GET /v5/asset/exchange/order-record
 *
 * Request Parameters
 * Parameter	Required	Type	Comments
 * fromCoin	false	string	The currency to convert from. e.g,BTC
 * toCoin	false	string	The currency to convert to. e.g,USDT
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 10
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 * Response Parameters
 * Parameter	Type	Comments
 * nextPageCursor	string	Refer to the cursor request parameter
 * orderBody	array	Object
 * > fromCoin	string	The currency to convert from
 * > fromAmount	string	The amount to convert from
 * > toCoin	string	The currency to convert to
 * > toAmount	string	The amount to convert to
 * > exchangeRate	string	Exchange rate
 * > createdTime	string	Exchange created timestamp (sec)
 * > exchangeTxId	string	Exchange transaction ID
 */
package com.bybit.api.client.domain.asset.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CoinExchangeRecordsRequest {
    private final String fromCoin;
    private final String toCoin;
    private final Integer limit;
    private final String cursor;
}
