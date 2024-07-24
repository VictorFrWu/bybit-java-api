package com.bybit.api.domain.account;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.account.SpotHedgingMode;
import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.restApi.BybitApiAccountRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

public class AccountBalanceTest {
    BybitApiAccountRestClient client = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj", BybitApiConfig.TESTNET_DOMAIN).newAccountRestClient();

    @Test
    public void Test_GetAccountBalance() {
        var unifyWalletBalanceRequest = AccountDataRequest.builder().accountType(AccountType.UNIFIED).build();
        var result = client.getWalletBalance(unifyWalletBalanceRequest);
        System.out.println(result);
    }
}
