package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.transaction.ClientExtensions;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A TrailingStopLossOrderRequest specifies the parameters that may be set when creating a Trailing
 * Stop Loss Order.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "tradeID",
    "clientTradeID",
    "distance",
    "timeInForce",
    "gtdTime",
    "triggerCondition",
    "clientExtensions"
})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TrailingStopLossOrderRequest implements OrderRequest, HasTimeInForce {

  @JsonPropertyDescription("The type of the Order to create.")
  private final OrderRequestType type = OrderRequestType.TRAILING_STOP_LOSS;  
    
  /** The ID of the Trade to close when the price threshold is breached. */
  @JsonProperty("tradeID")
  @JsonPropertyDescription("The ID of the Trade to close when the price threshold "
          + "is breached.")
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
      "The time-in-force requested for the TrailingStopLoss Order. Restricted to"
              + " \"GTC\", \"GFD\" and \"GTD\" for TrailingStopLoss Orders.")
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
              + " an Order should be triggered and filled. This allows Orders to"
              + " be triggered based on the bid, ask, mid, default (ask for buy,"
              + " bid for sell) or inverse (ask for sell, bid for buy) price depending"
              + " on the desired behaviour. Orders are always filled using their "
              + "default price component.\nThis feature is only provided through "
              + "the REST API. Clients who choose to specify a non-default trigger "
              + "condition will not see it reflected in any of OANDA's proprietary "
              + "or partner trading platforms, their transaction history or their "
              + "account statements. OANDA platforms always assume that an Order's "
              + "trigger condition is set to the default value when indicating the "
              + "distance from an Order's trigger price, and will always provide "
              + "the default trigger condition when creating or modifying an Order."
              + "A special restriction applies when creating a guaranteed Stop Loss Order."
              + " In this case the TriggerCondition value must either be \"DEFAULT\","
              + " or the \"natural\" trigger side \"DEFAULT\" results in. So for a "
              + "Stop Loss Order for a long trade valid values are \"DEFAULT\" and "
              + "\"BID\", and for short trades \"DEFAULT\" and \"ASK\" are valid.")
  private OrderTriggerCondition triggerCondition;

  private ClientExtensions clientExtensions;
}
