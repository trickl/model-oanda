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
 * OpenTradeFinancing is used to pay/collect daily financing charge for an open Trade within an
 * Account.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"tradeID", "financing"})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class OpenTradeFinancing {

  /** The ID of the Trade that financing is being paid/collected for. */
  @JsonProperty("tradeID")
  @JsonPropertyDescription("The ID of the Trade that financing is being paid/collected for.")
  private String tradeId;
 
  /** The amount of financing paid/collected for the Trade. */  
  @JsonPropertyDescription("The amount of financing paid/collected for the Trade.")
  private String financing;
}
