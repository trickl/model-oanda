package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/**
 * An OrderCancelRejectTransaction represents the rejection of the cancellation of an Order in the
 * client's Account.
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
    "rejectReason"
})
@Data
@Builder
public class OrderCancelRejectTransaction extends Transaction {
  /** The Type of the Transaction. */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type =
      TransactionStreamMessageType.ORDER_CANCEL_REJECT;

  /** The ID of the Order intended to be cancelled. */
  @JsonProperty("orderID")
  @JsonPropertyDescription("The ID of the Order intended to be cancelled")
  private String orderId;
  /**
   * The client ID of the Order intended to be cancelled (only provided if the Order has a client
   * Order ID).
   */
  @JsonProperty("clientOrderId")
  @JsonPropertyDescription(
      "The client ID of the Order intended to be cancelled (only provided if the "
          + "Order has a client Order ID).")
  private String clientOrderId;

  /** The reason that the Reject Transaction was created. */
  @JsonPropertyDescription("The reason that the Reject Transaction was created")
  private RejectReason rejectReason;
}
