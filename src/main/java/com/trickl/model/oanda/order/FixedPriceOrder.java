package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.time.Instant;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A FixedPriceOrder is an order that is filled immediately upon creation using a fixed price. */
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
    "positionFill",
    "tradeState",
    "takeProfitOnFill",
    "s#topLossOnFill",
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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class FixedPriceOrder extends Order
    implements HasInstrument, HasFilledTime, HasUnits, HasPrice {
    
  /** The type of the Order. */
  @JsonPropertyDescription("The type of the Order.")
  private final OrderType type = OrderType.FIXED_PRICE;

  /** The Fixed Price Order's Instrument. */
  @JsonPropertyDescription("The Fixed Price Order's Instrument.")
  private String instrument;

  /**
   * The quantity requested to be filled by the Fixed Price Order. A posititive number of units
   * results in a long Order, and a negative number of units results in a short Order.
   */
  @JsonPropertyDescription(
      "The quantity requested to be filled by the Fixed Price Order. A posititive"
          + " number of units results in a long Order, and a negative number "
          + "of units results in a short Order.")
  private BigDecimal units;

  /**
   * The price specified for the Fixed Price Order. This price is the exact price that the Fixed
   * Price Order will be filled at.
   */
  @JsonPropertyDescription(
      "The price specified for the Fixed Price Order. This price is the exact "
          + "price that the Fixed Price Order will be filled at.")
  private BigDecimal price;

  /** Specification of how Positions in the Account are modified when the Order is filled. */
  @JsonPropertyDescription(
      "Specification of how Positions in the Account are modified when the Order is filled.")
  private OrderPositionFill positionFill;

  /** The state that the trade resulting from the Fixed Price Order should be set to. */
  @JsonPropertyDescription(
      "The state that the trade resulting from the Fixed Price Order should be set to.")
  private String tradeState;

  private TakeProfitDetails takeProfitOnFill;

  @JsonProperty("sTopLossOnFill")
  private StopLossDetails stopLossOnFill;

  private TrailingStopLossDetails trailingStopLossOnFill;

  private ClientExtensions tradeClientExtensions;

  /**
   * ID of the Transaction that filled this Order (only provided when the Order's state is FILLED).
   */
  @JsonProperty("fillingTransactionID")
  @JsonPropertyDescription(
      "ID of the Transaction that filled this Order (only provided when the "
          + "Order's state is FILLED)")
  private String fillingTransactionId;

  /** Date/time when the Order was filled (only provided when the Order's state is FILLED). */  
  @JsonPropertyDescription(
      "Date/time when the Order was filled (only provided when the Order's state is FILLED)")  
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnnX", timezone = "UTC")
  private Instant filledTime;

  /**
   * Trade ID of Trade opened when the Order was filled (only provided when the Order's state is
   * FILLED and a Trade was opened as a result of the fill).
   */
  @JsonProperty("tradeOpenedID")
  @JsonPropertyDescription(
      "Trade ID of Trade opened when the Order was filled (only provided when"
          + " the Order's state is FILLED and a Trade was opened as a result of the fill)")
  private String tradeOpenedId;

  /**
   * Trade ID of Trade reduced when the Order was filled (only provided when the Order's state is
   * FILLED and a Trade was reduced as a result of the fill).
   */
  @JsonProperty("tradeReducedID")
  @JsonPropertyDescription(
      "Trade ID of Trade reduced when the Order was filled (only provided when"
          + " the Order's state is FILLED and a Trade was reduced as a result of the fill)")
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
   * Date/time when the Order was cancelled (only provided when the state of 
   * the Order is CANCELLED).
   */
  @JsonPropertyDescription(
      "Date/time when the Order was cancelled (only provided when the state of "
          + "the Order is CANCELLED)")
  private String cancelledTime;
}
