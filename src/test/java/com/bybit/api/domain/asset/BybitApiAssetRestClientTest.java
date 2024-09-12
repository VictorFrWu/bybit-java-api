package com.bybit.api.domain.asset;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.asset.request.AssetDataRequest;
import com.bybit.api.client.impl.BybitApiAssetRestClientImpl;
import com.bybit.api.client.restApi.BybitApiService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BybitApiAssetRestClientTest {

    private BybitApiAssetRestClientImpl client; // Use the implementation class directly
    private BybitApiService bybitApiService; // Mock the BybitApiService

    @Before
    public void setUp() {
        bybitApiService = Mockito.mock(BybitApiService.class); // Create a mock instance of BybitApiService
        client = new BybitApiAssetRestClientImpl(bybitApiService); // Pass the mock to the constructor
    }

    @Test
    public void testRequestQuote_Success() throws IOException {
        // Arrange
        AssetDataRequest request = AssetDataRequest.builder()
                .fromCoin("BTC")
                .toCoin("ETH")
                .accountType(AccountType.CONVERT_UTA)
                .requestCoin("BTC")
                .requestAmount("0.1")
                .build();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("retCode", 0);
        responseMap.put("retMsg", "ok");
        responseMap.put("result", Map.of(
                "quoteTxId", "1010231249434446672291139584",
                "exchangeRate", "23.811831232157220000",
                "fromCoin", "BTC",
                "toCoin", "ETH",
                "fromAmount", "0.1",
                "toAmount", "2.381183123215722000",
                "expiredTime", 1726056973334L
        ));
        responseMap.put("time", 1726056958360L);

        Call<Object> mockedCall = (Call<Object>) mock(Call.class);
        Response<Object> mockedResponse;
        mockedResponse = Response.success(responseMap);

        when(mockedCall.execute()).thenReturn(mockedResponse);
        when(bybitApiService.requestQuote(any())).thenReturn(mockedCall);

        // Act
        Object result = client.requestQuote(request);

        // Convert the result as needed to inspect deeper
        Map<String, Object> resultMap = (Map<String, Object>) result;
        Map<String, Object> resultDetails = (Map<String, Object>) resultMap.get("result");

        // Assert
        assertNotNull(result);
        assertEquals(0, resultMap.get("retCode"));
        assertEquals("ok", resultMap.get("retMsg"));
        assertEquals("1010231249434446672291139584", resultDetails.get("quoteTxId"));
    }
}
