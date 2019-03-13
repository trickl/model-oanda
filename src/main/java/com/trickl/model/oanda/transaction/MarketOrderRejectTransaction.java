package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.order.TimeInForce;
import lombok.Builder;
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
@Builder
public class MarketOrderRejectTransaction extends Transaction {

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

  private MarketOrderTradeClose tradeClose;

  private MarketOrderPositionCloseout longPositionCloseout;

  private MarketOrderPositionCloseout shortPositionCloseout;

  private MarketOrderMarginCloseout marginCloseout;

  private MarketOrderDelayedTradeClose delayedTradeClose;
  
  /** The reason that the Market Order was created. */
  @JsonPropertyDescription("The reason that the Market Order was created")
  private MarketOrderReason reason;

  private ClientExtensions clientExtensions;

  private TakeProfitDetails takeProfitOnFill;

  private StopLossDetails stopLossOnFill;

  private TrailingStopLossDetails trailingStopLossOnFill;

  private ClientExtensions tradeClientExtensions;
  
  /** The reason that the Reject Transaction was created. */
  @JsonPropertyDescription("The reason that the Reject Transaction was created")
  private RejectReason rejectReason;
}
