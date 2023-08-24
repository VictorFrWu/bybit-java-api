package com.bybit.api.client.domain.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Reject reason. Normal spot is not supported
 */
public enum RejectReason {
    EC_NoError,
    EC_Others,
    EC_UnknownMessageType,
    EC_MissingClOrdID,
    EC_MissingOrigClOrdID,
    EC_ClOrdIDOrigClOrdIDAreTheSame,
    EC_DuplicatedClOrdID,
    EC_OrigClOrdIDDoesNotExist,
    EC_TooLateToCancel,
    EC_UnknownOrderType,
    EC_UnknownSide,
    EC_UnknownTimeInForce,
    EC_WronglyRouted,
    EC_MarketOrderPriceIsNotZero,
    EC_LimitOrderInvalidPrice,
    EC_NoEnoughQtyToFill,
    EC_NoImmediateQtyToFill,
    EC_PerCancelRequest,
    EC_MarketOrderCannotBePostOnly,
    EC_PostOnlyWillTakeLiquidity,
    EC_CancelReplaceOrder,
    EC_InvalidSymbolStatus,
    UNKNOWN;

    @JsonCreator
    public static RejectReason fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return UNKNOWN;
        }
        try {
            return RejectReason.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
