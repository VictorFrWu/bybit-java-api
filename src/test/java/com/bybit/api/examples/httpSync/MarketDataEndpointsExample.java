package com.bybit.api.examples.httpSync;

import com.bybit.api.client.domain.market.request.*;
import com.bybit.api.client.impl.BybitApiClientFactory;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.BybitApiRestClient;

/**
 * Examples on how to get market data information such as the latest price of a symbol, etc.
 */
public class MarketDataEndpointsExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        BybitApiRestClient client = factory.newRestClient();

        // Weekly candlestick bars for a symbol
        var marketKlineResult = client.getMarketLinesData(ProductType.SPOT,"BTCUSDT", MarketInterval.WEEKLY);
        System.out.println(marketKlineResult);

        // Weekly market price for a symbol
        var marketPriceKlineResult = client.getMarketLinesData(ProductType.SPOT,"BTCUSDT", MarketInterval.WEEKLY);
        System.out.println(marketPriceKlineResult);

        // Weekly index price for a symbol
        var indexPriceKlineResult = client.getMarketLinesData(ProductType.SPOT,"BTCUSDT", MarketInterval.WEEKLY);
        System.out.println(indexPriceKlineResult);

        // Weekly premium index price for a symbol
        var indexPremiumPriceKlineResult = client.getMarketLinesData(ProductType.SPOT,"BTCUSDT", MarketInterval.WEEKLY);
        System.out.println(indexPremiumPriceKlineResult);

        // Get server time
        var serverTime = client.getServerTime();
        System.out.println(serverTime);

        // Get Instrument info
        var instrumentInfoRequest = new InstrumentInfoRequest.Builder(ProductType.SPOT)
                .symbol("BTCUSDT")
                .status("Trading")
                .limit(500)
                .build();
        var instrumentInfoResponse = client.getInstrumentsInfo(instrumentInfoRequest);
        System.out.println(instrumentInfoResponse);

        // Get orderbook
        var orderBook = client.getMarketOrderbook(ProductType.SPOT, "BTCUSDT");
        System.out.println(orderBook);

        // Get market tickers
        var tickers = client.getMarketTickers(ProductType.SPOT, "BTCUSDT");
        System.out.println(tickers);

        // Get funding history
        var fundingHistoryRequest = new FundingHistoryRequest.Builder(ProductType.LINEAR, "BTCUSD")
                .startTime(1632046800000L) // Example start time
                .endTime(1632133200000L)   // Example end time
                .limit(150)
                .build();
        var fundingResponse = client.getFundingHistory(fundingHistoryRequest);
        System.out.println(fundingResponse);

        // Get Open Interest data
        var openInterest = new OpenInterestRequest.Builder(ProductType.LINEAR, "BTCUSDT", "5min") .build();
        var openInterestResponse = client.getOpenInterest(openInterest);
        System.out.println(openInterestResponse);

        // Get Recent Trade Data
        var recentTrade = new RecentTradeDataRequest.Builder(ProductType.OPTION).symbol("ETH-30JUN23-2050-C").build();
        var recentTradeResponse = client.getRecentTradeData(recentTrade);
        System.out.println(recentTradeResponse);

        // Get Historical Volatility
        var historicalVolatilityRequest = new HistoricalVolatilityRequest.Builder(ProductType.OPTION).period(7).build();
        var historicalVolatilityResponse = client.getHistoricalVolatility(historicalVolatilityRequest);
        System.out.println(historicalVolatilityResponse);

        // Get Insurance data
        var insuranceData = client.getInsurance("BTC"); // BTC Insurance
        System.out.println(insuranceData);
        var instanceAllData = client.getInsurance();
        System.out.println(instanceAllData);

        // Get Risk Limit
        var riskLimitData = client.getRiskLimit(ProductType.INVERSE, "ADAUSD");
        System.out.println(riskLimitData);
        var riskLimitALLData = client.getRiskLimit(ProductType.INVERSE);
        System.out.println(riskLimitALLData);

        // Get delivery price
        var deliveryPriceRequest = new DeliveryPriceRequest.Builder(ProductType.OPTION)
                .baseCoin("BTC")
                .limit(10)
                .build();
        var deliveryPriceData = client.getDeliveryPrice(deliveryPriceRequest);
        System.out.println(deliveryPriceData);
    }
}
