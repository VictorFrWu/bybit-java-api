/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * bizType	false	string	Business type. SPOT, DERIVATIVES, OPTIONS
 * startTime	false	integer	The start timestamp(ms)
 * endTime	false	integer	The end timestamp(ms)
 * limit	false	integer	Limit for data size per page. [1, 1000]. Default: 1000
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 * Response Parameters
 * Parameter	Type	Comments
 * list	array	Object
 * > userId	string	uid
 * > bizType	string	Business type
 * > symbol	string	Symbol name
 * > coin	string	Coin name. The currency of earning
 * > earning	string	Earning
 * > orderId	string	Order ID
 * > execTime	string	Execution timestamp (ms)
 * nextPageCursor	string	Refer to the cursor request parameter
 */
package com.bybit.api.client.domain.broker.request;

import com.bybit.api.client.domain.broker.BusinessType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BrokerEarningRequest {
    private final BusinessType bizType;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;

    private BrokerEarningRequest(Builder builder) {
        this.bizType = builder.bizType;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private BusinessType bizType;
        private Long startTime;
        private Long endTime;
        private Integer limit;
        private String cursor;

        public Builder bizType(BusinessType bizType) {
            this.bizType = bizType;
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

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public BrokerEarningRequest build() {
            return new BrokerEarningRequest(this);
        }
    }
}

