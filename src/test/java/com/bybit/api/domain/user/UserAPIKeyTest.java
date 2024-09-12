package com.bybit.api.domain.user;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.user.*;
import com.bybit.api.client.restApi.BybitApiUserRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

public class UserAPIKeyTest {
    BybitApiUserRestClient client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newUserRestClient();

    @Test
    public void Test_GetSubUsersInfo(){
        System.out.println(client.getSubUIDList());
    }

    @Test
    public void Test_GetSubUsersInfoUnlimited(){
        var subUserRequest = UserDataRequest.builder().pageSize("100")
                .build();
        System.out.println(client.getSubUIDListUnlimited(subUserRequest));
    }

    @Test
    public void Test_GetSubUsersInfoUnlimitedNoParams(){
        System.out.println(client.getSubUIDListUnlimited());
    }

    @Test
    public void Test_GetSubAccAllAPIKeyInfo() {
        var subUserRequest = UserDataRequest.builder().subMemberId("101583835")
                .build();
        var subAccAllAPIKeyInfo = client.getSubAccAllAPIKeyInfo(subUserRequest);
        System.out.println(subAccAllAPIKeyInfo);
    }
}
