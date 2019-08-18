package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/**
 * A TradeClientExtensionsModifyRejectTransaction represents the rejection of the modification of a
 * Trade's Client Extensions.
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
    "tradeID",
    "clientTradeID",
    "tradeClientExtensionsModify",
    "rejectReason"
})
@Data
@Builder
public class TradeClientExtensionsModifyRejectTransaction extends Transaction {
  /** The Type of the Transaction. */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type =
      TransactionStreamMessageType.TRADE_CLIENT_EXTENSIONS_MODIFY_REJECT;

  /** The ID of the Trade who's client extensions are to be modified. */
  @JsonProperty("tradeID")
  @JsonPropertyDescription("The ID of the Trade who's client extensions are to be" + " modified.")
  private String tradeId;

  /** The original Client ID of the Trade who's client extensions are to be modified. */
  @JsonProperty("clientTradeID")
  @JsonPropertyDescription(
      "The original Client ID of the Trade who's client extensions are to be" + " modified.")
  private String clientTradeId;

  private ClientExtensions tradeClientExtensionsModify;

  /** The reason that the Reject Transaction was created. */
  @JsonPropertyDescription("The reason that the Reject Transaction was created")
  private RejectReason rejectReason;
}
