package com.bybit.api.client.exception;

import lombok.Getter;

/**
 * An exception which can occur while invoking methods of the Bybit API.
 */
@Getter
public class BybitApiException extends RuntimeException {

    private static final long serialVersionUID = 3788669840036201041L;
    /**
     * Error response object returned by Bybit API.
     * -- GETTER --
     */
    private BybitApiError error;

    /**
     * Instantiates a new Bybit api exception.
     *
     * @param error an error response object
     */
    public BybitApiException(BybitApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new Bybit api exception.
     */
    public BybitApiException() {
        super();
    }

    /**
     * Instantiates a new Bybit api exception.
     *
     * @param message the message
     */
    public BybitApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Bybit api exception.
     *
     * @param cause the cause
     */
    public BybitApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Bybit api exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public BybitApiException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
