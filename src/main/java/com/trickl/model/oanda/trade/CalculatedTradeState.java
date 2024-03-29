package com.trickl.model.oanda.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** The dynamic (calculated) state of an open Trade. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "unrealizedPL", "marginUsed"})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CalculatedTradeState {

  /** The Trade's ID. */
  @JsonPropertyDescription("The Trade's ID.")
  private String id;
  
  /** The Trade's unrealized profit/loss. */
  @JsonProperty("unrealizedPL")
  @JsonPropertyDescription("The Trade's unrealized profit/loss.")
  private String unrealizedPandL;
  
  /** Margin currently used by the Trade. */
  @JsonPropertyDescription("Margin currently used by the Trade.")
  private String marginUsed;
}
