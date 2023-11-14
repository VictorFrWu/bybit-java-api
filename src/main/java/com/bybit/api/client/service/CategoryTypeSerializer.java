package com.bybit.api.client.service;

import com.bybit.api.client.domain.CategoryType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;

import java.io.IOException;

public class CategoryTypeSerializer extends JsonSerializer<CategoryType> {
    @Override
    public void serialize(CategoryType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.getCategoryTypeId());
    }
}
