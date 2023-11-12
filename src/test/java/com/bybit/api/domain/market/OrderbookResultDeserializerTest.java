package com.bybit.api.domain.market;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.response.orderbook.OrderbookBidEntry;
import com.bybit.api.client.domain.market.response.orderbook.OrderbookResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OrderbookResultDeserializerTest {
    @Test
    public void testOrderbookResultDeserializer()
    {
        final String orderbookResultJson = "{\n" +
                "    \"retCode\": 0,\n" +
                "    \"retMsg\": \"OK\",\n" +
                "    \"result\": {\n" +
                "        \"s\": \"BTCUSDT\",\n" +
                "        \"b\": [\n" +
                "            [\n" +
                "                \"37202.8\",\n" +
                "                \"95.091\"\n" +
                "            ],\n" +
                "            [\n" +
                "                \"37202.6\",\n" +
                "                \"176.891\"\n" +
                "            ],\n" +
                "            [\n" +
                "                \"37202.4\",\n" +
                "                \"158.376\"\n" +
                "            ],\n" +
                "            [\n" +
                "                \"37202.2\",\n" +
                "                \"110.382\"\n" +
                "            ],\n" +
                "            [\n" +
                "                \"37202\",\n" +
                "                \"173.777\"\n" +
                "            ]\n" +
                "        ],\n" +
                "        \"a\": [\n" +
                "            [\n" +
                "                \"37208.2\",\n" +
                "                \"110.033\"\n" +
                "            ],\n" +
                "            [\n" +
                "                \"37208.4\",\n" +
                "                \"174.123\"\n" +
                "            ],\n" +
                "            [\n" +
                "                \"37208.6\",\n" +
                "                \"176.461\"\n" +
                "            ],\n" +
                "            [\n" +
                "                \"37208.8\",\n" +
                "                \"190.986\"\n" +
                "            ],\n" +
                "            [\n" +
                "                \"37209\",\n" +
                "                \"174.425\"\n" +
                "            ]\n" +
                "        ],\n" +
                "        \"ts\": 1699804424320,\n" +
                "        \"u\": 1135826\n" +
                "    },\n" +
                "    \"retExtInfo\": {},\n" +
                "    \"time\": 1699804424370\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            GenericResponse<OrderbookResult> response = mapper.readValue(orderbookResultJson, mapper.getTypeFactory().constructParametricType(GenericResponse.class, OrderbookResult.class));
            // You can now access the fields of the response
            assertEquals(response.getRetCode(), 0);
            assertEquals(response.getRetMsg(), "OK");
            // Accessing the fields of the result
            OrderbookResult orderbookResult = response.getResult();
            assertEquals(orderbookResult.getSymbol(), "BTCUSDT");
            List<OrderbookBidEntry> entries = orderbookResult.getOrderbookBidEntries();
            assertEquals(entries.size(), 5);
            assertEquals(entries.get(0).getBidPrice(), "37202.8");
            assertEquals(entries.get(0).getBidSize(), "95.091");
        }catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
}
