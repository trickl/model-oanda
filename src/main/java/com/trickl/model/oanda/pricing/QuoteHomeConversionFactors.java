package com.trickl.model.oanda.pricing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * QuoteHomeConversionFactors represents the factors that can be used used to convert quantities of
 * a Price's Instrument's quote currency into the Account's home currency.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"positiveUnits", "negativeUnits"})
@Data
public class QuoteHomeConversionFactors {

  /**
   * The factor used to convert a positive amount of the Price's Instrument's quote currency into a
   * positive amount of the Account's home currency. Conversion is performed by multiplying the
   * quote units by the conversion factor.
   */
  @JsonPropertyDescription(
      "The factor used to convert a positive amount of the Price's Instrument's "
              + "quote currency into a positive amount of the Account's home currency."
              + " Conversion is performed by multiplying the quote units by the"
              + " conversion factor.")
  private String positiveUnits;
  
  /**
   * The factor used to convert a negative amount of the Price's Instrument's quote currency into a
   * negative amount of the Account's home currency. Conversion is performed by multiplying the
   * quote units by the conversion factor.
   */
  @JsonPropertyDescription(
      "The factor used to convert a negative amount of the Price's Instrument's "
              + "quote currency into a negative amount of the Account's home currency."
              + " Conversion is performed by multiplying the quote units by the"
              + " conversion factor.")
  private String negativeUnits;
}
