/**
 * HTTP Request
 * GET /v5/asset/deposit/query-record
 * <p>
 * Request Parameters
 * Parameter	Required	Type	Comments
 * coin	false	string	Coin
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 50
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 * Response Parameters
 * Parameter	Type	Comments
 * rows	array	Object
 * > coin	string	Coin
 * > chain	string	Chain
 * > amount	string	Amount
 * > txID	string	Transaction ID
 * > status	integer	Deposit status
 * > toAddress	string	Deposit target address
 * > tag	string	Tag of deposit target address
 * > depositFee	string	Deposit fee
 * > successAt	string	Last updated time
 * > confirmations	string	Number of confirmation blocks
 * > txIndex	string	Transaction sequence number
 * > blockHash	string	Hash number on the chain
 * > batchReleaseLimit	string	The deposit limit for this coin in this chain. "-1" means no limit
 * > depositType	integer	The deposit type. 0: normal deposit, 10: the deposit reaches daily deposit limit, 20: abnormal deposit
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
public class AssetDepositRecordsRequest {
    private String subMemberId; // required = true to Get Sub Deposit Records (on-chain)
    private String coin;
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;
}
