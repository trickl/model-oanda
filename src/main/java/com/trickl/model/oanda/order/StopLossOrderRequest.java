package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * A StopLossOrderRequest specifies the parameters that may be set when creating a Stop Loss Order.
 * Only one of the price and distance fields may be specified.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "tradeID",
    "clientTradeID",
    "price",
    "distance",
    "timeInForce",
    "gtdTime",
    "triggerCondition",
    "guaranteed",
    "clientExtensions"
})
@Data
public class StopLossOrderRequest {

  /**
   * The type of the Order to Create. Must be set to "STOP_LOSS" when creating a Stop Loss Order.
   */
  @JsonProperty("type")
  @JsonPropertyDescription(
      "The type of the Order to Create. Must be set to \"STOP_LOSS\" when creating"
              + " a Stop Loss Order.")
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

  /**
   * The price threshold specified for the Stop Loss Order. If the guaranteed flag is false, the
   * associated Trade will be closed by a market price that is equal to or worse than this
   * threshold. If the flag is true the associated Trade will be closed at this price.
   */
  @JsonPropertyDescription(
      "The price threshold specified for the Stop Loss Order. If the guaranteed flag"
              + " is false, the associated Trade will be closed by a market price "
              + "that is equal to or worse than this threshold. If the flag is true"
              + " the associated Trade will be closed at this price.")
  private String price;

  /**
   * Specifies the distance (in price units) from the Account's current price to use as the Stop
   * Loss Order price. If the Trade is short the Instrument's bid price is used, and for long Trades
   * the ask is used.
   */
  @JsonPropertyDescription(
      "Specifies the distance (in price units) from the Account's current price to"
              + " use as the Stop Loss Order price. If the Trade is short the Instrument's"
              + " bid price is used, and for long Trades the ask is used.")
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
              + "default price component.\nThis feature is only provided through"
              + " the REST API. Clients who choose to specify a non-default trigger"
              + " condition will not see it reflected in any of OANDA's proprietary "
              + "or partner trading platforms, their transaction history or their "
              + "account statements. OANDA platforms always assume that an Order's "
              + "trigger condition is set to the default value when indicating the "
              + "distance from an Order's trigger price, and will always provide "
              + "the default trigger condition when creating or modifying an Order."
              + "A special restriction applies when creating a guaranteed Stop Loss "
              + "Order. In this case the TriggerCondition value must either be \"DEFAULT\","
              + " or the \"natural\" trigger side \"DEFAULT\" results in. So for a"
              + " Stop Loss Order for a long trade valid values are \"DEFAULT\" "
              + "and \"BID\", and for short trades \"DEFAULT\" and \"ASK\" are valid.")
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

  private Object clientExtensions;
}
