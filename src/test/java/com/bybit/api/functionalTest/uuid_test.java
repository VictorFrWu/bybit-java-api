package com.bybit.api.functionalTest;

import java.util.UUID;

public class uuid_test {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        System.out.println("Your UUID is: " + uuidAsString);
    }
}
