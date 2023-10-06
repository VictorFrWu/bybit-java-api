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

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SetMMPRequest {
    private String baseCoin;
    private String window;
    private String frozenPeriod;
    private String qtyLimit;
    private String deltaLimit;
}

