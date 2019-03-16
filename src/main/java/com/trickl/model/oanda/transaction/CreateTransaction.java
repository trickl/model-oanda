package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/** A CreateTransaction represents the creation of an Account. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "time",
    "userID",
    "accountID",
    "batchID",
    "requestID",
    "type",
    "divisionID",
    "siteID",
    "accountUserID",
    "accountNumber",
    "homeCurrency"
})
@Data
@Builder
public class CreateTransaction extends Transaction {
  /**
   * The Type of the Transaction.
   */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionType type = TransactionType.CREATE;  
    
  /** The ID of the Division that the Account is in. */
  @JsonProperty("divisionID")
  @JsonPropertyDescription("The ID of the Division that the Account is in")
  private Integer divisionId;
 
  /** The ID of the Site that the Account was created at. */
  @JsonProperty("siteID")
  @JsonPropertyDescription("The ID of the Site that the Account was created at")
  private Integer siteId;
 
  /** The ID of the user that the Account was created for. */
  @JsonProperty("accountUserID")
  @JsonPropertyDescription("The ID of the user that the Account was created for")
  private Integer accountUserId;
  
  /** The number of the Account within the site/division/user. */
  @JsonPropertyDescription("The number of the Account within the site/division/user")
  private Integer accountNumber;
  
  /** The home currency of the Account. */
  @JsonPropertyDescription("The home currency of the Account")
  private String homeCurrency;
}
