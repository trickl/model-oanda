package com.trickl.model.oanda.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/** The response from the /v3/accounts/ endpoint. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "positions",
    "accounts",
})
@Data
@Builder
public class GetAccountsResponse {
  /* The list of Accounts the client is authorized to access 
   * and their associated properties. */
  @JsonPropertyDescription("The list of Accounts the client is authorized to access "
          + "and their associated properties.")
  private List<AccountProperties> accounts;

  /* The ID of the most recent Transaction created for the Account. */
  @JsonProperty("lastTransactionID")
  @JsonPropertyDescription("The ID of the most recent Transaction created for the Account")
  private String lastTransactionId;
}
