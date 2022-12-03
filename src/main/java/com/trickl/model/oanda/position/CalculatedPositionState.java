package com.trickl.model.oanda.position;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** The dynamic (calculated) state of a Position. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "instrument",
    "netUnrealizedPL",
    "longUnrealizedPL",
    "shortUnrealizedPL",
    "marginUsed"
})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CalculatedPositionState {

  /** The Position's Instrument. */
  @JsonPropertyDescription("The Position's Instrument.")
  private String instrument;
  
  /** The Position's net unrealized profit/loss. */
  @JsonProperty("netUnrealizedPL")
  @JsonPropertyDescription("The Position's net unrealized profit/loss")
  private String netUnrealizedPandL;
  
  /** The unrealized profit/loss of the Position's long open Trades. */
  @JsonProperty("longUnrealizedPL")
  @JsonPropertyDescription("The unrealized profit/loss of the Position's long open Trades")
  private String longUnrealizedPandL;
  
  /** The unrealized profit/loss of the Position's short open Trades. */
  @JsonProperty("shortUnrealizedPL")
  @JsonPropertyDescription("The unrealized profit/loss of the Position's short open Trades")
  private String shortUnrealizedPandL;
  
  /** Margin currently used by the Position. */
  @JsonPropertyDescription("Margin currently used by the Position.")
  private String marginUsed;
}
