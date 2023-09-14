package com.bybit.api.client.domain.spot.marginTrade;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpotMarginTradeBorrowOrdersRequest {
    private final Long startTime;
    private final Long endTime;
    private final String coin;
    private final Integer status;
    private final Integer limit;

    private SpotMarginTradeBorrowOrdersRequest(Builder builder) {
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.coin = builder.coin;
        this.status = builder.status;
        this.limit = builder.limit;
    }

    public static class Builder {
        private Long startTime;
        private Long endTime;
        private String coin;
        private Integer status;
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

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public SpotMarginTradeBorrowOrdersRequest build() {
            return new SpotMarginTradeBorrowOrdersRequest(this);
        }
    }
}

