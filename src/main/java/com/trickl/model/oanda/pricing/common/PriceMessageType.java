package com.trickl.model.oanda.pricing.common;

import static lombok.AccessLevel.PRIVATE;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** The type of the Order. */
@RequiredArgsConstructor(access = PRIVATE)
public enum PriceMessageType {
  HEARTBEAT(PricingHeartbeat.class),
  PRICE(Price.class);
  
  @Getter private final Class<? extends PriceMessage> priceMessageClass;

  private static final Map<Class<? extends PriceMessage>, PriceMessageType> CONSTANTS =
      new HashMap<>();

  static {
    for (PriceMessageType c : values()) {
      CONSTANTS.put(c.priceMessageClass, c);
    }
  }

  /**
   * Create the enum from a string representation.
   *
   * @param priceMessageClass The order request class
   * @return The enum
   */
  @JsonCreator
  public static PriceMessageType fromPriceMessageClass(
      Class<? extends PriceMessage> priceMessageClass) {
    PriceMessageType constant = CONSTANTS.get(priceMessageClass);
    if (constant == null) {
      throw new IllegalArgumentException(priceMessageClass.toString());
    } else {
      return constant;
    }
  }
}
