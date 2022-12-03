package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** The Candlestick representation. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"time", "bid", "ask", "mid", "volume", "complete"})
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class Candlestick {

  /** The start time of the candlestick. */
  @JsonPropertyDescription("The start time of the candlestick")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnnXXX", timezone = "UTC")
  private Instant time;

  private CandlestickData bid;

  private CandlestickData ask;

  private CandlestickData mid;

  /** The number of prices created during the time-range represented by the candlestick. */
  @JsonPropertyDescription(
      "The number of prices created during the time-range represented by the candlestick.")
  private long volume;

  /**
   * A flag indicating if the candlestick is complete. A complete candlestick is one whose ending
   * time is not in the future.
   */
  @JsonPropertyDescription(
      "A flag indicating if the candlestick is complete. A complete candlestick"
          + " is one whose ending time is not in the future.")
  private Boolean complete;
}
