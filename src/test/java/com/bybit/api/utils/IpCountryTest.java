package com.bybit.api.utils;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

import static org.junit.Assert.assertEquals;

public class IpCountryTest {
        @Test
        public void testGetCountryByIP() {
            String ip = "3.23.186.221";
            String country = getCountryByIP(ip);
            System.out.println("Country for IP " + ip + " is: " + country);
            assertEquals(country, "US");
        }

        public static String getCountryByIP(String ip) {
            String urlString = "http://ipinfo.io/" + ip + "/json";
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                JSONObject obj = new JSONObject(content.toString());
                return obj.getString("country");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

}
