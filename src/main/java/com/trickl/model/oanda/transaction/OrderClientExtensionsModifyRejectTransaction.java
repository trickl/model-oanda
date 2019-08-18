package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
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
@Builder
public class OrderClientExtensionsModifyRejectTransaction extends Transaction {
  /** The Type of the Transaction. */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type =
      TransactionStreamMessageType.ORDER_CLIENT_EXTENSIONS_MODIFY_REJECT;

  /** The ID of the Order who's client extensions are to be modified. */
  @JsonProperty("orderID")
  @JsonPropertyDescription("The ID of the Order who's client extensions are to be modified.")
  private String orderId;

  /** The original Client ID of the Order who's client extensions are to be modified. */
  @JsonProperty("clientOrderID")
  @JsonPropertyDescription(
      "The original Client ID of the Order who's client extensions are to be modified.")
  private String clientOrderId;

  private ClientExtensions clientExtensionsModify;

  private ClientExtensions tradeClientExtensionsModify;

  /** The reason that the Reject Transaction was created. */
  @JsonPropertyDescription("The reason that the Reject Transaction was created")
  private RejectReason rejectReason;
}
