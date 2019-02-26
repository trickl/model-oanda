package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** The base Order definition specifies the properties that are common to all Orders. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "createTime", "state", "clientExtensions"})
public class Order {

  /** The Order's identifier, unique within the Order's Account. */
  @JsonPropertyDescription("The Order's identifier, unique within the Order's Account.")
  public String id;

  /** The time when the Order was created. */
  @JsonPropertyDescription("The time when the Order was created.")
  public String createTime;

  /** The current state of the Order. */
  @JsonPropertyDescription("The current state of the Order.")
  public OrderState state;

  public Object clientExtensions;
}
