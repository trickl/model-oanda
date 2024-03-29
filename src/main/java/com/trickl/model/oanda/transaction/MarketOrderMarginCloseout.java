package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Details for the Market Order extensions specific to a Market Order placed that is part of a
 * Market Order Margin Closeout in a client's account.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"reason"})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MarketOrderMarginCloseout {

  /** The reason the Market Order was created to perform a margin closeout. */
  @JsonPropertyDescription("The reason the Market Order was created to perform a margin closeout")
  private MarketOrderMarginCloseoutReason reason;
}
