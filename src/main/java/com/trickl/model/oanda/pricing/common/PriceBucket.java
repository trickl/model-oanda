package com.trickl.model.oanda.pricing.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/** A Price Bucket represents a price available for an amount of liquidity. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"price", "liquidity"})
@Data
public class PriceBucket {

  /** The Price offered by the PriceBucket. */
  @JsonPropertyDescription("The Price offered by the PriceBucket")
  private String price;

  /** The amount of liquidity offered by the PriceBucket. */
  @JsonPropertyDescription("The amount of liquidity offered by the PriceBucket")
  private Integer liquidity;
}
