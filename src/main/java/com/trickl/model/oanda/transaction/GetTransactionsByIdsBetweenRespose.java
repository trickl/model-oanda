package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/** The response from the /v3/accounts/{accountId}/transactions/idrange edpoint. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "transactions",
    "lastTransactionID",
})
@Data
@Builder
public class GetTransactionsByIdsBetweenRespose {
  /* The list of Transactions that satisfy the request. */
  @JsonPropertyDescription("The list of Transactions that satisfy the request.")
  private List<Transaction> transactions;

  /* The ID of the most recent Transaction created for the Account. */
  @JsonProperty("lastTransactionID")
  @JsonPropertyDescription("The ID of the most recent Transaction created for the Account")
  private String lastTransactionId;
}
