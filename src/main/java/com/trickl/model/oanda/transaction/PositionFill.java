package com.trickl.model.oanda.transaction;

/** Specification of how Positions in the Account are modified when the Order is filled. */
enum PositionFill {
  OPEN_ONLY,
  REDUCE_FIRST,
  REDUCE_ONLY,
  DEFAULT
}
