/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. spot, linear, inverse, option
 * symbol	true	string	Symbol name
 * limit	false	integer	Limit size for each bid and ask
 * spot: [1, 50]. Default: 1.
 * linear&inverse: [1, 200]. Default: 25.
 * option: [1, 25]. Default: 1.
 * Response Parameters
 * Parameter	Type	Comments
 * s	string	Symbol name
 * b	array	Bid, buyer. Sort by price desc
 * > b[0]	string	Bid price
 * > b[1]	string	Bid size
 * a	array	Ask, seller. Order by price asc
 * > a[0]	string	Ask price
 * > a[1]	string	Ask size
 * ts	integer	The timestamp (ms) that the system generates the data
 * u	integer	Update ID, is always in sequence
 * For future, it is corresponding to u in the wss 200-level orderbook
 * For spot, it is corresponding to u in the wss 50-level orderbook
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
public class MarketOrderBookRequest {
    private final ProductType category; // Required
    private final String symbol; // Required
    private final Integer limit;
}
