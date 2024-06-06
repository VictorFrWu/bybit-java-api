# bybit-java-api
[![Java 11](https://img.shields.io/badge/Java-11-brightgreen.svg)](https://github.com/wuhewuhe/bybit-java-api)   [![Contributor Victor](https://img.shields.io/badge/contributor-Victor-blue.svg)](https://github.com/wuhewuhe/bybit-java-api)   [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/wuhewuhe/bybit-java-api/blob/main/LICENSE)
## Table of Contents
- [About](#about)
- [Development](#development)
- [Installation](#installation)
- [Release Notes](#release-notes)
- [Usage](#usage)
- [Contact](#contact)
- [Contributors](#contributors)
## About
The Official Java API connector for Bybit's HTTP and WebSocket APIs.

Dive into a plethora of functionalities:
- Market Data Retrieval
- Trade Execution
- Position Management
- Account and Asset Info Retrieval
- User and Upgrade Management
- Public Websocket Streaming
- Private Websocket Streaming
- Lending Institution and Client
- Broker Earning Data

bybit-java-api provides an official, robust, and high-performance Java connector to Bybit's trading APIs. 

Initially conceptualized by Java developer Victor, this module is now maintained by Bybit's in-house Java experts. 

Your contributions are most welcome!

## Development
bybit-java-api is under active development with the latest features and updates from Bybit's API implemented promptly. The module utilizes minimal external libraries to provide a lightweight and efficient experience. If you've made enhancements or fixed bugs, please submit a pull request.

## Installation
Ensure you have Java 11 or higher. You can include bybit-java-api in your project using Maven or Gradle.

Maven Example
```java
<!-- Maven -->
<dependency>
    <groupId>io.github.wuhewuhe</groupId>
    <artifactId>bybit-java-api</artifactId>
    <version>1.2.6</version>
</dependency>
```
Gradle Example
```java
implementation group: 'io.github.wuhewuhe', name: 'bybit-java-api', version: '1.2.6'
```
Furthermore, build tool, please check [sonar type central repository](https://central.sonatype.com/artifact/io.github.wuhewuhe/bybit-java-api/1.2.3)

## Release-Notes
### Websockets
- Websocket Trade API headers change to header

### Rest API
- Fix create user uta and switch
- Fix get recent trade
- Add Broker get all sub uids deposits records
- Add get smp group id
- Add transaction log to classical user

### Change Log
- decrypted functions:
getC2CLendingCoinInfo
getC2cLendingDepositFunds
getC2cLendingRedeemFunds
getC2cLendingRedeemCancel
getC2cOrdersRecords
getC2CLendingAccountInfo

## Usage
Note: Replace placeholders (like YOUR_API_KEY, links, or other details) with the actual information. You can also customize this template to better fit the actual state and details of your Java API.
### HttP Client Factory & Websocket Client
#### Client Factory Option
```java
private final String apiKey;
private final String secret;
private final String baseUrl;
private final Boolean debugMode;
private final String logOption;
private final Long recvWindow;
private final String referer;
```

### Http Async Examples
- Place Single Order By Object
```java
var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN, true).newAsyncTradeRestClient();
        Map<String, Object> order =Map.of(
        "category", "option",
        "symbol", "BTC-29DEC23-10000-P",
        "side", "Buy",
        "orderType", "Limit",
        "orderIv", "0.1",
        "qty", "0.1",
        "price", "5"
        );
        client.createOrder(order, System.out::println);
```

- Place Single Order By Map
```java
var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN, true).newAsyncTradeRestClient();
var newOrderRequest = TradeOrderRequest.builder().category(CategoryType.LINEAR).symbol("XRPUSDT")
.side(Side.BUY).orderType(TradeOrderType.MARKET).qty("10").timeInForce(TimeInForce.GOOD_TILL_CANCEL)
.positionIdx(PositionIdx.ONE_WAY_MODE).build();
client.createOrder(newOrderRequest, System.out::println);
```

- Place Batch Order
```java
var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newAsyncTradeRestClient();
var orderRequests = Arrays.asList(TradeOrderRequest.builder().category(CategoryType.OPTION).symbol("BTC-10FEB23-24000-C").side(Side.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
.price("5").orderIv("0.1").timeInForce(TimeInForce.GOOD_TILL_CANCEL).orderLinkId("9b381bb1-401").mmp(false).reduceOnly(false).build(),
TradeOrderRequest.builder().category(CategoryType.OPTION).symbol("BTC-10FEB23-24000-C").side(Side.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
.price("5").orderIv("0.1").timeInForce(TimeInForce.GOOD_TILL_CANCEL).orderLinkId("82ee86dd-001").mmp(false).reduceOnly(false).build());
var createBatchOrders = BatchOrderRequest.builder().category(CategoryType.OPTION).request(orderRequests).build();
client.createBatchOrder(createBatchOrders, System.out::println);
```
- Position Info
```java
var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newAsyncPositionRestClient();
var positionListRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").build();
client.getPositionInfo(positionListRequest, System.out::println);
```
- Asset Info
```java
var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newAsyncAssetRestClient();
var coinExchangeRecordsRequest = AssetDataRequest.builder().build();
client.getAssetCoinExchangeRecords(coinExchangeRecordsRequest, System.out::println);
```
### Http Sync Examples
- Amend Order
```java
var amendOrderRequest = TradeOrderRequest.builder().orderId("1523347543495541248").category(CategoryType.LINEAR).symbol("XRPUSDT")
        .price("0.5")  // setting a new price, for example
        .qty("15")  // and a new quantity
        .build();
var amendedOrder = client.amendOrder(amendOrderRequest);
System.out.println(amendedOrder);
```
- Place Batch Order
```java
String jsonRequest = """
{
  "category":"option", 
  "request": [ 
  {  
  "category":"option", 
  "symbol":"BTC-10FEB23-24000-C", 
  "orderType":"Limit", 
  "side":"Buy",   
  "qty":"0.1", 
  "price":"5", 
  "orderIv":"0.1", 
  "timeInForce":"GTC", 
  "orderLinkId":"9b381bb1-401", 
  "mmp":false, 
  "reduceOnly":false  
  },
  {  
  "category":"option", 
  "symbol":"BTC-10FEB23-24000-C", 
  "orderType":"Limit", 
  "side":"Buy",   
  "qty":"0.1", 
  "price":"5", 
  "orderIv":"0.1", 
  "timeInForce":"GTC", 
  "orderLinkId":"82ee86dd-001", 
  "mmp":false, 
  "reduceOnly":false  
  } 
 ]
}
""";
var batchOrderRequest = client.createBathOrder(jsonRequest);
System.out.println(batchOrderRequest);
```

- Market Data Info 
```java
var client = BybitApiClientFactory.newInstance(BybitApiConfig.TESTNET_DOMAIN,true).newMarketDataRestClient();
var marketKLineRequest = MarketDataRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").marketInterval(MarketInterval.WEEKLY).build();
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
```

- User Management
```java
var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newUserRestClient();
var subUserRequest = UserDataRequest.builder().username("VictorWuTest3").password("Password123").memberType(MemberType.NORMAL_SUB_ACCOUNT).note("Some note").switchOption(SwitchOption.TURN_OFF).isUta(IsUta.CLASSIC_ACCOUNT).build();
var subUser = client.createSubMember(subUserRequest);
System.out.println(subUser);
```

#### Websocket Client
```java
private final Integer pingInterval;
private final WebsocketMessageHandler messageHandler;
private final String maxAliveTime; // Only valid for private channel, timeunit in seconds or minutes
```

### Websocket public channel
- Order book Subscribe
```java
var client = BybitApiClientFactory.newInstance(BybitApiConfig.STREAM_TESTNET_DOMAIN, true, "okhttp3").newWebsocketClient(20);
client.getPublicChannelStream(List.of("orderbook.50.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
client.getPublicChannelStream(List.of("orderbook.50.BTCUSDT","orderbook.1.ETHUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
```

- Ticker Subscribe
```java
var client = BybitApiClientFactory.newInstance(BybitApiConfig.STREAM_MAINNET_DOMAIN, true).newWebsocketClient();
client.setMessageHandler(message -> {
    var tickerData = (new ObjectMapper()).readValue(message, WebSocketTickerMessage.class);
    System.out.println("Websocket Message Data: " + tickerData.getData().toString());
});
client.getPublicChannelStream(List.of("tickers.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
```
- Websocket Trade API
```java
var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.STREAM_TESTNET_DOMAIN, true).newWebsocketClient(20);
client.getTradeChannelStream(Map.of("category", "spot","symbol", "XRPUSDT", "side", "Buy", "orderType", "Market", "qty", "10"), V5_TRADE);
```
### Websocket private channel
- Position Subscribe
```java
var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.STREAM_TESTNET_DOMAIN).newWebsocketClient();
client.getPrivateChannelStream(List.of("position"), BybitApiConfig.V5_PRIVATE);
```

- Order Channel active Message Handler & Max Alive Time & Ping Interval 
```java
var client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.STREAM_TESTNET_DOMAIN, true)
        .newWebsocketClient(5, "60s", (message) -> {
        var orderMessage = (new ObjectMapper()).readValue(message, WebSocketOrderMessage.class);
        // Process message data here
        System.out.println("Websocket Message Data: " + orderMessage.getData().toString());
        });

// Order
client.getPrivateChannelStream(List.of("order"), BybitApiConfig.V5_PRIVATE);
```

## Contact
For support, join our Bybit API community on [Telegram](https://t.me/Bybitapi).

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
        <a href="https://github.com/wuhewuhe/bybit-java-api/commits?author=wuhewuhe" title="Code">💻</a>
        <a href="https://github.com/wuhewuhe/bybit-java-api/commits?author=wuhewuhe" title="Documentation">📖</a>
    </td>
  </tr>
</table>