package com.bybit.api.domain.asset;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.asset.request.AssetDataRequest;
import com.bybit.api.client.restApi.BybitApiAssetRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;
public class ConvertCoinTest {
    BybitApiClientFactory factory = BybitApiClientFactory.newInstance("d08Wh6P037IXAvcrL2", "gLfd1BLGU9oq6YoRZRlwXkIQRYB4n5KvXDvv", BybitApiConfig.TESTNET_DOMAIN);
    BybitApiAssetRestClient client = factory.newAssetRestClient();

    @Test
    public void Test_RequestQuote() {
        var requestQuoteRequest = AssetDataRequest.builder().fromCoin("BTC").toCoin("ETH").accountType(AccountType.CONVERT_UTA).requestCoin("BTC").requestAmount("0.1").build();
        var requestQuoteResponse = client.requestQuote(requestQuoteRequest);
        System.out.println(requestQuoteResponse);
    }
}