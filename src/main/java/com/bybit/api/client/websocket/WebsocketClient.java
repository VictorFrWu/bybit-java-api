package com.bybit.api.client.websocket;

import okhttp3.WebSocket;

import java.util.List;

public interface WebsocketClient {
    void onMessage(String msg);
    void onError(Throwable t);
    void onClose(int code, String reason);
    void onOpen(WebSocket ws);
    void connect();

    /**
     * Orderbook
     * Subscribe to the orderbook stream. Supports different depths.
     *
     * TIP
     * Once you have subscribed successfully, you will receive a snapshot.
     * The WebSocket will keep pushing delta messages every time the orderbook changes. If you receive a new snapshot message, you will have to reset your local orderbook.
     * If there is a problem on Bybit's end, a snapshot will be re-sent, which is guaranteed to contain the latest data.
     * INFO
     * Linear & inverse level 1 data: if 3 seconds have elapsed without a change in the orderbook, a snapshot message will be pushed again.
     *
     * Linear & inverse:
     * Level 1 data, push frequency: 10ms
     * Level 50 data, push frequency: 20ms
     * Level 200 data, push frequency: 100ms
     * Level 500 data, push frequency: 100ms
     *
     * Spot:
     * Level 1 data, push frequency: 10ms
     * Level 50 data, push frequency: 20ms
     * Level 200 data, push frequency: 200ms
     *
     * Option:
     * Level 25 data, push frequency: 20ms
     * Level 100 data, push frequency: 100ms
     *
     * Topic:
     * orderbook.{depth}.{symbol} e.g., orderbook.1.BTCUSDT
     * https://bybit-exchange.github.io/docs/v5/websocket/public/orderbook

     */
    void getOrderBookStream(List<String> argNames, String path);

    /**
     * Trade
     * Subscribe to the recent trades stream.
     *
     * After subscription, you will be pushed trade messages in real-time.
     *
     * Push frequency: real-time
     *
     * Topic:
     * publicTrade.{symbol}
     * Note: option uses baseCoin, e.g., publicTrade.BTC
     * https://bybit-exchange.github.io/docs/v5/websocket/public/trade

     */
    void getTradeStream(List<String> argNames, String path);

    /**
     * Ticker
     * Subscribe to the ticker stream.
     *
     * NOTE
     * This topic utilises the snapshot field and delta field. If a response param is not found in the message, then its value has not changed.
     * Spot & Option tickers message are snapshot only
     * Push frequency: Derivatives & Options - 100ms, Spot - real-time
     *
     * Topic:
     * tickers.{symbol}
     * https://bybit-exchange.github.io/docs/v5/websocket/public/ticker

     */
    void getTickerStream(List<String> argNames, String path);

    /**
     * Kline
     * Subscribe to the klines stream.
     *
     * TIP
     * If confirm=true, this means that the candle has closed. Otherwise, the candle is still open and updating.
     *
     * Available intervals:
     *
     * 1 3 5 15 30 (min)
     * 60 120 240 360 720 (min)
     * D (day)
     * W (week)
     * M (month)
     * Push frequency: 1-60s
     *
     * Topic:
     * kline.{interval}.{symbol} e.g., kline.30.BTCUSDT
     * https://bybit-exchange.github.io/docs/v5/websocket/public/kline

     */
    void getMarketKlineStream(List<String> argNames, String path);

    /**
     * Liquidation
     * Subscribe to the liquidation stream
     *
     * Push frequency: real-time
     *
     * Topic:
     * liquidation.{symbol} e.g., liquidation.BTCUSDT
     * https://bybit-exchange.github.io/docs/v5/websocket/public/liquidation

     */
    void getLiquidationStream(List<String> argNames, String path);

    /**
     * LT Kline
     * Subscribe to the leveraged token kline stream.
     *
     * TIP
     * If confirm=true, this means that the candle has closed. Otherwise, the candle is still open and updating.
     *
     * Available intervals:
     *
     * 1 3 5 15 30 (min)
     * 60 120 240 360 720 (min)
     * D (day)
     * W (week)
     * M (month)
     * Push frequency: 1-60s
     *
     * Topic:
     * kline_lt.{interval}.{symbol} e.g., kline_lt.30.BTC3SUSDT
     * https://bybit-exchange.github.io/docs/v5/websocket/public/etp-kline

     */
    void getLeverageKlineStream(List<String> argNames, String path);

    /**
     * LT Ticker
     * Subscribe to the leveraged token ticker stream.
     *
     * Push frequency: 300ms
     *
     * Topic:
     * tickers_lt.{symbol} e.g.,tickers_lt.BTC3SUSDT
     * https://bybit-exchange.github.io/docs/v5/websocket/public/etp-ticker

     */
    void getLeverageTickerStream(List<String> argNames, String path);

    /**
     * LT Nav
     * Subscribe to the leveraged token nav stream.
     *
     * Push frequency: 300ms
     *
     * Topic:
     * lt.{symbol} e.g.,lt.BTC3SUSDT
     * https://bybit-exchange.github.io/docs/v5/websocket/public/etp-nav

     */
    void getLeverageNavStream(List<String> argNames, String path);

    /**
     * Position
     * Subscribe to the position stream to see changes to your position data in real-time.
     *
     * All-In-One Topic: position
     * Categorised Topic: position.linear, position.inverse, position.option
     *
     * INFO
     * All-In-One topic and Categorised topic cannot be in the same subscription request
     * All-In-One topic: Allow you to listen to all categories (linear, inverse, option) websocket updates
     * Categorised Topic: Allow you to listen only to specific category websocket updates
     * https://bybit-exchange.github.io/docs/v5/websocket/private/position

     */
    void getPositionStream(List<String> argNames, String path);

    /**
     * Execution
     * Subscribe to the execution stream to see your executions in real-time.
     *
     * TIP
     * You may have multiple executions for one order in a single message.
     *
     * All-In-One Topic: execution
     * Categorised Topic: execution.spot, execution.linear, execution.inverse, execution.option
     *
     * INFO
     * All-In-One topic and Categorised topic cannot be in the same subscription request
     * All-In-One topic: Allow you to listen to all categories (spot, linear, inverse, option) websocket updates
     * Categorised Topic: Allow you to listen only to specific category websocket updates
     * https://bybit-exchange.github.io/docs/v5/websocket/private/execution

     */
    void getExecutionStream(List<String> argNames, String path);

    /**
     * Order
     * Subscribe to the order stream to see changes to your orders in real-time.
     *
     * All-In-One Topic: order
     * Categorised Topic: order.spot, order.linear, order.inverse, order.option
     *
     * INFO
     * All-In-One topic and Categorised topic cannot be in the same subscription request
     * All-In-One topic: Allow you to listen to all categories (spot, linear, inverse, option) websocket updates
     * Categorised Topic: Allow you to listen only to specific category websocket updates
     * https://bybit-exchange.github.io/docs/v5/websocket/private/order

     */
    void getOrderStream(List<String> argNames, String path);

    /**
     * Wallet
     * Subscribe to the wallet stream to see changes to your wallet in real-time.
     *
     * Topic: wallet
     * https://bybit-exchange.github.io/docs/v5/websocket/private/wallet

     */
    void getWalletStream(List<String> argNames, String path);

    /**
     * Greek
     * Subscribe to the greeks stream to see changes to your greeks data in real-time. option only.
     *
     * Topic: greeks
     * https://bybit-exchange.github.io/docs/v5/websocket/private/greek
     */
    void getGreekStream(List<String> argNames, String path);

    /**
     * Dcp
     * Subscribe to the dcp stream to trigger DCP function.
     *
     * For example, connection A subscribes "dcp", connection B does not and connection C subscribes "dcp".
     *
     * If A is alive, B is dead, C is alive, then this case will not trigger DCP.
     * If A is alive, B is dead, C is dead, then this case will not trigger DCP.
     * If A is dead, B is alive, C is dead, then DCP is triggered when reach the timeWindow threshold
     * To sum up, for those private connections subscribing "dcp" topic are all dead, then DCP will be triggered.
     *
     * Topic: dcp
     * https://bybit-exchange.github.io/docs/v5/websocket/private/dcp
     */
    void getDcpStream(List<String> argNames, String path);
}
