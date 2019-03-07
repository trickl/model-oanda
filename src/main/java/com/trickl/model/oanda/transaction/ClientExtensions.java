package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/**
 * A ClientExtensions object allows a client to attach a clientID, tag and comment to Orders and
 * Trades in their Account. Do not set, modify, or delete this field if your account is associated
 * with MT4.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "tag", "comment"})
@Data
@Builder
public class ClientExtensions {

  /** The Client ID of the Order/Trade. */
  @JsonProperty("id")
  @JsonPropertyDescription("The Client ID of the Order/Trade")
  private String id;
  /** A tag associated with the Order/Trade. */
  @JsonProperty("tag")
  @JsonPropertyDescription("A tag associated with the Order/Trade")
  private String tag;
  /** A comment associated with the Order/Trade. */
  @JsonProperty("comment")
  @JsonPropertyDescription("A comment associated with the Order/Trade")
  private String comment;
}
