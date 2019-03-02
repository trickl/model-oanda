package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * Representation of how many units of an Instrument are available to be traded by an Order
 * depending on its postionFill option.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"default", "reduceFirst", "reduceOnly", "openOnly"})
@Data
public class UnitsAvailable {

  @JsonProperty("default")
  private UnitsAvailableDetails defaultUnits;

  private UnitsAvailableDetails reduceFirst;

  private UnitsAvailableDetails reduceOnly;

  private UnitsAvailableDetails openOnly;
}
