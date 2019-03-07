package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.transaction.ClientExtensions;
import com.trickl.model.oanda.transaction.StopLossDetails;
import com.trickl.model.oanda.transaction.TakeProfitDetails;
import com.trickl.model.oanda.transaction.TrailingStopLossDetails;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * A MarketIfTouchedOrder is an order that is created with a price threshold, and will only be
 * filled by a market price that is touches or crosses the threshold.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "createTime",
    "state",
    "clientExtensions",
    "type",
    "instrument",
    "units",
    "price",
    "priceBound",
    "timeInForce",
    "gtdTime",
    "positionFill",
    "triggerCondition",
    "initialMarketPrice",
    "takeProfitOnFill",
    "stopLossOnFill",
    "trailingStopLossOnFill",
    "tradeClientExtensions",
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
public class MarketIfTouchedOrder {

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

  /** The type of the Order. Always set to "MARKET_IF_TOUCHED" for Market If Touched Orders. */
  @JsonPropertyDescription(
      "The type of the Order. Always set to \"MARKET_IF_TOUCHED\" for Market If Touched Orders.")
  private OrderType type;

  /** The MarketIfTouched Order's Instrument. */
  @JsonPropertyDescription("The MarketIfTouched Order's Instrument.")
  private String instrument;

  /**
   * The quantity requested to be filled by the MarketIfTouched Order. A positive number of units
   * results in a long Order, and a negative number of units results in a short Order.
   */
  @JsonPropertyDescription(
      "The quantity requested to be filled by the MarketIfTouched Order."
          + " A posititive number of units results in a long Order, and a "
          + "negative number of units results in a short Order.")
  private String units;

  /**
   * The price threshold specified for the MarketIfTouched Order. The MarketIfTouched Order will
   * only be filled by a market price that crosses this price from the direction of the market price
   * at the time when the Order was created (the initialMarketPrice). Depending on the value of the
   * Order's price and initialMarketPrice, the MarketIfTouchedOrder will behave like a Limit or a
   * Stop Order.
   */
  @JsonPropertyDescription(
      "The price threshold specified for the MarketIfTouched Order. The MarketIfTouched "
          + "Order will only be filled by a market price that crosses this price "
          + "from the direction of the market price at the time when the Order "
          + "was created (the initialMarketPrice). Depending on the value of the"
          + " Order's price and initialMarketPrice, the MarketIfTouchedOrder "
          + "will behave like a Limit or a Stop Order.")
  private String price;

  /** The worst market price that may be used to fill this MarketIfTouched Order. */
  @JsonPropertyDescription(
      "The worst market price that may be used to fill this MarketIfTouched Order.")
  private String priceBound;

  /**
   * The time-in-force requested for the MarketIfTouched Order. Restricted to "GTC", "GFD" and "GTD"
   * for MarketIfTouched Orders.
   */
  @JsonPropertyDescription(
      "The time-in-force requested for the MarketIfTouched Order. Restricted "
          + "to \"GTC\", \"GFD\" and \"GTD\" for MarketIfTouched Orders.")
  private TimeInForce timeInForce;

  /** The date/time when the MarketIfTouched Order will be cancelled if its timeInForce is "GTD". */
  @JsonPropertyDescription(
      "The date/time when the MarketIfTouched Order will be cancelled if its "
          + "timeInForce is \"GTD\".")
  private String gtdTime;

  /** Specification of how Positions in the Account are modified when the Order is filled. */
  @JsonPropertyDescription(
      "Specification of how Positions in the Account are modified when the Order is filled.")
  private OrderPositionFill positionFill;

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
      "Specification of which price component should be used when determining if an "
          + "Order should be triggered and filled. This allows Orders to be "
          + "triggered based on the bid, ask, mid, default (ask for buy, bid for"
          + " sell) or inverse (ask for sell, bid for buy) price depending on "
          + "the desired behaviour. Orders are always filled using their default "
          + "price component.\nThis feature is only provided through the REST API."
          + " Clients who choose to specify a non-default trigger condition"
          + "will not see it reflected in any of OANDA's proprietary or partner"
          + " trading platforms, their transaction history or their account statements."
          + " OANDA platforms always assume that an Order's trigger condition is set "
          + "to the default value when indicating the distance from an Order's "
          + "trigger price, and will always provide the default trigger condition "
          + "when creating or modifying an Order.\nA special restriction applies "
          + "when creating a guaranteed Stop Loss Order. In this case the TriggerCondition"
          + " value must either be \"DEFAULT\", or the \"natural\" trigger side "
          + "\"DEFAULT\" results in. So for a Stop Loss Order for a long trade valid "
          + "values are \"DEFAULT\" and \"BID\", and for short trades \"DEFAULT\" "
          + "and \"ASK\" are valid.")
  private OrderTriggerCondition triggerCondition;

  /** The Market price at the time when the MarketIfTouched Order was created. */
  @JsonPropertyDescription(
      "The Market price at the time when the MarketIfTouched Order was created.")
  private String initialMarketPrice;

  private TakeProfitDetails takeProfitOnFill;

  private StopLossDetails stopLossOnFill;

  private TrailingStopLossDetails trailingStopLossOnFill;

  private ClientExtensions tradeClientExtensions;

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
      "Trade ID of Trade opened when the Order was filled (only provided when the Order's"
          + " state is FILLED and a Trade was opened as a result of the fill)")
  private String tradeOpenedId;

  /**
   * Trade ID of Trade reduced when the Order was filled (only provided when the Order's state is
   * FILLED and a Trade was reduced as a result of the fill).
   */
  @JsonProperty("tradeReducedID")
  @JsonPropertyDescription(
      "Trade ID of Trade reduced when the Order was filled (only provided when "
          + "the Order's state is FILLED and a Trade was reduced as a result"
          + " of the fill)")
  private String tradeReducedId;

  /**
   * Trade IDs of Trades closed when the Order was filled (only provided when the Order's state is
   * FILLED and one or more Trades were closed as a result of the fill).
   */
  @JsonProperty("tradeClosedIDs")
  @JsonPropertyDescription(
      "Trade IDs of Trades closed when the Order was filled (only provided "
          + "when the Order's state is FILLED and one or more Trades were"
          + " closed as a result of the fill)")
  private List<String> tradeClosedIds = null;

  /**
   * ID of the Transaction that cancelled the Order (only provided when the Order's state is
   * CANCELLED).
   */
  @JsonProperty("cancellingTransactionID")
  @JsonPropertyDescription(
      "ID of the Transaction that cancelled the Order (only provided when the"
          + " Order's state is CANCELLED)")
  private String cancellingTransactionId;

  /**
   * Date/time when the Order was cancelled (only provided when the state of the Order is
   * CANCELLED).
   */
  @JsonProperty("cancelledTime")
  @JsonPropertyDescription(
      "Date/time when the Order was cancelled (only provided when the state of the Order"
          + " is CANCELLED)")
  private String cancelledTime;

  /**
   * The ID of the Order that was replaced by this Order (only provided if this Order was created as
   * part of a cancel/replace).
   */
  @JsonProperty("replacesOrderID")
  @JsonPropertyDescription(
      "The ID of the Order that was replaced by this Order (only provided if this "
          + "Order was created as part of a cancel/replace).")
  private String replacesOrderId;

  /**
   * The ID of the Order that replaced this Order (only provided if this Order was cancelled as part
   * of a cancel/replace).
   */
  @JsonProperty("replacedByOrderID")
  @JsonPropertyDescription(
      "The ID of the Order that replaced this Order (only provided if this Order"
          + " was cancelled as part of a cancel/replace).")
  private String replacedByOrderId;
}
