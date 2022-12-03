package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.instrument.HasInstrument;
import com.trickl.model.oanda.order.OrderTriggerCondition;
import com.trickl.model.oanda.order.TimeInForce;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A LimitOrderTransaction represents the creation of a Limit Order in the user's Account. */
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
    "price",
    "timeInForce",
    "gtdTime",
    "positionFill",
    "triggerCondition",
    "reason",
    "clientExtensions",
    "takeProfitOnFill",
    "stopLossOnFill",
    "trailingStopLossOnFill",
    "tradeClientExtensions",
    "replacesOrderID",
    "cancellingTransactionID"
})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LimitOrderTransaction extends Transaction 
    implements HasInstrument {
  /**
   * The Type of the Transaction.
   */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type = TransactionStreamMessageType.LIMIT_ORDER; 
  
  /** The Limit Order's Instrument. */
  @JsonPropertyDescription("The Limit Order's Instrument.")
  private String instrument;
  
  /**
   * The quantity requested to be filled by the Limit Order. A positive number of units results in
   * a long Order, and a negative number of units results in a short Order.
   */
  @JsonPropertyDescription(
      "The quantity requested to be filled by the Limit Order."
              + " A positive number of units results in a long Order, "
              + "and a negative number of units results in a short Order.")
  private String units;
  
  /**
   * The price threshold specified for the Limit Order. The Limit Order will only be filled by a
   * market price that is equal to or better than this price.
   */
  @JsonPropertyDescription(
      "The price threshold specified for the Limit Order. The Limit Order will"
              + " only be filled by a market price that is equal to or better than"
              + " this price.")
  private String price;
  
  /** The time-in-force requested for the Limit Order. */
  @JsonPropertyDescription("The time-in-force requested for the Limit Order.")
  private TimeInForce timeInForce;
  
  /** The date/time when the Limit Order will be cancelled if its timeInForce is "GTD". */
  @JsonPropertyDescription(
      "The date/time when the Limit Order will be cancelled if its timeInForce is"
              + " \"GTD\".")
  private String gtdTime;
  
  /** Specification of how Positions in the Account are modified when the Order is filled. */
  @JsonPropertyDescription(
      "Specification of how Positions in the Account are modified when the Order"
              + "is filled.")
  private PositionFill positionFill;
  
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
              + "an Order should be triggered and filled. This allows Orders to"
              + " be triggered based on the bid, ask, mid, default (ask for buy,"
              + " bid for sell) or inverse (ask for sell, bid for buy) price depending"
              + " on the desired behaviour. Orders are always filled using their "
              + "default price component.\nThis feature is only provided through "
              + "the REST API. Clients who choose to specify a non-default trigger"
              + " condition will not see it reflected in any of OANDA's proprietary "
              + "or partner trading platforms, their transaction history or their "
              + "account statements. OANDA platforms always assume that an Order's"
              + " trigger condition is set to the default value when indicating the"
              + " distance from an Order's trigger price, and will always provide "
              + "the default trigger condition when creating or modifying an Order."
              + "A special restriction applies when creating a guaranteed Stop Loss Order. "
              + "In this case the TriggerCondition value must either be \"DEFAULT\", "
              + "or the \"natural\" trigger side \"DEFAULT\" results in. So for a "
              + "Stop Loss Order for a long trade valid values are \"DEFAULT\" and "
              + "\"BID\", and for short trades \"DEFAULT\" and \"ASK\" are valid.")
  private OrderTriggerCondition triggerCondition;
  
  /** The reason that the Limit Order was initiated .*/
  @JsonPropertyDescription("The reason that the Limit Order was initiated")
  private LimitOrderReason reason;
  
  private ClientExtensions clientExtensions;
  
  private TakeProfitDetails takeProfitOnFill;

  private StopLossDetails stopLossOnFill;

  private TrailingStopLossDetails trailingStopLossOnFill;

  private ClientExtensions tradeClientExtensions;
  
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
      "The ID of the Transaction that cancels the replaced Order (only provided"
              + " if this Order replaces an existing Order).")
  private String cancellingTransactionId;
}
