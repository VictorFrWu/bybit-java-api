/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. linear, inverse, option
 * symbol	false	string	Symbol name.
 * If not passed, return settleCoin=USDT by default
 * To get USDC perp, please pass symbol
 * baseCoin	false	string	Base coin. Used for option query
 * orderId	false	string	Order ID
 * orderLinkId	false	string	User customised order ID
 * orderFilter	false	string	Order: active order, StopOrder: conditional order
 * orderStatus	false	string	Order status
 * startTime	false	integer	The start timestamp (ms)
 * startTime and endTime must be passed together
 * If not passed, query the past 7 days data by default
 * endTime	false	integer	The end timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 */
package com.bybit.api.client.domain.preupgrade.request;

import com.bybit.api.client.domain.CategoryType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class PreUpgradeOrderHistoryRequest {
    private String category;
    private String symbol;
    private String baseCoin;
    private String orderId;
    private String orderLinkId;
    private String orderFilter;
    private String orderStatus;
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;
}

