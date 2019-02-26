package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

public enum WeeklyAlignment {
  MONDAY("Monday"),
  TUESDAY("Tuesday"),
  WEDNESDAY("Wednesday"),
  THURSDAY("Thursday"),
  FRIDAY("Friday"),
  SATURDAY("Saturday"),
  SUNDAY("Sunday");
  private final String value;
  private static final Map<String, WeeklyAlignment> CONSTANTS =
      new HashMap<String, WeeklyAlignment>();

  static {
    for (WeeklyAlignment c : values()) {
      CONSTANTS.put(c.value, c);
    }
  }

  private WeeklyAlignment(String value) {
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
   * Parse the enum from a string.
   * @param value The string representation
   * @return  The enum
   */
  @JsonCreator
  public static WeeklyAlignment fromValue(String value) {
    WeeklyAlignment constant = CONSTANTS.get(value);
    if (constant == null) {
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
}
