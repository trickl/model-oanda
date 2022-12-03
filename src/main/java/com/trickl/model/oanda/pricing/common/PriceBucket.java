package com.trickl.model.oanda.pricing.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A Price Bucket represents a price available for an amount of liquidity. */
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"price", "liquidity"})
public class PriceBucket {

  /** The Price offered by the PriceBucket. */
  @JsonPropertyDescription("The Price offered by the PriceBucket")
  private BigDecimal price;

  /** The amount of liquidity offered by the PriceBucket. */
  @JsonPropertyDescription("The amount of liquidity offered by the PriceBucket")
  private long liquidity;
}
