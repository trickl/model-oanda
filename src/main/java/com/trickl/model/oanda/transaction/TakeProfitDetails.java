package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.order.TimeInForce;
import lombok.Builder;
import lombok.Data;

/**
 * TakeProfitDetails specifies the details of a Take Profit Order to be created on behalf of a
 * client. This may happen when an Order is filled that opens a Trade requiring a Take Profit, or
 * when a Trade's dependent Take Profit Order is modified directly through the Trade.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"price", "timeInForce", "gtdTime", "clientExtensions"})
@Data
@Builder
public class TakeProfitDetails {

  /**
   * The price that the Take Profit Order will be triggered at. Only one of the price and distance
   * fields may be specified.
   */
  @JsonPropertyDescription(
      "The price that the Take Profit Order will be triggered at. Only one of the"
              + " price and distance fields may be specified.")  
  private String price;
  
  /** The time in force for the created Take Profit Order. This may only be GTC, GTD or GFD. */
  @JsonPropertyDescription(
      "The time in force for the created Take Profit Order. This may only be GTC, GTD or GFD.")
  private TimeInForce timeInForce;
  
  /** The date when the Take Profit Order will be cancelled on if timeInForce is GTD. */
  @JsonPropertyDescription(
      "The date when the Take Profit Order will be cancelled on if timeInForce is GTD.")
  private String gtdTime;
  

  private ClientExtensions clientExtensions;
}
