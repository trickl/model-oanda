package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.instrument.HasInstrument;
import com.trickl.model.oanda.transaction.ClientExtensions;
import com.trickl.model.oanda.transaction.StopLossDetails;
import com.trickl.model.oanda.transaction.TakeProfitDetails;
import com.trickl.model.oanda.transaction.TrailingStopLossDetails;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A StopOrderRequest specifies the parameters that may be set when creating a Stop Order. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "instrument",
    "units",
    "price",
    "priceBound",
    "timeInForce",
    "gtdTime",
    "positionFill",
    "triggerCondition",
    "clientExtensions",
    "takeProfitOnFill",
    "stopLossOnFill",
    "trailingStopLossOnFill",
    "tradeClientExtensions"
})
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class StopOrderRequest 
    implements OrderRequest, HasInstrument, HasTimeInForce, HasUnits, HasPrice {
    
  @JsonPropertyDescription("The type of the Order to create.")
  private final OrderRequestType type = OrderRequestType.STOP;
  
  /** The Stop Order's Instrument. */
  @JsonPropertyDescription("The Stop Order's Instrument.")
  private String instrument;
 
  /**
   * The quantity requested to be filled by the Stop Order. A positive number of units results in
   * a long Order, and a negative number of units results in a short Order.
   */
  @JsonPropertyDescription(
      "The quantity requested to be filled by the Stop Order. A posititive number "
              + "of units results in a long Order, and a negative number of units"
              + " results in a short Order.")
  private BigDecimal units;
 
  /**
   * The price threshold specified for the Stop Order. The Stop Order will only be filled by a
   * market price that is equal to or worse than this price.
   */
  @JsonPropertyDescription(
      "The price threshold specified for the Stop Order. The Stop Order will only "
              + "be filled by a market price that is equal to or worse than this price.")
  private BigDecimal price;
  
  /**
   * The worst market price that may be used to fill this Stop Order. If the market gaps and crosses
   * through both the price and the priceBound, the Stop Order will be cancelled instead of being
   * filled.
   */
  @JsonPropertyDescription(
      "The worst market price that may be used to fill this Stop Order. If the market gaps"
              + " and crosses through both the price and the priceBound, the Stop Order"
              + " will be cancelled instead of being filled.")
  private BigDecimal priceBound;
 
  /** The time-in-force requested for the Stop Order. */
  @JsonPropertyDescription("The time-in-force requested for the Stop Order.")
  private TimeInForce timeInForce;
  
  /** The date/time when the Stop Order will be cancelled if its timeInForce is "GTD". */ 
  @JsonPropertyDescription(
      "The date/time when the Stop Order will be cancelled if its timeInForce is \"GTD\".")
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
              + "Order should be triggered and filled. This allows Orders to be"
              + " triggered based on the bid, ask, mid, default (ask for buy, bid "
              + "for sell) or inverse (ask for sell, bid for buy) price depending"
              + " on the desired behaviour. Orders are always filled using their "
              + "default price component.\nThis feature is only provided through"
              + " the REST API. Clients who choose to specify a non-default trigger "
              + "condition will not see it reflected in any of OANDA's proprietary"
              + " or partner trading platforms, their transaction history or their "
              + "account statements. OANDA platforms always assume that an Order's "
              + "trigger condition is set to the default value when indicating the"
              + " distance from an Order's trigger price, and will always provide "
              + "the default trigger condition when creating or modifying an Order."
              + "A special restriction applies when creating a guaranteed Stop Loss"
              + " Order. In this case the TriggerCondition value must either be"
              + " \"DEFAULT\", or the \"natural\" trigger side \"DEFAULT\" results "
              + "in. So for a Stop Loss Order for a long trade valid values are \"DEFAULT\""
              + " and \"BID\", and for short trades \"DEFAULT\" and \"ASK\" are valid.")
  private OrderTriggerCondition triggerCondition;

  private ClientExtensions clientExtensions;

  private TakeProfitDetails takeProfitOnFill;

  private StopLossDetails stopLossOnFill;

  private TrailingStopLossDetails trailingStopLossOnFill;

  private ClientExtensions tradeClientExtensions;
}
