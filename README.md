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
```
Http Async Examples
```
        // Get orderbook
        var orderbookRequest = MarketDataRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").build();
        client.getMarketOrderbook(orderbookRequest,System.out::println);

        // Get market tickers
        var tickerReueqt = MarketDataRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").build();
        client.getMarketTickers(tickerReueqt, System.out::println);

        // Get funding history
        var fundingHistoryRequest = MarketDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSD")
                .startTime(1632046800000L) // Example start time
                .endTime(1632133200000L)   // Example end time
                .limit(150)
                .build();
        client.getFundingHistory(fundingHistoryRequest, System.out::println);

        // Get Open Interest data
        var openInterest = MarketDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").marketInterval(MarketInterval.FIVE_MINUTES).build();
        client.getOpenInterest(openInterest, System.out::println);

        // Get Recent Trade Data
        var recentTrade = MarketDataRequest.builder().category(ProductType.OPTION).symbol("ETH-30JUN23-2050-C").build();
        client.getRecentTradeData(recentTrade, System.out::println);

        // Get Historical Volatility
        var historicalVolatilityRequest = MarketDataRequest.builder().category(ProductType.OPTION).optionPeriod(7).build();
        client.getHistoricalVolatility(historicalVolatilityRequest, System.out::println);

        // Get Insurance data
        client.getInsurance("BTC", System.out::println); // BTC Insurance

        // Get Risk Limit
        var riskMimitRequest = MarketDataRequest.builder().category(ProductType.INVERSE).symbol("ADAUSD").build();
        client.getRiskLimit(riskMimitRequest, System.out::println);

        // Get delivery price
        var deliveryPriceRequest = MarketDataRequest.builder().category(ProductType.OPTION)
                .baseCoin("BTC")
                .limit(10)
                .build();
        client.getDeliveryPrice(deliveryPriceRequest, System.out::println);

        // Get Long Short Ratio
        var marketAccountRatioRequest = MarketDataRequest.builder().category(ProductType.LINEAR)
                .symbol("BTCUSDT")
                .dataRecordingPeriod(DataRecordingPeriod.FIFTEEN_MINUTES)
                .limit(10)
                .build();
        client.getMarketAccountRatio(marketAccountRatioRequest, System.out::println);
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