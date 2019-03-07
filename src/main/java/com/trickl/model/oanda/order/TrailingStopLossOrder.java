package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.transaction.ClientExtensions;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * A TrailingStopLossOrder is an order that is linked to an open Trade and created with a price
 * distance. The price distance is used to calculate a trailing stop value for the order that is in
 * the losing direction from the market price at the time of the order's creation. The trailing stop
 * value will follow the market price as it moves in the winning direction, and the order will
 * filled (closing the Trade) by the first price that is equal to or worse than the trailing stop
 * value. A TrailingStopLossOrder cannot be used to open a new Position.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "createTime",
    "state",
    "clientExtensions",
    "type",
    "tradeID",
    "clientTradeID",
    "distance",
    "timeInForce",
    "gtdTime",
    "triggerCondition",
    "trailingStopValue",
    "fillingTransactionID",
    "filledTime",
    "tradeOpenedID",
    "tradeReducedID",
    "tradeClosedIDs",
    "cancellingTransactionID",
    "cancelledTime",
    "replacesOrderID",
    "replacedByOrderID"
})
@Builder
@Data
public class TrailingStopLossOrder {

  /** The Order's identifier, unique within the Order's Account. */
  @JsonPropertyDescription("The Order's identifier, unique within the Order's Account.")
  private String id;
 
  /** The time when the Order was created. */
  @JsonPropertyDescription("The time when the Order was created.")
  private String createTime;
 
  /** The current state of the Order. */
  @JsonPropertyDescription("The current state of the Order.")
  private OrderState state;

  private ClientExtensions clientExtensions;
 
  /** The type of the Order. Always set to "TRAILING_STOP_LOSS" for Trailing Stop Loss Orders. */
  @JsonPropertyDescription(
      "The type of the Order. Always set to \"TRAILING_STOP_LOSS\" for Trailing Stop Loss Orders.")
  private OrderType type;
 
  /** The ID of the Trade to close when the price threshold is breached. */
  @JsonProperty("tradeID")
  @JsonPropertyDescription("The ID of the Trade to close when the price threshold is breached.")
  private String tradeId;
 
  /** The client ID of the Trade to be closed when the price threshold is breached. */
  @JsonProperty("clientTradeID")
  @JsonPropertyDescription(
      "The client ID of the Trade to be closed when the price threshold is breached.")
  private String clientTradeId;
 
  /** The price distance (in price units) specified for the TrailingStopLoss Order. */
  @JsonPropertyDescription(
      "The price distance (in price units) specified for the TrailingStopLoss Order.")
  private String distance;
 
  /**
   * The time-in-force requested for the TrailingStopLoss Order. Restricted to "GTC", "GFD" and
   * "GTD" for TrailingStopLoss Orders.
   */
  @JsonPropertyDescription(
      "The time-in-force requested for the TrailingStopLoss Order. Restricted to \"GTC\", "
              + "\"GFD\" and \"GTD\" for TrailingStopLoss Orders.")
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
      "Specification of which price component should be used when determining if"
              + " an Order should be triggered and filled. This allows Orders to be"
              + " triggered based on the bid, ask, mid, default (ask for buy, bid"
              + " for sell) or inverse (ask for sell, bid for buy) price depending"
              + " on the desired behaviour. Orders are always filled using their "
              + "default price component.\nThis feature is only provided through "
              + "the REST API. Clients who choose to specify a non-default trigger "
              + "condition will not see it reflected in any of OANDA's proprietary "
              + "or partner trading platforms, their transaction history or their"
              + " account statements. OANDA platforms always assume that an Order's"
              + " trigger condition is set to the default value when indicating"
              + " the distance from an Order's trigger price, and will always provide "
              + "the default trigger condition when creating or modifying an Order."
              + "A special restriction applies when creating a guaranteed Stop Loss Order."
              + " In this case the TriggerCondition value must either be \"DEFAULT\","
              + " or the \"natural\" trigger side \"DEFAULT\" results in. So for a "
              + "Stop Loss Order for a long trade valid values are \"DEFAULT\" and "
              + "\"BID\", and for short trades \"DEFAULT\" and \"ASK\" are valid.")
  private OrderTriggerCondition triggerCondition;

  /**
   * The trigger price for the Trailing Stop Loss Order. The trailing stop value will trail (follow)
   * the market price by the TSL order's configured "distance" as the market price moves in the
   * winning direction. If the market price moves to a level that is equal to or worse than the
   * trailing stop value, the order will be filled and the Trade will be closed.
   */
  @JsonPropertyDescription(
      "The trigger price for the Trailing Stop Loss Order. The trailing stop value"
              + " will trail (follow) the market price by the TSL order's configured "
              + "\"distance\" as the market price moves in the winning direction."
              + " If the market price moves to a level that is equal to or worse than "
              + "the trailing stop value, the order will be filled and the Trade "
              + "will be closed.")
  private String trailingStopValue;
 
  /**
   * ID of the Transaction that filled this Order (only provided when the Order's state is FILLED).
   */
  @JsonProperty("fillingTransactionID")
  @JsonPropertyDescription(
      "ID of the Transaction that filled this Order (only provided when the Order's"
              + " state is FILLED)")
  private String fillingTransactionId;
 
  /** Date/time when the Order was filled (only provided when the Order's state is FILLED). */
  @JsonPropertyDescription(
      "Date/time when the Order was filled (only provided when the Order's state is FILLED)")
  private String filledTime;
 
  /**
   * Trade ID of Trade opened when the Order was filled (only provided when the Order's state is
   * FILLED and a Trade was opened as a result of the fill).
   */
  @JsonProperty("tradeOpenedID")
  @JsonPropertyDescription(
      "Trade ID of Trade opened when the Order was filled (only provided when the"
              + " Order's state is FILLED and a Trade was opened as a result of the fill)")
  private String tradeOpenedId;
 
  /**
   * Trade ID of Trade reduced when the Order was filled (only provided when the Order's state is
   * FILLED and a Trade was reduced as a result of the fill).
   */
  @JsonProperty("tradeReducedID")
  @JsonPropertyDescription(
      "Trade ID of Trade reduced when the Order was filled (only provided when the"
              + " Order's state is FILLED and a Trade was reduced as a result of the fill)")
  private String tradeReducedId;

  /**
   * Trade IDs of Trades closed when the Order was filled (only provided when the Order's state is
   * FILLED and one or more Trades were closed as a result of the fill).
   */
  @JsonProperty("tradeClosedIDs")
  @JsonPropertyDescription(
      "Trade IDs of Trades closed when the Order was filled (only provided when the"
              + " Order's state is FILLED and one or more Trades were closed as a "
              + "result of the fill)")
  private List<String> tradeClosedIds = null;

  /**
   * ID of the Transaction that cancelled the Order (only provided when the Order's state is
   * CANCELLED).
   */
  @JsonProperty("cancellingTransactionID")
  @JsonPropertyDescription(
      "ID of the Transaction that cancelled the Order (only provided when the Order's "
              + "state is CANCELLED)")
  private String cancellingTransactionId;
  
  /**
   * Date/time when the Order was cancelled (only provided when the state of the Order 
   * is CANCELLED).
   */
  @JsonPropertyDescription(
      "Date/time when the Order was cancelled (only provided when the state of the"
              + " Order is CANCELLED)")
  private String cancelledTime;
  
  /**
   * The ID of the Order that was replaced by this Order (only provided if this Order was created as
   * part of a cancel/replace).
   */
  @JsonProperty("replacesOrderID")
  @JsonPropertyDescription(
      "The ID of the Order that was replaced by this Order (only provided if this"
              + " Order was created as part of a cancel/replace).")
  private String replacesOrderId;
  
  /**
   * The ID of the Order that replaced this Order (only provided if this Order was cancelled as part
   * of a cancel/replace).
   */
  @JsonProperty("replacedByOrderID")
  @JsonPropertyDescription(
      "The ID of the Order that replaced this Order (only provided if this Order was"
              + " cancelled as part of a cancel/replace).")
  private String replacedByOrderId;
}
