package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/**
 * A TransactionHeartbeat object is injected into the Transaction stream to ensure that the HTTP
 * connection remains active.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "lastTransactionID", "time"})
@Data
@Builder
public class TransactionHeartbeat {

  /** The string "HEARTBEAT". */
  @JsonPropertyDescription("The string \"HEARTBEAT\"")
  private String type;

  /** The ID of the most recent Transaction created for the Account. */
  @JsonProperty("lastTransactionID")
  @JsonPropertyDescription("The ID of the most recent Transaction created for the Account")
  private String lastTransactionId;

  /** The date/time when the TransactionHeartbeat was created. */
  @JsonPropertyDescription("The date/time when the TransactionHeartbeat was created.")
  private String time;
}
