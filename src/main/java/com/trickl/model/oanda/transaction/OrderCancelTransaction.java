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

/** An OrderCancelTransaction represents the cancellation of an Order in the client's Account. */
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
    "reason",
    "replacedByOrderID"
})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class OrderCancelTransaction extends Transaction {
  /**
   * The Type of the Transaction.
   */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type = TransactionStreamMessageType.ORDER_CANCEL;
  
  /** The ID of the Order cancelled. */
  @JsonProperty("orderID")
  @JsonPropertyDescription("The ID of the Order cancelled")
  private String orderId;
  
  /** The client ID of the Order cancelled (only provided if the Order has a client Order ID). */
  @JsonProperty("clientOrderID")
  @JsonPropertyDescription(
      "The client ID of the Order cancelled (only provided if the Order has a"
              + " client Order ID).")
  private String clientOrderId;
  
  /** The reason that the Order was cancelled. */
  @JsonPropertyDescription("The reason that the Order was cancelled.")
  private OrderCancelReason reason;
  
  /**
   * The ID of the Order that replaced this Order (only provided if this Order was cancelled for
   * replacement).
   */
  @JsonProperty("replacedByOrderID")
  @JsonPropertyDescription(
      "The ID of the Order that replaced this Order (only provided if this Order "
              + "was cancelled for replacement).")
  private String replacedByOrderId;
}
