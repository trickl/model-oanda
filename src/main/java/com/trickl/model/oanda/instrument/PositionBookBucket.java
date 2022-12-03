package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** The position book data for a partition of the instrument's prices. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"price", "longCountPercent", "shortCountPercent"})
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class PositionBookBucket {

  /**
   * The lowest price (inclusive) covered by the bucket. The bucket covers the price range from the
   * price to price + the position book's bucketWidth.
   */
  @JsonPropertyDescription(
      "The lowest price (inclusive) covered by the bucket. The bucket "
          + "covers the price range from the price to price + the position "
          + "book's bucketWidth.")
  private String price;
  /**
   * The percentage of the total number of positions represented by the long positions found in this
   * bucket.
   */
  @JsonPropertyDescription(
      "The percentage of the total number of positions represented by the "
          + "long positions found in this bucket.")
  private String longCountPercent;

  /**
   * The percentage of the total number of positions represented by the short positions found in
   * this bucket.
   */
  @JsonPropertyDescription(
      "The percentage of the total number of positions represented by the "
          + "short positions found in this bucket.")
  private String shortCountPercent;
}
