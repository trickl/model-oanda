package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * Details for the Market Order extensions specific to a Market Order placed with the intent of
 * fully closing a specific open trade that should have already been closed but wasn't due to halted
 * market conditions.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"tradeID", "clientTradeID", "sourceTransactionID"})
@Data
public class MarketOrderDelayedTradeClose {

  /** The ID of the Trade being closed. */
  @JsonProperty("tradeID")
  @JsonPropertyDescription("The ID of the Trade being closed")
  private String tradeId;

  /** The Client ID of the Trade being closed. */
  @JsonProperty("clientTradeID")
  @JsonPropertyDescription("The Client ID of the Trade being closed")
  private String clientTradeId;

  /**
   * The Transaction ID of the DelayedTradeClosure transaction to which this Delayed Trade Close
   * belongs to.
   */
  @JsonProperty("sourceTransactionID")
  @JsonPropertyDescription(
      "The Transaction ID of the DelayedTradeClosure transaction to which this Delayed "
              + "Trade Close belongs to")
  private String sourceTransactionId;
}
