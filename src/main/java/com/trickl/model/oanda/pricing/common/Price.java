package com.trickl.model.oanda.pricing.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Data;

/** The Price representation. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "instrument",
    "tradeable",
    "timestamp",
    "baseBid",
    "baseAsk",
    "bids",
    "asks",
    "closeoutBid",
    "closeoutAsk"
})
@Data
public class Price {

  /** The Price's Instrument. */
  @JsonPropertyDescription("The Price's Instrument.")
  private String instrument;
 
  /** Flag indicating if the Price is tradeable or not. */
  @JsonPropertyDescription("Flag indicating if the Price is tradeable or not")
  private Boolean tradeable;
 
  /** The date/time when the Price was created. */
  @JsonPropertyDescription("The date/time when the Price was created.")
  private String timestamp;
 
  /** The base bid price as calculated by pricing. */
  @JsonPropertyDescription("The base bid price as calculated by pricing.")
  private String baseBid;
 
  /** The base ask price as calculated by pricing. */
  @JsonPropertyDescription("The base ask price as calculated by pricing.")
  private String baseAsk;
 
  /**
   * The list of prices and liquidity available on the Instrument's bid side. It is possible for
   * this list to be empty if there is no bid liquidity currently available for the Instrument in
   * the Account.
   */
  @JsonPropertyDescription(
      "The list of prices and liquidity available on the Instrument's bid side. "
              + "It is possible for this list to be empty if there is no bid"
              + " liquidity currently available for the Instrument in the Account.")
  private List<PriceBucket> bids = null;
  
  /**
   * The list of prices and liquidity available on the Instrument's ask side. It is possible for
   * this list to be empty if there is no ask liquidity currently available for the Instrument in
   * the Account.
   */
  @JsonPropertyDescription(
      "The list of prices and liquidity available on the Instrument's ask side."
              + " It is possible for this list to be empty if there is no ask"
              + " liquidity currently available for the Instrument in the Account.")
  private List<PriceBucket> asks = null;
 
  /**
   * The closeout bid price. This price is used when a bid is required to closeout a Position
   * (margin closeout or manual) yet there is no bid liquidity. The closeout bid is never used to
   * open a new position.
   */
  @JsonPropertyDescription(
      "The closeout bid price. This price is used when a bid is required to closeout "
              + "a Position (margin closeout or manual) yet there is no bid liquidity."
              + " The closeout bid is never used to open a new position.")
  private String closeoutBid;
  
  /**
   * The closeout ask price. This price is used when an ask is required to closeout a Position
   * (margin closeout or manual) yet there is no ask liquidity. The closeout ask is never used to
   * open a new position.
   */
  @JsonPropertyDescription(
      "The closeout ask price. This price is used when an ask is required to closeout"
              + " a Position (margin closeout or manual) yet there is no ask liquidity."
              + " The closeout ask is never used to open a new position.")
  private String closeoutAsk;
}
