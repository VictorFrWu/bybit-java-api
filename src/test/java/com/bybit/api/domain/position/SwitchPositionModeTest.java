package com.bybit.api.domain.position;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.position.PositionMode;
import com.bybit.api.client.domain.position.request.PositionDataRequest;
import com.bybit.api.client.restApi.BybitApiPositionRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

public class SwitchPositionModeTest {
    BybitApiPositionRestClient client = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj", BybitApiConfig.TESTNET_DOMAIN).newPositionRestClient();
    @Test
    public void Test_SwitchPositionMode()
    {
        var switchPositionMode = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").positionMode(PositionMode.MERGED_SINGLE).build();
        var switchModeResult = client.switchPositionMode(switchPositionMode);
        System.out.println(switchModeResult);
    }
}
