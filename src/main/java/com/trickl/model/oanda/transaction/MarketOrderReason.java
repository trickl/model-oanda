package com.trickl.model.oanda.transaction;

/** The reason that the Market Order was created. */
enum MarketOrderReason {
    CLIENT_ORDER,
    TRADE_CLOSE,
    POSITION_CLOSEOUT,
    MARGIN_CLOSEOUT,
    DELAYED_TRADE_CLOSE
}
