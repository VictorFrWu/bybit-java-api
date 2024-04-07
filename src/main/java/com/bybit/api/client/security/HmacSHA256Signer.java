package com.bybit.api.client.security;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import com.bybit.api.client.util.ParameterChecker;
import org.jetbrains.annotations.NotNull;

/**
 * Utility class to sign messages using HMAC-SHA256.
 */
public class HmacSHA256Signer implements SignatureGenerator {

    private final String apiSecret;

    public HmacSHA256Signer(String apiSecret) {
        ParameterChecker.checkParameterType(apiSecret, String.class, "apiSecret");
        this.apiSecret = apiSecret;
    }

    /**
     * Sign the given message using the given secret.
     *
     * @param apiKey     api key
     * @param apiSecret  api secret
     * @param payload    query parameters
     * @param timestamp  current time in milliseconds
     * @param recvWindow server receives window
     * @return a signed message
     */
    public static String sign(String apiKey, String apiSecret, String payload, String timestamp, String recvWindow) {
        try {
            String message = timestamp + apiKey + recvWindow + payload;
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(apiSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256_HMAC.init(secretKeySpec);
            byte[] hash = sha256_HMAC.doFinal(message.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }


    public String auth(String data) {
        return getSignatureString(data, apiSecret);
    }

    @NotNull
    private static String getSignatureString(String data, String apiSecret) {
        byte[] hmacSha256;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(apiSecret.getBytes(), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            hmacSha256 = mac.doFinal(data.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate hmac-sha256", e);
        }
        return Hex.encodeHexString(hmacSha256);
    }

    public static String getSignature(String data, String secret) {
        return getSignatureString(data, secret);
    }
}