package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Data;

/** The Candlestick representation. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"time", "bid", "ask", "mid", "volume", "complete"})
@Data
public class Candlestick {

  /** The start time of the candlestick. */
  @JsonPropertyDescription("The start time of the candlestick")
  private String time;

  private List<CandlestickData> bid;

  private List<CandlestickData> ask;

  private List<CandlestickData> mid;

  /** The number of prices created during the time-range represented by the candlestick. */
  @JsonPropertyDescription(
      "The number of prices created during the time-range represented by the candlestick.")
  private Integer volume;

  /**
   * A flag indicating if the candlestick is complete. A complete candlestick is one whose ending
   * time is not in the future.
   */
  @JsonPropertyDescription(
      "A flag indicating if the candlestick is complete. A complete candlestick"
          + " is one whose ending time is not in the future.")
  private Boolean complete;
}
