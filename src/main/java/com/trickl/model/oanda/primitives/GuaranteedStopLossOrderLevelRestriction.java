package com.trickl.model.oanda.primitives;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A GuaranteedStopLossOrderLevelRestriction represents the total position size that can exist
 * within a given price window for Trades with guaranteed Stop Loss Orders attached for a specific
 * Instrument.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"volume", "priceRange"})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class GuaranteedStopLossOrderLevelRestriction {

  /**
   * Applies to Trades with a guaranteed Stop Loss Order attached for the specified Instrument. This
   * is the total allowed Trade volume that can exist within the priceRange based on the trigger
   * prices of the guaranteed Stop Loss Orders.
   */
  @JsonPropertyDescription(
      "Applies to Trades with a guaranteed Stop Loss Order attached for the specified"
              + " Instrument. This is the total allowed Trade volume that can exist"
              + " within the priceRange based on the trigger prices of the guaranteed"
              + " Stop Loss Orders.")
  private String volume;
  
  /** The price range the volume applies to. This value is in price units. */
  @JsonPropertyDescription("The price range the volume applies to. This value is "
          + "in price units.")
  private String priceRange;
}
