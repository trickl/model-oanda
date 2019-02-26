package com.trickl.model.oanda.order;

/** The state to filter the requested Orders by. */
public enum OrderStateFilter {
  PENDING,
  FILLED,
  TRIGGERED,
  CANCELLED,
  ALL
}
