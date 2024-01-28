package com.bybit.api.client.domain.account.request;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.account.CollateralSwitch;
import com.bybit.api.client.domain.account.SpotHedgingMode;
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
    private CategoryType category;
    private String currency;
    private String baseCoin;
    private TransactionType transactionType;
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;
    private String coin;
    private CollateralSwitch collateralSwitch;
    private String window;
    private String frozenPeriod;
    private String qtyLimit;
    private String deltaLimit;
    private String coins;
    private MarginMode setMarginMode;
    private String symbol;
    private SpotHedgingMode setHedgingMode;
}
