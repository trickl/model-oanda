package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A TransactionHeartbeat object is injected into the Transaction stream to ensure that the HTTP
 * connection remains active.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "lastTransactionID", "time"})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TransactionHeartbeat implements TransactionStreamMessage {

  /** The string "HEARTBEAT". */
  @JsonPropertyDescription("The string \"HEARTBEAT\"")  
  private final TransactionStreamMessageType type = TransactionStreamMessageType.HEARTBEAT;

  /** The ID of the most recent Transaction created for the Account. */
  @JsonProperty("lastTransactionID")
  @JsonPropertyDescription("The ID of the most recent Transaction created for the Account")
  private String lastTransactionId;

  /** The date/time when the TransactionHeartbeat was created. */
  @JsonPropertyDescription("The date/time when the TransactionHeartbeat was created.")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnnXXX", timezone = "UTC")
  private Instant time;
}
