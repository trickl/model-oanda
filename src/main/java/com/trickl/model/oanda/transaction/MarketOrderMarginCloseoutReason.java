package com.trickl.model.oanda.transaction;

/**
 * The reason that the Market Order was created to perform a margin closeout.
 */
public enum MarketOrderMarginCloseoutReason {
    MARGIN_CHECK_VIOLATION,
    REGULATORY_MARGIN_CALL_VIOLATION,
    REGULATORY_MARGIN_CHECK_VIOLATION
}
