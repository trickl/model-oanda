package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * A MarketOrderPositionCloseout specifies the extensions to a Market Order when it has been created
 * to closeout a specific Position.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"instrument", "units"})
public class MarketOrderPositionCloseout {

  /** The instrument of the Position being closed out. */
  @JsonPropertyDescription("The instrument of the Position being closed out.")
  private String instrument;
  
  /**
   * Indication of how much of the Position to close. Either "ALL", or a DecimalNumber reflection a
   * partial close of the Trade. The DecimalNumber must always be positive, and represent a number
   * that doesn't exceed the absolute size of the Position.
   */
  @JsonPropertyDescription(
      "Indication of how much of the Position to close. Either \"ALL\", or a DecimalNumber"
              + " reflection a partial close of the Trade. The DecimalNumber must"
              + " always be positive, and represent a number that doesn't exceed"
              + " the absolute size of the Position.")
  private String units;
}
