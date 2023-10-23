package com.bybit.api.examples.http.async;

import com.bybit.api.client.BybitApiRestClient;
import com.bybit.api.client.domain.user.*;
import com.bybit.api.client.service.BybitApiClientFactory;

import java.util.List;
import java.util.Map;

public class UserAsyncExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        var client = factory.newAsyncUserRestClient();

        // create a new sub user
        var subUserRequest = UserDataRequest.builder().username("VictorWuTest3")
                .password("Password123")
                .memberType(MemberType.NORMAL_SUB_ACCOUNT)
                .note("Some note")
                .switchOption(SwitchOption.TURN_OFF)
                .isUta(IsUta.CLASSIC_ACCOUNT)
                .build();
        client.createSubMember(subUserRequest, System.out::println);

        // Get API Key Information
        client.getCurrentAPIKeyInfo(System.out::println);

        // Get sub UID list
        client.getSubUIDList(System.out::println);

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
        UserPermissionsMap permissions = UserPermissionsMap.builder().permissionMap(permissionMap).build();
        UserDataRequest createApiKeyRequest = UserDataRequest.builder().subuid(1637192).readOnlyStatus(ReadOnlyStatus.READ_AND_WRITE).userPermissionsMap(permissions)
                .ips(List.of("*"))
                .note("Some note")
                .build();
        client.createSubAPI(createApiKeyRequest, System.out::println);

        // freeze a sub uid
        UserDataRequest freezeSubUIDRequest = UserDataRequest.builder().subuid(1553904).frozenStatus(FrozenStatus.UNFREEZE).build();
        client.freezeSubMember(freezeSubUIDRequest, System.out::println);

        // get UID wallet type
        UserDataRequest uidWallet = UserDataRequest.builder().build();
        client.getUIDWalletType(uidWallet, System.out::println);

        // get affiliate User info
        UserDataRequest affiliateRequest = UserDataRequest.builder().uid("1553904").build();
       client.getAffiliateUserInfo(affiliateRequest, System.out::println);
    }
}
