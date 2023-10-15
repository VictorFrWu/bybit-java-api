package com.bybit.api.client.service;

import com.bybit.api.client.domain.ProductType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;

import java.io.IOException;

public class ProductTypeSerializer extends JsonSerializer<ProductType> {
    @Override
    public void serialize(ProductType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.getProductTypeId());
    }
}
