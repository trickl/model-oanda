package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.order.OrderTriggerCondition;
import com.trickl.model.oanda.order.TimeInForce;
import lombok.Builder;
import lombok.Data;

/**
 * A StopLossOrderRejectTransaction represents the rejection of the creation of a StopLoss Order.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "time",
    "userID",
    "accountID",
    "batchID",
    "requestID",
    "type",
    "tradeID",
    "clientTradeID",
    "price",
    "distance",
    "timeInForce",
    "gtdTime",
    "triggerCondition",
    "guaranteed",
    "reason",
    "clientExtensions",
    "orderFillTransactionID",
    "intendedReplacesOrderID",
    "rejectReason"
})
@Data
@Builder
public class StopLossOrderRejectTransaction {

  /** The Transaction's Identifier. */  
  @JsonPropertyDescription("The Transaction's Identifier.")
  private String id;
  
  /** The date/time when the Transaction was created. */  
  @JsonPropertyDescription("The date/time when the Transaction was created.")
  private String time;
  
  /** The ID of the user that initiated the creation of the Transaction. */
  @JsonProperty("userID")
  @JsonPropertyDescription("The ID of the user that initiated the creation of"
          + " the Transaction.")
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
   * The Type of the Transaction. Always set to "STOP_LOSS_ORDER_REJECT" in a
   * StopLossOrderRejectTransaction.
   */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"STOP_LOSS_ORDER_REJECT\" "
              + "in a StopLossOrderRejectTransaction.")
  private TransactionType type;
  
  /** The ID of the Trade to close when the price threshold is breached. */
  @JsonProperty("tradeID")
  @JsonPropertyDescription("The ID of the Trade to close when the price threshold is breached.")
  private String tradeId;
  
  /** The client ID of the Trade to be closed when the price threshold is breached. */
  @JsonProperty("clientTradeID")
  @JsonPropertyDescription(
      "The client ID of the Trade to be closed when the price threshold is breached.")
  private String clientTradeId;
  
  /**
   * The price threshold specified for the Stop Loss Order. If the guaranteed flag is false, the
   * associated Trade will be closed by a market price that is equal to or worse than this
   * threshold. If the flag is true the associated Trade will be closed at this price.
   */
  @JsonProperty("price")
  @JsonPropertyDescription(
      "The price threshold specified for the Stop Loss Order. If the guaranteed"
              + " flag is false, the associated Trade will be closed by a market"
              + " price that is equal to or worse than this threshold. If the "
              + "flag is true the associated Trade will be closed at this price.")
  private String price;
  
  /**
   * Specifies the distance (in price units) from the Account's current price to use as the Stop
   * Loss Order price. If the Trade is short the Instrument's bid price is used, and for long Trades
   * the ask is used.
   */
  @JsonPropertyDescription(
      "Specifies the distance (in price units) from the Account's current price "
              + "to use as the Stop Loss Order price. If the Trade is short the "
              + "Instrument's bid price is used, and for long Trades the ask is used.")
  private String distance;
  
  /**
   * The time-in-force requested for the StopLoss Order. Restricted to "GTC", "GFD" and "GTD" for
   * StopLoss Orders.
   */
  @JsonPropertyDescription(
      "The time-in-force requested for the StopLoss Order. Restricted to \"GTC\","
              + " \"GFD\" and \"GTD\" for StopLoss Orders.")
  private TimeInForce timeInForce;
  
  /** The date/time when the StopLoss Order will be cancelled if its timeInForce is "GTD". */
  @JsonPropertyDescription(
      "The date/time when the StopLoss Order will be cancelled if its timeInForce "
              + "is \"GTD\".")
  private String gtdTime;
  
  /**
   * Specification of which price component should be used when determining if an Order should be
   * triggered and filled. This allows Orders to be triggered based on the bid, ask, mid, default
   * (ask for buy, bid for sell) or inverse (ask for sell, bid for buy) price depending on the
   * desired behaviour. Orders are always filled using their default price component. This feature
   * is only provided through the REST API. Clients who choose to specify a non-default trigger
   * condition will not see it reflected in any of OANDA's proprietary or partner trading platforms,
   * their transaction history or their account statements. OANDA platforms always assume that an
   * Order's trigger condition is set to the default value when indicating the distance from an
   * Order's trigger price, and will always provide the default trigger condition when creating or
   * modifying an Order. A special restriction applies when creating a guaranteed Stop Loss Order.
   * In this case the TriggerCondition value must either be "DEFAULT", or the "natural" trigger side
   * "DEFAULT" results in. So for a Stop Loss Order for a long trade valid values are "DEFAULT" and
   * "BID", and for short trades "DEFAULT" and "ASK" are valid.
   */
  @JsonPropertyDescription(
      "Specification of which price component should be used when determining if "
              + "an Order should be triggered and filled. This allows Orders to "
              + "be triggered based on the bid, ask, mid, default (ask for buy,"
              + " bid for sell) or inverse (ask for sell, bid for buy) price depending "
              + "on the desired behaviour. Orders are always filled using their "
              + "default price component.\nThis feature is only provided through "
              + "the REST API. Clients who choose to specify a non-default trigger "
              + "condition will not see it reflected in any of OANDA's proprietary"
              + " or partner trading platforms, their transaction history or their"
              + " account statements. OANDA platforms always assume that an Order's "
              + "trigger condition is set to the default value when indicating the "
              + "distance from an Order's trigger price, and will always provide "
              + "the default trigger condition when creating or modifying an Order."
              + "A special restriction applies when creating a guaranteed Stop Loss Order."
              + " In this case the TriggerCondition value must either be \"DEFAULT\","
              + " or the \"natural\" trigger side \"DEFAULT\" results in. So for a"
              + " Stop Loss Order for a long trade valid values are \"DEFAULT\" and "
              + "\"BID\", and for short trades \"DEFAULT\" and \"ASK\" are valid.")
  private OrderTriggerCondition triggerCondition;
  
  /**
   * Flag indicating that the Stop Loss Order is guaranteed. The default value depends on the
   * GuaranteedStopLossOrderMode of the account, if it is REQUIRED, the default will be true, for
   * DISABLED or ENABLED the default is false.
   */
  @JsonPropertyDescription(
      "Flag indicating that the Stop Loss Order is guaranteed. The default value"
              + " depends on the GuaranteedStopLossOrderMode of the account, if "
              + "it is REQUIRED, the default will be true, for DISABLED or ENABLED"
              + " the default is false.")
  private Boolean guaranteed;
  
  /** The reason that the Stop Loss Order was initiated. */
  @JsonPropertyDescription("The reason that the Stop Loss Order was initiated")
  private TransactionReason reason;

  private ClientExtensions clientExtensions;
  /**
   * The ID of the OrderFill Transaction that caused this Order to be created (only provided if this
   * Order was created automatically when another Order was filled).
   */
  @JsonProperty("orderFillTransactionID")
  @JsonPropertyDescription(
      "The ID of the OrderFill Transaction that caused this Order to be created"
              + " (only provided if this Order was created automatically when another"
              + " Order was filled).")
  private String orderFillTransactionId;
  
  /**
   * The ID of the Order that this Order was intended to replace (only provided if this Order was
   * intended to replace an existing Order).
   */
  @JsonProperty("intendedReplacesOrderID")
  @JsonPropertyDescription(
      "The ID of the Order that this Order was intended to replace (only provided "
              + "if this Order was intended to replace an existing Order).")
  private String intendedReplacesOrderId;
  
  /** The reason that the Reject Transaction was created. */
  @JsonPropertyDescription("The reason that the Reject Transaction was created")
  private RejectReason rejectReason;
}
