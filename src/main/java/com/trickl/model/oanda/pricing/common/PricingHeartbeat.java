package com.trickl.model.oanda.pricing.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;

/**
 * A PricingHeartbeat object is injected into the Pricing stream to ensure that the HTTP connection
 * remains active.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"time"})
@Data
@Builder
public class PricingHeartbeat implements PriceStreamMessage {
  @JsonPropertyDescription("The type of the price message.")
  private final PriceStreamMessageType type = PriceStreamMessageType.HEARTBEAT;

  /** The date/time when the Heartbeat was created. */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnnXXX", timezone = "UTC")
  private Instant time;
}
