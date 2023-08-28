package com.bybit.api.client.impl;

/**
 * BybitApiCallback is a functional interface used together with the BybitApiAsyncClient to provide a non-blocking REST client.
 *
 * @param <T> the return type from the callback
 */
public interface BybitApiCallback<T> {

    /**
     * Called whenever a response comes back from the Bybit API.
     *
     * @param response the expected response object
     */
    void onResponse(T response);

    /**
     * Called whenever an error occurs.
     *
     * @param cause the cause of the failure
     */
    default void onFailure(Throwable cause) {}
}
