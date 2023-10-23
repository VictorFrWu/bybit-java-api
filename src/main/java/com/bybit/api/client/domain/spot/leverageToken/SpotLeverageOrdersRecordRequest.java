/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * ltCoin	false	string	Abbreviation of the LT, such as BTC3L
 * orderId	false	string	Order ID
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 500]. Default: 100
 * ltOrderType	false	integer	LT order type. 1: purchase, 2: redemption
 * serialNo	false	string	Serial number
 */
package com.bybit.api.client.domain.spot.leverageToken;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SpotLeverageOrdersRecordRequest {
    private final String ltCoin;
    private final String orderId;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final Integer ltOrderType;
    private final String serialNo;
}


