package com.bybit.api.client.service;

import com.bybit.api.client.domain.TradeOrderType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class TradeOrderTypeSerializer extends JsonSerializer<TradeOrderType> {
    @Override
    public void serialize(TradeOrderType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.getOType());
    }
}
