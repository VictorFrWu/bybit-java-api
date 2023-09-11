/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * baseCoin	true	string	Base coin
 * window	true	string	Time window (ms)
 * frozenPeriod	true	string	Frozen period (ms). "0" means the trade will remain frozen until manually reset
 * qtyLimit	true	string	Trade qty limit (positive and up to 2 decimal places)
 * deltaLimit	true	string	Delta limit (positive and up to 2 decimal places)
 */
package com.bybit.api.client.domain.account.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SetMMPRequest {
    private final String baseCoin;
    private final String window;
    private final String frozenPeriod;
    private final String qtyLimit;
    private final String deltaLimit;

    private SetMMPRequest(Builder builder) {
        this.baseCoin = builder.baseCoin;
        this.window = builder.window;
        this.frozenPeriod = builder.frozenPeriod;
        this.qtyLimit = builder.qtyLimit;
        this.deltaLimit = builder.deltaLimit;
    }
    public static class Builder {
        private String baseCoin;
        private String window;
        private String frozenPeriod;
        private String qtyLimit;
        private String deltaLimit;

        public Builder baseCoin(String baseCoin) {
            this.baseCoin = baseCoin;
            return this;
        }

        public Builder window(String window) {
            this.window = window;
            return this;
        }

        public Builder frozenPeriod(String frozenPeriod) {
            this.frozenPeriod = frozenPeriod;
            return this;
        }

        public Builder qtyLimit(String qtyLimit) {
            this.qtyLimit = qtyLimit;
            return this;
        }

        public Builder deltaLimit(String deltaLimit) {
            this.deltaLimit = deltaLimit;
            return this;
        }

        public SetMMPRequest build() {
            return new SetMMPRequest(this);
        }
    }
}

