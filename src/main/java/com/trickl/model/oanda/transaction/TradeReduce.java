package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * A TradeReduce object represents a Trade for an instrument that was reduced (either partially or
 * fully) in an Account. It is found embedded in Transactions that affect the position of an
 * instrument in the account, specifically the OrderFill Transaction.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tradeID",
    "units",
    "price",
    "realizedPL",
    "financing",
    "guaranteedExecutionFee",
    "halfSpreadCost"
})
@Data
public class TradeReduce {

  /** The ID of the Trade that was reduced or closed. */
  @JsonProperty("tradeID")
  @JsonPropertyDescription("The ID of the Trade that was reduced or closed")
  private String tradeId;
  
  /** The number of units that the Trade was reduced by. */
  @JsonPropertyDescription("The number of units that the Trade was reduced by")
  private String units;
  
  /**
   * The average price that the units were closed at. This price may be clamped for guaranteed Stop
   * Loss Orders.
   */
  @JsonPropertyDescription(
      "The average price that the units were closed at. This price may be clamped "
              + "for guaranteed Stop Loss Orders.")
  private String price;
  
  /** The PL realized when reducing the Trade. */
  @JsonProperty("realizedPL")
  @JsonPropertyDescription("The PL realized when reducing the Trade")
  private String realizedPandL;
 
  /** The financing paid/collected when reducing the Trade. */
  @JsonPropertyDescription("The financing paid/collected when reducing the Trade")
  private String financing;
  
  /**
   * This is the fee that is charged for closing the Trade if it has a guaranteed Stop Loss Order
   * attached to it.
   */
  @JsonPropertyDescription(
      "This is the fee that is charged for closing the Trade if it has a guaranteed "
              + "Stop Loss Order attached to it.")
  private String guaranteedExecutionFee;

  /**
   * The half spread cost for the trade reduce/close. This can be a positive or negative value and
   * is represented in the home currency of the Account.
   */
  @JsonPropertyDescription(
      "The half spread cost for the trade reduce/close. This can be a positive or"
              + " negative value and is represented in the home currency of the Account.")
  private String halfSpreadCost;
}
