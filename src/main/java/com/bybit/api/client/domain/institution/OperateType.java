package com.bybit.api.client.domain.institution;

import lombok.Getter;

@Getter
public enum OperateType {
    BIND("0"),
    UNBIND("1");

    private final String operateType;
    OperateType(String operateType) {
        this.operateType = operateType;
    }
}
