package com.trickl.model.oanda.order;

/** Specification of how Positions in the Account are modified when the Order is filled. */
public enum OrderPositionFill {
  OPEN_ONLY,
  REDUCE_FIRST,
  REDUCE_ONLY,
  DEFAULT,
  POSITION_DEFAULT,
}
