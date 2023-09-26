/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * orderId	false	string	Loan order id. If not passed, then return all orders, sort by loanTime in descend
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end timestamp (ms)
 * limit	false	integer	Limit for data size. [1, 100], Default: 10
 */
package com.bybit.api.client.domain.institution;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class InstitutionLoanOrdersRequest {
    private String orderId;
    private Long startTime;
    private Long endTime;
    private Integer limit;
}

