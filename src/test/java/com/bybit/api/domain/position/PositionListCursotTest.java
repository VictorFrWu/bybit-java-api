package com.bybit.api.domain.position;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.position.request.PositionDataRequest;
import com.bybit.api.client.restApi.BybitApiPositionRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

public class PositionListCursotTest {
    BybitApiPositionRestClient client = BybitApiClientFactory.newInstance("d08Wh6P037IXAvcrL2", "gLfd1BLGU9oq6YoRZRlwXkIQRYB4n5KvXDvv", BybitApiConfig.TESTNET_DOMAIN).newPositionRestClient();
    @Test
    public void Test_SwitchPositionMode()
    {
        var positionDataRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("XRPUSDT").cursor("XRPUSDT%2C1709884800016%2C0").limit(1).build();
        var switchModeResult = client.getPositionInfo(positionDataRequest);
        System.out.println(switchModeResult);
    }
}
