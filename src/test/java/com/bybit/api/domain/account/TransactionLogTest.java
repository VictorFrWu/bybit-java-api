package com.bybit.api.domain.account;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.account.CollateralSwitch;
import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.domain.account.request.BatchSetCollateralCoinRequest;
import com.bybit.api.client.domain.account.request.SetCollateralCoinRequest;
import com.bybit.api.client.domain.user.IsUta;
import com.bybit.api.client.restApi.BybitApiAccountRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

import java.util.Arrays;

public class TransactionLogTest {
    @Test
    public void Test_UTAAccountGetTransaction()
    {
        BybitApiAccountRestClient client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newAccountRestClient();
        var transactionLogRequest = AccountDataRequest.builder().build();
        var result = client.getTransactionLog(transactionLogRequest);
        System.out.println(result);
    }

    @Test
    public void Test_ClassicalAccountGetTransaction()
    {
        BybitApiAccountRestClient client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newAccountRestClient();
        var transactionLogRequest = AccountDataRequest.builder().isUta(IsUta.CLASSIC_ACCOUNT).build();
        var result = client.getTransactionLog(transactionLogRequest);
        System.out.println(result);
    }
}
