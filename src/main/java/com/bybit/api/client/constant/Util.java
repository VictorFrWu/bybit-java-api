package com.bybit.api.client.constant;

import java.util.HashMap;
import java.util.List;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public static Map<String, Object> convertQueryToMap(String query) {
        Map<String, Object> result = new HashMap<>();
        if (query == null || query.isEmpty()) {
            return result;
        }

        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            }
        }

        return result;
    }

    public static String generateTransferID()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String convertMapToJson(Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(map);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert map to JSON", e);
        }
    }
}