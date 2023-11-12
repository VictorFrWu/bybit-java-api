package com.bybit.api.domain.asset;

import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.asset.AssetDataRequest;
import com.bybit.api.client.restApi.BybitApiAssetRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

public class AccountTransferTest {
    BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
    BybitApiAssetRestClient client = factory.newAssetRestClient();
    @Test
    public void Test_AssetTransferMasterToSubClassical()
    {
        var universalTransferRequest = AssetDataRequest.builder().coin("USDT").amount("10").fromMemberId(1553904).toMemberId(100366706).fromAccountType(AccountType.FUND).toAccountType(AccountType.SPOT).build();
        var universalTransfer = client.createAssetUniversalTransfer(universalTransferRequest);
        System.out.println(universalTransfer);
    }

    @Test
    public void Test_AssetTransferMasterToSubCustodian()
    {
        var universalTransferRequest = AssetDataRequest.builder().coin("USDT").amount("14").fromMemberId(1553904).toMemberId(100402546).fromAccountType(AccountType.FUND).toAccountType(AccountType.SPOT).build();
        var universalTransfer = client.createAssetUniversalTransfer(universalTransferRequest);
        System.out.println(universalTransfer);
    }
}
