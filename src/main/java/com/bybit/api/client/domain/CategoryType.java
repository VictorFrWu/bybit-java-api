package com.bybit.api.client.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 *  Category type. Spot,linear, inverse
 */
@Getter
public enum CategoryType {
    SPOT("spot"),
    LINEAR("linear"),
    INVERSE("inverse"),
    OPTION("option");
    private final String categoryTypeId;

    CategoryType(String categoryTypeId) {
        this.categoryTypeId = categoryTypeId;
    }
/*    @JsonValue
    public String getCategoryTypeId() {
        return categoryTypeId;
    }

    @JsonCreator
    public static CategoryType forValue(String value) {
        for (CategoryType categoryType : values()) {
            if (categoryType.getCategoryTypeId().equalsIgnoreCase(value)) {
                return categoryType;
            }
        }
        throw new IllegalArgumentException("Unknown category type: " + value);
    }*/
}
