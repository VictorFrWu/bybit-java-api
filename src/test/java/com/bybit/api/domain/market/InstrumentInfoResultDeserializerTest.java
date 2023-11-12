package com.bybit.api.domain.market;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.response.instrumentInfo.InstrumentEntry;
import com.bybit.api.client.domain.market.response.instrumentInfo.InstrumentInfoResult;
import com.bybit.api.client.domain.market.response.instrumentInfo.LeverageFilter;
import com.bybit.api.client.domain.market.response.instrumentInfo.LotSizeFilter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class InstrumentInfoResultDeserializerTest {
    @Test
    public void testFutureInstrumentResultDeserializer()
    {
        final String futureJsonString = "{\n" +
                "    \"retCode\": 0,\n" +
                "    \"retMsg\": \"OK\",\n" +
                "    \"result\": {\n" +
                "        \"category\": \"linear\",\n" +
                "        \"list\": [\n" +
                "            {\n" +
                "                \"symbol\": \"BTCUSDT\",\n" +
                "                \"contractType\": \"LinearPerpetual\",\n" +
                "                \"status\": \"Trading\",\n" +
                "                \"baseCoin\": \"BTC\",\n" +
                "                \"quoteCoin\": \"USDT\",\n" +
                "                \"launchTime\": \"1585526400000\",\n" +
                "                \"deliveryTime\": \"0\",\n" +
                "                \"deliveryFeeRate\": \"\",\n" +
                "                \"priceScale\": \"2\",\n" +
                "                \"leverageFilter\": {\n" +
                "                    \"minLeverage\": \"1\",\n" +
                "                    \"maxLeverage\": \"100.00\",\n" +
                "                    \"leverageStep\": \"0.01\"\n" +
                "                },\n" +
                "                \"priceFilter\": {\n" +
                "                    \"minPrice\": \"0.10\",\n" +
                "                    \"maxPrice\": \"199999.80\",\n" +
                "                    \"tickSize\": \"0.10\"\n" +
                "                },\n" +
                "                \"lotSizeFilter\": {\n" +
                "                    \"maxOrderQty\": \"100.000\",\n" +
                "                    \"minOrderQty\": \"0.001\",\n" +
                "                    \"qtyStep\": \"0.001\",\n" +
                "                    \"postOnlyMaxOrderQty\": \"1000.000\"\n" +
                "                },\n" +
                "                \"unifiedMarginTrade\": true,\n" +
                "                \"fundingInterval\": 480,\n" +
                "                \"settleCoin\": \"USDT\",\n" +
                "                \"copyTrading\": \"both\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"nextPageCursor\": \"\"\n" +
                "    },\n" +
                "    \"retExtInfo\": {},\n" +
                "    \"time\": 1699807388622\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            GenericResponse<InstrumentInfoResult> response = mapper.readValue(futureJsonString, new TypeReference<GenericResponse<InstrumentInfoResult>>() {});
            // You can now access the fields of the response
            assertEquals(response.getRetCode(), 0);
            assertEquals(response.getRetMsg(), "OK");
            // Accessing the fields of the result
            assertEquals(response.getResult().getCategory(), "linear");
            InstrumentEntry futureInstrumentResult = response.getResult().getInstrumentEntries().get(0);
            assertEquals(futureInstrumentResult.getSymbol(), "BTCUSDT");
            assertEquals(futureInstrumentResult.getStatus(), "Trading");
            assertEquals(futureInstrumentResult.getFundingInterval().intValue(), 480);

            LeverageFilter futureLeverageFilter= futureInstrumentResult.getLeverageFilter();
            assertEquals(futureLeverageFilter.getMinLeverage(), "1");
            assertEquals(futureLeverageFilter.getLeverageStep(), "0.01");

            LotSizeFilter futureLotSizeFilter = futureInstrumentResult.getLotSizeFilter();
            assertEquals(futureLotSizeFilter.getPostOnlyMaxOrderQty(), "1000.000");
        }catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
}
