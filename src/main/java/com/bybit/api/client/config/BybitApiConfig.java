package com.bybit.api.client.config;

/**
 * Configuration used for Bybit operations.
 */
public class BybitApiConfig {
    /**
     * Mainnet domain for URLs.
     */
    public static final String MAINNET_DOMAIN = "https://api.bybit.com";
    public static final String MAINNET_DOMAIN_BACKUP = "https://api.bytick.com";
    /**
     * Testnet Network URL.
     */
    public static final String TESTNET_DOMAIN = "https://api-testnet.bybit.com";
    /**
     * Testnet websocket url
     */
    public static final String STREAM_TESTNET_DOMAIN = "wss://stream-testnet.bybit.com";
    /**
     * Demo Trading Network URL.
     */
    public static final String DEMO_TRADING_DOMAIN = "https://api-demo.bybit.com";
    /**
     * Demo Trading websocket url
     */
    public static final String DEMO_TRADING_STREAM_DOMAIN = "wss://stream-demo.bybit.com";
    /**
     * Mainnet websocket url
     */
    public static final String STREAM_MAINNET_DOMAIN = "wss://stream.bybit.com";

    /**
     * bybit Spot Test Network option:
     * true if endpoint is spot test network URL; false if endpoint is production spot API URL.
     * @deprecated use base url to instead
     */
    @Deprecated
    public static boolean useTestnet;

    // V5
    public static final String V5_PUBLIC_SPOT = "/v5/public/spot";
    public static final String V5_PUBLIC_LINEAR = "/v5/public/linear";
    public static final String V5_PUBLIC_INVERSE = "/v5/public/inverse";
    public static final String V5_PUBLIC_OPTION = "/v5/public/option";
    public static final String V3_PUBLIC_OPTION = "/option/usdc/public/v3";
    public static final String V5_PRIVATE = "/v5/private";
    public static final String V5_TRADE = "/v5/trade";

    // V3 endpoint offline from end of August 2024
    @Deprecated
    public static final String V3_CONTRACT_PRIVATE = "/contract/private/v3";
    @Deprecated
    public static final String V3_UNIFIED_PRIVATE = "/unified/private/v3";
    @Deprecated
    public static final String V3_CONTRACT_USDT_PUBLIC = "/contract/usdt/public/v3";
    @Deprecated
    public static final String V3_SPOT_PRIVATE = "/spot/private/v3";
}
