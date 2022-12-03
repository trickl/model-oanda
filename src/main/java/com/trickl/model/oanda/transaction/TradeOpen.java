package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A TradeOpen object represents a Trade for an instrument that was opened in an Account. It is
 * found embedded in Transactions that affect the position of an instrument in the Account,
 * specifically the OrderFill Transaction.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tradeID",
    "units",
    "price",
    "guaranteedExecutionFee",
    "clientExtensions",
    "halfSpreadCost",
    "initialMarginRequired"
})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TradeOpen {

  /** The ID of the Trade that was opened. */
  @JsonProperty("tradeID")
  @JsonPropertyDescription("The ID of the Trade that was opened")
  private String tradeId;
  
  /** The number of units opened by the Trade. */
  @JsonPropertyDescription("The number of units opened by the Trade")
  private String units;
  
  /** The average price that the units were opened at. */
  @JsonPropertyDescription("The average price that the units were opened at.")
  private String price;
  /**
   * This is the fee charged for opening the trade if it has a guaranteed Stop Loss Order attached
   * to it.
   */
  @JsonPropertyDescription(
      "This is the fee charged for opening the trade if it has a guaranteed Stop Loss"
              + " Order attached to it.")
  private String guaranteedExecutionFee;

  private ClientExtensions clientExtensions;
  
  /**
   * The half spread cost for the trade open. This can be a positive or negative value and is
   * represented in the home currency of the Account.
   */
  @JsonPropertyDescription(
      "The half spread cost for the trade open. This can be a positive or negative"
              + " value and is represented in the home currency of the Account.")
  private String halfSpreadCost;
  
  /**
   * The margin required at the time the Trade was created. Note, this is the 'pure' margin
   * required, it is not the 'effective' margin used that factors in the trade risk if a GSLO is
   * attached to the trade.
   */
  @JsonPropertyDescription(
      "The margin required at the time the Trade was created. Note, this is the 'pure'"
              + " margin required, it is not the 'effective' margin used that factors"
              + " in the trade risk if a GSLO is attached to the trade.")
  private String initialMarginRequired;
}
