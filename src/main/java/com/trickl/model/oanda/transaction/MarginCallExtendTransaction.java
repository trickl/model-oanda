package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
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
@Builder
public class MarginCallExtendTransaction extends Transaction {  
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
