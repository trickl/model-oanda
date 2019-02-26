package com.trickl.model.oanda.order;

/** The type of the Order. */
public enum CancellableOrderType {
  LIMIT,
  STOP,
  MARKET_IF_TOUCHED,
  TAKE_PROFIT,
  STOP_LOSS,
  TRAILING_STOP_LOSS
}
