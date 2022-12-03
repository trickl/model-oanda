package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A MarginCallEnterTransaction is created when an Account enters the margin call state. */
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MarginCallEnterTransaction extends Transaction {
  /**
   * The Type of the Transaction.
   */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type = TransactionStreamMessageType.MARGIN_CALL_ENTER; 
}
