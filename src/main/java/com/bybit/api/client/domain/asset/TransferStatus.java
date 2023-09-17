package com.bybit.api.client.domain.asset;

import lombok.Getter;

@Getter
public enum TransferStatus {
    SUCCESS("SUCCESS"),
    PENDING("PENDING"),
    FAILED("FAILED");

    private final String status;

    TransferStatus(String status) {
        this.status = status;
    }
}

