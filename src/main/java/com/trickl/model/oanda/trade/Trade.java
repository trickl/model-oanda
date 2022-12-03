package com.trickl.model.oanda.trade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.order.StopLossOrder;
import com.trickl.model.oanda.order.TakeProfitOrder;
import com.trickl.model.oanda.order.TrailingStopLossOrder;
import com.trickl.model.oanda.transaction.ClientExtensions;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The specification of a Trade within an Account. This includes the full representation of the
 * Trade's dependent Orders in addition to the IDs of those Orders.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "instrument",
    "price",
    "openTime",
    "state",
    "initialUnits",
    "initialMarginRequired",
    "currentUnits",
    "realizedPL",
    "unrealizedPL",
    "marginUsed",
    "averageClosePrice",
    "closingTransactionIDs",
    "financing",
    "closeTime",
    "clientExtensions",
    "takeProfitOrder",
    "stopLossOrder",
    "trailingStopLossOrder"
})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Trade {

  /** The Trade's identifier, unique within the Trade's Account. */    
  @JsonPropertyDescription("The Trade's identifier, unique within the Trade's Account.")
  private String id;
  
  /** The Trade's Instrument. */
  @JsonPropertyDescription("The Trade's Instrument.")
  private String instrument;
  
  /** The execution price of the Trade. */
  @JsonPropertyDescription("The execution price of the Trade.")
  private BigDecimal price;
  
  /** The date/time when the Trade was opened. */
  @JsonPropertyDescription("The date/time when the Trade was opened.")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnnX", timezone = "UTC")
  private Instant openTime;
  
  /** The current state of the Trade. */
  @JsonPropertyDescription("The current state of the Trade.")
  private TradeState state;
  /**
   * The initial size of the Trade. Negative values indicate a short Trade, and positive values
   * indicate a long Trade.
   */
  @JsonPropertyDescription(
      "The initial size of the Trade. Negative values indicate a short Trade, and"
              + " positive values indicate a long Trade.")
  private BigDecimal initialUnits;
  /**
   * The margin required at the time the Trade was created. Note, this is the 'pure' margin
   * required, it is not the 'effective' margin used that factors in the trade risk if a GSLO is
   * attached to the trade.
   */
  @JsonPropertyDescription(
      "The margin required at the time the Trade was created. Note, this is the"
              + " 'pure' margin required, it is not the 'effective' margin used"
              + " that factors in the trade risk if a GSLO is attached to the trade.")
  private BigDecimal initialMarginRequired;
  
  /**
   * The number of units currently open for the Trade. This value is reduced to 0.0 as the Trade is
   * closed.
   */
  @JsonPropertyDescription(
      "The number of units currently open for the Trade. This value is reduced "
              + "to 0.0 as the Trade is closed.")
  private BigDecimal currentUnits;
  
  /** The total profit/loss realized on the closed portion of the Trade. */
  @JsonProperty("realizedPL")
  @JsonPropertyDescription("The total profit/loss realized on the closed portion"
          + " of the Trade.")
  private BigDecimal realizedPandL;
  
  /** The unrealized profit/loss on the open portion of the Trade. */
  @JsonProperty("unrealizedPL")
  @JsonPropertyDescription("The unrealized profit/loss on the open portion of the Trade.")
  private BigDecimal unrealizedPandL;
  
  /** Margin currently used by the Trade. */
  @JsonPropertyDescription("Margin currently used by the Trade.")
  private BigDecimal marginUsed;
  
  /**
   * The average closing price of the Trade. Only present if the Trade has been closed or reduced at
   * least once.
   */
  @JsonPropertyDescription(
      "The average closing price of the Trade. Only present if the Trade has been "
              + "closed or reduced at least once.")
  private BigDecimal averageClosePrice;
  
  /** The IDs of the Transactions that have closed portions of this Trade. */
  @JsonProperty("closingTransactionIDs")
  @JsonPropertyDescription("The IDs of the Transactions that have closed portions of this Trade.")
  private List<Integer> closingTransactionIds = null;
  
  /** The financing paid/collected for this Trade. */  
  @JsonPropertyDescription("The financing paid/collected for this Trade.")
  private BigDecimal financing;
  
  /**
   * The date/time when the Trade was fully closed. Only provided for Trades whose 
   * state is CLOSED.
   */
  @JsonPropertyDescription(
      "The date/time when the Trade was fully closed. Only provided for Trades "
              + "whose state is CLOSED.")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnnX", timezone = "UTC")
  private Instant closeTime;

  private ClientExtensions clientExtensions;

  private TakeProfitOrder takeProfitOrder;

  private StopLossOrder stopLossOrder;

  private TrailingStopLossOrder trailingStopLossOrder;
}
