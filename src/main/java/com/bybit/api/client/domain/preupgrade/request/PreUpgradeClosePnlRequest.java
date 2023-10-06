/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type linear, inverse
 * symbol	true	string	Symbol name
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 100]. Default: 50
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 */
package com.bybit.api.client.domain.preupgrade.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class PreUpgradeClosePnlRequest {
    private String category;
    private String symbol;
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;
}

