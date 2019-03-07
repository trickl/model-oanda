package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * A LiquidityRegenerationSchedule indicates how liquidity that is used when filling an Order for an
 * instrument is regenerated following the fill. A liquidity regeneration schedule will be in effect
 * until the timestamp of its final step, but may be replaced by a schedule created for an Order of
 * the same instrument that is filled while it is still in effect.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"steps"})
@Data
@Builder
public class LiquidityRegenerationSchedule {

  /** The steps in the Liquidity Regeneration Schedule. */
  @JsonPropertyDescription("The steps in the Liquidity Regeneration Schedule")
  private List<LiquidityRegenerationScheduleStep> steps = null;
}
