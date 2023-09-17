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
package com.bybit.api.client.domain.c2c;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientLendingOrderRecordsRequest {
    private final String coin;
    private final String orderId;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String orderType;

    private ClientLendingOrderRecordsRequest(Builder builder) {
        this.coin = builder.coin;
        this.orderId = builder.orderId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.limit = builder.limit;
        this.orderType = builder.orderType;
    }

    public static class Builder {
        private String coin;
        private String orderId;
        private Long startTime;
        private Long endTime;
        private Integer limit;
        private String orderType;

        public Builder coin(String coin) {
            this.coin = coin;
            return this;
        }

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

        public Builder orderType(String orderType) {
            this.orderType = orderType;
            return this;
        }

        public ClientLendingOrderRecordsRequest build() {
            return new ClientLendingOrderRecordsRequest(this);
        }
    }
}
