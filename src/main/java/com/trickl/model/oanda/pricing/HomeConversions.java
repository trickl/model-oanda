package com.trickl.model.oanda.pricing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * HomeConversions represents the factors to use to convert quantities of a given currency into the
 * Account's home currency. The conversion factor depends on the scenario the conversion is required
 * for.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"currency", "accountGain", "accountLoss", "positionValue"})
public class HomeConversions {

  /** The currency to be converted into the home currency. */
  @JsonPropertyDescription("The currency to be converted into the home currency.")
  private String currency;
 
  /**
   * The factor used to convert any gains for an Account in the specified currency into the
   * Account's home currency. This would include positive realized P/L and positive financing
   * amounts. Conversion is performed by multiplying the positive P/L by the conversion factor.
   */
  @JsonPropertyDescription(
      "The factor used to convert any gains for an Account in the specified currency "
              + "into the Account's home currency. This would include positive realized"
              + " P/L and positive financing amounts. Conversion is performed by"
              + " multiplying the positive P/L by the conversion factor.")
  private String accountGain;
  
  /** The string representation of a decimal number. */
  @JsonPropertyDescription("The string representation of a decimal number.")
  private String accountLoss;
  
  /**
   * The factor used to convert a Position or Trade Value in the specified currency into the
   * Account's home currency. Conversion is performed by multiplying the Position or Trade Value by
   * the conversion factor.
   */
  @JsonPropertyDescription(
      "The factor used to convert a Position or Trade Value in the specified currency "
              + "into the Account's home currency. Conversion is performed by multiplying "
              + "the Position or Trade Value by the conversion factor.")
  private String positionValue;
}
