package com.bybit.api.examples.http.async;

import com.bybit.api.client.BybitApiRestClient;
import com.bybit.api.client.domain.account.AccountDataRequest;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.service.BybitApiClientFactory;

public class AccountAsyncExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        var client = factory.newAsyncRestClient();

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
