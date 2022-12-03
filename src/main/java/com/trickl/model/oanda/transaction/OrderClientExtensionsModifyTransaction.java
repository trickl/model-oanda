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
 * A OrderClientExtensionsModifyTransaction represents the rejection of the modification of an
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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class OrderClientExtensionsModifyTransaction extends Transaction {
  /** The Type of the Transaction. */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type =
      TransactionStreamMessageType.ORDER_CLIENT_EXTENSIONS_MODIFY;

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
}
