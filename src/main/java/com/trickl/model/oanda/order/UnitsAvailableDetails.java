package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Representation of many units of an Instrument are available to be traded for both long and short
 * Orders.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"long", "short"})
public class UnitsAvailableDetails {

  /** The units available for long Orders. */
  @JsonProperty("long")
  @JsonPropertyDescription("The units available for long Orders.")
  private String longUnitsAvailable;
  
  /** The units available for short Orders. */
  @JsonProperty("short")
  @JsonPropertyDescription("The units available for short Orders.")
  private String shortUnitsAvailable;
}
