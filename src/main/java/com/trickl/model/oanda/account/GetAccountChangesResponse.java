package com.trickl.model.oanda.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/** The response from the /v3/accounts/{accountId} endpoint. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "changes",
    "state",
    "lastTransactionID",
})
@Data
@Builder
public class GetAccountChangesResponse {
  /*  The changes to the Account’s Orders, Trades and Positions since the
   * specified Transaction ID. Only provided if the sinceTransactionID is
   * supplied to the poll request. */
  @JsonPropertyDescription(
      " The changes to the Account’s Orders, Trades and Positions since the"
          + " specified Transaction ID. Only provided if the sinceTransactionID is"
          + " supplied to the poll request.")
  private AccountChanges changes;

  /* The Account’s current price-dependent state. */
  @JsonPropertyDescription("The Account’s current price-dependent state.")
  private AccountChangesState state;

  /* The ID of the most recent Transaction created for the Account. */
  @JsonProperty("lastTransactionID")
  @JsonPropertyDescription("The ID of the most recent Transaction created for the Account")
  private String lastTransactionId;
}
