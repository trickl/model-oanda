package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * A DailyFinancingTransaction represents the daily payment/collection of financing for an Account.
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
    "financing",
    "accountBalance",
    "accountFinancingMode",
    "positionFinancings"
})
@Data
@Builder
public class DailyFinancingTransaction {

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
      "The ID of the \"batch\" that the Transaction belongs to. "
              + "Transactions in the same batch are applied to the Account simultaneously.")
  private String batchId;
  
  /** The Request ID of the request which generated the transaction. */
  @JsonProperty("requestID")
  @JsonPropertyDescription("The Request ID of the request which generated the transaction.")
  private String requestId;
  
  /**
   * The Type of the Transaction. Always set to "DAILY_FINANCING" for a DailyFinancingTransaction.
   */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"DAILY_FINANCING\" for a "
              + "DailyFinancingTransaction.")
  private TransactionType type;
  
  /** The amount of financing paid/collected for the Account. */
  @JsonPropertyDescription("The amount of financing paid/collected for the Account.")
  private String financing;
  
  /** The Account's balance after daily financing. */
  @JsonPropertyDescription("The Account's balance after daily financing.")
  private String accountBalance;
  
  /** The account financing mode at the time of the daily financing. */
  @JsonPropertyDescription("The account financing mode at the time of the daily financing.")
  private AccountFinancingMode accountFinancingMode;
  
  /** The financing paid/collected for each Position in the Account. */
  @JsonPropertyDescription("The financing paid/collected for each Position in the Account.")
  private List<PositionFinancing> positionFinancings = null;  
}
