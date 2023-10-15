package com.bybit.api.client.service;

import com.bybit.api.client.domain.trade.PositionIdx;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PositionIdxSerializer extends JsonSerializer<PositionIdx> {
    @Override
    public void serialize(PositionIdx value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(value.getIndex());
    }
}
