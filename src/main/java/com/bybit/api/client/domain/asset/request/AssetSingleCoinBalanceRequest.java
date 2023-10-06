/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * transferId	false	string	UUID. Use the one you generated in createTransfer
 * coin	false	string	Coin
 * status	false	string	Transfer status
 * startTime	false	integer	The start timestamp (ms) Note: the query logic is actually effective based on second level
 * endTime	false	integer	The end timestamp (ms) Note: the query logic is actually effective based on second level
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 * Response Parameters
 * Parameter	Type	Comments
 * list	array	Object
 * > transferId	string	Transfer ID
 * > coin	string	Transferred coin
 * > amount	string	Transferred amount
 * > fromAccountType	string	From account type
 * > toAccountType	string	To account type
 * > timestamp	string	Transfer created timestamp (ms)
 * > status	string	Transfer status
 * nextPageCursor	string	Refer to the cursor request parameter
 */
package com.bybit.api.client.domain.asset.request;

import com.bybit.api.client.domain.account.AccountType;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class AssetSingleCoinBalanceRequest {
    private String memberId;
    private String toMemberId;
    private String accountType; // Required true
    private String toAccountType;
    private String coin; // Required true
    private Integer withBonus;
    private Integer withTransferSafeAmount;
    private Integer withLtvTransferSafeAmount;
}

