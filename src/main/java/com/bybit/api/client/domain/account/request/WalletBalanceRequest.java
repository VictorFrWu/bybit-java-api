/**
request Parameters
        Parameter	Required	Type	Comments
        accountType	true	string	Account type
        Unified account: UNIFIED (trade spot/linear/options), CONTRACT(trade inverse)
        Normal account: CONTRACT, SPOT
        coin	false	string	Coin name
        If not passed, it returns non-zero asset info
        You can pass multiple coins to query, separated by comma. USDT,USDC

 */
package com.bybit.api.client.domain.account.request;

import com.bybit.api.client.domain.account.AccountType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class WalletBalanceRequest {
    private String accountType;
    private String coins;
}
