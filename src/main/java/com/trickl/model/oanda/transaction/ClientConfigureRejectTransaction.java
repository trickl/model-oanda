package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/**
 * A ClientConfigureRejectTransaction represents the reject of configuration of an Account by a
 * client.
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
    "alias",
    "marginRate",
    "rejectReason"
})
@Data
@Builder
public class ClientConfigureRejectTransaction {

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
      "The ID of the \"batch\" that the Transaction belongs to. Transactions in t"
              + "he same batch are applied to the Account simultaneously.")
  private String batchId;
  
  /** The Request ID of the request which generated the transaction. */
  @JsonProperty("requestID")
  @JsonPropertyDescription("The Request ID of the request which generated the transaction.")
  private String requestId;
  
  /**
   * The Type of the Transaction. Always set to "CLIENT_CONFIGURE_REJECT" in a
   * ClientConfigureRejectTransaction.
   */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"CLIENT_CONFIGURE_REJECT\" "
              + "in a ClientConfigureRejectTransaction.")
  private TransactionType type;
  
  /** The client-provided alias for the Account. */
  @JsonPropertyDescription("The client-provided alias for the Account.")
  private String alias;
  
  /** The margin rate override for the Account. */
  @JsonPropertyDescription("The margin rate override for the Account.")
  private String marginRate;
  
  /** The reason that the Reject Transaction was created. */
  @JsonPropertyDescription("The reason that the Reject Transaction was created")
  private RejectReason rejectReason;
}
