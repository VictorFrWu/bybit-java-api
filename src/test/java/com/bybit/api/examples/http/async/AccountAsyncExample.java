package com.bybit.api.examples.http.async;

import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.service.BybitApiClientFactory;

public class AccountAsyncExample {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET").newAsyncAccountRestClient();

        // Get wallet balance
        var walletBalanceRequest = AccountDataRequest.builder().accountType(AccountType.UNIFIED).build();
        client.getWalletBalance(walletBalanceRequest, System.out::println);

        // Upgrade to uta
        client.upgradeAccountToUTA(System.out::println);

        // Get Borrow History
        var accountBorrowHistoryRequest = AccountDataRequest.builder().build();
        client.getAccountBorrowHistory(accountBorrowHistoryRequest, System.out::println);

        // Get Account info
        client.getAccountInfo(System.out::println);

        // Get Coin Geek
        var coinGeekRequest = AccountDataRequest.builder().baseCoin("BTC").build();
        client.getAccountCoinGeeks(coinGeekRequest, System.out::println);

        // Get Transaction Log
        var transactionLogRequest = AccountDataRequest.builder().build();
        client.getTransactionLog(transactionLogRequest, System.out::println);
    }
}
