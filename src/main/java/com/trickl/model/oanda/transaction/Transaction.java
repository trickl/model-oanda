package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Data;

/**
 * The base Transaction specification. Specifies properties that are common between all Transaction.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public abstract class Transaction implements TransactionStreamMessage {

  /** The Transaction's Identifier. */
  @JsonPropertyDescription("The Transaction's Identifier.")
  @NotBlank
  private String id;

  /** The date/time when the Transaction was created. */
  @JsonPropertyDescription("The date/time when the Transaction was created.")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnnX", timezone = "UTC")
  @NotNull
  private Instant time;

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
}
