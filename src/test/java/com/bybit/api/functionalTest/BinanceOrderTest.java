package com.bybit.api.functionalTest;

import okhttp3.*;
import org.apache.commons.codec.binary.Hex;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Objects;

public class BinanceOrderTest {
    private static final String API_KEY = "2GLaXG6in1BA4zDuwdCj4ys3PovZ3qRJ9r6fhU7CHTjNJPNktz5c2KQz4ClcA6za";
    private static final String API_SECRET = "aBxWqhRuFhChhgR19sgl80Y0NfuaBB9DgTyVlRJuZhKupVDGoV8vWDzBs0CtN6Rd";
    private static final String SPOT_URL = "https://testnet.binance.vision";
    private static final String WS_URL = "wss://testnet.binance.vision/ws/";
    private static final OkHttpClient client = new OkHttpClient();
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, IOException, URISyntaxException {
        // get listen key from user data stream
        String listenKey = GetListenKey(client);

        // connect ws to listen order stream
        WebSocketClient wsClient = new BinanceWebSocketClient(new URI(WS_URL + listenKey));
        wsClient.connect();
    }

    public static class BinanceWebSocketClient extends WebSocketClient {

        public BinanceWebSocketClient(URI serverUri) {
            super(serverUri);
        }

        @Override
        public void onOpen(ServerHandshake handshakedata) {
            System.out.println("Opened WebSocket connection");
            // Place an order immediately after the WebSocket connection is open
            try {
                PlaceSpotOrder(client);
            } catch (IOException e) {
                System.err.println("Error placing order: " + e.getMessage());
                e.printStackTrace();
            }
        }

        @Override
        public void onMessage(String message) {
            try {
                JSONObject json = new JSONObject(message);
                if (json.getString("e").equals("executionReport")) {
                    System.out.println("Order Status: " + json.getString("X"));
                    System.out.println("Execution Type: " + json.getString("x"));
                    if (json.getString("x").equals("TRADE")) {
                        System.out.println("Filled Quantity: " + json.getString("z"));
                        System.out.println("Cumulative Quote Qty Transacted: " + json.getString("Z"));
                    }
                }
            } catch (JSONException e) {
                System.err.println("Failed to parse message: " + e.getMessage());
            }
        }

        @Override
        public void onClose(int code, String reason, boolean remote) {
            System.out.println("Closed with exit code " + code + " and reason: " + reason);
        }

        @Override
        public void onError(Exception ex) {
            System.out.println("An error occurred:" + ex.getMessage());
        }
    }

    private static String GetListenKey(OkHttpClient client) {
        Request request = new Request.Builder()
                .url(SPOT_URL + "/api/v3/userDataStream")
                .addHeader("X-MBX-APIKEY", API_KEY)
                .post(RequestBody.create("", null))  // An empty body for a POST request
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                String responseData = response.body().string();
                JSONObject jsonObject = new JSONObject(responseData);
                String listenKey = jsonObject.getString("listenKey");
                System.out.println("Received listen key: " + responseData);
                return listenKey;
            } else {
                throw new RuntimeException("Failed to get listen key: " + response);
            }
        } catch (Exception e) {
            System.err.println("Error while trying to get listen key: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private static void PlaceSpotOrder(OkHttpClient client) throws IOException {
        String symbol = "BTCUSDT", side = "BUY", type = "MARKET", quantity = "0.01";
        String timeStamp = String.valueOf(Instant.now().toEpochMilli());

        String queryParams = "symbol=" + symbol +
                "&side=" + side +
                "&type=" + type +
                "&quantity=" + quantity + // Fixed '=' sign here
                "&timestamp=" + timeStamp;
        String signature = getSignature(queryParams);

        HttpUrl url = Objects.requireNonNull(HttpUrl.parse(SPOT_URL + "/api/v3/order")).newBuilder()
                .addEncodedQueryParameter("symbol", symbol)
                .addEncodedQueryParameter("side", side)
                .addEncodedQueryParameter("type", type)
                .addEncodedQueryParameter("quantity", quantity)
                .addEncodedQueryParameter("timestamp", timeStamp)
                .addEncodedQueryParameter("signature", signature)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-MBX-APIKEY", API_KEY)
                .post(RequestBody.create(null, new byte[0]))
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("Response Code: " + response.code());
            System.out.println("Response Body: " + response.body().string()); // Proper response handling
        }
    }

    public static String getSignature(String data) {
        byte[] hmacSha256;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(API_SECRET.getBytes(), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            hmacSha256 = mac.doFinal(data.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate hmac-sha256", e);
        }
        return Hex.encodeHexString(hmacSha256);
    }
}
