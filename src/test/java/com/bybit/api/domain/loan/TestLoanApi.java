package com.bybit.api.domain.loan;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.loan.VipLevel;
import com.bybit.api.client.domain.loan.request.CryptoLoanAdjustLtvRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanBorrowRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanDataRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanRepayRequest;
import com.bybit.api.client.restApi.BybitApiLoanRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

public class TestLoanApi {
    BybitApiLoanRestClient client = BybitApiClientFactory.newInstance("lUMPZL0Id26ACt0XyX", "oYBatVDMlxIkpkqwey04C7aY6OeiasMHXu1C", BybitApiConfig.TESTNET_DOMAIN).newCryptoLoanRestClient();

    @Test
    public void collateralCoinList() {
        CryptoLoanDataRequest param = CryptoLoanDataRequest.builder()
                .vipLevel(VipLevel.PRO_1)
                .collateralCurrency("USDT")
                .build();
        System.out.println(client.getCollateralCoins(param));
    }

    @Test
    public void loanCoinList() {
        CryptoLoanDataRequest param = CryptoLoanDataRequest.builder()
                .vipLevel(VipLevel.VIP_SUPREME)
                .loanCurrency("ETH")
                .build();
        System.out.println(client.getBorrowableCoins(param));
    }

    @Test
    public void accountCollateralLoanData() {
        CryptoLoanDataRequest param = CryptoLoanDataRequest.builder()
                .collateralCurrency("USDT")
                .loanCurrency("BTC")
                .build();
        System.out.println(client.getAcctMortgageLoanLimit(param));
    }

    @Test
    public void borrowCoin() {
        CryptoLoanBorrowRequest param = CryptoLoanBorrowRequest.builder()
                .loanCurrency("USDT")
                .loanAmount("5000")
                .collateralAmount("0.1")
                .collateralCurrency("BTC")
                .loanTerm("14")
                .build();
        System.out.println(client.borrow(param));
    }

    @Test
    public void repay() {
        CryptoLoanRepayRequest param = CryptoLoanRepayRequest.builder()
                .amount("150.000644")
                .orderId("1794267532472646144")
                .build();
        System.out.println(client.repay(param));
    }

    @Test
    public void adjustLTV() {
        CryptoLoanAdjustLtvRequest param = CryptoLoanAdjustLtvRequest.builder()
                .direction("1")
                .amount("0.01")
                .orderId("1793683005081680384")
                .build();
        System.out.println(client.adjustCollateralAmount(param));
    }

    @Test
    public void maxAdjustAmount() {
        CryptoLoanDataRequest param = CryptoLoanDataRequest.builder()
                .orderId("1793683005081680384")
                .build();
        System.out.println(client.getMaxReduceAmount(param));
    }

    @Test
    public void ongoingOrders() {
        CryptoLoanDataRequest param = CryptoLoanDataRequest.builder()
                .orderId("1793683005081680384")
                .loanCurrency(null)
                .collateralCurrency("ETH")
                .loanTermType(null)
                .loanTerm(null)
                .cursor(null)
                .limit(null)
                .build();
        System.out.println(client.getUnpaidOrders(param));
    }

    @Test
    public void repaymentTransaction() {
        CryptoLoanDataRequest param = CryptoLoanDataRequest.builder()
                .orderId(null)
                .repayId(null)
                .loanCurrency("USDT")
                .limit("1")
                .cursor("1844285455328559105")
                .build();
        System.out.println(client.getRepayTransactions(param));
    }

    @Test
    public void completeLoanOrders() {
        CryptoLoanDataRequest param = CryptoLoanDataRequest.builder()
                .orderId(null)
                .loanCurrency(null)
                .collateralCurrency(null)
                .limit("2")
                .cursor(null)
                .build();
        System.out.println(client.getCompletedOrders(param));
    }

    @Test
    public void adjustmentHistory() {
        CryptoLoanDataRequest param = CryptoLoanDataRequest.builder()
                .orderId("1794894382471346176")
                .adjustId(null)
                .collateralCurrency(null)
                .limit(null)
                .cursor(null)
                .build();
        System.out.println(client.getLtvAdjustmentHistory(param));
    }
}
