/**
 * /**
 *  Request Parameters
 *  Parameter	Required	Type	Comments
 *  orderId	false	string	Loan order id. If not passed, then return all orders, sort by loanTime in descend
 *  startTime	false	integer	The start timestamp (ms)
 *  endTime	false	integer	The end timestamp (ms)
 *  limit	false	integer	Limit for data size. [1, 100], Default: 10
 *  */
package com.bybit.api.client.domain.account.institution;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InstitutionRepayOrdersRequest {
    private Long startTime;
    private Long endTime;
    private Integer limit;

    public InstitutionRepayOrdersRequest(Long startTime, Long endTime, Integer limit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.limit = limit;
    }
    public static class Builder {
        private Long startTime;
        private Long endTime;
        private Integer limit;

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

        public InstitutionRepayOrdersRequest build() {
            return new InstitutionRepayOrdersRequest(startTime, endTime, limit);
        }
    }
}
