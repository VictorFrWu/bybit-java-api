package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.market.*;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.BybitApiRestClient;

/**
 * Examples on how to get market data information such as the latest price of a symbol, etc.
 */
public class MarketDataEndpointsExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        BybitApiRestClient client = factory.newRestClient();

        var marketKLineRequest = MarketDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").marketInterval(MarketInterval.WEEKLY).build();
        // Weekly market Kline
        var marketKlineResult = client.getMarketLinesData(marketKLineRequest);
        System.out.println(marketKlineResult);

        // Weekly market price Kline for a symbol
        var marketPriceKlineResult = client.getMarketPriceLinesData(marketKLineRequest);
        System.out.println(marketPriceKlineResult);

        // Weekly index price Kline for a symbol
        var indexPriceKlineResult = client.getIndexPriceLinesData(marketKLineRequest);
        System.out.println(indexPriceKlineResult);

        // Weekly premium index price Kline for a symbol
        var indexPremiumPriceKlineResult = client.getPremiumIndexPriceLinesData(marketKLineRequest);
        System.out.println(indexPremiumPriceKlineResult);

        // Get server time
        var serverTime = client.getServerTime();
        System.out.println(serverTime);

        // Get Instrument info
        var instrumentInfoRequest = MarketDataRequest.builder().category(ProductType.SPOT)
                .symbol("BTCUSDT")
                .instrumentStatus(InstrumentStatus.TRADING)
                .limit(500)
                .build();
        var instrumentInfoResponse = client.getInstrumentsInfo(instrumentInfoRequest);
        System.out.println(instrumentInfoResponse);

        // Get orderbook
        var orderbookRequest = MarketDataRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").build();
        var orderBook = client.getMarketOrderBook(orderbookRequest);
        System.out.println(orderBook);

        // Get market tickers
        var tickerReueqt = MarketDataRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").build();
        var tickers = client.getMarketTickers(tickerReueqt);
        System.out.println(tickers);

        // Get funding history
        var fundingHistoryRequest = MarketDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSD")
                .startTime(1632046800000L) // Example start time
                .endTime(1632133200000L)   // Example end time
                .limit(150)
                .build();
        var fundingResponse = client.getFundingHistory(fundingHistoryRequest);
        System.out.println(fundingResponse);

        // Get Open Interest data
        var openInterest = MarketDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").marketIntervalTime(IntervalTime.FIFTEEN_MINUTES).build();
        var openInterestResponse = client.getOpenInterest(openInterest);
        System.out.println(openInterestResponse);

        // Get Recent Trade Data
        var recentTrade = MarketDataRequest.builder().category(ProductType.OPTION).symbol("ETH-30JUN23-2050-C").build();
        var recentTradeResponse = client.getRecentTradeData(recentTrade);
        System.out.println(recentTradeResponse);

        // Get Historical Volatility
        var historicalVolatilityRequest = MarketDataRequest.builder().category(ProductType.OPTION).optionPeriod(7).build();
        var historicalVolatilityResponse = client.getHistoricalVolatility(historicalVolatilityRequest);
        System.out.println(historicalVolatilityResponse);

        // Get Insurance data
        var insuranceData = client.getInsurance("BTC"); // BTC Insurance
        System.out.println(insuranceData);
        var instanceAllData = client.getInsurance();
        System.out.println(instanceAllData);

        // Get Risk Limit
        var riskMimitRequest = MarketDataRequest.builder().category(ProductType.INVERSE).symbol("ADAUSD").build();
        var riskLimitData = client.getRiskLimit(riskMimitRequest);
        System.out.println(riskLimitData);

        // Get delivery price
        var deliveryPriceRequest = MarketDataRequest.builder().category(ProductType.OPTION)
                .baseCoin("BTC")
                .limit(10)
                .build();
        var deliveryPriceData = client.getDeliveryPrice(deliveryPriceRequest);
        System.out.println(deliveryPriceData);

        // Get Long Short Ratio
        var marketAccountRatioRequest = MarketDataRequest.builder().category(ProductType.LINEAR)
                .symbol("BTCUSDT")
                .dataRecordingPeriod(DataRecordingPeriod.FIFTEEN_MINUTES)
                .limit(10)
                .build();
        var accountRatio = client.getMarketAccountRatio(marketAccountRatioRequest);
        System.out.println(accountRatio);
    }
}
