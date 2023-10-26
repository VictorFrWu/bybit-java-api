package com.bybit.api.domain.asset;

import com.bybit.api.client.restApi.BybitApiAssetRestClient;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.asset.AssetDataRequest;
import com.bybit.api.client.domain.asset.WithBonus;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

public class CoinBalanceTest {
    BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
    BybitApiAssetRestClient client = factory.newAssetRestClient();
    @Test
    public void Test_GetSingleCoinBalance()
    {
        var SingleCoinBalanceRequest = AssetDataRequest.builder().accountType(AccountType.UNIFIED).coin("USDT").withBonus(WithBonus.QUERY).build();
        var SingleCoinBalance = client.getAssetSingleCoinBalance(SingleCoinBalanceRequest);
        System.out.println(SingleCoinBalance);
    }

    @Test
    public void Test_GetAllCoinsBalance()
    {
        var allCoinsBalanceRequest = AssetDataRequest.builder().accountType(AccountType.UNIFIED).withBonus(WithBonus.QUERY).build();
        var allCoinsBalance = client.getAssetAllCoinsBalance(allCoinsBalanceRequest);
        System.out.println(allCoinsBalance);
    }
}
