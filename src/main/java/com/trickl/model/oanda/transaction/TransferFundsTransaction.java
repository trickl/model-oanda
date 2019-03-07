package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/** A TransferFundsTransaction represents the transfer of funds in/out of an Account. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "time",
    "userID",
    "accountID",
    "batchID",
    "requestID",
    "type",
    "amount",
    "fundingReason",
    "comment",
    "accountBalance"
})
@Data
@Builder
public class TransferFundsTransaction {

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
      "The ID of the \"batch\" that the Transaction belongs to."
              + " Transactions in the same batch are applied to the Account"
              + " simultaneously.")
  private String batchId;
  
  /** The Request ID of the request which generated the transaction. */
  @JsonProperty("requestID")
  @JsonPropertyDescription("The Request ID of the request which generated the transaction.")
  private String requestId;
  
  /** The Type of the Transaction. Always set to "TRANSFER_FUNDS" in a TransferFundsTransaction. */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"TRANSFER_FUNDS\" in a"
              + " TransferFundsTransaction.")
  private TransactionType type;
  
  /**
   * The amount to deposit/withdraw from the Account in the Account's home currency. A positive
   * value indicates a deposit, a negative value indicates a withdrawal.
   */
  @JsonPropertyDescription(
      "The amount to deposit/withdraw from the Account in the Account's home currency."
              + " A positive value indicates a deposit, a negative value indicates"
              + " a withdrawal.")
  private String amount;
  
  /** The reason that an Account is being funded. */
  @JsonPropertyDescription("The reason that an Account is being funded.")
  private FundingReason fundingReason;
  
  /** An optional comment that may be attached to a fund transfer for audit purposes. */
  @JsonPropertyDescription(
      "An optional comment that may be attached to a fund transfer for audit purposes")
  private String comment;
  
  /** The Account's balance after funds are transferred. */
  @JsonPropertyDescription("The Account's balance after funds are transferred.")
  private String accountBalance;
}
