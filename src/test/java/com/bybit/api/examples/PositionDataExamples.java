package com.bybit.api.examples;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.position.request.PositionListRequest;
import com.bybit.api.client.domain.position.request.SetLeverageRequest;
import com.bybit.api.client.impl.BybitApiClientFactory;
import com.bybit.api.client.impl.BybitApiRestClient;

public class PositionDataExamples {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiRestClient client = factory.newRestClient();

        var positionListRequest = new PositionListRequest.Builder(ProductType.LINEAR)
                .symbol("BTCUSDT")
                .build();
        var positionListData = client.getPositionInfo(positionListRequest);
        System.out.println(positionListData);

        var setLeverageRequest = new SetLeverageRequest.Builder("linear", "BTCUSDT", "2", "2").build();
        var setPositionLeverageResult = client.setPositionLeverage(setLeverageRequest);
        System.out.println(setPositionLeverageResult);
    }
}
