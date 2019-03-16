package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class ClientConfigureRejectTransaction extends Transaction {
    
  /**
   * The Type of the Transaction.
   */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionType type = TransactionType.CLIENT_CONFIGURE_REJECT;
  
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
