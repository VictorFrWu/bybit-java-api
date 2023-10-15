package com.bybit.api.client.service;
import com.bybit.api.client.domain.trade.SmpType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;

import java.io.IOException;
public class SmpTypeSerializer extends JsonSerializer<SmpType> {
    @Override
    public void serialize(SmpType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.getDescription());
    }
}