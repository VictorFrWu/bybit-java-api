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
     * @param strings
     * @param wssPath
     */
    void orderBookStream(List<String> strings, String wssPath);

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
     * @param strings
     * @param wssPath
     */
    void tradeInfoStream(List<String> strings, String wssPath);

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
     * @param strings
     * @param wssPath
     */
    void marketTickerStream(List<String> strings, String wssPath);

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
     * @param strings
     * @param wssPath
     */
    void marketKlineStream(List<String> strings, String wssPath);

    /**
     * Liquidation
     * Subscribe to the liquidation stream
     *
     * Push frequency: real-time
     *
     * Topic:
     * liquidation.{symbol} e.g., liquidation.BTCUSDT
     * https://bybit-exchange.github.io/docs/v5/websocket/public/liquidation
     * @param strings
     * @param wssPath
     */
    void liquidationStream(List<String> strings, String wssPath);

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
     * @param strings
     * @param wssPath
     */
    void leverageTokenKlineStream(List<String> strings, String wssPath);

    /**
     * LT Ticker
     * Subscribe to the leveraged token ticker stream.
     *
     * Push frequency: 300ms
     *
     * Topic:
     * tickers_lt.{symbol} e.g.,tickers_lt.BTC3SUSDT
     * https://bybit-exchange.github.io/docs/v5/websocket/public/etp-ticker
     * @param strings
     * @param wssPath
     */
    void leverageTickerStream(List<String> strings, String wssPath);

    /**
     * LT Nav
     * Subscribe to the leveraged token nav stream.
     *
     * Push frequency: 300ms
     *
     * Topic:
     * lt.{symbol} e.g.,lt.BTC3SUSDT
     * https://bybit-exchange.github.io/docs/v5/websocket/public/etp-nav
     * @param strings
     * @param wssPath
     */
    void leverageTickerNavStream(List<String> strings, String wssPath);
}
