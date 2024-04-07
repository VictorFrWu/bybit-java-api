package com.bybit.api.examples.http.sync;

import com.bybit.api.client.constant.Helper;
import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.asset.request.AssetDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class AssetExample {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET").newAssetRestClient();

        // Get Coin Exchange Records
        var coinExchangeRecordsRequest = AssetDataRequest.builder().build();
        var coinExchangeRecords = client.getAssetCoinExchangeRecords(coinExchangeRecordsRequest);
        System.out.println(coinExchangeRecords);

        // Get Delivery Records
        var deliveryRecordsRequest = AssetDataRequest.builder().category(CategoryType.LINEAR).build();
        var deliveryRecords = client.getAssetDeliveryRecords(deliveryRecordsRequest);
        System.out.println(deliveryRecords);

        // Get USDC settlement
        var usdcSettlementRequest = AssetDataRequest.builder().category(CategoryType.LINEAR).build();
        var usdcSettlement = client.getAssetUSDCSettlementRecords(usdcSettlementRequest);
        System.out.println(usdcSettlement);

        // Get Asset Info
        var assetInfoRequest = AssetDataRequest.builder().accountType(AccountType.SPOT).build();
        var assetInfo = client.getAssetInfo(assetInfoRequest);
        System.out.println(assetInfo);

        // Get All Coins Balance
        var allCoinsBalanceRequest = AssetDataRequest.builder().accountType(AccountType.UNIFIED).build();
        var allCoinsBalance = client.getAssetAllCoinsBalance(allCoinsBalanceRequest);
        System.out.println(allCoinsBalance);

        // Get Single Coin Balance
        var SingleCoinBalanceRequest = AssetDataRequest.builder().accountType(AccountType.UNIFIED).coin("USDT").build();
        var SingleCoinBalance = client.getAssetSingleCoinBalance(SingleCoinBalanceRequest);
        System.out.println(SingleCoinBalance);

        // Get Transferable Coin
        var transferableCoinsRequest = AssetDataRequest.builder().fromAccountType(AccountType.UNIFIED).toAccountType(AccountType.FUND).build();
        var transferableCoins = client.getAssetTransferableCoins(transferableCoinsRequest);
        System.out.println(transferableCoins);

        // Get Sub Uids
        var assetSubUids = client.getAssetTransferSubUidList();
        System.out.println(assetSubUids);

        // Create Internal Transfer
        var assetInternalTransferRequest = AssetDataRequest.builder()
                .transferId(Helper.generateTransferID())
                .coin("USDT")
                .amount("100")
                .fromAccountType(AccountType.UNIFIED)
                .toAccountType(AccountType.FUND)
                .build();
        var internalTransfer = client.createAssetInternalTransfer(assetInternalTransferRequest);
        System.out.println(internalTransfer);

        // Create Universal Transfer
        var assetUniversalTransferRequest = AssetDataRequest.builder()
                .transferId(Helper.generateTransferID())
                .coin("USDT")
                .amount("100")
                .fromMemberId(1553904)
                .toMemberId(1635703)
                .fromAccountType(AccountType.UNIFIED)
                .toAccountType(AccountType.FUND)
                .build();
        var universalTransfer = client.createAssetUniversalTransfer(assetUniversalTransferRequest);
        System.out.println(universalTransfer);

        // Get Allowed Deposit Coin Info
        var allowedDepositCoinRequest = AssetDataRequest.builder().build();
        var allowedDepositCoinInfo = client.getAssetAllowedDepositCoinInfo(allowedDepositCoinRequest);
        System.out.println(allowedDepositCoinInfo);

        // Set Deposit Account
        var setDepositAccountRequest = AssetDataRequest.builder().accountType(AccountType.FUND).build();
        var setDepositAccount = client.setAssetDepositAccount(setDepositAccountRequest);
        System.out.println(setDepositAccount);

        var depositRecordsRequest = AssetDataRequest.builder();
        // Get Deposit Records (on-chain)
        var depositRecordsOnChain = client.getAssetDepositRecords(depositRecordsRequest.build());
        System.out.println(depositRecordsOnChain);

        // Get Sub Deposit Records (on-chain)
        var depositSubRecordsOnChain = client.getAssetSubMembersDepositRecords(depositRecordsRequest.subMemberId("1637192").build());
        System.out.println(depositSubRecordsOnChain);

        // Get Internal Deposit Records (off-chain)
        var internalDepositRecords = client.getAssetInternalDepositRecords(depositRecordsRequest.build());
        System.out.println(internalDepositRecords);

        // Get Internal Transfer Records
        var internalTransferRequest = AssetDataRequest.builder().build();
        var internalTransferRecords = client.getAssetInternalTransferRecords(internalTransferRequest);
        System.out.println(internalTransferRecords);

        // Get Universal Transfer Records
        var universalTransferRequest = AssetDataRequest.builder().build();
        var universalTransferRecords = client.getAssetUniversalTransferRecords(universalTransferRequest);
        System.out.println(universalTransferRecords);

        // Get Master Deposit Address
        var masterDepositRequest = AssetDataRequest.builder().coin("USDT").build();
        var masterDeposit = client.getAssetMasterDepositAddress(masterDepositRequest);
        System.out.println(masterDeposit);

        // Get Sub Deposit Address
        var subDepositRequest = AssetDataRequest.builder().coin("USDT").chainType("TRC20").subMemberId("1637192").build();
        var subDeposit = client.getAssetSubMemberDepositAddress(subDepositRequest);
        System.out.println(subDeposit);

        // Get coin info
        var coinInfoRequest = AssetDataRequest.builder().coin("ETH").build();
        var coinInfo = client.getAssetCoinInfo(coinInfoRequest);
        System.out.println(coinInfo);

        // Get Withdrawal Amount
        var withdrawAmountRequest =AssetDataRequest.builder().coin("USDT").build();
        var withdrawalAmount = client.getAssetWithdrawalAmount(withdrawAmountRequest);
        System.out.println(withdrawalAmount);

        // Get Withdraw Records
        var assetWithdrawRecordsRequest = AssetDataRequest.builder().build();
        var withdrawRecords = client.getAssetWithdrawalRecords(assetWithdrawRecordsRequest);
        System.out.println(withdrawRecords);

        // Withdraw
        var assetWithdrawRequest = AssetDataRequest.builder()
                .coin("USDT")
                .chain("ETH")
                .address("0xSampleWalletAddress")
                .amount("100")
                .timestamp(Helper.generateTimestamp())
                .build();
        var assetWithdraw = client.createAssetWithdraw(assetWithdrawRequest);
        System.out.println(assetWithdraw);

        // Cancel Withdraw
        var assetWithdrawCancelRequest = AssetDataRequest.builder().withdrawID("xxxxx").build();
        var cancelWithdraw = client.cancelAssetWithdraw(assetWithdrawCancelRequest);
        System.out.println(cancelWithdraw);
    }
}
