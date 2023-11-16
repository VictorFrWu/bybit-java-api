package com.bybit.api.domain.market;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.response.openInterests.OpenInterestEntry;
import com.bybit.api.client.domain.market.response.openInterests.OpenInterestResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OpenInterestResultDeserializerTest {
    @Test
    public void testOpenInterestResultDeserializer()
    {
        final String openInterestResultJson = "{\n" +
                "    \"retCode\": 0,\n" +
                "    \"retMsg\": \"OK\",\n" +
                "    \"result\": {\n" +
                "        \"symbol\": \"SSVUSDT\",\n" +
                "        \"category\": \"linear\",\n" +
                "        \"list\": [\n" +
                "            {\n" +
                "                \"openInterest\": \"1181.05000000\",\n" +
                "                \"timestamp\": \"1699747200000\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"openInterest\": \"1180.41000000\",\n" +
                "                \"timestamp\": \"1699660800000\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"openInterest\": \"1274.26000000\",\n" +
                "                \"timestamp\": \"1699574400000\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"openInterest\": \"1554.97000000\",\n" +
                "                \"timestamp\": \"1699488000000\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"openInterest\": \"1531.25000000\",\n" +
                "                \"timestamp\": \"1699401600000\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"nextPageCursor\": \"lastid%3D78103121%26lasttime%3D1699401600\"\n" +
                "    },\n" +
                "    \"retExtInfo\": {},\n" +
                "    \"time\": 1699818357636\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            GenericResponse<OpenInterestResult> response = mapper.readValue(openInterestResultJson, new TypeReference<GenericResponse<OpenInterestResult>>() {
            });
            // You can now access the fields of the response
            assertEquals(response.getRetCode(), 0);
            assertEquals(response.getRetMsg(), "OK");
            // Accessing the fields of the result
            OpenInterestResult openInterestResult = response.getResult();
            assertEquals(openInterestResult.getCategory(), CategoryType.LINEAR.getCategoryTypeId());
            assertEquals(openInterestResult.getSymbol(), "SSVUSDT");

            List<OpenInterestEntry> entries = openInterestResult.getOpenInterestEntries();
            assertEquals(entries.size(), 5);
            assertEquals(entries.get(0).getOpenInterest(), "1181.05000000");
            assertEquals(entries.get(0).getTimestamp(), "1699747200000");
        }catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
}
