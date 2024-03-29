package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class DelayedTradeClosureTransaction extends Transaction {
  /** The Type of the Transaction. */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type =
      TransactionStreamMessageType.DELAYED_TRADE_CLOSURE;

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
