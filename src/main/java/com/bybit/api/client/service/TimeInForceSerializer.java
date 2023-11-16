package com.bybit.api.client.service;
import com.bybit.api.client.domain.trade.TimeInForce;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;

import java.io.IOException;
public class TimeInForceSerializer extends JsonSerializer<TimeInForce> {
    @Override
    public void serialize(TimeInForce value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.getDescription()[0]);
    }
}
