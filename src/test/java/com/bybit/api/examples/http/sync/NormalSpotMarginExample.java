package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.spot.CompleteRepayment;
import com.bybit.api.client.domain.spot.SpotMarginDataRequest;
import com.bybit.api.client.domain.spot.SwitchStatus;
import com.bybit.api.client.service.BybitApiClientFactory;

public class NormalSpotMarginExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        var client = factory.newSpotMarginRestClient();

        // Get VIP Margin Data
        var normalMarginDataRequest = SpotMarginDataRequest.builder().build();
        var normalMarginData = client.getNormalVipSpotMarginTradeData(normalMarginDataRequest);
        System.out.println(normalMarginData);

        // Get Margin Coin Info
        var marginCoinInfo = SpotMarginDataRequest.builder().coin("ETH").build();
        var normalMarginCoinInfo = client.getNormalSpotMarginTradeCoinInfo(marginCoinInfo);
        System.out.println(normalMarginCoinInfo);

        // Get Borrowable Coin Info
        var normalBorrowCoinInfo = client.getNormalSpotMarginTradeBorrowCoinInfo(marginCoinInfo);
        System.out.println(normalBorrowCoinInfo);

        // Get Interest and Quota
        var normalInterestQuota = client.getNormalSpotMarginTradeInterestQuota(marginCoinInfo);
        System.out.println(normalInterestQuota);

        // Get Loan Account Info
        var normalSpotLoanAccountInfo = client.getNormalSpotMarginTradeAccountInfo();
        System.out.println(normalSpotLoanAccountInfo);

        // Toggle Margin Trade
        var setToogleMarginRequest = SpotMarginDataRequest.builder().switchStatus(SwitchStatus.ON).build();
        var normalSpotToggleMarginTrade = client.setNormalSpotToggleMarginTrade(setToogleMarginRequest);
        System.out.println(normalSpotToggleMarginTrade);

        // Borrow
        var normalSpotBorrowRequest = SpotMarginDataRequest.builder().coin("ETH").qty("10").build();
        var normalSpotBorrowResult = client.loanNormalSpotMarginTrade(normalSpotBorrowRequest);
        System.out.println(normalSpotBorrowResult);

        // Repay
        var normalSpotRepayRequest = SpotMarginDataRequest.builder().coin("ETH").completeRepayment(CompleteRepayment.TRUE).build();
        var normalSpotRepayResult = client.repayNormalSpotMarginTrade(normalSpotRepayRequest);
        System.out.println(normalSpotRepayResult);
    }
}
