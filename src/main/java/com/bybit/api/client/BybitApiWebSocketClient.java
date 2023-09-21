package com.bybit.api.client;

import com.bybit.api.client.BybitApiCallback;

import java.io.Closeable;

public interface BybitApiWebSocketClient extends Closeable {

    /**
     *  Orderbook
     * Subscribe to the orderbook stream. Supports different depths.
     *
     * TIP
     * Once you have subscribed successfully, you will receive a snapshot.
     * The WebSocket will keep pushing delta messages every time the orderbook changes. If you receive a new snapshot message, you will have to reset your local orderbook.
     * If there is a problem on Bybit's end, a snapshot will be re-sent, which is guaranteed to contain the latest data.
     * INFO
     * Linear & inverse level 1 data: if 3 seconds have elapsed without a change in the orderbook, a snapshot message will be pushed again.
     *  orderbook.{depth}.{symbol} e.g., orderbook.1.BTCUSDT
     * @param depth
     * @param symbol
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed
     * @return
     */
    Closeable onOrderBookDataUpdateEvent(String depth, String symbol, BybitApiCallback<Object> callback);

    /**
     * @deprecated This method is no longer functional. Please use the returned {@link Closeable} from any of the other methods to close the web socket.
     */
    @Deprecated
    void close();
}
