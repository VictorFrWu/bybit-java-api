package com.bybit.api.client.domain.account.request;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.preupgrade.TransactionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetTransactionLogRequest {
    private final AccountType accountType;
    private final ProductType category;
    private final String currency;
    private final String baseCoin;
    private final TransactionType transactionType;
    private final Long startTime;
    private final Long endTime;
    private final Integer limit;
    private final String cursor;

    private GetTransactionLogRequest(Builder builder) {
        this.accountType = builder.accountType;
        this.category = builder.category;
        this.currency = builder.currency;
        this.baseCoin = builder.baseCoin;
        this.transactionType = builder.transactionType;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }
    public static class Builder {
        private AccountType accountType;
        private ProductType category;
        private String currency;
        private String baseCoin;
        private TransactionType transactionType;
        private Long startTime;
        private Long endTime;
        private Integer limit;
        private String cursor;

        public Builder accountType(AccountType accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder category(ProductType category) {
            this.category = category;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
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

        public GetTransactionLogRequest build() {
            return new GetTransactionLogRequest(this);
        }
    }
}

