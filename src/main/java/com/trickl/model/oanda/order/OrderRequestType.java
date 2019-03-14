package com.trickl.model.oanda.order;

import static lombok.AccessLevel.PRIVATE;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** The type of the Order. */
@RequiredArgsConstructor(access = PRIVATE)
public enum OrderRequestType {
  MARKET(MarketOrderRequest.class),
  LIMIT(LimitOrderRequest.class),
  STOP(StopOrderRequest.class),
  MARKET_IF_TOUCHED(MarketIfTouchedOrderRequest.class),
  TAKE_PROFIT(TakeProfitOrderRequest.class),
  STOP_LOSS(StopLossOrderRequest.class),
  TRAILING_STOP_LOSS(TrailingStopLossOrderRequest.class);

  @Getter private final Class<? extends OrderRequest> orderRequestClass;

  private static final Map<Class<? extends OrderRequest>, OrderRequestType> CONSTANTS =
      new HashMap<Class<? extends OrderRequest>, OrderRequestType>();

  static {
    for (OrderRequestType c : values()) {
      CONSTANTS.put(c.orderRequestClass, c);
    }
  }

  /**
   * Create the enum from a string representation.
   *
   * @param orderRequestClass The order request class
   * @return The enum
   */
  @JsonCreator
  public static OrderRequestType fromOrderRequestClass(
      Class<? extends OrderRequest> orderRequestClass) {
    OrderRequestType constant = CONSTANTS.get(orderRequestClass);
    if (constant == null) {
      throw new IllegalArgumentException(orderRequestClass.toString());
    } else {
      return constant;
    }
  }
}
