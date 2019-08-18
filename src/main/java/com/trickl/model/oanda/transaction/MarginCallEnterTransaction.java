package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Builder;
import lombok.Data;

/** A MarginCallEnterTransaction is created when an Account enters the margin call state. */
@Data
@Builder
public class MarginCallEnterTransaction extends Transaction {
  /**
   * The Type of the Transaction.
   */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type = TransactionStreamMessageType.MARGIN_CALL_ENTER; 
}
