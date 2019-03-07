package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/**
 * A DelayedTradeClosure Transaction is created administratively to indicate open trades that should
 * have been closed but weren't because the open trades' instruments were untradeable at the time.
 * Open trades listed in this transaction will be closed once their respective instruments become
 * tradeable.
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
    "reason",
    "tradeIDs"
})
@Data
@Builder
public class DelayedTradeClosureTransaction {

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
   * The Type of the Transaction. Always set to "DELAYED_TRADE_CLOSURE" for an
   * DelayedTradeClosureTransaction.
   */
  @JsonProperty("type")
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"DELAYED_TRADE_CLOSURE\" for an"
              + " DelayedTradeClosureTransaction.")
  private TransactionType type;
  
  /** The reason for the delayed trade closure. */
  @JsonPropertyDescription("The reason for the delayed trade closure")
  private DelayedTradeClosureReason reason;
  
  /**
   * List of Trade ID's identifying the open trades that will be closed when their respective
   * instruments become tradeable.
   */
  @JsonProperty("tradeIDs")
  @JsonPropertyDescription(
      "List of Trade ID's identifying the open trades that will be closed when their"
              + " respective instruments become tradeable")
  private String tradeIds;
}
