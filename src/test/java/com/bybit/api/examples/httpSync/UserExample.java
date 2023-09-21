package com.bybit.api.examples.httpSync;

import com.bybit.api.client.domain.user.request.ApiKeyRequest;
import com.bybit.api.client.domain.user.request.FreezeSubUIDRquest;
import com.bybit.api.client.domain.user.request.SubUserRequest;
import com.bybit.api.client.impl.BybitApiClientFactory;
import com.bybit.api.client.BybitApiRestClient;

import java.util.Map;
import java.util.List;

public class UserExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiRestClient client = factory.newRestClient();

        // Get API Key Information
        var apikeyInfo = client.getCurrentAPIKeyInfo();
        System.out.println(apikeyInfo);

        // Get sub UID list
        var subUidsInfo = client.getSubUIDList();
        System.out.println(subUidsInfo);

        // Create a new api key
        Map<String, List<String>> permissionMap = Map.of(
                "ContractTrade", List.of("Order", "Position"),
                "Spot", List.of("SpotTrade"),
                "Wallet", List.of("AccountTransfer"),
                "Options", List.of("OptionsTrade"),
                "Derivatives", List.of("DerivativesTrade"),
                "Exchange", List.of("ExchangeHistory"),
                "CopyTrading", List.of("CopyTrading"),
                "BlockTrade", List.of("BlockTrade"),
                "NFT", List.of("NFTQueryProductList")
        );
        ApiKeyRequest.Permissions permissions = new ApiKeyRequest.Permissions(permissionMap);
        ApiKeyRequest apiKeyRequest = new ApiKeyRequest.Builder(1234561,1,permissions)
                .ips(List.of("*"))
                .note("Some note")
                .build();
        var subAPIKey = client.createSubAPI(apiKeyRequest);
        System.out.println(subAPIKey);

        // create a new sub user
        SubUserRequest subUserRequest = new SubUserRequest.Builder("TestUsser123", 1)
                .password("Password123!")
                .switchOption(0)
                .isUta(false)
                .note("Some note")
                .build();
        var subUser = client.createSubMember(subUserRequest);
        System.out.println(subUser);

        // freeze a sub uid
        FreezeSubUIDRquest freezeSubUIDRquest = new FreezeSubUIDRquest(100312034, 1);
        var freezeResponse = client.freezeSubMember(freezeSubUIDRquest);
        System.out.println(freezeResponse);

        // get UID wallet type
        var uidWalletType = client.getUIDWalletType();
        System.out.println(uidWalletType);

        // get affiliate User info
        var affiliateInfo = client.getAffiliateUserInfo("100312034");
        System.out.println(affiliateInfo);
    }
}
