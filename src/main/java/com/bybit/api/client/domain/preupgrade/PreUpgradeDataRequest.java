package com.bybit.api.client.domain.preupgrade;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.position.ExecType;
import com.bybit.api.client.domain.trade.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class PreUpgradeDataRequest {
    private CategoryType category;
    private String symbol;
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;
    private String expDate;
    private String baseCoin;
    private String orderId;
    private String orderLinkId;
    private String orderFilter;
    private OrderStatus orderStatus;
    private ExecType execType;
    private TransactionType transactionType;
}
