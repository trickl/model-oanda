package com.trickl.model.oanda.transaction;

/** The reason that the Trailing Stop Loss Order was initiated. */
enum TrailingStopLossOrderReason {
  CLIENT_ORDER,
  REPLACEMENT,
  ON_FILL
}
