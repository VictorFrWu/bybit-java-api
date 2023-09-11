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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WalletBalanceRequest {
    private final AccountType accountType;
    private final String coins;

    private WalletBalanceRequest(Builder builder) {
        this.accountType = builder.accountType;
        this.coins = builder.coins;
    }

    public static class Builder {
        private final AccountType accountType;
        private String coins;

        public Builder(AccountType accountType) {
            this.accountType = accountType;
        }

        public Builder coins(String coins) {
            this.coins = coins;
            return this;
        }

        public WalletBalanceRequest build() {
            return new WalletBalanceRequest(this);
        }
    }
}
