package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * A MarginCallExtendTransaction is created when the margin call state for an Account has been
 * extended.
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
    "extensionNumber"
})
@Data
public class MarginCallExtendTransaction {

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
      "The ID of the \"batch\" that the Transaction belongs to. Transactions "
              + "in the same batch are applied to the Account simultaneously.")
  private String batchId;
  
  /** The Request ID of the request which generated the transaction. */
  @JsonProperty("requestID")
  @JsonPropertyDescription("The Request ID of the request which generated the transaction.")
  private String requestId;
  
  /**
   * The Type of the Transaction. Always set to "MARGIN_CALL_EXTEND" for an
   * MarginCallExtendTransaction.
   */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"MARGIN_CALL_EXTEND\" for an "
              + "MarginCallExtendTransaction.")
  private TransactionType type;
  
  /**
   * The number of the extensions to the Account's current margin call that have been applied. This
   * value will be set to 1 for the first MarginCallExtend Transaction
   */
  
  @JsonPropertyDescription(
      "The number of the extensions to the Account's current margin call that have"
              + " been applied. This value will be set to 1 for the first MarginCallExtend"
              + " Transaction")
  private Integer extensionNumber;
}
