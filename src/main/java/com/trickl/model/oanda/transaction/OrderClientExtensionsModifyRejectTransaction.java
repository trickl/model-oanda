package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * A OrderClientExtensionsModifyRejectTransaction represents the rejection of the modification of an
 * Order's Client Extensions.
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
    "orderID",
    "clientOrderID",
    "clientExtensionsModify",
    "tradeClientExtensionsModify",
    "rejectReason"
})
@Data
public class OrderClientExtensionsModifyRejectTransaction {

  /** The Transaction's Identifier. */
  @JsonPropertyDescription("The Transaction's Identifier.")
  private String id;
  
  /** The date/time when the Transaction was created. */
  @JsonPropertyDescription("The date/time when the Transaction was created.")
  private String time;
  
  /** The ID of the user that initiated the creation of the Transaction. */
  @JsonProperty("userID")
  @JsonPropertyDescription("The ID of the user that initiated the creation of the"
          + " Transaction.")
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
      "The ID of the \"batch\" that the Transaction belongs to. Transactions in the"
              + " same batch are applied to the Account simultaneously.")
  private String batchId;
  
  /** The Request ID of the request which generated the transaction. */
  @JsonProperty("requestID")
  @JsonPropertyDescription("The Request ID of the request which generated the transaction.")
  private String requestId;
  
  /**
   * The Type of the Transaction. Always set to "ORDER_CLIENT_EXTENSIONS_MODIFY_REJECT" for a
   * OrderClientExtensionsModifyRejectTransaction.
   */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"ORDER_CLIENT_EXTENSIONS_MODIFY_REJECT\""
              + " for a OrderClientExtensionsModifyRejectTransaction.")
  private TransactionType type;
  
  /** The ID of the Order who's client extensions are to be modified. */
  @JsonProperty("orderID")
  @JsonPropertyDescription("The ID of the Order who's client extensions are to be modified.")
  private String orderId;
  
  /** The original Client ID of the Order who's client extensions are to be modified. */
  @JsonProperty("clientOrderID")
  @JsonPropertyDescription(
      "The original Client ID of the Order who's client extensions are to be modified.")
  private String clientOrderId;
  
  private Object clientExtensionsModify;

  private Object tradeClientExtensionsModify;
  
  /** The reason that the Reject Transaction was created. */  
  @JsonPropertyDescription("The reason that the Reject Transaction was created")
  private TransactionRejectReason rejectReason;
}
