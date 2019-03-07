package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/** The representation of an instrument's order book at a point in time. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"instrument", "time", "price", "bucketWidth", "buckets"})
@Builder
@Data
public class OrderBook {

  /** The order book's instrument. */
  @JsonPropertyDescription("The order book's instrument")
  private String instrument;

  /** The time when the order book snapshot was created. */
  @JsonPropertyDescription("The time when the order book snapshot was created.")
  private String time;

  /** The price (midpoint) for the order book's instrument at the time of the 
   * order book snapshot. */
  @JsonPropertyDescription(
      "The price (midpoint) for the order book's instrument at the time of the order book snapshot")
  private String price;

  /**
   * The price width for each bucket. Each bucket covers the price range from the bucket's price to
   * the bucket's price + bucketWidth.
   */
  @JsonPropertyDescription(
      "The price width for each bucket. Each bucket covers the price range "
          + "from the bucket's price to the bucket's price + bucketWidth.")
  private String bucketWidth;

  @JsonProperty(
      "The partitioned order book, divided into buckets using a default"
          + " bucket width. These buckets are only provided for price ranges "
          + "which actually contain order or position data.")
  private List<OrderBookBucket> buckets;
}
