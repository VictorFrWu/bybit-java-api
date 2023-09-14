package com.bybit.api.client.domain.spot.marginTrade;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpotMarginTradeRepayOrdersRequest {
    private final Long startTime;
    private final Long endTime;
    private final String coin;
    private final Integer limit;

    private SpotMarginTradeRepayOrdersRequest(Builder builder) {
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.coin = builder.coin;
        this.limit = builder.limit;
    }

    public static class Builder {
        private Long startTime;
        private Long endTime;
        private String coin;
        private Integer limit;

        public Builder startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder coin(String coin) {
            this.coin = coin;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public SpotMarginTradeRepayOrdersRequest build() {
            return new SpotMarginTradeRepayOrdersRequest(this);
        }
    }
}
