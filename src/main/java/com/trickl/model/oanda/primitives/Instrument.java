package com.trickl.model.oanda.primitives;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Full specification of an Instrument. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "type",
    "displayName",
    "pipLocation",
    "displayPrecision",
    "tradeUnitsPrecision",
    "minimumTradeSize",
    "maximumTrailingStopDistance",
    "minimumTrailingStopDistance",
    "maximumPositionSize",
    "maximumOrderUnits",
    "marginRate",
    "commission"
})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Instrument {

  /** The name of the Instrument. */
  @JsonPropertyDescription("The name of the Instrument")
  private String name;

  /** The type of the Instrument. */
  @JsonProperty("type")
  @JsonPropertyDescription("The type of the Instrument")
  private InstrumentType type;

  /** The display name of the Instrument. */
  @JsonPropertyDescription("The display name of the Instrument")
  private String displayName;

  /**
   * The location of the "pip" for this instrument. The decimal position of the pip in this
   * Instrument's price can be found at 10 ^ pipLocation (e.g. -4 pipLocation results in a decimal
   * pip position of 10 ^ -4 = 0.0001).
   */
  @JsonPropertyDescription(
      "The location of the \"pip\" for this instrument. The decimal position of "
              + "the pip in this Instrument's price can be found at 10 ^ pipLocation"
              + " (e.g. -4 pipLocation results in a decimal pip position of 10 ^ -4 "
              + "= 0.0001).")
  private Integer pipLocation;

  /**
   * The number of decimal places that should be used to display prices for this instrument. (e.g. a
   * displayPrecision of 5 would result in a price of "1" being displayed as "1.00000")
   */
  @JsonPropertyDescription(
      "The number of decimal places that should be used to display prices for this "
              + "instrument. (e.g. a displayPrecision of 5 would result in a price "
              + "of \"1\" being displayed as \"1.00000\")")
  private Integer displayPrecision;

  /**
   * The amount of decimal places that may be provided when specifying the number of units traded
   * for this instrument.
   */
  @JsonPropertyDescription(
      "The amount of decimal places that may be provided when specifying the number"
              + " of units traded for this instrument.")
  private Integer tradeUnitsPrecision;

  /** The smallest number of units allowed to be traded for this instrument. */
  @JsonPropertyDescription("The smallest number of units allowed to be traded for"
          + " this instrument.")
  private String minimumTradeSize;

  /**
   * The maximum trailing stop distance allowed for a trailing stop loss created for this
   * instrument. Specified in price units.
   */
  @JsonPropertyDescription(
      "The maximum trailing stop distance allowed for a trailing stop loss created"
              + " for this instrument. Specified in price units.")
  private String maximumTrailingStopDistance;

  /**
   * The minimum trailing stop distance allowed for a trailing stop loss created for this
   * instrument. Specified in price units.
   */
  @JsonPropertyDescription(
      "The minimum trailing stop distance allowed for a trailing stop loss created"
              + " for this instrument. Specified in price units.")
  private String minimumTrailingStopDistance;

  /** The maximum position size allowed for this instrument. Specified in units. */
  @JsonPropertyDescription(
      "The maximum position size allowed for this instrument. Specified in units.")
  private String maximumPositionSize;

  /** The maximum units allowed for an Order placed for this instrument. Specified in units. */
  @JsonPropertyDescription(
      "The maximum units allowed for an Order placed for this instrument."
              + " Specified in units.")
  private String maximumOrderUnits;

  /** The margin rate for this instrument. */
  @JsonPropertyDescription("The margin rate for this instrument.")
  private String marginRate;

  private InstrumentCommission commission;
}
