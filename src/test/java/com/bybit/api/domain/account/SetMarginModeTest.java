package com.bybit.api.domain.account;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.account.SpotHedgingMode;
import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.domain.position.MarginMode;
import com.bybit.api.client.restApi.BybitApiAccountRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

public class SetMarginModeTest {
    BybitApiAccountRestClient client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newAccountRestClient();
    @Test
    public void Test_SetMarginMode()
    {
        var setAccountMarginModeRequest = AccountDataRequest.builder().setMarginMode(MarginMode.CROSS_MARGIN).build();
        var marginModeResult = client.setAccountMarginMode(setAccountMarginModeRequest);
        System.out.println(marginModeResult);
    }
}
