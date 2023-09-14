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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpotLeverageOrdersRecordRequest {
    private final String ltCoin;
    private final String orderId;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final Integer ltOrderType;
    private final String serialNo;

    private SpotLeverageOrdersRecordRequest(Builder builder) {
        this.ltCoin = builder.ltCoin;;
        this.orderId = builder.orderId;
        this.startTime= builder.startTime;;
        this.endTime=builder.endTime;
        this.limit=builder.limit;
        this.ltOrderType=builder.ltOrderType;
        this.serialNo= builder.serialNo;
    }

    public static class Builder {
        private String ltCoin;
        private String orderId;
        private Long startTime;
        private Long endTime;
        private Integer limit;
        private Integer ltOrderType;
        private String serialNo;

        public Builder ltCoin(String ltCoin) {
            this.ltCoin = ltCoin;
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

        public Builder ltOrderType(Integer ltOrderType) {
            this.ltOrderType = ltOrderType;
            return this;
        }

        public Builder serialNo(String serialNo) {
            this.serialNo = serialNo;
            return this;
        }

        public SpotLeverageOrdersRecordRequest build() {
            return new SpotLeverageOrdersRecordRequest(this);
        }
    }
}


