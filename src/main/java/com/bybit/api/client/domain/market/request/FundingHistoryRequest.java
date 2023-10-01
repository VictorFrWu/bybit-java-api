/**
 Request Parameters
 Parameter	Required	Type	Comments
 category	true	string	Product type. linear,inverse
 symbol	true	string	Symbol name
 startTime	false	integer	The start timestamp (ms)
 endTime	false	integer	The end timestamp (ms)
 limit	false	integer	Limit for data size per page. [1, 200]. Default: 200
 Response Parameters
 Parameter	Type	Comments
 category	string	Product type
 list	array	Object
 > symbol	string	Symbol name
 > fundingRate	string	Funding rate
 > fundingRateTimestamp	string	Funding rate timestamp (ms)
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
public class FundingHistoryRequest {
    private final ProductType category;
    private final String symbol;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
}

