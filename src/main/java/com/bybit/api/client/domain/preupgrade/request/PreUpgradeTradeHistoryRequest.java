/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type linear, inverse, option
 * symbol	false	string	Symbol name
 * orderId	false	string	Order ID
 * orderLinkId	false	string	User customised order ID
 * baseCoin	false	string	Base coin. Used for option
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end timestamp (ms)
 * execType	false	string	Execution type
 * limit	false	integer	Limit for data size per page. [1, 100]. Default: 50
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 */
package com.bybit.api.client.domain.preupgrade.request;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.position.ExecType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class PreUpgradeTradeHistoryRequest {
    private String category;
    private String symbol;
    private String orderId;
    private String orderLinkId;
    private String baseCoin;
    private Long startTime;
    private Long endTime;
    private String execType;
    private Integer limit;
    private String cursor;
}

