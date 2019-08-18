package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.order.OrderTriggerCondition;
import com.trickl.model.oanda.order.TimeInForce;
import lombok.Builder;
import lombok.Data;

/** A StopLossOrderTransaction represents the creation of a StopLoss Order in the user's Account. */
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
    "guaranteedExecutionPremium",
    "reason",
    "clientExtensions",
    "orderFillTransactionID",
    "replacesOrderID",
    "cancellingTransactionID"
})
@Data
@Builder
public class StopLossOrderTransaction extends Transaction {
  /**
   * The Type of the Transaction.
   */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type = TransactionStreamMessageType.STOP_LOSS_ORDER;
  
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
  @JsonPropertyDescription(
      "The price threshold specified for the Stop Loss Order. If the guaranteed "
              + "flag is false, the associated Trade will be closed by a market "
              + "price that is equal to or worse than this threshold. If the flag "
              + "is true the associated Trade will be closed at this price.")
  private String price;
  
  /**
   * Specifies the distance (in price units) from the Account's current price to use as the Stop
   * Loss Order price. If the Trade is short the Instrument's bid price is used, and for long Trades
   * the ask is used.
   */
  @JsonPropertyDescription(
      "Specifies the distance (in price units) from the Account's current price to "
              + "use as the Stop Loss Order price. If the Trade is short the "
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
      "The date/time when the StopLoss Order will be cancelled if its timeInForce is \"GTD\".")
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
      "Specification of which price component should be used when determining if an"
              + " Order should be triggered and filled. This allows Orders to be "
              + "triggered based on the bid, ask, mid, default (ask for buy, bid "
              + "for sell) or inverse (ask for sell, bid for buy) price depending "
              + "on the desired behaviour. Orders are always filled using their "
              + "default price component.\nThis feature is only provided through "
              + "the REST API. Clients who choose to specify a non-default trigger "
              + "condition will not see it reflected in any of OANDA's proprietary "
              + "or partner trading platforms, their transaction history or their "
              + "account statements. OANDA platforms always assume that an Order's "
              + "trigger condition is set to the default value when indicating the "
              + "distance from an Order's trigger price, and will always provide "
              + "the default trigger condition when creating or modifying an Order."
              + "A special restriction applies when creating a guaranteed Stop Loss Order."
              + " In this case the TriggerCondition value must either be \"DEFAULT\", "
              + "or the \"natural\" trigger side \"DEFAULT\" results in. So for a"
              + "Stop Loss Order for a long trade valid values are \"DEFAULT\" and "
              + "\"BID\", and for short trades \"DEFAULT\" and \"ASK\" are valid.")
  private OrderTriggerCondition triggerCondition;
  
  /**
   * Flag indicating that the Stop Loss Order is guaranteed. The default value depends on the
   * GuaranteedStopLossOrderMode of the account, if it is REQUIRED, the default will be true, for
   * DISABLED or ENABLED the default is false.
   */
  @JsonPropertyDescription(
      "Flag indicating that the Stop Loss Order is guaranteed. The default value "
              + "depends on the GuaranteedStopLossOrderMode of the account, if it "
              + "is REQUIRED, the default will be true, for DISABLED or ENABLED "
              + "the default is false.")
  private Boolean guaranteed;
  
  /**
   * The fee that will be charged if the Stop Loss Order is guaranteed and the Order is filled at
   * the guaranteed price. The value is determined at Order creation time. It is in price units and
   * is charged for each unit of the Trade.
   */
  @JsonPropertyDescription(
      "The fee that will be charged if the Stop Loss Order is guaranteed and the"
              + " Order is filled at the guaranteed price. The value is determined "
              + "at Order creation time. It is in price units and is charged for "
              + "each unit of the Trade.")
  private String guaranteedExecutionPremium;
  
  /** The reason that the Stop Loss Order was initiated. */
  @JsonPropertyDescription("The reason that the Stop Loss Order was initiated")
  private StopLossOrderReason reason;  

  private ClientExtensions clientExtensions;
  /**
   * The ID of the OrderFill Transaction that caused this Order to be created (only provided if this
   * Order was created automatically when another Order was filled).
   */
  @JsonProperty("orderFillTransactionID")
  @JsonPropertyDescription(
      "The ID of the OrderFill Transaction that caused this Order to be created "
              + "(only provided if this Order was created automatically when "
              + "another Order was filled).")
  private String orderFillTransactionId;
  
  /**
   * The ID of the Order that this Order replaces (only provided if this Order replaces an existing
   * Order).
   */
  @JsonProperty("replacesOrderID")
  @JsonPropertyDescription(
      "The ID of the Order that this Order replaces (only provided if this Order "
              + "replaces an existing Order).")
  private String replacesOrderId;
  
  /**
   * The ID of the Transaction that cancels the replaced Order (only provided if this Order replaces
   * an existing Order).
   */
  @JsonProperty("cancellingTransactionID")
  @JsonPropertyDescription(
      "The ID of the Transaction that cancels the replaced Order (only provided "
              + "if this Order replaces an existing Order).")
  private String cancellingTransactionId;  
}
