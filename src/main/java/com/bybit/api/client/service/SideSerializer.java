package com.bybit.api.client.service;

import com.bybit.api.client.domain.trade.Side;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class SideSerializer extends JsonSerializer<Side> {
    @Override
    public void serialize(Side value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.getTransactionSide());
    }
}
