# bybit-java-api
[![Java 11](https://img.shields.io/badge/Java-11-brightgreen.svg)](https://github.com/wuhewuhe/bybit-java-api)   [![Contributor Victor](https://img.shields.io/badge/contributor-Victor-blue.svg)](https://github.com/wuhewuhe/bybit-java-api)   [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/wuhewuhe/bybit-java-api/blob/main/LICENSE)
## Table of Contents
- [About](#about)
- [Development](#development)
- [Installation](#installation)
- [Usage](#usage)
- [Contact](#contact)
- [Contributors](#contributors)
- [Donations](#donations)
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

Initially conceptualized by esteemed Java developer Victor, this module is now maintained by Bybit's in-house Java experts. 

Your contributions are most welcome!

## Development
bybit-java-api is under active development with the latest features and updates from Bybit's API implemented promptly. The module utilizes minimal external libraries to provide a lightweight and efficient experience. If you've made enhancements or fixed bugs, please submit a pull request.

## Installation
Ensure you have Java 11 or higher. You can include bybit-java-api in your project using Maven or Gradle.

Maven Example
```java
    <!-- Maven -->
    <dependency>
        <groupId>com.bybit.api</groupId>
        <artifactId>bybit-java-api</artifactId>
        <version>1.0.9</version>
    </dependency>
```
Gradle Example
```java
    implementation group: 'io.github.wuhewuhe', name: 'bybit-java-api', version: '1.0.8'
```
## Usage

### Http Async Examples
- Create Factory 
```java
        // Client Factory in Mainnet with API key and Secret
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        // Client Factory in Testnet, with API key and Secret
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", true);
        // Client Factory in Mainnet without API key and Secret
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance()
        // Client Factory in Testnet without API key and Secret
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance(true)
```

- Place Single Order
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", true);
        BybitApiAsyncTradeRestClient client = factory.newAsyncTradeRestClient();
        // Place an order
        var newOrderRequest = TradeOrderRequest.builder().category(ProductType.LINEAR).symbol("XRPUSDT")
                .side(Side.BUY).orderType(TradeOrderType.MARKET).qty("10").timeInForce(TimeInForce.IMMEDIATE_OR_CANCEL)
                .positionIdx(PositionIdx.ONE_WAY_MODE).build();
        client.createOrder(newOrderRequest, System.out::println);
```

- Place Batch Order
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET",true);
        BybitApiAsyncTradeRestClient client = factory.newAsyncTradeRestClient();
        // Create a batch order
        var orderRequests = Arrays.asList(TradeOrderRequest.builder().category(ProductType.OPTION).symbol("BTC-10FEB23-24000-C").side(Side.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
                .price("5").orderIv("0.1").timeInForce(TimeInForce.GOOD_TILL_CANCEL).orderLinkId("9b381bb1-401").mmp(false).reduceOnly(false).build(),
                TradeOrderRequest.builder().category(ProductType.OPTION).symbol("BTC-10FEB23-24000-C").side(Side.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
                .price("5").orderIv("0.1").timeInForce(TimeInForce.GOOD_TILL_CANCEL).orderLinkId("82ee86dd-001").mmp(false).reduceOnly(false).build());
                var createBatchOrders = BatchOrderRequest.builder().category(ProductType.OPTION).request(orderRequests).build();
        client.createBatchOrder(createBatchOrders, System.out::println);
```
- Position Info
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET",true);
        var client = factory.newAsyncPositionRestClient();
        // Get Position Info
        var positionListRequest = PositionDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").build();
        client.getPositionInfo(positionListRequest, System.out::println);
```
- Asset Info
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET",true);
        var client = factory.newAsyncAssetRestClient();
        // Get Coin Exchange Records
        var coinExchangeRecordsRequest = AssetDataRequest.builder().build();
        client.getAssetCoinExchangeRecords(coinExchangeRecordsRequest, System.out::println);
```
### Http Sync Examples
- Place Batch Order
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", true);
        BybitApiTradeRestClient client = factory.newTradeRestClient();
        // Create a batch order
        var orderRequests = Arrays.asList(TradeOrderRequest.builder().category(ProductType.OPTION).symbol("BTC-10FEB23-24000-C").side(Side.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
                        .price("5").orderIv("0.1").timeInForce(TimeInForce.GoodTillCancel).orderLinkId("9b381bb1-401").mmp(false).reduceOnly(false).build(),
                TradeOrderRequest.builder().category(ProductType.OPTION).symbol("BTC-10FEB23-24000-C").side(Side.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
                        .price("5").orderIv("0.1").timeInForce(TimeInForce.GoodTillCancel).orderLinkId("82ee86dd-001").mmp(false).reduceOnly(false).build());
        var createBatchOrders = BatchOrderRequest.builder().category(ProductType.OPTION).request(orderRequests).build();
        var createBatchRequestResponse = client.createBatchOrder(createBatchOrders);
        System.out.println(createBatchRequestResponse);

        // Create a batch order by map
        Map<String, Object> payload = new HashMap<>();
        payload.put("category", "option");
        List<Map<String, Object>> orders = new ArrayList<>();
        List<Integer> prices = Arrays.asList(15000, 15500, 16000, 16500, 16600);
        for (Integer price : prices) {
            Map<String, Object> order = new HashMap<>();
            order.put("symbol", "BTC-30JUN23-20000-C");
            order.put("side", "Buy");
            order.put("orderType", "Limit");
            order.put("qty", "0.1");
            order.put("price", price.toString());
            orders.add(order);
        }
        payload.put("request", orders);
        var createBatchResponse = client.createBathOrder(payload);
        System.out.println(createBatchResponse);
        
        var batchOrderRequest = client.createBathOrder(jsonRequest);
        System.out.println(batchOrderRequest);
```

- Market Data Info 
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance(true);
        var client = factory.newMarketDataRestClient();
        var marketKLineRequest = MarketDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").marketInterval(MarketInterval.WEEKLY).build();
        // Weekly market Kline
        var marketKlineResult = client.getMarketLinesData(marketKLineRequest);
        System.out.println(marketKlineResult);
```
- Account Data Info
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET",true);
        var client = factory.newAccountRestClient();
        // Get wallet balance
        var walletBalanceRequest = AccountDataRequest.builder().accountType(AccountType.UNIFIED).build();
        var walletBalanceData = client.getWalletBalance(walletBalanceRequest);
        System.out.println(walletBalanceData);
```

- User Management
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET",true);
        var client = factory.newUserRestClient();
        // create a new sub user
        var subUserRequest = UserDataRequest.builder().username("VictorWuTest3")
        .password("Password123")
        .memberType(MemberType.NORMAL_SUB_ACCOUNT)
        .note("Some note")
        .switchOption(SwitchOption.TURN_OFF)
        .isUta(IsUta.CLASSIC_ACCOUNT)
        .build();
        var subUser = client.createSubMember(subUserRequest);
        System.out.println(subUser);
```

### Websocket public channel
- Create Websocket Client
```java
        // new websocket client in debug mode
        var client = factory.newWebsocketClient(true);
        // new websocket client with message handler
        var client = factory.newWebsocketClient((message) -> System.out.println("Handle message :" + message));
        // new websocket client with message handler and debug mode
        var client = factory.newWebsocketClient((message) -> System.out.println("Handle message :" + message), true);
        // new websocket client without message handler and debug mode
        var client = factory.newWebsocketClient();
```
- Order book Subscribe
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        var client = factory.newWebsocketClient((message) -> System.out.println("Handle message :" + message), true);

        // Orderbook
        client.getPublicChannelStream(List.of("orderbook.50.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
        
        // Subscribe Orderbook more than one args
        client.getPublicChannelStream(List.of("orderbook.50.BTCUSDT","orderbook.1.ETHUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
```

### Websocket private channel
- Order Subscribe
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY","YOUR_API_SECRET",true);
        var client = factory.newWebsocketClient((message) -> System.out.println("Handle message :" + message), true);

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
    <td align="center">
        <a href="https://github.com/Doom-Prince">
            <img src="https://avatars.githubusercontent.com/u/124635036?v=4" width="100px;" alt=""/>
            <br />
            <sub>   
                <b>Doom</b>
            </sub>
        </a>
        <br />
        <a href="https://github.com/wuhewuhe/bybit-java-api/commits?author=Doom-Prince" title="Code">💻</a>
        <a href="https://github.com/wuhewuhe/bybit-java-api/commits?author=Doom-Prince" title="Documentation">📖</a>
    </td>
  </tr>
</table>

## Donations
Your donations keep our development active and our community growing. Donate USDT to our [ERC20 Wallet Address](0x238bbb45af1254e2fd76564c9b56042c452f3d6e).

Note: Replace placeholders (like YOUR_API_KEY, links, or other details) with the actual information. You can also customize this template to better fit the actual state and details of your Java API.