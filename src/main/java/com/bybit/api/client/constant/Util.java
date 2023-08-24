package com.bybit.api.client.constant;

import java.util.List;
import java.time.Instant;

/**
 * Utility class
 */
public final class Util {

    public static long generateTimestamp() {
        return Instant.now().toEpochMilli();
    }

    /**
     * List of fiat currencies.
     */
    public static final List<String> FIAT_CURRENCY = List.of("USDT", "BUSD", "PAX", "TUSD", "USDC", "NGN", "RUB", "USDS", "TRY");

    public static final String BTC_TICKER = "BTC";

    private Util() {

    }

    /**
     * Check if the ticker is fiat currency.
     */
    public static boolean isFiatCurrency(String symbol) {
        for (String fiat : FIAT_CURRENCY) {
            if (symbol.equals(fiat)) return true;
        }
        return false;
    }
}