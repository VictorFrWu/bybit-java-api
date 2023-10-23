package com.bybit.api.examples.http.async;

import com.bybit.api.client.constant.Util;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.asset.AssetDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class AssetAsyncExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        var client = factory.newAsyncAssetRestClient();

        // Get Coin Exchange Records
        var coinExchangeRecordsRequest = AssetDataRequest.builder().build();
        client.getAssetCoinExchangeRecords(coinExchangeRecordsRequest, System.out::println);

        // Get Delivery Records
        var deliveryRecordsRequest = AssetDataRequest.builder().category(ProductType.LINEAR).build();
        client.getAssetDeliveryRecords(deliveryRecordsRequest, System.out::println);

        // Get USDC settlement
        var usdcSettlementRequest = AssetDataRequest.builder().category(ProductType.LINEAR).build();
        client.getAssetUSDCSettlementRecords(usdcSettlementRequest, System.out::println);

        // Get Asset Info
        var assetInfoRequest = AssetDataRequest.builder().accountType(AccountType.SPOT).build();
        client.getAssetInfo(assetInfoRequest, System.out::println);

        // Get All Coins Balance
        var allCoinsBalanceRequest = AssetDataRequest.builder().accountType(AccountType.UNIFIED).build();
        client.getAssetAllCoinsBalance(allCoinsBalanceRequest, System.out::println);

        // Get Single Coin Balance
        var SingleCoinBalanceRequest = AssetDataRequest.builder().accountType(AccountType.UNIFIED).coin("USDT").build();
        client.getAssetSingleCoinBalance(SingleCoinBalanceRequest, System.out::println);

        // Get Transferable Coin
        var transferableCoinsRequest = AssetDataRequest.builder().fromAccountType(AccountType.UNIFIED).toAccountType(AccountType.FUND).build();
        client.getAssetTransferableCoins(transferableCoinsRequest, System.out::println);

        // Get Sub Uids
        client.getAssetTransferSubUidList(System.out::println);

        // Create Internal Transfer
        var assetInternalTransferRequest = AssetDataRequest.builder()
                .transferId(Util.generateTransferID())
                .coin("USDT")
                .amount("100")
                .fromAccountType(AccountType.UNIFIED)
                .toAccountType(AccountType.FUND)
                .build();
        client.createAssetInternalTransfer(assetInternalTransferRequest, System.out::println);

        // Create Universal Transfer
        var assetUniversalTransferRequest = AssetDataRequest.builder()
                .transferId(Util.generateTransferID())
                .coin("USDT")
                .amount("100")
                .fromMemberId(1553904)
                .toMemberId(1635703)
                .fromAccountType(AccountType.UNIFIED)
                .toAccountType(AccountType.FUND)
                .build();
        client.createAssetUniversalTransfer(assetUniversalTransferRequest, System.out::println);

        // Get Allowed Deposit Coin Info
        var allowedDepositCoinRequest = AssetDataRequest.builder().build();
        client.getAssetAllowedDepositCoinInfo(allowedDepositCoinRequest, System.out::println);

        // Set Deposit Account
        var setDepositAccountRequest = AssetDataRequest.builder().accountType(AccountType.FUND).build();
        client.setAssetDepositAccount(setDepositAccountRequest, System.out::println);

        var depositRecordsRequest = AssetDataRequest.builder();
        // Get Deposit Records (on-chain)
        client.getAssetDepositRecords(depositRecordsRequest.build(), System.out::println);

        // Get Sub Deposit Records (on-chain)
        client.getAssetSubMembersDepositRecords(depositRecordsRequest.subMemberId("1637192").build(), System.out::println);

        // Get Internal Deposit Records (off-chain)
        client.getAssetInternalDepositRecords(depositRecordsRequest.build(), System.out::println);

        // Get Internal Transfer Records
        var internalTransferRequest = AssetDataRequest.builder().build();
        client.getAssetInternalTransferRecords(internalTransferRequest, System.out::println);

        // Get Universal Transfer Records
        var universalTransferRequest = AssetDataRequest.builder().build();
        client.getAssetUniversalTransferRecords(universalTransferRequest, System.out::println);

        // Get Master Deposit Address
        var masterDepositRequest = AssetDataRequest.builder().coin("USDT").build();
        client.getAssetMasterDepositAddress(masterDepositRequest, System.out::println);

        // Get Sub Deposit Address
        var subDepositRequest = AssetDataRequest.builder().coin("USDT").chainType("TRC20").subMemberId("1637192").build();
        client.getAssetSubMemberDepositAddress(subDepositRequest, System.out::println);

        // Get coin info
        var coinInfoRequest = AssetDataRequest.builder().coin("ETH").build();
        client.getAssetCoinInfo(coinInfoRequest, System.out::println);

        // Get Withdrawable Amount
        var withdrawAmountRequest = AssetDataRequest.builder().coin("USDT").build();
        client.getAssetWithdrawalAmount(withdrawAmountRequest, System.out::println);

        // Get Withdraw Records
        var assetWithdrawRecordsRequest = AssetDataRequest.builder().build();
        client.getAssetWithdrawalRecords(assetWithdrawRecordsRequest, System.out::println);

        // Withdraw
        var assetWithdrawRequest = AssetDataRequest.builder()
                .coin("USDT")
                .chain("ETH")
                .address("0xSampleWalletAddress")
                .amount("100")
                .timestamp(Util.generateTimestamp())
                .build();
        client.createAssetWithdraw(assetWithdrawRequest, System.out::println);

        // Cancel Withdraw
        var assetWithdrawCancelRequest = AssetDataRequest.builder().withdrawID("xxxxx").build();
        client.cancelAssetWithdraw(assetWithdrawCancelRequest, System.out::println);
    }
}
