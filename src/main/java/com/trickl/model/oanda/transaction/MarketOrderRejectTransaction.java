package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.order.TimeInForce;
import lombok.Data;

/** A MarketOrderRejectTransaction represents the rejection of the creation of a Market Order. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "time",
    "userID",
    "accountID",
    "batchID",
    "requestID",
    "type",
    "instrument",
    "units",
    "timeInForce",
    "priceBound",
    "positionFill",
    "tradeClose",
    "longPositionCloseout",
    "shortPositionCloseout",
    "marginCloseout",
    "delayedTradeClose",
    "reason",
    "clientExtensions",
    "takeProfitOnFill",
    "stopLossOnFill",
    "trailingStopLossOnFill",
    "tradeClientExtensions",
    "rejectReason"
})
@Data
public class MarketOrderRejectTransaction {

  /** The Transaction's Identifier. */
  @JsonPropertyDescription("The Transaction's Identifier.")
  private String id;
  
  /** The date/time when the Transaction was created. */  
  @JsonPropertyDescription("The date/time when the Transaction was created.")
  private String time;
  
  /** The ID of the user that initiated the creation of the Transaction. */
  @JsonProperty("userID")
  @JsonPropertyDescription("The ID of the user that initiated the creation of the"
          + " Transaction.")
  private Integer userId;
  
  /** The ID of the Account the Transaction was created for. */
  @JsonProperty("accountID")
  @JsonPropertyDescription("The ID of the Account the Transaction was created for.")
  private String accountId;
  
  /**
   * The ID of the "batch" that the Transaction belongs to. Transactions in the same batch are
   * applied to the Account simultaneously.
   */
  @JsonProperty("batchID")
  @JsonPropertyDescription(
      "The ID of the \"batch\" that the Transaction belongs to. Transactions in"
              + " the same batch are applied to the Account simultaneously.")
  private String batchId;
  
  /** The Request ID of the request which generated the transaction. */
  @JsonProperty("requestID")
  @JsonPropertyDescription("The Request ID of the request which generated the transaction.")
  private String requestId;
  
  /**
   * The Type of the Transaction. Always set to "MARKET_ORDER_REJECT" in a
   * MarketOrderRejectTransaction.
   */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"MARKET_ORDER_REJECT\""
              + " in a MarketOrderRejectTransaction.")
  private TransactionType type;
  /** The Market Order's Instrument. */
  @JsonPropertyDescription("The Market Order's Instrument.")
  private String instrument;
  
  /**
   * The quantity requested to be filled by the Market Order. A positive number of units results in
   * a long Order, and a negative number of units results in a short Order.
   */
  @JsonPropertyDescription(
      "The quantity requested to be filled by the Market Order. A positive number "
              + "of units results in a long Order, and a negative number of units"
              + " results in a short Order.")
  private String units;
  /**
   * The time-in-force requested for the Market Order. Restricted to FOK or IOC for a MarketOrder.
   */
  @JsonPropertyDescription(
      "The time-in-force requested for the Market Order. Restricted to FOK or IOC"
              + " for a MarketOrder.")
  private TimeInForce timeInForce;
  
  /** The worst price that the client is willing to have the Market Order filled at. */
  @JsonPropertyDescription(
      "The worst price that the client is willing to have the Market Order filled at.")
  private String priceBound;
  
  /** Specification of how Positions in the Account are modified when the Order is filled. */
  @JsonPropertyDescription(
      "Specification of how Positions in the Account are modified when the Order "
              + "is filled.")
  private PositionFill positionFill;

  private Object tradeClose;

  private Object longPositionCloseout;

  private Object shortPositionCloseout;

  private Object marginCloseout;

  private Object delayedTradeClose;
  
  /** The reason that the Market Order was created. */
  @JsonPropertyDescription("The reason that the Market Order was created")
  private TransactionReason reason;

  private Object clientExtensions;

  private Object takeProfitOnFill;

  private Object stopLossOnFill;

  private Object trailingStopLossOnFill;

  private Object tradeClientExtensions;
  
  /** The reason that the Reject Transaction was created. */
  @JsonPropertyDescription("The reason that the Reject Transaction was created")
  private RejectReason rejectReason;
}
