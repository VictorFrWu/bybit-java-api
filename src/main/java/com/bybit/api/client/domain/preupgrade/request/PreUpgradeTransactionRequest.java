/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. option
 * symbol	false	string	Symbol name
 * expDate	false	string	Expiry date. 25MAR22. Default: return all
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
 * cursor	false	string	Cursor. Used for pagination
 */
package com.bybit.api.client.domain.preupgrade.request;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.preupgrade.TransactionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PreUpgradeTransactionRequest {
    private final ProductType category;
    private final String baseCoin;
    private final TransactionType transactionType;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;

    private PreUpgradeTransactionRequest(Builder builder) {
        this.category = builder.category;
        this.baseCoin = builder.baseCoin;
        this.transactionType = builder.transactionType;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private final ProductType category;
        private String baseCoin;
        private TransactionType transactionType;
        private Long startTime;
        private Long endTime;
        private Integer limit; // Default value 20
        private String cursor;

        public Builder(ProductType category) {
            this.category = category;
        }

        public Builder baseCoin(String baseCoin) {
            this.baseCoin = baseCoin;
            return this;
        }

        public Builder type(TransactionType transactionType) {
            this.transactionType = transactionType;
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

        public PreUpgradeTransactionRequest build() {
            return new PreUpgradeTransactionRequest(this);
        }
    }
}
