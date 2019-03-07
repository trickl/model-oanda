package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.primitives.GuaranteedStopLossOrderLevelRestriction;
import lombok.Builder;
import lombok.Data;

/** Details required by clients creating a Guaranteed Stop Loss Order. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"minimumDistance", "premium", "levelRestriction"})
@Builder
@Data
public class GuaranteedStopLossOrderEntryData {

  /**
   * The minimum distance allowed between the Trade's fill price and the configured price for
   * guaranteed Stop Loss Orders created for this instrument. Specified in price units.
   */
  @JsonPropertyDescription(
      "The minimum distance allowed between the Trade's fill "
          + "price and the configured price for guaranteed Stop Loss Orders created "
          + "for this instrument. Specified in price units.")
  private String minimumDistance;

  /**
   * The amount that is charged to the account if a guaranteed Stop Loss Order is triggered and
   * filled. The value is in price units and is charged for each unit of the Trade.
   */
  @JsonPropertyDescription(
      "The amount that is charged to the account if a guaranteed "
          + "Stop Loss Order is triggered and filled. The value is in price units "
          + "and is charged for each unit of the Trade.")
  private String premium;

  private GuaranteedStopLossOrderLevelRestriction levelRestriction;
}
