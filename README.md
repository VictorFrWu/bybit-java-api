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
```java
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

## Contact
For support, join our Java Bybit API community on JavaBybitAPI Telegram.

## Contributors
List of other contributors
<table>
  <tr>
    <td align="center"><a href="https://github.com/wuhewuhe"><img src="https://avatars.githubusercontent.com/u/54495183?v=4" width="100px;" alt=""/><br /><sub><b>Victor</b></sub></a><br /><a href="https://github.com/bybit-exchange/pybit/commits?author=wuhewuhe" title="Code">💻</a> <a href="https://github.com/bybit-exchange/pybit/commits?author=wuhewuhe" title="Documentation">📖</a></td>
</tr>
</table>

## Donations
Your donations keep our development active and our community growing. Donate to YOUR_CRYPTO_ADDRESS.

Note: Replace placeholders (like YOUR_API_KEY, links, or other details) with the actual information. You can also customize this template to better fit the actual state and details of your Java API.