package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.instrument.HasInstrument;
import com.trickl.model.oanda.pricing.ClientPrice;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/** An OrderFillTransaction represents the filling of an Order in the client's Account. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "time",
    "userID",
    "accountID",
    "batchID",
    "requestID",
    "type",
    "orderID",
    "clientOrderID",
    "instrument",
    "units",
    "gainQuoteHomeConversionFactor",
    "lossQuoteHomeConversionFactor",
    "price",
    "fullVWAP",
    "fullPrice",
    "reason",
    "pl",
    "financing",
    "commission",
    "guaranteedExecutionFee",
    "accountBalance",
    "tradeOpened",
    "tradesClosed",
    "tradeReduced",
    "halfSpreadCost"
})
@Data
@Builder
public class OrderFillTransaction extends Transaction
    implements HasInstrument {
  /**
   * The Type of the Transaction.
   */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type = TransactionStreamMessageType.ORDER_FILL;
  
  /** The ID of the Order filled. */
  @JsonProperty("orderID")
  @JsonPropertyDescription("The ID of the Order filled.")
  private String orderId;
  
  /** The client Order ID of the Order filled (only provided if the client has assigned one). */
  @JsonProperty("clientOrderID")
  @JsonPropertyDescription(
      "The client Order ID of the Order filled (only provided if the client has "
              + "assigned one).")
  private String clientOrderId;
  
  /** The name of the filled Order's instrument. */
  @JsonPropertyDescription("The name of the filled Order's instrument.")
  private String instrument;
  
  /** The number of units filled by the OrderFill. */
  @JsonPropertyDescription("The number of units filled by the OrderFill.")
  private String units;
  
  /**
   * This is the conversion factor in effect for the Account at the time of the OrderFill for
   * converting any gains realized in Instrument quote units into units of the Account's home
   * currency.
   */
  @JsonPropertyDescription(
      "This is the conversion factor in effect for the Account at the time of the"
              + " OrderFill for converting any gains realized in Instrument quote "
              + "units into units of the Account's home currency.")
  private String gainQuoteHomeConversionFactor;
  
  /**
   * This is the conversion factor in effect for the Account at the time of the OrderFill for
   * converting any losses realized in Instrument quote units into units of the Account's home
   * currency.
   */
  @JsonPropertyDescription(
      "This is the conversion factor in effect for the Account at the time of the "
              + "OrderFill for converting any losses realized in Instrument"
              + " quote units into units of the Account's home currency.")
  private String lossQuoteHomeConversionFactor;
  
  /**
   * This field is now deprecated and should no longer be used. The individual tradesClosed,
   * tradeReduced and tradeOpened fields contain the exact/official price each unit was filled at.
   */
  @JsonPropertyDescription(
      "This field is now deprecated and should no longer be used. The individual "
              + "tradesClosed, tradeReduced and tradeOpened fields contain the "
              + "exact/official price each unit was filled at.")
  private String price;
  
  /**
   * The price that all of the units of the OrderFill should have been filled at, in the absence of
   * guaranteed price execution. This factors in the Account's current ClientPrice, used liquidity
   * and the units of the OrderFill only. If no Trades were closed with their price clamped for
   * guaranteed stop loss enforcement, then this value will match the price fields of each Trade
   * opened, closed, and reduced, and they will all be the exact same.
   */
  @JsonPropertyDescription(
      "The price that all of the units of the OrderFill should have been filled at,"
              + " in the absence of guaranteed price execution. This factors in the"
              + " Account's current ClientPrice, used liquidity and the units of "
              + "the OrderFill only. If no Trades were closed with their price "
              + "clamped for guaranteed stop loss enforcement, then this value will "
              + "match the price fields of each Trade opened, closed, and reduced,"
              + " and they will all be the exact same.")
  private String fullVwap;
  
  private ClientPrice fullPrice;
  
  /** The reason that an Order was filled. */
  @JsonPropertyDescription("The reason that an Order was filled")
  private OrderFillReason reason;
  
  /** The profit or loss incurred when the Order was filled. */
  @JsonProperty("pl")
  @JsonPropertyDescription("The profit or loss incurred when the Order was filled.")
  private String pandl;
  
  /** The financing paid or collected when the Order was filled. */
  @JsonProperty("financing")
  @JsonPropertyDescription("The financing paid or collected when the Order was filled.")
  private String financing;
  
  /**
   * The commission charged in the Account's home currency as a result of filling the Order. The
   * commission is always represented as a positive quantity of the Account's home currency, however
   * it reduces the balance in the Account.
   */
  @JsonPropertyDescription(
      "The commission charged in the Account's home currency as a result of filling"
              + " the Order. The commission is always represented as a positive"
              + " quantity of the Account's home currency, however it reduces the "
              + "balance in the Account.")
  private String commission;
  
  /**
   * The total guaranteed execution fees charged for all Trades opened, closed or reduced with
   * guaranteed Stop Loss Orders.
   */
  @JsonPropertyDescription(
      "The total guaranteed execution fees charged for all Trades opened,"
              + " closed or reduced with guaranteed Stop Loss Orders.")
  private String guaranteedExecutionFee;
  
  /** The Account's balance after the Order was filled. */
  @JsonPropertyDescription("The Account's balance after the Order was filled.")
  private String accountBalance;

  @JsonProperty("tradeOpened")
  private TradeOpen tradeOpened;
  
  /**
   * The Trades that were closed when the Order was filled (only provided if filling the Order
   * resulted in a closing open Trades).
   */
  @JsonPropertyDescription(
      "The Trades that were closed when the Order was filled (only provided if "
              + "filling the Order resulted in a closing open Trades).")
  private List<TradeReduce> tradesClosed = null;

  private TradeReduce tradeReduced;
  
  /**
   * The half spread cost for the OrderFill, which is the sum of the halfSpreadCost values in the
   * tradeOpened, tradesClosed and tradeReduced fields. This can be a positive or negative value and
   * is represented in the home currency of the Account.
   */
  @JsonPropertyDescription(
      "The half spread cost for the OrderFill, which is the sum of the "
              + "halfSpreadCost values in the tradeOpened, tradesClosed "
              + "and tradeReduced fields. This can be a positive or negative value"
              + " and is represented in the home currency of the Account.")
  private String halfSpreadCost;
}
