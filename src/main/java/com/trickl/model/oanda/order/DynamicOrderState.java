package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * The dynamic state of an Order. This is only relevant to TrailingStopLoss Orders, as no other
 * Order type has dynamic state.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "trailingStopValue", "triggerDistance", "isTriggerDistanceExact"})
@Data
public class DynamicOrderState {

  /** The Order's ID. */
  @JsonPropertyDescription("The Order's ID.")
  public String id;

  /** The Order's calculated trailing stop value. */
  @JsonPropertyDescription("The Order's calculated trailing stop value.")
  public String trailingStopValue;

  /**
   * The distance between the Trailing Stop Loss Order's trailingStopValue and the current Market
   * Price. This represents the distance (in price units) of the Order from a triggering price. If
   * the distance could not be determined, this value will not be set.
   */
  @JsonPropertyDescription(
      "The distance between the Trailing Stop Loss Order's trailingStopValue "
              + "and the current Market Price. This represents the distance "
              + "(in price units) of the Order from a triggering price. If the"
              + " distance could not be determined, this value will not be set.")
  public String triggerDistance;

  /**
   * True if an exact trigger distance could be calculated. If false, it means the provided trigger
   * distance is a best estimate. If the distance could not be determined, this value will not be
   * set.
   */
  @JsonPropertyDescription(
      "True if an exact trigger distance could be calculated. If false, "
              + "it means the provided trigger distance is a best estimate."
              + " If the distance could not be determined, this value will"
              + " not be set.")
  public Boolean isTriggerDistanceExact;
}
