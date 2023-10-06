package com.bybit.api.client.domain.account;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.position.MarginMode;
import com.bybit.api.client.domain.preupgrade.TransactionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AccountDataRequest {
    private AccountType accountType;
    private ProductType category;
    private String currency;
    private String baseCoin;
    private TransactionType transactionType;
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;
    private String coin;
    private String collateralSwitch;
    private String window;
    private String frozenPeriod;
    private String qtyLimit;
    private String deltaLimit;
    private String coins;
    private MarginMode setMarginMode;
    private String symbol;
}
