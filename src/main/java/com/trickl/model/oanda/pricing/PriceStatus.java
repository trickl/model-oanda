package com.trickl.model.oanda.pricing;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * The status of the Price.
 * @author tgee
 */
public enum PriceStatus {
  TRADEABLE("tradeable"),
  NON_TRADEABLE("non-tradeable"),
  INVALID("invalid");
  
  private final String value;
  
  private static final Map<String, PriceStatus> CONSTANTS = new HashMap<String, PriceStatus>();

  static {
    for (PriceStatus c : values()) {
      CONSTANTS.put(c.value, c);
    }
  }

  private PriceStatus(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return this.value;
  }

  @JsonValue
  public String value() {
    return this.value;
  }

  /**
   * Create the enum from a string representation.
   * @param value The string representation
   * @return  The enum
   */
  @JsonCreator
  public static PriceStatus fromValue(String value) {
    PriceStatus constant = CONSTANTS.get(value);
    if (constant == null) {
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
}
