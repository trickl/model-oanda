package com.trickl.model.oanda.order;

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
 * An OrderIdentifier is used to refer to an Order, and contains both the OrderID and the
 * ClientOrderID.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"orderID", "clientOrderID"})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class OrderIdentifier {

  /** The OANDA-assigned Order ID. */
  @JsonProperty("orderID")
  @JsonPropertyDescription("The OANDA-assigned Order ID")
  private String orderId;

  /** The client-provided client Order ID. */
  @JsonProperty("clientOrderID")
  @JsonPropertyDescription("The client-provided client Order ID")
  private String clientOrderId;
}
