package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
public class FixedPriceOrderTransaction {

  /** The Transaction's Identifier. */
  @JsonPropertyDescription("The Transaction's Identifier.")
  private String id;
  
  /** The date/time when the Transaction was created. */
  @JsonPropertyDescription("The date/time when the Transaction was created.")
  private String time;
  
  /** The ID of the user that initiated the creation of the Transaction. */
  @JsonProperty("userID")
  @JsonPropertyDescription("The ID of the user that initiated the creation of the Transaction.")
  private Integer userId;
  
  /** The ID of the Account the Transaction was created for. */
  @JsonProperty("accountID")
  @JsonPropertyDescription("The ID of the Account the Transaction was created for.")
  private String accountId;
  
  /**
   * The ID of the "batch" that the Transaction belongs to. Transactions in the same batch are
   * applied to the Account simultaneously.
   */
  @JsonProperty("batchID")
  @JsonPropertyDescription(
      "The ID of the \"batch\" that the Transaction belongs to. Transactions in the "
              + "same batch are applied to the Account simultaneously.")
  private String batchId;
  
  /** The Request ID of the request which generated the transaction. */
  @JsonProperty("requestID")
  @JsonPropertyDescription("The Request ID of the request which generated the transaction.")
  private String requestId;
  
  /**
   * The Type of the Transaction. Always set to "FIXED_PRICE_ORDER" in a FixedPriceOrderTransaction.
   */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"FIXED_PRICE_ORDER\" in a "
              + "FixedPriceOrderTransaction.")
  private TransactionType type;
  
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
  private TransactionReason reason;

  private Object clientExtensions;

  private Object takeProfitOnFill;

  private Object stopLossOnFill;

  private Object trailingStopLossOnFill;

  private Object tradeClientExtensions;
}
