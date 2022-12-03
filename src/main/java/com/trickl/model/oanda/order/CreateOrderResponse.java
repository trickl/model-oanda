package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.transaction.OrderCancelTransaction;
import com.trickl.model.oanda.transaction.OrderFillTransaction;
import com.trickl.model.oanda.transaction.Transaction;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** The response from the /v3/accounts/{accountId}/orders endpoint. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "orderCreateTransaction",
    "orderFillTransaction",
    "orderCancelTransaction",
    "orderReissueTransaction",
    "orderReissueRejectTransaction",
    "relatedTransactionIds",
    "lastTransactionId"
})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CreateOrderResponse {
  /*
   * The Transaction that created the Order specified by the request.
   */
  @JsonPropertyDescription("The list of Orders that satisfy the request.")
  private Transaction orderCreateTransaction;

  /*
   * The Transaction that filled the newly created Order. Only provided when
   * the Order was immediately filled.
   */
  @JsonPropertyDescription(
      "The Transaction that filled the newly created Order. Only provided when\n"
          + " * the Order was immediately filled.")
  private OrderFillTransaction orderFillTransaction;

  /*
   * The Transaction that cancelled the newly created Order. Only provided
   * when the Order was immediately cancelled.
   */
  @JsonPropertyDescription(
      "The Transaction that cancelled the newly created Order. Only provided\n"
          + " * when the Order was immediately cancelled. ")
  private OrderCancelTransaction orderCancelTransaction;

  /*
   * The Transaction that reissues the Order. Only provided when the Order is
   * configured to be reissued for its remaining units after a partial fill
   * and the reissue was successful.
   */
  @JsonPropertyDescription(
      "The Transaction that reissues the Order. Only provided when the Order is\n"
          + " * configured to be reissued for its remaining units after a partial fill\n"
          + " * and the reissue was successful. ")
  private Transaction orderReissueTransaction;

  /*
   * The Transaction that rejects the reissue of the Order. Only provided when
   * the Order is configured to be reissued for its remaining units after a
   * partial fill and the reissue was rejected.
   */
  @JsonPropertyDescription(
      "The Transaction that rejects the reissue of the Order. Only provided when\n"
          + " * the Order is configured to be reissued for its remaining units after a\n"
          + " * partial fill and the reissue was rejected.")
  private Transaction orderReissueRejectTransaction;

  /*
   * The IDs of all Transactions that were created while satisfying the
   * request.
   */
  @JsonProperty("relatedTransactionIDs")
  @JsonPropertyDescription(
      "The IDs of all Transactions that were created while satisfying the\n" + " request.")
  private List<String> relatedTransactionIds;

  /* The ID of the most recent Transaction created for the Account. */
  @JsonProperty("lastTransactionID")
  @JsonPropertyDescription("The ID of the most recent Transaction created for the Account")
  private String lastTransactionId;
}
