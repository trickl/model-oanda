package com.trickl.model.oanda.position;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/** The response from the /v3/accounts/{accountId}/positions/{instrumentId} endpoint. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "position",
    "lastTransactionID",
})
@Data
@Builder
public class GetPositionResponse {
  /* The requested Position.. */
  @JsonPropertyDescription("The requested Position.")
  private Position position;

  /* The ID of the most recent Transaction created for the Account. */
  @JsonProperty("lastTransactionID")
  @JsonPropertyDescription("The ID of the most recent Transaction created for the Account")
  private String lastTransactionId;
}
