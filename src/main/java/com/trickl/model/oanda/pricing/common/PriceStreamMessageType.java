package com.trickl.model.oanda.pricing.common;

import static lombok.AccessLevel.PRIVATE;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** The type of the Order. */
@RequiredArgsConstructor(access = PRIVATE)
public enum PriceStreamMessageType {
  HEARTBEAT(PricingHeartbeat.class),
  PRICE(Price.class);

  @Getter private final Class<? extends PriceStreamMessage> priceStreamMessageClass;

  private static final Map<Class<? extends PriceStreamMessage>, PriceStreamMessageType> CONSTANTS =
      new HashMap<>();

  static {
    for (PriceStreamMessageType c : values()) {
      CONSTANTS.put(c.priceStreamMessageClass, c);
    }
  }

  /**
   * Create the enum from a string representation.
   *
   * @param priceStreamMessageClass The order request class
   * @return The enum
   */
  @JsonCreator
  public static PriceStreamMessageType fromPriceStreamMessageClass(
      Class<? extends PriceStreamMessage> priceStreamMessageClass) {
    PriceStreamMessageType constant = CONSTANTS.get(priceStreamMessageClass);
    if (constant == null) {
      throw new IllegalArgumentException(priceStreamMessageClass.toString());
    } else {
      return constant;
    }
  }
}
