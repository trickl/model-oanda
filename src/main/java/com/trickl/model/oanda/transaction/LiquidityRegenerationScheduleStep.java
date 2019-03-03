package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * A liquidity regeneration schedule Step indicates the amount of bid and ask liquidity that is used
 * by the Account at a certain time. These amounts will only change at the timestamp of the
 * following step.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"timestamp", "bidLiquidityUsed", "askLiquidityUsed"})
@Data
public class LiquidityRegenerationScheduleStep {

  /** The timestamp of the schedule step. */
  @JsonPropertyDescription("The timestamp of the schedule step.")
  private String timestamp;
  
  /** The amount of bid liquidity used at this step in the schedule. */
  @JsonPropertyDescription("The amount of bid liquidity used at this step in the schedule.")
  private String bidLiquidityUsed;
 
  /** The amount of ask liquidity used at this step in the schedule. */
  @JsonPropertyDescription("The amount of ask liquidity used at this step in the schedule.")
  private String askLiquidityUsed;
}
