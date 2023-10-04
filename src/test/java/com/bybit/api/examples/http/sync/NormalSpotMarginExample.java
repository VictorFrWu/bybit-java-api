package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.spot.marginTrade.SpotMarginTradeBorrowRequest;
import com.bybit.api.client.domain.spot.marginTrade.SpotMarginTradeRePayRequest;
import com.bybit.api.client.domain.spot.marginTrade.VIPMarginDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.BybitApiRestClient;

public class NormalSpotMarginExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("VUEODVICUIVUXIJJKO", "TWZAESUUJGROUJTAMRKLDDMHLPOXUHUEDBFZ");
        BybitApiRestClient client = factory.newRestClient();

        // Get VIP Margin Data
        var normalMarginDataRequest = new VIPMarginDataRequest.Builder().build();
        var normalMarginData = client.getNormalVipSpotMarginTradeData(normalMarginDataRequest);
        System.out.println(normalMarginData);

        // Get Margin Coin Info
        var normalMarginCoinInfo = client.getNormalSpotMarginTradeCoinInfo("ETH");
        System.out.println(normalMarginCoinInfo);

        // Get Borrowable Coin Info
        var normalBorrowCoinInfo = client.getNormalSpotMarginTradeBorrowCoinInfo("ETH");
        System.out.println(normalBorrowCoinInfo);

        // Get Interest & Quota
        var normalInteresetQuota = client.getNormalSpotMarginTradeInterestQuota("ETH");
        System.out.println(normalInteresetQuota);

        // Get Loan Account Info
        var normalSpotLoanAccountInfo = client.getNormalSpotMarginTradeAccountInfo();
        System.out.println(normalSpotLoanAccountInfo);

        // Toggle Margin Trade
        var normalSpotToggleMarginTrade = client.getNormalSpotToggleMarginTrade(1);
        System.out.println(normalSpotToggleMarginTrade);

        // Borrow
        var normalSpotBorrowRequest = new SpotMarginTradeBorrowRequest.Builder("ETH", "10").build();
        var normalSpotBorrowResult = client.loanNormalSpotMarginTrade(normalSpotBorrowRequest);
        System.out.println(normalSpotBorrowResult);

        // Repay
        var normalSpotRepayRequest = new SpotMarginTradeRePayRequest.Builder("ETH").completeRepayment(1).build();
        var normalSpotRepayResult = client.repayNormalSpotMarginTrade(normalSpotRepayRequest);
        System.out.println(normalSpotRepayResult);
    }
}
