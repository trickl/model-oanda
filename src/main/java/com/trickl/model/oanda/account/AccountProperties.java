package com.trickl.model.oanda.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/** Properties related to an Account. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "mt4AccountID", "tags"})
@Builder
@Data
public class AccountProperties {

  /** The Account's identifier. */
  @JsonPropertyDescription("The Account's identifier")
  private String id;

  /**
   * The Account's associated MT4 Account ID. This field will not be present if the Account is not
   * an MT4 account.
   */
  @JsonProperty("mt4AccountID")
  @JsonPropertyDescription(
      "The Account's associated MT4 Account ID. This field will not be present "
          + "if the Account is not an MT4 account.")
  private Integer mt4AccountId;

  /** The Account's tags. */
  @JsonPropertyDescription("The Account's tags")
  private List<String> tags = null;
}
