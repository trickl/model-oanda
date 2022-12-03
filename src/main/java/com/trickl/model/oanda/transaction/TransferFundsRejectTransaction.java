package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A TransferFundsRejectTransaction represents the rejection of the transfer of funds in/out of an
 * Account.
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
    "amount",
    "fundingReason",
    "comment",
    "rejectReason"
})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TransferFundsRejectTransaction extends Transaction {
  /** The Type of the Transaction. */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type =
      TransactionStreamMessageType.TRANSFER_FUNDS_REJECT;

  /**
   * The amount to deposit/withdraw from the Account in the Account's home currency. A positive
   * value indicates a deposit, a negative value indicates a withdrawal.
   */
  @JsonPropertyDescription(
      "The amount to deposit/withdraw from the Account in the Account's home currency. "
          + "A positive value indicates a deposit, a negative value indicates"
          + " a withdrawal.")
  private String amount;

  /** The reason that an Account is being funded. */
  @JsonPropertyDescription("The reason that an Account is being funded.")
  private FundingReason fundingReason;

  /** An optional comment that may be attached to a fund transfer for audit purposes. */
  @JsonPropertyDescription(
      "An optional comment that may be attached to a fund transfer for audit purposes")
  private String comment;

  /** The reason that the Reject Transaction was created. */
  @JsonPropertyDescription("The reason that the Reject Transaction was created")
  private RejectReason rejectReason;
}
