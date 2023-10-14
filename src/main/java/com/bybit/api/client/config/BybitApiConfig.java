package com.bybit.api.client.config;

import lombok.Getter;

/**
 * Configuration used for Bybit operations.
 */
public class BybitApiConfig {
    /**
     * Mainnet domain for URLs.
     */
    public static final String MAINNET_DOMAIN = "https://api.bybit.com";
    /**
     * Testnet Network URL.
     */
    public static final String TESTNET_DOMAIN = "https://api-testnet.bybit.com";
    /**
     * Testnet websocket url
     */
    public static final String STREAM_TESTNET_DOMAIN = "wss://stream-testnet.bybit.com";
    /**
     * Mainnet websocket url
     */
    public static final String STREAM_MAINNET_DOMAIN = "wss://stream.bybit.com";

    /**
     * bybit Spot Test Network option:
     * true if endpoint is spot test network URL; false if endpoint is production spot API URL.
     */
    public static boolean useTestnet;

    public static final String V5_PUBLIC_SPOT = "/v5/public/spot";
    public static final String V5_PUBLIC_LINEAR = "/v5/public/linear";
    public static final String V5_PUBLIC_INVERSE = "/v5/public/inverse";
    public static final String V5_PUBLIC_OPTION = "/v5/public/option";
    public static final String V3_PUBLIC_OPTION = "/option/usdc/public/v3";

    public static final String v2_PUBLIC_SPOT = "/spot/quote/ws/v2";

    public static final String V5_PRIVATE = "/v5/private";

    public static final String V3_CONTRACT_PRIVATE = "/contract/private/v3";
    public static final String V3_UNIFIED_PRIVATE = "/unified/private/v3";
    public static final String V3_CONTRACT_USDT_PUBLIC = "/contract/usdt/public/v3";
    public static final String V3_SPOT_PRIVATE = "/spot/private/v3";
    public static final String V1_SPOT_PRIVATE = "/spot/ws";

    public static final String V2_USDT_PRIVATE = "/realtime_private";

    public static final String V2_USDT_PUBLIC = "/realtime_public";

    public static final String USDC_V1_PRIVATE = "/trade/option/usdc/private/v1";
}
