package com.trickl.model.oanda.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** A representation of user information, as provided to the user themself. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"username", "userID", "country", "emailAddress"})
public class UserInfo {

  /** The user-provided username. */
  @JsonPropertyDescription("The user-provided username.")
  public String username;
  
  /** The user's OANDA-assigned user ID. */
  @JsonProperty("userID")
  @JsonPropertyDescription("The user's OANDA-assigned user ID.")
  public Integer userId;
  
  /** The country that the user is based in. */
  @JsonPropertyDescription("The country that the user is based in.")
  public String country;
  
  /** The user's email address. */
  @JsonPropertyDescription("The user's email address.")
  public String emailAddress;
}
