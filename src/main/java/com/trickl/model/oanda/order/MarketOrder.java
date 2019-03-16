package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.transaction.ClientExtensions;
import com.trickl.model.oanda.transaction.MarketOrderDelayedTradeClose;
import com.trickl.model.oanda.transaction.MarketOrderMarginCloseout;
import com.trickl.model.oanda.transaction.MarketOrderPositionCloseout;
import com.trickl.model.oanda.transaction.MarketOrderTradeClose;
import com.trickl.model.oanda.transaction.StopLossDetails;
import com.trickl.model.oanda.transaction.TakeProfitDetails;
import com.trickl.model.oanda.transaction.TrailingStopLossDetails;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * A MarketOrder is an order that is filled immediately upon creation using the current market
 * price.
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
    "timeInForce",
    "priceBound",
    "positionFill",
    "tradeClose",
    "longPositionCloseout",
    "shortPositionCloseout",
    "marginCloseout",
    "delayedTradeClose",
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
    "cancelledTime"
})
@Data
@Builder
public class MarketOrder extends Order {
      
  /** The type of the Order. */
  @JsonPropertyDescription("The type of the Order.")
  private final OrderType type = OrderType.MARKET;

  /** The Market Order's Instrument. */
  @JsonPropertyDescription("The Market Order's Instrument.")
  private String instrument;

  /**
   * The quantity requested to be filled by the Market Order. A posititive number of units results
   * in a long Order, and a negative number of units results in a short Order.
   */
  @JsonPropertyDescription(
      "The quantity requested to be filled by the Market Order. A posititive number"
            + " of units results in a long Order, and a negative number of units"
            + " results in a short Order.")
  private String units;

  /**
   * The time-in-force requested for the Market Order. Restricted to FOK or IOC for a MarketOrder.
   */
  @JsonPropertyDescription(
      "The time-in-force requested for the Market Order. Restricted to FOK "
            + "or IOC for a MarketOrder.")
  private TimeInForce timeInForce;

  /** The worst price that the client is willing to have the Market Order filled at. */
  @JsonPropertyDescription(
      "The worst price that the client is willing to have the Market Order filled at.")
  private String priceBound;

  /** Specification of how Positions in the Account are modified when the Order is filled. */
  @JsonPropertyDescription(
      "Specification of how Positions in the Account are modified when the Order is filled.")
  private OrderPositionFill positionFill;

  @JsonProperty("tradeClose")
  private MarketOrderTradeClose tradeClose;

  @JsonProperty("longPositionCloseout")
  private MarketOrderPositionCloseout longPositionCloseout;

  @JsonProperty("shortPositionCloseout")
  private MarketOrderPositionCloseout shortPositionCloseout;

  @JsonProperty("marginCloseout")
  private MarketOrderMarginCloseout marginCloseout;

  @JsonProperty("delayedTradeClose")
  private MarketOrderDelayedTradeClose delayedTradeClose;

  @JsonProperty("takeProfitOnFill")
  private TakeProfitDetails takeProfitOnFill;

  @JsonProperty("stopLossOnFill")
  private StopLossDetails stopLossOnFill;

  @JsonProperty("trailingStopLossOnFill")
  private TrailingStopLossDetails trailingStopLossOnFill;

  @JsonProperty("tradeClientExtensions")
  private ClientExtensions tradeClientExtensions;

  /**
   * ID of the Transaction that filled this Order (only provided when the
   * Order's state is FILLED).
   */
  @JsonProperty("fillingTransactionID")
  @JsonPropertyDescription(
      "ID of the Transaction that filled this Order (only provided when "
          + "the Order's state is FILLED)")
  private String fillingTransactionId;

  /** Date/time when the Order was filled (only provided when the Order's 
   * state is FILLED).
   */
  @JsonPropertyDescription(
      "Date/time when the Order was filled (only provided when the Order's " + "state is FILLED)")
  private String filledTime;

  /**
   * Trade ID of Trade opened when the Order was filled (only provided when
   * the Order's state is FILLED and a Trade was opened as a result of the fill).
   */
  @JsonProperty("tradeOpenedID")
  @JsonPropertyDescription(
      "Trade ID of Trade opened when the Order was filled (only provided when "
          + "the Order's state is FILLED and a Trade was opened as a result"
          + " of the fill)")
  private String tradeOpenedId;

  /**
   * Trade ID of Trade reduced when the Order was filled (only provided whenthe Order's state is
   * FILLED and a Trade was reduced as a result of the fill).
   */
  @JsonProperty("tradeReducedID")
  @JsonPropertyDescription(
      "Trade ID of Trade reduced when the Order was filled (only provided when "
          + "the Order's state is FILLED and a Trade was reduced as a result of "
          + "the fill)")
  private String tradeReducedId;

  /**
   * Trade IDs of Trades closed when the Order was filled (only provided 
   * when the Order's state is FILLED and one or more Trades were closed 
   * as a result of the fill).
   */
  @JsonProperty("tradeClosedIDs")
  @JsonPropertyDescription(
      "Trade IDs of Trades closed when the Order was filled (only provided "
          + "when the Order's state is FILLED and one or more Trades were"
          + " closed as a result of the fill)")
  private List<String> tradeClosedIds = null;

  /**
   * ID of the Transaction that cancelled the Order (only provided when 
   * the Order's state is CANCELLED).
   */
  @JsonProperty("cancellingTransactionID")
  @JsonPropertyDescription(
      "ID of the Transaction that cancelled the Order (only provided "
          + "when the Order's state is CANCELLED)")
  private String cancellingTransactionId;

  /**
   * Date/time when the Order was cancelled (only provided when the state of
   * the Order is CANCELLED).
   */
  @JsonPropertyDescription(
      "Date/time when the Order was cancelled (only provided when the "
          + "state of the Order is CANCELLED)")
  private String cancelledTime;
}
