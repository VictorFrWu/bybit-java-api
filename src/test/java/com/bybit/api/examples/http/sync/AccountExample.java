package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.account.AccountDataRequest;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.account.request.BorrowHistoryRequest;
import com.bybit.api.client.domain.account.request.GetTransactionLogRequest;
import com.bybit.api.client.domain.account.request.WalletBalanceRequest;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.BybitApiRestClient;

public class AccountExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        var client = factory.newAccountRestClient();

        // Get wallet balance
        var walletBalanceRequest = AccountDataRequest.builder().accountType(AccountType.UNIFIED).build();
        var walletBalanceData = client.getWalletBalance(walletBalanceRequest);
        System.out.println(walletBalanceData);

        // Upgrade to uta
        var upgradeToUTAResult = client.upgradeAccountToUTA();
        System.out.println(upgradeToUTAResult);

        // Get Borrow History
        var accountBorrowHistoryRequest = AccountDataRequest.builder().build();
        var accountBorrowData = client.getAccountBorrowHistory(accountBorrowHistoryRequest);
        System.out.println(accountBorrowData);

        // Get Account info
        var accountInfo = client.getAccountInfo();
        System.out.println(accountInfo);

        // Get Coin Geek
        var coinGeekRequest = AccountDataRequest.builder().baseCoin("BTC").build();
        var coinGeeks = client.getAccountCoinGeeks(coinGeekRequest);
        System.out.println(coinGeeks);

        // Get Transaction Log
        var transactionLogRequest = AccountDataRequest.builder().build();
        var transactionLogData = client.getTransactionLog(transactionLogRequest);
        System.out.println(transactionLogData);

    }
}
