/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * orderId	false	string	Loan order id. If not passed, then return all orders, sort by loanTime in descend
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end timestamp (ms)
 * limit	false	integer	Limit for data size. [1, 100], Default: 10
 */
package com.bybit.api.client.domain.account.institution;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InstitutionLoanOrdersRequest {
    private String orderId;
    private Long startTime;
    private Long endTime;
    private Integer limit;

    public InstitutionLoanOrdersRequest(String orderId, Long startTime, Long endTime, Integer limit) {
        this.orderId = orderId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.limit = limit;
    }
    public static class Builder {
        private String orderId;
        private Long startTime;
        private Long endTime;
        private Integer limit;

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public InstitutionLoanOrdersRequest build() {
            return new InstitutionLoanOrdersRequest(orderId, startTime, endTime, limit);
        }
    }
}

