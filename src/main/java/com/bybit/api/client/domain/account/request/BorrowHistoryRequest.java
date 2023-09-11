/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * currency	false	string	USDC,USDT,BTC,ETH
 * startTime	false	integer	The start timestamp (ms)
 * endTime	false	integer	The end time. timestamp (ms)
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
 * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
 */
package com.bybit.api.client.domain.account.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BorrowHistoryRequest {
    private final String currency;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;

    private BorrowHistoryRequest(Builder builder) {
        this.currency = builder.currency;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private String currency;
        private Long startTime;
        private Long endTime;
        private Integer limit;
        private String cursor;

        public Builder() {
        }

        public Builder currency(String currency) {
            this.currency = currency;
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

        public BorrowHistoryRequest build() {
            return new BorrowHistoryRequest(this);
        }
    }
}
