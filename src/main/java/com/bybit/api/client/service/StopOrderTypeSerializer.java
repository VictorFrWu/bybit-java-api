package com.bybit.api.client.service;
import com.bybit.api.client.domain.trade.StopOrderType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;

import java.io.IOException;
public class StopOrderTypeSerializer extends JsonSerializer<StopOrderType>{
    @Override
    public void serialize(StopOrderType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.getDescription());
    }
}
