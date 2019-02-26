package com.trickl.model.oanda.order;

/**
 * The time-in-force of an Order. TimeInForce describes how long an Order should remain pending
 * before being automatically cancelled by the execution system.
 */
public enum TimeInForce {
  GTC,
  GTD,
  GFD,
  FOK,
  IOC
}
