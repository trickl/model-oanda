package com.trickl.model.oanda.position;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/** The representation of a Position for a single direction (long or short). */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "units",
    "averagePrice",
    "tradeIDs",
    "pl",
    "unrealizedPL",
    "resettablePL",
    "financing",
    "guaranteedExecutionFees"
})
@Data
@Builder
public class PositionSide {

  /**
   * Number of units in the position (negative value indicates short position, positive indicates
   * long position).
   */
  @JsonPropertyDescription(
      "Number of units in the position (negative value indicates short position,"
              + " positive indicates long position).")
  private BigDecimal units;
  
  /** Volume-weighted average of the underlying Trade open prices for the Position. */
  @JsonPropertyDescription(
      "Volume-weighted average of the underlying Trade open prices for the Position.")  
  private BigDecimal averagePrice;
  
  /** List of the open Trade IDs which contribute to the open Position. */
  @JsonProperty("tradeIDs")
  @JsonPropertyDescription("List of the open Trade IDs which contribute to the open Position.")
  private List<String> tradeIds = null;
  
  /** Profit/loss realized by the PositionSide over the lifetime of the Account. */
  @JsonProperty("pl")
  @JsonPropertyDescription(
      "Profit/loss realized by the PositionSide over the lifetime of the Account.")
  private BigDecimal pandl;
  
  /** The unrealized profit/loss of all open Trades that contribute to this PositionSide. */
  @JsonProperty("unrealizedPL")
  @JsonPropertyDescription(
      "The unrealized profit/loss of all open Trades that contribute to this PositionSide.")
  private BigDecimal unrealizedPandL;
 
  /**
   * Profit/loss realized by the PositionSide since the Account's resettablePL was last reset by the
   * client.
   */
  @JsonProperty("resettablePL")
  @JsonPropertyDescription(
      "Profit/loss realized by the PositionSide since the Account's resettablePL was"
              + " last reset by the client.")
  private BigDecimal resettablePandL;
  
  /**
   * The total amount of financing paid/collected for this PositionSide over the lifetime of the
   * Account.
   */
  @JsonPropertyDescription(
      "The total amount of financing paid/collected for this PositionSide over the "
              + "lifetime of the Account.")
  private BigDecimal financing;
  /**
   * The total amount of fees charged over the lifetime of the Account for the execution of
   * guaranteed Stop Loss Orders attached to Trades for this PositionSide.
   */
  @JsonPropertyDescription(
      "The total amount of fees charged over the lifetime of the Account for the "
              + "execution of guaranteed Stop Loss Orders attached to Trades "
              + "for this PositionSide.")
  private BigDecimal guaranteedExecutionFees;
}
