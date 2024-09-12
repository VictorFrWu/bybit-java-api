package com.bybit.api.domain.spot_margin;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.position.MovePositionStatus;
import com.bybit.api.client.domain.position.request.BatchMovePositionRequest;
import com.bybit.api.client.domain.position.request.MovePositionDetailsRequest;
import com.bybit.api.client.domain.position.request.PositionDataRequest;
import com.bybit.api.client.domain.trade.Side;
import com.bybit.api.client.restApi.BybitApiAssetRestClient;
import com.bybit.api.client.restApi.BybitApiPositionRestClient;
import com.bybit.api.client.restApi.BybitApiSpotMarginRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

import java.util.Arrays;

public class SpotMarginTradeTest {
    BybitApiSpotMarginRestClient client = BybitApiClientFactory.newInstance("xx", "xxx", BybitApiConfig.TESTNET_DOMAIN).newSpotMarginRestClient();

    @Test
    public void Test_MovePositions()
    {
        // Toggle Margin Trade
        var utaToggleMarginTradeResult = client.setUTASpotMarginTrade("0");
        System.out.println(utaToggleMarginTradeResult);

        // Set Leverage
        var utaLeverageResult = client.setUTASpotMarginTradeLeverage("2");
        System.out.println(utaLeverageResult);
    }
}
