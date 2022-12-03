package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A MarketOrderTradeClose specifies the extensions to a Market Order that has been created
 * specifically to close a Trade.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"tradeID", "clientTradeID", "units"})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MarketOrderTradeClose {

  /** The ID of the Trade requested to be closed. */
  @JsonProperty("tradeID")
  @JsonPropertyDescription("The ID of the Trade requested to be closed")
  private String tradeId;
  
  /** The client ID of the Trade requested to be closed. */
  @JsonProperty("clientTradeID")
  @JsonPropertyDescription("The client ID of the Trade requested to be closed")
  private String clientTradeId;
  /**
   * Indication of how much of the Trade to close. Either "ALL", or a DecimalNumber reflection a
   * partial close of the Trade.
   */
  @JsonPropertyDescription(
      "Indication of how much of the Trade to close."
          + " Either \"ALL\", or a DecimalNumber reflection a partial "
          + "close of the Trade.")
  private String units;
}
