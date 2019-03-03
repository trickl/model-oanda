
package com.trickl.model.oanda.transaction;

/**
 * The reason for the delayed trade closure.
 */
public enum DelayedTradeClosureReason {
    CLIENT_ORDER,
    TRADE_CLOSE,
    POSITION_CLOSEOUT,
    MARGIN_CLOSEOUT,
    DELAYED_TRADE_CLOSE
}
