package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
public class CreateTransaction {

  /** The Transaction's Identifier. */
  @JsonPropertyDescription("The Transaction's Identifier.")
  private String id;
  
  /** The date/time when the Transaction was created. */
  @JsonPropertyDescription("The date/time when the Transaction was created.")
  private String time;
 
  /** The ID of the user that initiated the creation of the Transaction. */
  @JsonProperty("userID")
  @JsonPropertyDescription("The ID of the user that initiated the creation of the Transaction.")
  private Integer userId;
  
  /** The ID of the Account the Transaction was created for. */
  @JsonProperty("accountID")
  @JsonPropertyDescription("The ID of the Account the Transaction was created for.")
  private String accountId;
  
  /**
   * The ID of the "batch" that the Transaction belongs to. Transactions in the same batch are
   * applied to the Account simultaneously.
   */
  @JsonProperty("batchID")
  @JsonPropertyDescription(
      "The ID of the \"batch\" that the Transaction belongs to. Transactions in the "
              + "same batch are applied to the Account simultaneously.")
  private String batchId;
  
  /** The Request ID of the request which generated the transaction. */
  @JsonProperty("requestID")
  @JsonPropertyDescription("The Request ID of the request which generated the transaction.")
  private String requestId;
  
  /** The Type of the Transaction. Always set to "CREATE" in a CreateTransaction. */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"CREATE\" in a CreateTransaction.")
  private TransactionType type;
  
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
