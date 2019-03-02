package com.trickl.model.oanda.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/** The dynamic (calculated) state of an open Trade. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "unrealizedPL", "marginUsed"})
@Data
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
