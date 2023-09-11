package com.bybit.api.examples;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.account.request.BorrowHistoryRequest;
import com.bybit.api.client.domain.account.request.GetTransactionLogRequest;
import com.bybit.api.client.domain.account.request.WalletBalanceRequest;
import com.bybit.api.client.domain.position.request.TradingStopRequest;
import com.bybit.api.client.impl.BybitApiClientFactory;
import com.bybit.api.client.impl.BybitApiRestClient;

public class AccountExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("8wYkmpLsMg10eNQyPm", "Ouxc34myDnXvei54XsBZgoQzfGxO4bkr2Zsj");
        BybitApiRestClient client = factory.newRestClient();

        // Get wallet balance
        var walletBalanceRequest = new WalletBalanceRequest.Builder(AccountType.UNIFIED).build();
        var walletBalanceData = client.getWalletBalance(walletBalanceRequest);
        System.out.println(walletBalanceData);

        // Upgrade to uta
        var upgradeToUTAResult = client.upgradeAccountToUTA();
        System.out.println(upgradeToUTAResult);

        // Get Borrow History
        var accountBorrowHistoryRequest = new BorrowHistoryRequest.Builder().build();
        var accountBorrowData = client.getAccountBorrowHistory(accountBorrowHistoryRequest);
        System.out.println(accountBorrowData);

        // Get Account info
        var accountInfo = client.getAccountInfo();
        System.out.println(accountInfo);

        // Get Coin Geek
        var coinGeeks = client.getAccountCoinGeeks();
        System.out.println(coinGeeks);

        // Get Transaction Log
        var transactionLogRequest = new GetTransactionLogRequest.Builder().build();
        var transactionLogData = client.getTransactionLog(transactionLogRequest);
        System.out.println(transactionLogData);

    }
}
