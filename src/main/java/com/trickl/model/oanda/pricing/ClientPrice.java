package com.trickl.model.oanda.pricing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.order.UnitsAvailable;
import com.trickl.model.oanda.pricing.common.PriceBucket;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/** The specification of an Account-specific Price. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "instrument",
    "time",
    "status",
    "tradeable",
    "bids",
    "asks",
    "closeoutBid",
    "closeoutAsk",
    "quoteHomeConversionFactors",
    "unitsAvailable"
})
@Data
@Builder
public class ClientPrice {

  /** The string "PRICE". Used to identify the a Price object when found in a stream. */
  @JsonPropertyDescription(
      "The string \"PRICE\". Used to identify the a Price object when found in a stream.")
  private String type;
  
  /** The Price's Instrument. */
  @JsonPropertyDescription("The Price's Instrument.")
  private String instrument;
  
  /** The date/time when the Price was created. */
  @JsonPropertyDescription("The date/time when the Price was created")
  private String time;
  
  /** The status of the Price. */
  @JsonPropertyDescription("The status of the Price.")
  private PriceStatus status;
  
  /** Flag indicating if the Price is tradeable or not. */
  @JsonPropertyDescription("Flag indicating if the Price is tradeable or not")
  private Boolean tradeable;
  /**
   * The list of prices and liquidity available on the Instrument's bid side. It is possible for
   * this list to be empty if there is no bid liquidity currently available for the Instrument in
   * the Account.
   */
  @JsonPropertyDescription(
      "The list of prices and liquidity available on the Instrument's bid side. "
              + "It is possible for this list to be empty if there is no bid "
              + "liquidity currently available for the Instrument in the Account.")
  private List<PriceBucket> bids = null;
  /**
   * The list of prices and liquidity available on the Instrument's ask side. It is possible for
   * this list to be empty if there is no ask liquidity currently available for the Instrument in
   * the Account.
   */
  
  @JsonPropertyDescription(
      "The list of prices and liquidity available on the Instrument's ask side. "
              + "It is possible for this list to be empty if there is no ask "
              + "liquidity currently available for the Instrument in the Account.")
  private List<PriceBucket> asks = null;
  /**
   * The closeout bid Price. This Price is used when a bid is required to closeout a Position
   * (margin closeout or manual) yet there is no bid liquidity. The closeout bid is never used to
   * open a new position.
   */
  @JsonPropertyDescription(
      "The closeout bid Price. This Price is used when a bid is required to closeout "
              + "a Position (margin closeout or manual) yet there is no bid liquidity."
              + " The closeout bid is never used to open a new position.")
  private String closeoutBid;
  /**
   * The closeout ask Price. This Price is used when a ask is required to closeout a Position
   * (margin closeout or manual) yet there is no ask liquidity. The closeout ask is never used to
   * open a new position.
   */
  @JsonPropertyDescription(
      "The closeout ask Price. This Price is used when a ask is required to closeout"
              + " a Position (margin closeout or manual) yet there is no ask"
              + " liquidity. The closeout ask is never used to open a new position.")
  private String closeoutAsk;

  private QuoteHomeConversionFactors quoteHomeConversionFactors;

  private UnitsAvailable unitsAvailable;
}
