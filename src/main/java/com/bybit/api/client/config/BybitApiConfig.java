package com.bybit.api.client.config;

/**
 * Configuration used for Bybit operations.
 */
public class BybitApiConfig {
    /**
     * Mainnet domain for URLs.
     */
    private static final String MAINNET_DOMAIN = "api.bybit.com";
    /**
     * Testnet Network URL.
     */
    private static final String TESTNET_DOMAIN = "api-testnet.bybit.com";
    /**
     * Testnet websocket url
     */
    private static final String STREAM_TESTNET_DOMAIN = "wss://stream-testnet.bybit.com";
    /**
     * Mainnet websocket url
     */
    private static final String STREAM_MAINNET_DOMAIN = "wss://stream.bybit.com";

    /**
     * bybit Spot Test Network option:
     * true if endpoint is spot test network URL; false if endpoint is production spot API URL.
     */
    public static boolean useTestnet;
    /**
     * Get the URL base domain name (e.g., bybit.com).
     *
     * @return The base domain for URLs
     */
    public static String getBaseDomain() {
        return MAINNET_DOMAIN;
    }

    /**
     * REST API base URL.
     */
    public static String getApiBaseUrl() {
        return String.format("https://%s", getBaseDomain());
    }
    /**
     * Spot Test Network API base URL.
     */
    public static String getTestNetBaseUrl() {
        return String.format("https://%s", TESTNET_DOMAIN);
    }

    /**
     * Streaming Testnet Network base URL.
     */
    public static String getStreamTestNetBaseUrl() {
        return String.format("wss://%s", STREAM_TESTNET_DOMAIN);
    }

    /**
     * Streaming Mainnet Network base URL.
     */
    public static String getStreamMainnetNetBaseUrl() {
        return String.format("wss://%s", STREAM_MAINNET_DOMAIN);
    }

    public static final String V5_PUBLIC_SPOT = "/v5/public/spot";
    public static final String V5_PUBLIC_LINEAR = "/v5/public/linear";
    public static final String V5_PUBLIC_INVERSE = "/v5/public/inverse";
    public static final String V5_PUBLIC_OPTION = "/v5/public/option";
    public static final String V5_PRIVATE = "/v5/private";
}
