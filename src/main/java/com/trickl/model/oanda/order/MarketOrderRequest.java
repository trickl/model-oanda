package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.instrument.HasInstrument;
import com.trickl.model.oanda.transaction.ClientExtensions;
import com.trickl.model.oanda.transaction.StopLossDetails;
import com.trickl.model.oanda.transaction.TakeProfitDetails;
import com.trickl.model.oanda.transaction.TrailingStopLossDetails;
import lombok.Builder;
import lombok.Data;

/** A MarketOrderRequest specifies the parameters that may be set when creating a Market Order. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "instrument",
    "units",
    "timeInForce",
    "priceBound",
    "positionFill",
    "clientExtensions",
    "takeProfitOnFill",
    "stopLossOnFill",
    "trailingStopLossOnFill",
    "tradeClientExtensions"
})
@Builder
@Data
public class MarketOrderRequest implements OrderRequest, HasInstrument {
    
  @JsonPropertyDescription("The type of the Order to create.")
  private final OrderRequestType type = OrderRequestType.MARKET;
  
  /** The Market Order's Instrument. */
  @JsonPropertyDescription("The Market Order's Instrument.")
  private String instrument;
 
  /**
   * The quantity requested to be filled by the Market Order. A positive number of units results
   * in a long Order, and a negative number of units results in a short Order.
   */
  @JsonPropertyDescription(
      "The quantity requested to be filled by the Market Order. A posititive number of "
              + "units results in a long Order, and a negative number of units results"
              + " in a short Order.")
  private String units;
 
  /**
   * The time-in-force requested for the Market Order. Restricted to FOK or IOC for a MarketOrder.
   */
  @JsonPropertyDescription(
      "The time-in-force requested for the Market Order. Restricted to FOK or IOC "
              + "for a MarketOrder.")
  private TimeInForce timeInForce;
  
  /** The worst price that the client is willing to have the Market Order filled at. */
  @JsonPropertyDescription(
      "The worst price that the client is willing to have the Market Order filled at.")  
  private String priceBound;
 
  /** Specification of how Positions in the Account are modified when the Order is filled. */
  @JsonPropertyDescription(
      "Specification of how Positions in the Account are modified when the Order is filled.")
  private OrderPositionFill positionFill;

  private ClientExtensions clientExtensions;

  private TakeProfitDetails takeProfitOnFill;

  private StopLossDetails stopLossOnFill;

  private TrailingStopLossDetails trailingStopLossOnFill;

  private ClientExtensions tradeClientExtensions;
}
