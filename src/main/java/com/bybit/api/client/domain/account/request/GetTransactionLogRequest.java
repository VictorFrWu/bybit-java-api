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
    private String accountType;
    private String category;
    private String currency;
    private String baseCoin;
    private String transactionType;
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;
}

