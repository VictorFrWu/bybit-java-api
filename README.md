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
Ensure you have Java 8 or higher. You can include BybitJavaAPI in your project using Maven or Gradle.

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

### Http Sync Examples
Http Async Examples
- Place Single Order
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        BybitApiAsyncTradeRestClient client = factory.newAsyncTradeRestClient();

        // Place an order
        var newOrderRequest = TradeOrderRequest.builder().category(ProductType.LINEAR).symbol("XRPUSDT")
                .side(Side.BUY).orderType(TradeOrderType.MARKET).qty("10").timeInForce(TimeInForce.ImmediateOrCancel)
                .positionIdx(PositionIdx.ONE_WAY_MODE).build();
        client.createOrder(newOrderRequest, System.out::println);
    }
```

- Place Batch Order
```java
        // Create a batch order
        var orderRequests = Arrays.asList(TradeOrderRequest.builder().category(ProductType.OPTION).symbol("BTC-10FEB23-24000-C").side(Side.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
                .price("5").orderIv("0.1").timeInForce(TimeInForce.GoodTillCancel).orderLinkId("9b381bb1-401").mmp(false).reduceOnly(false).build(),
                TradeOrderRequest.builder().category(ProductType.OPTION).symbol("BTC-10FEB23-24000-C").side(Side.BUY).orderType(TradeOrderType.LIMIT).qty("0.1")
                .price("5").orderIv("0.1").timeInForce(TimeInForce.GoodTillCancel).orderLinkId("82ee86dd-001").mmp(false).reduceOnly(false).build());
                var createBatchOrders = BatchOrderRequest.builder().category(ProductType.OPTION).request(orderRequests).build();
                client.createBatchOrder(createBatchOrders, System.out::println);
```
- Position Info
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
        BybitApiAsyncRestClient client = factory.newAsyncRestClient();

        // Get Position Info
        var positionListRequest = PositionDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").build();
        client.getPositionInfo(positionListRequest, System.out::println);
```
- Place Batch Order
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
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
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        BybitApiRestClient client = factory.newRestClient();

        var marketKLineRequest = MarketDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").marketInterval(MarketInterval.WEEKLY).build();
        // Weekly market Kline
        var marketKlineResult = client.getMarketLinesData(marketKLineRequest);
        System.out.println(marketKlineResult);
```
- Account Data Info
```java
  BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET");
  BybitApiRestClient client = factory.newRestClient();

        // Get wallet balance
        var walletBalanceRequest = AccountDataRequest.builder().accountType(AccountType.UNIFIED).build();
        var walletBalanceData = client.getWalletBalance(walletBalanceRequest);
        System.out.println(walletBalanceData);
```

- Websocket public channel
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        var client = factory.newWebsocketClient((message) -> System.out.println("Handle message :" + message));

        // Orderbook
        client.getOrderBookStream(List.of("orderbook.50.BTCUSDT"), BybitApiConfig.V5_PUBLIC_LINEAR);
```

- Websocket private channel
```java
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance("YOUR_API_KEY","YOUR_API_SECRET",true);
        var client = factory.newWebsocketClient((message) -> System.out.println("Handle message :" + message));

        // Order
        client.getOrderBookStream(List.of("order"), BybitApiConfig.V5_PRIVATE);
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