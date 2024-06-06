package com.bybit.api.examples.http.async;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.market.DataRecordingPeriod;
import com.bybit.api.client.domain.market.InstrumentStatus;
import com.bybit.api.client.domain.market.request.MarketDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.domain.market.MarketInterval;

public class MarketDataEndpointsExampleAsync {
    public static void main(String[] args) {
        var client = BybitApiClientFactory.newInstance().newAsyncMarketDataRestClient();

        // Get Recent Trade Data
        var recentTrade = MarketDataRequest.builder().category(CategoryType.OPTION).symbol("ETH-30JUN23-2050-C").build();
        var request = MarketDataRequest.builder()
                .category(CategoryType.LINEAR)
                .limit(1)
                .symbol("BTCUSDT")
                .build();
        client.getRecentTradeData(request, System.out::println);
        /*
        var marketKLineRequest = MarketDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").marketInterval(MarketInterval.WEEKLY).build();
        // Weekly Marketklin for a symbol
        client.getMarketLinesData(marketKLineRequest, System.out::println);

        // Weekly market price Kline for a symbol
        client.getMarketPriceLinesData(marketKLineRequest, System.out::println);

        // Weekly index price Kline for a symbol
        client.getIndexPriceLinesData(marketKLineRequest, System.out::println);

        // Weekly premium index price Kline for a symbol
        client.getPremiumIndexPriceLinesData(marketKLineRequest, System.out::println);

        // Get server time
        client.getServerTime(System.out::println);

        // Get Instrument info
        var instrumentInfoRequest = MarketDataRequest.builder().category(CategoryType.SPOT)
                .symbol("BTCUSDT")
                .instrumentStatus(InstrumentStatus.TRADING)
                .limit(500)
                .build();
        client.getInstrumentsInfo(instrumentInfoRequest,System.out::println);

        // Get orderbook
        var orderbookRequest = MarketDataRequest.builder().category(CategoryType.SPOT).symbol("BTCUSDT").build();
        client.getMarketOrderBook(orderbookRequest,System.out::println);

        // Get market tickers
        var tickerReueqt = MarketDataRequest.builder().category(CategoryType.SPOT).symbol("BTCUSDT").build();
        client.getMarketTickers(tickerReueqt, System.out::println);

        // Get funding history
        var fundingHistoryRequest = MarketDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSD")
                .startTime(1632046800000L) // Example start time
                .endTime(1632133200000L)   // Example end time
                .limit(150)
                .build();
        client.getFundingHistory(fundingHistoryRequest, System.out::println);

        // Get Open Interest data
        var openInterest = MarketDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").marketInterval(MarketInterval.FIVE_MINUTES).build();
        client.getOpenInterest(openInterest, System.out::println);

        // Get Historical Volatility
        var historicalVolatilityRequest = MarketDataRequest.builder().category(CategoryType.OPTION).optionPeriod(7).build();
        client.getHistoricalVolatility(historicalVolatilityRequest, System.out::println);

        // Get Insurance data
        var insuranceRequest = MarketDataRequest.builder().coin("BTC").build();
        client.getInsurance(insuranceRequest, System.out::println); // BTC Insurance

        // Get Risk Limit
        var riskMimitRequest = MarketDataRequest.builder().category(CategoryType.INVERSE).symbol("ADAUSD").build();
        client.getRiskLimit(riskMimitRequest, System.out::println);

        // Get delivery price
        var deliveryPriceRequest = MarketDataRequest.builder().category(CategoryType.OPTION)
                .baseCoin("BTC")
                .limit(10)
                .build();
        client.getDeliveryPrice(deliveryPriceRequest, System.out::println);

        // Get Long Short Ratio
        var marketAccountRatioRequest = MarketDataRequest.builder().category(CategoryType.LINEAR)
                .symbol("BTCUSDT")
                .dataRecordingPeriod(DataRecordingPeriod.FIFTEEN_MINUTES)
                .limit(10)
                .build();
        client.getMarketAccountRatio(marketAccountRatioRequest, System.out::println);
        */
    }
}
