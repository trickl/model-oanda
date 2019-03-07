package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/** The price data (open, high, low, close) for the Candlestick representation. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"o", "h", "l", "c"})
@Builder
@Data
public class CandlestickData {

  /** The first (open) price in the time-range represented by the candlestick. */
  @JsonProperty("o")
  @JsonPropertyDescription(
      "The first (open) price in the time-range represented by the candlestick.")
  private String open;
  /** The highest price in the time-range represented by the candlestick. */
  @JsonProperty("h")
  @JsonPropertyDescription("The highest price in the time-range represented by the candlestick.")
  private String high;
  /** The lowest price in the time-range represented by the candlestick. */
  @JsonProperty("l")
  @JsonPropertyDescription("The lowest price in the time-range represented by the candlestick.")
  private String last;
  /** The last (closing) price in the time-range represented by the candlestick. */
  @JsonProperty("c")
  @JsonPropertyDescription(
      "The last (closing) price in the time-range represented by the candlestick.")
  private String close;
}
