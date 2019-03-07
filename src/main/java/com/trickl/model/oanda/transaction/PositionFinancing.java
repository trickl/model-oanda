package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * OpenTradeFinancing is used to pay/collect daily financing charge for a Position within
 * an Account.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"instrument", "financing", "openTradeFinancings"})
@Data
@Builder
public class PositionFinancing {

  /** The instrument of the Position that financing is being paid/collected for. */
  @JsonPropertyDescription(
      "The instrument of the Position that financing is being paid/collected for.")
  private String instrument;

  /** The amount of financing paid/collected for the Position. */
  @JsonPropertyDescription("The amount of financing paid/collected for the Position.")
  private String financing;

  /** The financing paid/collecte for each open Trade within the Position. */
  @JsonPropertyDescription("The financing paid/collecte for each open Trade within"
          + " the Position.")
  private List<OpenTradeFinancing> openTradeFinancings = null;
}
