# BybitJavaAPI

Build Status Build Status Contributions Welcome

The Official Java API connector for Bybit's HTTP and WebSocket APIs.

## Table of Contents

- [About](#about)
- [Development](#development)
- [Installation](#installation)
- [Usage](#usage)
- [Contact](#contact)
- [Contributors](#contributors)
- [Donations](#donations)

## About
BybitJavaAPI provides an official, robust, and high-performance Java connector to Bybit's trading APIs. Initially conceptualized by esteemed Java developer Victor, this module is now maintained by Bybit's in-house Java experts. Your contributions are most welcome!

## Development
BybitJavaAPI is under active development with the latest features and updates from Bybit's API implemented promptly. The module utilizes minimal external libraries to provide a lightweight and efficient experience. If you've made enhancements or fixed bugs, please submit a pull request.

## Installation
Ensure you have Java 1.8 or higher. You can include BybitJavaAPI in your project using Maven or Gradle.

Maven Example
```java
<!-- Maven -->
<dependency>
    <groupId>com.bybit.api</groupId>
    <artifactId>BybitJavaAPI</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage
Http Sync Examples
```java
package com.bybit.api.examples.http.sync;

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

        var marketKLineRequest = MarketKlineRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").marketInterval(MarketInterval.WEEKLY).build();
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
        var instrumentInfoRequest = InstrumentInfoRequest.builder().category(ProductType.SPOT)
                .symbol("BTCUSDT")
                .status("Trading")
                .limit(500)
                .build();
        var instrumentInfoResponse = client.getInstrumentsInfo(instrumentInfoRequest);
        System.out.println(instrumentInfoResponse);

        // Get orderbook
        var orderbookRequest = MarketOrderBookRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").build();
        var orderBook = client.getMarketOrderbook(orderbookRequest);
        System.out.println(orderBook);

        // Get market tickers
        var tickerReueqt = MarketDataTickerRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").build();
        var tickers = client.getMarketTickers(tickerReueqt);
        System.out.println(tickers);

        // Get funding history
        var fundingHistoryRequest = FundingHistoryRequest.builder().category(ProductType.LINEAR).symbol("BTCUSD")
                .startTime(1632046800000L) // Example start time
                .endTime(1632133200000L)   // Example end time
                .limit(150)
                .build();
        var fundingResponse = client.getFundingHistory(fundingHistoryRequest);
        System.out.println(fundingResponse);

        // Get Open Interest data
        var openInterest = OpenInterestRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").intervalTime("5min").build();
        var openInterestResponse = client.getOpenInterest(openInterest);
        System.out.println(openInterestResponse);

        // Get Recent Trade Data
        var recentTrade = RecentTradeDataRequest.builder().category(ProductType.OPTION).symbol("ETH-30JUN23-2050-C").build();
        var recentTradeResponse = client.getRecentTradeData(recentTrade);
        System.out.println(recentTradeResponse);

        // Get Historical Volatility
        var historicalVolatilityRequest = HistoricalVolatilityRequest.builder().category(ProductType.OPTION).period(7).build();
        var historicalVolatilityResponse = client.getHistoricalVolatility(historicalVolatilityRequest);
        System.out.println(historicalVolatilityResponse);

        // Get Insurance data
        var insuranceData = client.getInsurance("BTC"); // BTC Insurance
        System.out.println(insuranceData);
        var instanceAllData = client.getInsurance();
        System.out.println(instanceAllData);

        // Get Risk Limit
        var riskMimitRequest = MarketRiskLimitRequest.builder().category(ProductType.INVERSE).symbol("ADAUSD").build();
        var riskLimitData = client.getRiskLimit(riskMimitRequest);
        System.out.println(riskLimitData);

        // Get delivery price
        var deliveryPriceRequest = DeliveryPriceRequest.builder().category(ProductType.OPTION)
                .baseCoin("BTC")
                .limit(10)
                .build();
        var deliveryPriceData = client.getDeliveryPrice(deliveryPriceRequest);
        System.out.println(deliveryPriceData);

        // Get Long Short Ratio
        var marketAccountRatioRequest = MarketAccountRatioRequest.builder().category(ProductType.LINEAR)
                .symbol("BTCUSDT")
                .period("15min")
                .limit(10)
                .build();
        var accountRatio = client.getMarketAccountRatio(marketAccountRatioRequest);
        System.out.println(accountRatio);
    }
}
```
Http Async Examples
```
package com.bybit.api.examples.http.async;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.request.*;
import com.bybit.api.client.impl.BybitApiClientFactory;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.BybitApiAsyncRestClient;

public class MarketDataEndpointsExampleAsync {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        BybitApiAsyncRestClient client = factory.newAsyncRestClient();

        var marketKLineRequest = MarketKlineRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").marketInterval(MarketInterval.WEEKLY).build();
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
        var instrumentInfoRequest = InstrumentInfoRequest.builder().category(ProductType.SPOT)
                .symbol("BTCUSDT")
                .status("Trading")
                .limit(500)
                .build();
        client.getInstrumentsInfo(instrumentInfoRequest,System.out::println);

        // Get orderbook
        var orderbookRequest = MarketOrderBookRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").build();
        client.getMarketOrderbook(orderbookRequest,System.out::println);

        // Get market tickers
        var tickerReueqt = MarketDataTickerRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").build();
        client.getMarketTickers(tickerReueqt, System.out::println);

        // Get funding history
        var fundingHistoryRequest = FundingHistoryRequest.builder().category(ProductType.LINEAR).symbol("BTCUSD")
                .startTime(1632046800000L) // Example start time
                .endTime(1632133200000L)   // Example end time
                .limit(150)
                .build();
        client.getFundingHistory(fundingHistoryRequest, System.out::println);

        // Get Open Interest data
        var openInterest = OpenInterestRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").intervalTime("5min").build();
        client.getOpenInterest(openInterest, System.out::println);

        // Get Recent Trade Data
        var recentTrade = RecentTradeDataRequest.builder().category(ProductType.OPTION).symbol("ETH-30JUN23-2050-C").build();
        client.getRecentTradeData(recentTrade, System.out::println);

        // Get Historical Volatility
        var historicalVolatilityRequest = HistoricalVolatilityRequest.builder().category(ProductType.OPTION).period(7).build();
        client.getHistoricalVolatility(historicalVolatilityRequest, System.out::println);

        // Get Insurance data
        client.getInsurance("BTC", System.out::println); // BTC Insurance

        // Get Risk Limit
        var riskMimitRequest = MarketRiskLimitRequest.builder().category(ProductType.INVERSE).symbol("ADAUSD").build();
        client.getRiskLimit(riskMimitRequest, System.out::println);

        // Get delivery price
        var deliveryPriceRequest = DeliveryPriceRequest.builder().category(ProductType.OPTION)
                .baseCoin("BTC")
                .limit(10)
                .build();
        client.getDeliveryPrice(deliveryPriceRequest, System.out::println);

        // Get Long Short Ratio
        var marketAccountRatioRequest = MarketAccountRatioRequest.builder().category(ProductType.LINEAR)
                .symbol("BTCUSDT")
                .period("15min")
                .limit(10)
                .build();
        client.getMarketAccountRatio(marketAccountRatioRequest, System.out::println);
    }
}
```
## Contact
For support, join our Java Bybit API community on JavaBybitAPI Telegram.

## Contributors
List of other contributors
<table>
  <tr>
    <td align="center">
        <a href="https://github.com/wuhewuhe">
            <img src="https://avatars.githubusercontent.com/u/32245754?v=4" width="100px;" alt=""/>
            <br />
            <sub>   
                <b>Victor</b>
            </sub>
        </a>
        <br />
        <a href="https://github.com/wuhewuhe/bybit-java-api/commits?author=wuhewuhe" title="Code">
            💻</a> <a href="https://github.com/wuhewuhe/bybit-java-api/commits?author=wuhewuhe" title="Documentation">
            📖</a>
</td>
</tr>
</table>

## Donations
Your donations keep our development active and our community growing. Donate to YOUR_CRYPTO_ADDRESS.

Note: Replace placeholders (like YOUR_API_KEY, links, or other details) with the actual information. You can also customize this template to better fit the actual state and details of your Java API.