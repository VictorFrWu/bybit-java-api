/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * currency	false	string	USDC,USDT,BTC,ETH
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end time. timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 */
package com.bybit.api.client.domain.account.request;

import com.bybit.api.client.domain.CategoryType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class BorrowHistoryRequest {
    private String currency;
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;
}
