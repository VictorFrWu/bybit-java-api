package com.bybit.api.client.security;

public interface SignatureGenerator {
    String auth(String payload);
}
