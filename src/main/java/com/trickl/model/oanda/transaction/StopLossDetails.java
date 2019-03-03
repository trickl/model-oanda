package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.order.TimeInForce;
import lombok.Data;

/**
 * StopLossDetails specifies the details of a Stop Loss Order to be created on behalf of a client.
 * This may happen when an Order is filled that opens a Trade requiring a Stop Loss, or when a
 * Trade's dependent Stop Loss Order is modified directly through the Trade.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "price",
    "distance",
    "timeInForce",
    "gtdTime",
    "clientExtensions",
    "guaranteed"
})
@Data
public class StopLossDetails {

  /**
   * The price that the Stop Loss Order will be triggered at. Only one of the price and distance
   * fields may be specified.
   */
  @JsonPropertyDescription(
      "The price that the Stop Loss Order will be triggered at. Only one of the "
              + "price and distance fields may be specified.")
  private String price;
  
  /**
   * Specifies the distance (in price units) from the Trade's open price to use as the Stop Loss
   * Order price. Only one of the distance and price fields may be specified.
   */
  @JsonPropertyDescription(
      "Specifies the distance (in price units) from the Trade's open price to use as "
              + "the Stop Loss Order price. Only one of the distance and price fields"
              + " may be specified.")
  private String distance;
  
  /** The time in force for the created Stop Loss Order. This may only be GTC, GTD or GFD. */
  @JsonPropertyDescription(
      "The time in force for the created Stop Loss Order. This may only be GTC, GTD or GFD.")
  private TimeInForce timeInForce;
  
  /** The date when the Stop Loss Order will be cancelled on if timeInForce is GTD. */
  @JsonPropertyDescription(
      "The date when the Stop Loss Order will be cancelled on if timeInForce is GTD.")
  private String gtdTime;

  private Object clientExtensions;
  /**
   * Flag indicating that the price for the Stop Loss Order is guaranteed. The default value depends
   * on the GuaranteedStopLossOrderMode of the account, if it is REQUIRED, the default will be true,
   * for DISABLED or ENABLED the default is false.
   */
  @JsonPropertyDescription(
      "Flag indicating that the price for the Stop Loss Order is guaranteed."
              + " The default value depends on the GuaranteedStopLossOrderMode"
              + " of the account, if it is REQUIRED, the default will be true,"
              + " for DISABLED or ENABLED the default is false.")
  private Boolean guaranteed;
}
