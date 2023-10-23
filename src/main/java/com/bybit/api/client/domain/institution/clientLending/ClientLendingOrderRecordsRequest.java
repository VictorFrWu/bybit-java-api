/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * coin	false	string	Coin name
 * orderId	false	string	Order ID
 * startTime	false	long	The start timestamp (ms)
 * endTime	false	long	The end timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 500]. Default: 50
 * orderType	false	string	Order type. 1: deposit, 2: redemption, 3: Payment of proceeds
 * Response Parameters
 * Parameter	Type	Comments
 * list	array	Object
 * > coin	string	Coin name
 * > createdTime	string	Created timestamp (ms)
 * > orderId	string	Order ID
 * > quantity	string	quantity
 * > serialNo	string	Serial No
 * > status	string	Order status. 0: Initial, 1: Processing, 2: Success, 10: Failed
 * > updatedTime	string	Updated timestamp (ms)
 */
package com.bybit.api.client.domain.institution.clientLending;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ClientLendingOrderRecordsRequest {
    private final String coin;
    private final String orderId;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String orderType;
}
