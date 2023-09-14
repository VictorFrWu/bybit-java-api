package com.bybit.api.client.domain.spot.marginTrade;

import com.bybit.api.client.domain.spot.VipLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VIPMarginDataRequest {
    private final VipLevel vipLevel;
    private final String currency;

    private VIPMarginDataRequest(Builder builder) {
        this.vipLevel = builder.vipLevel;
        this.currency = builder.currency;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private VipLevel vipLevel;
        private String currency;

        public Builder vipLevel(VipLevel vipLevel) {
            this.vipLevel = vipLevel;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public VIPMarginDataRequest build() {
            return new VIPMarginDataRequest(this);
        }
    }
}


