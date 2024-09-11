package com.bybit.api.domain.asset;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.asset.request.AssetDataRequest;
import com.bybit.api.client.restApi.BybitApiAssetRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;
public class ConvertCoinTest {
    BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN);
    BybitApiAssetRestClient client = factory.newAssetRestClient();

    @Test
    public void Test_RequestQuote() {
        var requestQuoteRequest = AssetDataRequest.builder().fromCoin("BTC").toCoin("ETH").accountType(AccountType.CONVERT_UTA).requestCoin("BTC").requestAmount("0.1")
                .paramType("opFrom").paramValue("broker-id-001").build();
        var requestQuoteResponse = client.requestQuote(requestQuoteRequest);
        System.out.println(requestQuoteResponse);
    }

    @Test
    public void Test_ConfirmQuote() {
        var confirmQuoteResponse = client.confirmQuote("10102225215434451987621355520");
        System.out.println(confirmQuoteResponse);
    }

    @Test
    public void Test_ConfirmQuoteByClass() {
        var confirmQuoteRequest = AssetDataRequest.builder().quoteTxId("10102225215434451987621355520").build();
        var confirmQuoteResponse = client.confirmQuote(confirmQuoteRequest);
        System.out.println(confirmQuoteResponse);
    }

    @Test
    public void Test_GetConvertCoinList() {
        var requestConvertCoinListRequest = AssetDataRequest.builder().accountType(AccountType.CONVERT_UTA).build();
        var convertCoinList = client.getConvertCoinList(requestConvertCoinListRequest);
        System.out.println(convertCoinList);
    }

    @Test
    public void Test_GetConvertCoinStatus() {
        var requestConvertCoinStatusRequest = AssetDataRequest.builder().accountType(AccountType.CONVERT_UTA).quoteTxId("1010231249434449484123181056").build();
        var convertCoinStatus = client.getConvertCoinStatus(requestConvertCoinStatusRequest);
        System.out.println(convertCoinStatus);
    }

    @Test
    public void Test_GetConvertCoinHistory() {
        var requestConvertCoinHistoryRequest = AssetDataRequest.builder().accountType(AccountType.CONVERT_UTA).quoteTxId("1010231249434449484123181056").build();
        var convertCoinHistory = client.getConvertCoinHistory(requestConvertCoinHistoryRequest);
        System.out.println(convertCoinHistory);
    }
}
