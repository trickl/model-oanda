package com.trickl.model.oanda.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A representation of user information, as provided to the user themself. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"username", "userID", "country", "emailAddress"})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserInfo {

  /** The user-provided username. */
  @JsonPropertyDescription("The user-provided username.")
  private String username;
  
  /** The user's OANDA-assigned user ID. */
  @JsonProperty("userID")
  @JsonPropertyDescription("The user's OANDA-assigned user ID.")
  private Integer userId;
  
  /** The country that the user is based in. */
  @JsonPropertyDescription("The country that the user is based in.")
  private String country;
  
  /** The user's email address. */
  @JsonPropertyDescription("The user's email address.")
  private String emailAddress;
}
