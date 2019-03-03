package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.order.TimeInForce;
import lombok.Data;

/**
 * TrailingStopLossDetails specifies the details of a Trailing Stop Loss Order to be created on
 * behalf of a client. This may happen when an Order is filled that opens a Trade requiring a
 * Trailing Stop Loss, or when a Trade's dependent Trailing Stop Loss Order is modified directly
 * through the Trade.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"distance", "timeInForce", "gtdTime", "clientExtensions"})
@Data
public class TrailingStopLossDetails {

  /**
   * The distance (in price units) from the Trade's fill price that the Trailing Stop Loss Order
   * will be triggered at.
   */
  @JsonPropertyDescription(
      "The distance (in price units) from the Trade's fill price that the Trailing"
              + " Stop Loss Order will be triggered at.")
  private String distance;

  /**
   * The time in force for the created Trailing Stop Loss Order. This may only be GTC, GTD or GFD.
   */
  @JsonPropertyDescription(
      "The time in force for the created Trailing Stop Loss Order. This may only be"
              + " GTC, GTD or GFD.")
  private TimeInForce timeInForce;

  /** The date when the Trailing Stop Loss Order will be cancelled on if timeInForce is GTD. */
  @JsonPropertyDescription(
      "The date when the Trailing Stop Loss Order will be cancelled on if timeInForce is GTD.")
  private String gtdTime;

  private Object clientExtensions;
}
