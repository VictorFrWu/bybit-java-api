package com.bybit.api.examples.http.async;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.loan.VipLevel;
import com.bybit.api.client.domain.loan.request.CryptoLoanAdjustLtvRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanBorrowRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanDataRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanRepayRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class CryptoLoanAsyncExample {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance("YOUR API KEY", "YOUR SECRET KEY", BybitApiConfig.TESTNET_DOMAIN).newAsyncCryptoLoanRestClient();

        //Get collateral coin
        var collateralCoinReq = CryptoLoanDataRequest.builder().currency("BTC").vipLevel(VipLevel.VIP_SUPREME).build();
        client.getCollateralCoins(collateralCoinReq, System.out::println);

        //Get loan coin
        var loanCoinReq = CryptoLoanDataRequest.builder().currency("BTC").vipLevel(VipLevel.PRO_6).build();
        client.getBorrowableCoins(loanCoinReq, System.out::println);

        //Get account loan collateral limit
        var acctCollateralLoanLimit = CryptoLoanDataRequest.builder().collateralCurrency("USDT").loanCurrency("BTC").build();
        client.getAcctMortgageLoanLimit(acctCollateralLoanLimit, System.out::println);

//        Borrow
        var borrowReq = CryptoLoanBorrowRequest.builder()
                .loanCurrency("USDT")
                .loanAmount("511")
                .collateralCurrency("BTC")
                .collateralAmount(null)
                .loanTerm("7")
                .build();
        client.borrow(borrowReq, System.out::println);

//        Get on-going loan order
        var ongoingOrder = CryptoLoanDataRequest.builder().orderId("1804403706696569600").build();
        client.getUnpaidOrders(ongoingOrder, System.out::println);

//        get completed loan order
        var completedOrderReq = CryptoLoanDataRequest.builder()
                .orderId(null)
                .collateralCurrency("BTC")
                .loanCurrency("USDT")
                .cursor("1844214388471799809")
                .limit("3")
                .build();
        client.getCompletedOrders(completedOrderReq, System.out::println);

//        repay
        var repayReq = CryptoLoanRepayRequest.builder()
                .amount("88")
                .orderId("1804403706696569600")
                .build();
        client.repay(repayReq, System.out::println);

        var repayTxReq = CryptoLoanDataRequest.builder()
                .repayId(null)
                .orderId(null)
                .loanCurrency("USDT")
                .cursor("1849704428895399938")
                .limit("1")
                .build();
        client.getRepayTransactions(repayTxReq, System.out::println);

        //Get max collateral amount reduce
        var maxReduceAmt = CryptoLoanDataRequest.builder()
                .orderId("1804403706696569600")
                .build();
        client.getMaxReduceAmount(maxReduceAmt, System.out::println);

        // Reduce or Add Collateral amount
        var adjustCollateral = CryptoLoanAdjustLtvRequest.builder()
                .direction("1")
                .amount("0.04")
                .orderId("1804403706696569600")
                .build();
        client.adjustCollateralAmount(adjustCollateral, System.out::println);

        var getAdjustLtv = CryptoLoanDataRequest.builder()
                .orderId(null)
                .adjustId(null)
                .collateralCurrency("BTC")
                .cursor(null)
                .limit(null)
                .build();
        client.getLtvAdjustmentHistory(getAdjustLtv, System.out::println);
    }
}
