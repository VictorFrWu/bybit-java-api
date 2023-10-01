/***
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. spot,linear,inverse
 * symbol	true	string	Symbol name
 * interval	true	string	Kline interval. 1,3,5,15,30,60,120,240,360,720,D,M,W
 * start	false	integer	The start timestamp (ms)
 * end	false	integer	The end timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 1000]. Default: 200
 * Response Parameters
 * Parameter	Type	Comments
 * category	string	Product type
 * symbol	string	Symbol name
 * list	array
 * An string array of individual candle
 * Sort in reverse by startTime
 * > list[0]: startTime	string	Start time of the candle (ms)
 * > list[1]: openPrice	string	Open price
 * > list[2]: highPrice	string	Highest price
 * > list[3]: lowPrice	string	Lowest price
 * > list[4]: closePrice	string	Close price. Is the last traded price when the candle is not closed
 * > list[5]: volume	string	Trade volume. Unit of contract: pieces of contract. Unit of spot: quantity of coins
 * > list[6]: turnover	string	Turnover. Unit of figure: quantity of quota coin
 */
package com.bybit.api.client.domain.market.request;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.MarketInterval;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class MarketKlineRequest {
    private final ProductType category;
    private final String symbol;
    private final MarketInterval marketInterval;
    private final Long start;
    private final Long end;
    private final Integer limit;
}
