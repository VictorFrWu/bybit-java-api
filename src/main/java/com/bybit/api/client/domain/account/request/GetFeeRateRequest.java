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

import com.bybit.api.client.domain.CategoryType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class GetFeeRateRequest {
    private String category;
    private String symbol;
    private String baseCoin;
}


