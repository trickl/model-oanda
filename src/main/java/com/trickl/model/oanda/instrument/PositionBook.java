package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** The representation of an instrument's position book at a point in time. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"instrument", "time", "price", "bucketWidth", "buckets"})
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class PositionBook {

  /** The position book's instrument. */
  @JsonPropertyDescription("The position book's instrument")
  private String instrument;

  /** The time when the position book snapshot was created. */
  @JsonPropertyDescription("The time when the position book snapshot was created")
  private String time;

  /**
   * The price (midpoint) for the position book's instrument at the time of the position book
   * snapshot.
   */
  @JsonPropertyDescription(
      "The price (midpoint) for the position book's instrument at the time of "
          + "the position book snapshot")
  private String price;

  /**
   * The price width for each bucket. Each bucket covers the price range from the bucket's price to
   * the bucket's price + bucketWidth.
   */
  @JsonPropertyDescription(
      "The price width for each bucket. Each bucket covers the price range "
          + "from the bucket's price to the bucket's price + bucketWidth.")
  private String bucketWidth;

  /**
   * The partitioned position book, divided into buckets using a default bucket width. These buckets
   * are only provided for price ranges which actually contain order or position data.
   */
  @JsonPropertyDescription(
      "The partitioned position book, divided into buckets using a default "
          + "bucket width. These buckets are only provided for price ranges "
          + "which actually contain order or position data.")
  private List<PositionBookBucket> buckets = null;
}
