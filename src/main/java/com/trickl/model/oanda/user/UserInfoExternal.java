package com.trickl.model.oanda.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/** A representation of user information, as available to external (3rd party) clients. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"userID", "country", "FIFO"})
@Data
@Builder
public class UserInfoExternal {

  /** The user's OANDA-assigned user ID. */
  @JsonProperty("userID")
  @JsonPropertyDescription("The user's OANDA-assigned user ID.")
  private Integer userId;
  
  /** The country that the user is based in. */
  @JsonPropertyDescription("The country that the user is based in.")
  private String country;
  
  /** Flag indicating if the the user's Accounts adhere to FIFO execution rules. */
  @JsonProperty("FIFO")
  @JsonPropertyDescription(
      "Flag indicating if the the user's Accounts adhere to FIFO execution rules.")
  private Boolean fifo;
}
