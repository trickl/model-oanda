package com.trickl.model.oanda.pricing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * A PricingHeartbeat object is injected into the Pricing stream to ensure that the HTTP connection
 * remains active.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "time"})
@Data
public class PricingHeartbeat {

  /** The string "HEARTBEAT". */
  @JsonPropertyDescription("The string \"HEARTBEAT\"")
  private String type;
 
  /** The date/time when the Heartbeat was created. */
  @JsonPropertyDescription("The date/time when the Heartbeat was created.")
  private String time;
}
