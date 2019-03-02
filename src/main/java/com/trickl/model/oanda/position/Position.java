package com.trickl.model.oanda.position;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** The specification of a Position within an Account. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "instrument",
    "pl",
    "unrealizedPL",
    "marginUsed",
    "resettablePL",
    "financing",
    "commission",
    "guaranteedExecutionFees",
    "long",
    "short"
})
public class Position {

  /** The Position's Instrument. */
  @JsonPropertyDescription("The Position's Instrument.")
  private String instrument;

  /** Profit/loss realized by the Position over the lifetime of the Account. */
  @JsonPropertyDescription("Profit/loss realized by the Position over the lifetime of the Account.")
  private String pandl;

  /** The unrealized profit/loss of all open Trades that contribute to this Position. */
  @JsonProperty("unrealizedPL")
  @JsonPropertyDescription(
      "The unrealized profit/loss of all open Trades that contribute to this Position.")
  private String unrealizedPandL;

  /** Margin currently used by the Position. */
  @JsonPropertyDescription("Margin currently used by the Position.")
  private String marginUsed;

  /**
   * Profit/loss realized by the Position since the Account's resettablePL was last reset by the
   * client.
   */
  @JsonProperty("resettablePL")
  @JsonPropertyDescription(
      "Profit/loss realized by the Position since the Account's resettablePL was last"
              + " reset by the client.")
  private String resettablePandL;

  /**
   * The total amount of financing paid/collected for this instrument over the lifetime of the
   * Account.
   */
  @JsonPropertyDescription(
      "The total amount of financing paid/collected for this instrument over the "
              + "lifetime of the Account.")
  private String financing;

  /** The total amount of commission paid for this instrument over the lifetime of the Account. */
  @JsonPropertyDescription(
      "The total amount of commission paid for this instrument over the lifetime of the Account.")
  private String commission;

  /**
   * The total amount of fees charged over the lifetime of the Account for the execution of
   * guaranteed Stop Loss Orders for this instrument.
   */
  @JsonPropertyDescription(
      "The total amount of fees charged over the lifetime of the Account for the "
              + "execution of guaranteed Stop Loss Orders for this instrument.")
  private String guaranteedExecutionFees;

  @JsonProperty("long")
  private PositionSide longSide;

  @JsonProperty("short")
  private PositionSide shortSide;
}
