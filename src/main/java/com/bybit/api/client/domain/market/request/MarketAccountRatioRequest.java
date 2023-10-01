/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. linear(USDT Perpetual only),inverse
 * symbol	true	string	Symbol name
 * period	true	string	Data recording period. 5min, 15min, 30min, 1h, 4h, 4d
 * limit	false	integer	Limit for data size per page. [1, 500]. Default: 50
 * Response Parameters
 * Parameter	Type	Comments
 * list	array	Object
 * > symbol	string	Symbol name
 * > buyRatio	string	Long position ratio
 * > sellRatio	string	Sell position ratio
 * > timestamp	string	Timestamp (ms)
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
public class MarketAccountRatioRequest {
    private final ProductType category;
    private final String symbol;
    private final String period;
    private final Integer limit;
}
