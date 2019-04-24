package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

/** The order book data for a partition of the instrument's prices. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"price", "longCountPercent", "shortCountPercent"})
@Builder
@Data
public class OrderBookBucket {

  /**
   * The lowest price (inclusive) covered by the bucket. The bucket covers the price range from the
   * price to price + the order book's bucketWidth.
   */
  @JsonPropertyDescription(
      "The lowest price (inclusive) covered by the bucket. The bucket covers"
          + " the price range from the price to price + the order book's bucketWidth.")
  private BigDecimal price;

  /**
   * The percentage of the total number of orders represented by the long orders found in this
   * bucket.
   */
  @JsonPropertyDescription(
      "The percentage of the total number of orders represented by the long "
          + "orders found in this bucket.")
  private BigDecimal longCountPercent;

  /**
   * The percentage of the total number of orders represented by the short orders found in this
   * bucket.
   */
  @JsonPropertyDescription(
      "The percentage of the total number of orders represented by the short "
          + "orders found in this bucket.")
  private BigDecimal shortCountPercent;
}
