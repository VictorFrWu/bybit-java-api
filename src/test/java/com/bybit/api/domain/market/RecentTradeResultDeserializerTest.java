package com.bybit.api.domain.market;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.response.recentTrade.RecentTradeEntry;
import com.bybit.api.client.domain.market.response.recentTrade.RecentTradeResult;
import com.bybit.api.client.domain.market.response.tickers.TickerEntry;
import com.bybit.api.client.domain.market.response.tickers.TickersResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RecentTradeResultDeserializerTest {
    @Test
    public void testRecentTradeResultDeserializer()
    {
        final String tradesResultJson = "{\n" +
                "    \"retCode\": 0,\n" +
                "    \"retMsg\": \"OK\",\n" +
                "    \"result\": {\n" +
                "        \"category\": \"spot\",\n" +
                "        \"list\": [\n" +
                "            {\n" +
                "                \"execId\": \"2110000000029412877\",\n" +
                "                \"symbol\": \"SOLUSDT\",\n" +
                "                \"price\": \"59.6001\",\n" +
                "                \"size\": \"0.85\",\n" +
                "                \"side\": \"Sell\",\n" +
                "                \"time\": \"1699782067852\",\n" +
                "                \"isBlockTrade\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"execId\": \"2110000000029412870\",\n" +
                "                \"symbol\": \"SOLUSDT\",\n" +
                "                \"price\": \"59.6216\",\n" +
                "                \"size\": \"0.57\",\n" +
                "                \"side\": \"Sell\",\n" +
                "                \"time\": \"1699782050312\",\n" +
                "                \"isBlockTrade\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"execId\": \"2110000000029412865\",\n" +
                "                \"symbol\": \"SOLUSDT\",\n" +
                "                \"price\": \"59.5813\",\n" +
                "                \"size\": \"0.3\",\n" +
                "                \"side\": \"Sell\",\n" +
                "                \"time\": \"1699782035987\",\n" +
                "                \"isBlockTrade\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"execId\": \"2110000000029412864\",\n" +
                "                \"symbol\": \"SOLUSDT\",\n" +
                "                \"price\": \"61.75\",\n" +
                "                \"size\": \"0.43\",\n" +
                "                \"side\": \"Sell\",\n" +
                "                \"time\": \"1699782035987\",\n" +
                "                \"isBlockTrade\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"execId\": \"2110000000029412861\",\n" +
                "                \"symbol\": \"SOLUSDT\",\n" +
                "                \"price\": \"61.75\",\n" +
                "                \"size\": \"0.61\",\n" +
                "                \"side\": \"Sell\",\n" +
                "                \"time\": \"1699782025973\",\n" +
                "                \"isBlockTrade\": false\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"retExtInfo\": {},\n" +
                "    \"time\": 1699817872798\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            GenericResponse<RecentTradeResult> response = mapper.readValue(tradesResultJson, new TypeReference<GenericResponse<RecentTradeResult>>() {
            });
            // You can now access the fields of the response
            assertEquals(response.getRetCode(), 0);
            assertEquals(response.getRetMsg(), "OK");
            // Accessing the fields of the result
            RecentTradeResult recentTradeResult = response.getResult();
            assertEquals(recentTradeResult.getCategory(), CategoryType.SPOT.getCategoryTypeId());
            assertEquals(recentTradeResult.getRecentTradeEntries().size(), 5);

            List<RecentTradeEntry> entries = recentTradeResult.getRecentTradeEntries();
            assertEquals(entries.get(0).getSymbol(), "SOLUSDT");
            assertEquals(entries.get(0).getIsBlockTrade(), false);
        }catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
}
