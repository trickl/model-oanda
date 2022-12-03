package com.trickl.model.oanda.primitives;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** An InstrumentCommission represents an instrument-specific commission. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"commission", "unitsTraded", "minimumCommission"})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class InstrumentCommission {

  /**
   * The commission amount (in the Account's home currency) charged per unitsTraded of the
   * instrument.
   */
  @JsonPropertyDescription(
      "The commission amount (in the Account's home currency) charged per unitsTraded "
              + "of the instrument")
  private String commission;

  /** The number of units traded that the commission amount is based on. */
  @JsonPropertyDescription("The number of units traded that the commission amount"
          + " is based on.")
  private String unitsTraded;

  /**
   * The minimum commission amount (in the Account's home currency) that is charged when an Order is
   * filled for this instrument.
   */
  @JsonPropertyDescription(
      "The minimum commission amount (in the Account's home currency) that is charged "
              + "when an Order is filled for this instrument.")
  private String minimumCommission;
}
