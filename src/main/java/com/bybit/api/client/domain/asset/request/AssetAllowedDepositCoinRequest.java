/**
 * HTTP Request
 * GET /v5/asset/deposit/query-allowed-list
 *
 * Request Parameters
 * Parameter	Required	Type	Comments
 * coin	false	string	Coin. coin and chain must be paired if passed
 * chain	false	string	Chain. coin and chain must be paired if passed
 * limit	false	integer	Limit for data size per page. [1, 35]. Default: 10
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 * Response Parameters
 * Parameter	Type	Comments
 * configList	array	Object
 * > coin	string	Coin
 * > chain	string	Chain
 * > coinShowName	string	Coin name
 * > chainType	string	Chain type
 * > blockConfirmNumber	integer	Deposit confirmation number
 * > minDepositAmount	string	Minimum deposit amount
 * nextPageCursor	string	Refer to the cursor request parameter
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
public class AssetAllowedDepositCoinRequest {
    private final String coin;
    private final String chain;
    private final Integer limit;
    private final String cursor;
}

