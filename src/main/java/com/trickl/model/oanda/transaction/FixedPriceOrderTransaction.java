package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.instrument.HasInstrument;
import lombok.Builder;
import lombok.Data;

/**
 * A FixedPriceOrderTransaction represents the creation of a Fixed Price Order in the user's
 * account. A Fixed Price Order is an Order that is filled immediately at a specified price.
 */
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
    "positionFill",
    "tradeState",
    "reason",
    "clientExtensions",
    "takeProfitOnFill",
    "stopLossOnFill",
    "trailingStopLossOnFill",
    "tradeClientExtensions"
})
@Data
@Builder
public class FixedPriceOrderTransaction extends Transaction
    implements HasInstrument {
  /**
   * The Type of the Transaction.
   */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionType type = TransactionType.FIXED_PRICE_ORDER; 
  
  /** The Fixed Price Order's Instrument. */
  @JsonPropertyDescription("The Fixed Price Order's Instrument.")
  private String instrument;
  
  /**
   * The quantity requested to be filled by the Fixed Price Order. A positive number of units
   * results in a long Order, and a negative number of units results in a short Order.
   */
  @JsonPropertyDescription(
      "The quantity requested to be filled by the Fixed Price Order. "
              + "A posititive number of units results in a long Order, "
              + "and a negative number of units results in a short Order.")
  private String units;
  
  /**
   * The price specified for the Fixed Price Order. This price is the exact price that the Fixed
   * Price Order will be filled at.
   */
  @JsonPropertyDescription(
      "The price specified for the Fixed Price Order. This price is the exact price that"
              + " the Fixed Price Order will be filled at.")
  private String price;
  
  /** Specification of how Positions in the Account are modified when the Order is filled. */
  @JsonPropertyDescription(
      "Specification of how Positions in the Account are modified when the Order is filled.")
  private PositionFill positionFill;
  
  /** The state that the trade resulting from the Fixed Price Order should be set to. */
  @JsonPropertyDescription(
      "The state that the trade resulting from the Fixed Price Order should be set to.")
  private String tradeState;
  
  /** The reason that the Fixed Price Order was created. */
  @JsonPropertyDescription("The reason that the Fixed Price Order was created")
  private FixedPriceOrderReason reason;

  private ClientExtensions clientExtensions;

  private TakeProfitDetails takeProfitOnFill;

  private StopLossDetails stopLossOnFill;

  private TrailingStopLossDetails trailingStopLossOnFill;

  private ClientExtensions tradeClientExtensions;
}
