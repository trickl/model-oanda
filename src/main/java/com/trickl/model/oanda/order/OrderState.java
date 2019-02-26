package com.trickl.model.oanda.order;

/** The current state of the Order. */
public enum OrderState {
  PENDING,
  FILLED,
  TRIGGERED,
  CANCELLED
}
