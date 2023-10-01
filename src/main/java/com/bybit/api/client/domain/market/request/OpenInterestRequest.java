/**
 Request Parameters
 Parameter	Required	Type	Comments
 category	true	string	Product type. linear,inverse
 symbol	true	string	Symbol name
 intervalTime	true	string	Interval. 5min,15min,30min,1h,4h,1d
 startTime	false	integer	The start timestamp (ms)
 endTime	false	integer	The end timestamp (ms)
 limit	false	integer	Limit for data size per page. [1, 200]. Default: 50
 cursor	false	string	Cursor. Used to paginate
 Response Parameters
 Parameter	Type	Comments
 category	string	Product type
 symbol	string	Symbol name
 list	array	Object
 > openInterest	string	Open interest
 > timestamp	string	The timestamp (ms)
 nextPageCursor	string	Used to paginate
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
public class OpenInterestRequest {
    private final ProductType category;
    private final String symbol;
    private final String intervalTime;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;
}
