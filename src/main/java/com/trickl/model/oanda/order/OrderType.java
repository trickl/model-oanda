package com.trickl.model.oanda.order;

import static lombok.AccessLevel.PRIVATE;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** The type of the Order. */
@RequiredArgsConstructor(access = PRIVATE)
public enum OrderType {
  MARKET(MarketOrder.class),
  LIMIT(LimitOrder.class),
  STOP(StopOrder.class),
  MARKET_IF_TOUCHED(MarketIfTouchedOrder.class),
  TAKE_PROFIT(TakeProfitOrder.class),
  STOP_LOSS(StopLossOrder.class),
  TRAILING_STOP_LOSS(TrailingStopLossOrder.class),
  FIXED_PRICE(FixedPriceOrder.class);

  @Getter private final Class<? extends Order> orderClass;

  private static final Map<Class<? extends Order>, OrderType> CONSTANTS =
      new HashMap<Class<? extends Order>, OrderType>();

  static {
    for (OrderType c : values()) {
      CONSTANTS.put(c.orderClass, c);
    }
  }

  /**
   * Create the enum from a string representation.
   *
   * @param orderClass The order class
   * @return The enum
   */
  @JsonCreator
  public static OrderType fromOrderClass(Class<? extends Order> orderClass) {
    OrderType constant = CONSTANTS.get(orderClass);
    if (constant == null) {
      throw new IllegalArgumentException(orderClass.toString());
    } else {
      return constant;
    }
  }
}
